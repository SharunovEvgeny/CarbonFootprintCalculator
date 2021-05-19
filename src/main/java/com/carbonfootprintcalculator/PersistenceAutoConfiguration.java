package com.carbonfootprintcalculator;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
    basePackages = "com.carbonfootprintcalculator.repositories",
    entityManagerFactoryRef = "baseEntityManager",
    transactionManagerRef = "baseTransactionManager")
public class PersistenceAutoConfiguration {
  @Autowired private Environment env;

  public PersistenceAutoConfiguration() {
    super();
  }

  @Primary
  @Bean
  public LocalContainerEntityManagerFactoryBean baseEntityManager() {
    final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(baseDataSource());
    em.setPackagesToScan("com.carbonfootprintcalculator.entities");
    final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    final HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
    properties.put("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
    em.setJpaPropertyMap(properties);

    return em;
  }

  @Primary
  @Bean
  public DataSource baseDataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setUrl(env.getProperty("spring.datasource.url"));
    ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
    ds.setUsername(env.getProperty("spring.datasource.username"));
    ds.setPassword(env.getProperty("spring.datasource.password"));
    return ds;
  }

  @Primary
  @Bean
  public PlatformTransactionManager baseTransactionManager() {
    final JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(baseEntityManager().getObject());
    return transactionManager;
  }
}
