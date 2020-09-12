 
package spring.config;

import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dao.*;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {


    private Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql","true");
        hibernateProperties.setProperty("current_session_context_class","thread");
        return hibernateProperties;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost/bank");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setPackagesToScan("entity");
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(hibernateProperties());
        return factoryBean;
    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
	@Bean
	public AccountDao getAccountDao() {
		return new AccountDao();
	}
	@Bean
	public ClientDao getClientDao() {
		return new ClientDao();
	}
	@Bean
	public DepartmentDao getDepartmentDao() {
		return new DepartmentDao();
	}
	@Bean
	public TransactionDao getTransactionDao() {
		return new TransactionDao();
	}
	@Bean
	public TypeDao getTypeDao() {
		return new TypeDao();
	}
}
