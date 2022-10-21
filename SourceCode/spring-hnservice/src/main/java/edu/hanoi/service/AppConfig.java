package edu.hanoi.service;

import edu.hanoi.service.dao.impl.UserDAOImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Properties;

@Configuration
@EnableWebMvc
@PropertySource("classpath:/application.properties")
public class AppConfig implements WebMvcConfigurer {
    private final static Logger LOGGER = Logger.getLogger(String.valueOf(AppConfig.class));

    @Autowired
    private org.springframework.core.env.Environment env;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
        System.out.println("=====================start application==================");
        LOGGER.info("====Context start application "+dataSource());
        try{
            createTable("HN_GROUP"," create table HN_GROUP(id bigint primary key generated always as identity (start with 1 , increment by 1), name varchar(100) ) ");
            createTable("HN_USER"," create table HN_USER(username varchar(100) primary key, password varchar(100), email varchar(100),age integer, groupId bigint, constraint group_fk FOREIGN KEY (groupId) REFERENCES HN_GROUP(id))");
        }catch (Exception e){
            LOGGER.error(e,e);
        }
    }
    private void createTable(String name, String script) throws Exception{
        DatabaseMetaData dbmd = dataSource().getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null,null,name,null);
        if (rs.next()){
            LOGGER.info("======TABLE "+rs.getString("TABLE_NAME")+ " already exists !");
            return;
        }
        dataSource().getConnection().createStatement().executeUpdate(script);
    }

    @Bean
    public DataSource dataSource(){
        String url = env.getProperty("jdbc.url");
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url);
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("edu.hanoi.service.model");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    public Properties hibernateProperties(){
        return new Properties(){
            {
                setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
            }
        };
    }
}
