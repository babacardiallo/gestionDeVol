package sn.myapp.gestionvol.config.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.logging.Logger;

@Configuration
@EnableJpaRepositories("sn.myapp.gestionvol.persitence.repository")
public class DataSourceConfiguration {

    Logger logger = Logger.getLogger(DataSourceConfiguration.class.getName());

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.reload}")
    boolean reload;

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.driver-class-name}")
    String driverClassName;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    String ddlMode;

    @Value("${spring.jpa.hibernate.dialect}")
    String dialect;


    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }



    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("sn.myapp.gestionvol..*");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", ddlMode);
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", true);
        em.setJpaPropertyMap(properties);
        return em;
    }



    @Bean(name = "serversDataSource")
    public DataSource dataSource() {
        logger.info("Url vers la base de données :" + this.url);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        if(this.reload){
            this.initialize(dataSource);
        }
        return dataSource;
    }

    private void initialize(DataSource dataSource) {
        ClassPathResource sql = new ClassPathResource("data/data.sql");
        ResourceDatabasePopulator populate = new ResourceDatabasePopulator(sql);
        populate.execute(dataSource);
    }


}

