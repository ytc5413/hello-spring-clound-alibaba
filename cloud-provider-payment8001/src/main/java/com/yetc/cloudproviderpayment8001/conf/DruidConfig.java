package com.yetc.cloudproviderpayment8001.conf;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import com.github.pagehelper.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author : yetc
 * @date : 2020/6/13 15:57
 */
@Slf4j
@Configuration
@MapperScan(basePackages = {"com.yetc.cloudproviderpayment8001.mysql.mapper"},
        sqlSessionFactoryRef = DruidConfig.SESSION_FACTORY)
public class DruidConfig {
    static final String DATA_SOURCE_NAME="mysql_local";
    static final String MAPPER_XML_PATH="classpath:/mapper/**.xml";
    static final String SESSION_FACTORY ="mysql_session" ;
    static final String TRANSACTION_MANAGER_NAME ="mysql_trans_manager";
    static final String TYPE_ALIASES_PACKAGE ="com.yetc.cloud.**.entity";

    @Primary
    @Bean(name = DATA_SOURCE_NAME)
    @ConfigurationProperties("spring.datasource.druid")
//    @ConfigurationProperties("spring.datasource.druid.one") 多数据源配置
    public DataSource druidDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
   /* 配置多数据源时，SpringBoot2.X之后不再支持配置继承，所以配置都需要单独一套
    @Bean
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }*/

    /**
     * 注册 ServletRegistrationBean
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean registrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        /** 初始化参数配置，initParams**/
        // 白名单
        bean.addInitParameter("allow", "127.0.0.1");// 多个 ip 逗号隔开
        // IP 黑名单 (存在共同时，deny 优先于 allow) : 如果满足 deny 的话提示:Sorry, you are not permitted to view this page.
        // bean.addInitParameter("deny", "192.168.1.73");
        // 登录查看信息的账号密码.
        bean.addInitParameter("loginUsername", "admin");
        bean.addInitParameter("loginPassword", "123456");
        // 是否能够重置数据.
        bean.addInitParameter("resetEnable", "true");
        return bean;
    }

    /**
     * 注册 FilterRegistrationBean
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        bean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        bean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return bean;
    }

    //整合Mybatis+PageHelper
    @Bean(name = SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory() {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(druidDataSource());
        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            sessionFactoryBean.setMapperLocations(resolver.getResources(MAPPER_XML_PATH));
            sessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
            sessionFactoryBean.setPlugins(new Interceptor[]{new PageInterceptor()});
            return sessionFactoryBean.getObject();
        } catch (Exception e) {
            log.error("配置mysql的SqlSessionFactory失败，error:"+e.getMessage(),e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Bean(name = TRANSACTION_MANAGER_NAME)
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(druidDataSource());
    }

}
