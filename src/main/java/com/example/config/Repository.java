package com.example.config;

import com.example.model.Department;
import com.example.model.Employee;
import com.example.model.Meeting;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Selma on 07.05.2017.
 */
public class Repository {
    @Configuration
    @EnableTransactionManagement
    @ComponentScan("com.example")
    public class RepositoryConfig {
        //${datasource.driverClassName}
        @Value("${datasource.driverClassName}")
        private String driverClassName;
        @Value("${datasource.url}")
        private String url;
        @Value("${datasource.username}")
        private String username;
        @Value("${datasource.password}")
        private String password;

        @Value("${hibernate.dialect}")
        private String hibernateDialect;
        @Value("${hibernate.show_sql}")
        private String hibernateShowSql;
        @Value("${hibernate.hbm2ddl.auto}")
        private String hibernateHbm2ddlAuto;

        @Bean()
        public DataSource getDataSource() {
            DriverManagerDataSource ds = new DriverManagerDataSource();
            ds.setDriverClassName(driverClassName);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);
            return ds;
        }

        @Bean
        @Autowired
        public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
            HibernateTransactionManager htm = new HibernateTransactionManager();
            htm.setSessionFactory(sessionFactory);
            return htm;
        }

        @Bean
        @Autowired
        public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
            HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
            return hibernateTemplate;
        }


        @Bean(name = "sessionFactory")
        public LocalSessionFactoryBean getSessionFactory() {
            LocalSessionFactoryBean asfb = new LocalSessionFactoryBean();
            asfb.setDataSource(getDataSource());
            asfb.setHibernateProperties(getHibernateProperties());
            asfb.setPackagesToScan(new String[]{"com.example"});
            asfb.setAnnotatedClasses(Department.class, Meeting.class, Employee.class);
            return asfb;
        }

        @Bean
        public Properties getHibernateProperties() {
            Properties properties = new Properties();
            properties.put("hibernate.dialect", hibernateDialect);
            properties.put("hibernate.show_sql", hibernateShowSql);
            properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);

            return properties;
        }

    }
}
