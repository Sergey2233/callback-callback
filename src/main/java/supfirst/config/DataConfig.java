package supfirst.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.beans.factory.annotation.Value;
import com.jolbox.bonecp.BoneCPDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
//import java.util.Properties;
 
@Configuration
@EnableTransactionManagement
@ComponentScan("supfirst")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("supfirst")
public class DataConfig{
 
    private static final String PROP_DATABASE_DRIVER = "db.driver";
    private static final String PROP_DATABASE_PASSWORD = "db.password";
    private static final String PROP_DATABASE_URL = "db.url";
    private static final String PROP_DATABASE_USERNAME = "db.username";
    private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN_USER = "db.entitymanager.packages.to.scan.user";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";
    private static final String IDLE_MAXAGE_IN_MINUTES = "bonecp.idleMaxAgeInMinutes";
    @Resource
    private Environment env;
    @Value("${bonecp.url}")
	private String jdbcUrl;

	@Value("${bonecp.username}")
	private String jdbcUsername;

	@Value("${bonecp.password}")
	private String jdbcPassword;

	@Value("${bonecp.driverClass}")
	private String driverClass;

	@Value("${bonecp.idleMaxAgeInMinutes}")
	private Integer idleMaxAgeInMinutes;

	@Value("${bonecp.idleConnectionTestPeriodInMinutes}")
	private Integer idleConnectionTestPeriodInMinutes;

	@Value("${bonecp.maxConnectionsPerPartition}")
	private Integer maxConnectionsPerPartition;

	@Value("${bonecp.minConnectionsPerPartition}")
	private Integer minConnectionsPerPartition;

	@Value("${bonecp.partitionCount}")
	private Integer partitionCount;

	@Value("${bonecp.acquireIncrement}")
	private Integer acquireIncrement;

	@Value("${bonecp.statementsCacheSize}")
	private Integer statementsCacheSize;
	@Bean(destroyMethod = "close")
    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
// 
//        dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
//        dataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
//        dataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
//        dataSource.setPassword(env.getRequiredProperty(PROP_DATABASE_PASSWORD));
      
      
    	BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUsername(jdbcUsername);
		dataSource.setPassword(jdbcPassword);
		dataSource.setIdleConnectionTestPeriodInMinutes(idleConnectionTestPeriodInMinutes);
		dataSource.setIdleMaxAgeInMinutes(idleMaxAgeInMinutes);
		dataSource.setMaxConnectionsPerPartition(maxConnectionsPerPartition);
		dataSource.setMinConnectionsPerPartition(minConnectionsPerPartition);
		dataSource.setPartitionCount(partitionCount);
		dataSource.setAcquireIncrement(acquireIncrement);
		dataSource.setStatementsCacheSize(statementsCacheSize);
		return dataSource;
    }
 
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(env.getProperty(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN,PROP_ENTITYMANAGER_PACKAGES_TO_SCAN_USER));
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
       // entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
 
        return entityManagerFactoryBean;
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true); //Auto creating scheme when true
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);//Database type
        return hibernateJpaVendorAdapter;
    }
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
 
        return transactionManager;
    }
 
//    private Properties getHibernateProperties() {
//        Properties properties = new Properties();
//        properties.put(PROP_HIBERNATE_DIALECT, env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
//        properties.put(PROP_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
//        properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));
// 
//        return properties;
//    }
 
}
