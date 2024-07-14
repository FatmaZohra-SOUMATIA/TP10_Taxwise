package edu.bdeb.a10.persistence;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import javax.sql.DataSource;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Taxwise_PersistenceUnitInfo implements PersistenceUnitInfo {

    @Override
    public String getPersistenceUnitName() {
        return "Taxwise_PersistenceUnitinfo";
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public DataSource getJtaDataSource() {
        return null;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return List.of();
    }

    @Override
    public List<URL> getJarFileUrls() {
        return List.of();
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        List<String> managedClassNames = new ArrayList<>();
        managedClassNames.add("TP10_Taxwise.model.AutoriteFiscale");
        managedClassNames.add("TP10_Taxwise.model.TranchesRevenu");
        return managedClassNames;
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("javax.persistence.jdbc.url", "jdbc:mariadb://mysql-fatmaa10.alwaysdata.net:3306");
        props.setProperty("javax.persistence.jdbc.user", "fatmaa10_usertax");
        props.setProperty("javax.persistence.jdbc.password", "password_userTaxe");
        props.setProperty("javax.persistence.jdbc.driver", "org.mariadb.jdbc.AutoriteFiscale");
        props.setProperty("javax.persistence.jdbc.driver", "org.mariadb.jdbc.TranchesRevenu");


        props.setProperty("hibernate.format_sql", "false");
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.mariadb.MariaDbDialect");
        props.setProperty("hibernate.show_sql", "tr");
        props.setProperty("hibernate.use_sql_comments", "false");
        props.setProperty("hibernate.ejb.interceptors", "org.hibernate.ejb.interceptors.EmptyInterceptor");
        return props;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return "";
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer classTransformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}
