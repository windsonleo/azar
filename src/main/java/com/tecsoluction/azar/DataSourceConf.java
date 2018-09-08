package com.tecsoluction.azar;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@Configuration
public class DataSourceConf {
	
	
	@Bean
	
    public DataSource dataSource() {
   
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://ec2-54-227-244-12.compute-1.amazonaws.com:5432/d7gaoujdb4o1lp");
        dataSource.setUsername("zhrzxiwajhepyq");
        dataSource.setPassword("89f7d7617d5f3955bdbf7565411e7c156573b68ad9fe3df179ba18b95c7f269f");
        
        
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/azzar?useSSL=true");
////        dataSource.setUrl("jdbc:mysql://node148635-jogodeazar.jelasticlw.com.br/azzar");
//
//        dataSource.setUsername("root");
////        dataSource.setPassword("ALEbly31071");
//        
////        dataSource.setUsername("root");
//        dataSource.setPassword("123456");

    	return dataSource;
    }
	
	
	
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){


        LocalContainerEntityManagerFactoryBean lcemfb
                = new LocalContainerEntityManagerFactoryBean();

        lcemfb.setDataSource(dataSource());
        lcemfb.setPackagesToScan(new String[] {"com.tecsoluction.azar.entidade"});

        lcemfb.setPersistenceUnitName("PU-AZAR");

        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        lcemfb.setJpaVendorAdapter(va);
        va.setDatabase(Database.MYSQL);
//        va.setDatabase(Database.POSTGRESQL);

        va.setGenerateDdl(true);
        va.setShowSql(true);
//        va.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        va.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        Properties ps = new Properties();
//        ps.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        ps.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        ps.put("spring.jpa.hibernate.ddl-auto", "update");
		ps.put("useSSL","false");
//		ps.put("security.basic.enabled","false");

		ps.put("spring.thymeleaf.encoding","UTF-8");

		ps.put("spring.jpa.properties.hibernate.format_sql","true");
		ps.put("spring.datasource.validationQuery","SELECT 1");
		ps.put("spring.thymeleaf.cache","false");
		ps.put("security.basic.enabled","false");

		
		
        lcemfb.setJpaProperties(ps);

        lcemfb.afterPropertiesSet();

        return lcemfb;

    }
    
    @Bean
    public PlatformTransactionManager transactionManager(){

        JpaTransactionManager tm = new JpaTransactionManager();

        tm.setEntityManagerFactory(
                this.entityManagerFactory().getObject() );

        return tm;

    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }


}
