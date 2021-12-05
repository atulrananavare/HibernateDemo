package com.java.demo.sample;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	
	private static SessionFactory sfactory = null;
	
	static public SessionFactory getSessionFactoryInstance() {
		
		if(sfactory==null) {
			//write a code for --> sessionfactory instantiation
			//xml configuration..
			sfactory  = new Configuration().configure().buildSessionFactory();
		}
		return sfactory;
	}
	
	
	//hibernate.cfg.xml --> replacement.
	// hibernate configuration --> entire code --:> java madhe... no xml
	static public SessionFactory getSessionFactoryInstanceAnn() {
		if(sfactory==null) {
			Configuration config = new Configuration();
			config.setProperties(getMysqlProps());
			config.addAnnotatedClass(Employee.class);
			config.addAnnotatedClass(Emp.class);
			config.addAnnotatedClass(Perm.class);
			config.addAnnotatedClass(Contract.class);
			
			/*config.addAnnotatedClass(Student.class);
			config.addAnnotatedClass(IDCard.class);*/
			
			//ServiceRegistry registry =new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build() ;
			return config.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build());
		}
		return sfactory;
	}
	
	
	private static Properties getMysqlProps() {
		Properties props = new Properties();
		props.put(AvailableSettings.DRIVER,"com.mysql.cj.jdbc.Driver");
		props.put(AvailableSettings.URL,"jdbc:mysql://localhost/samdb");
		props.put(AvailableSettings.USER,"root");
		props.put(AvailableSettings.PASS,"root");
		props.put(AvailableSettings.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
		props.put(AvailableSettings.HBM2DDL_AUTO,"update");
		props.put(AvailableSettings.SHOW_SQL,true);
		return props;
	}
	
	private HibernateUtil() {
		//in every utility class--> constructor shud be private all methods shud be static
	}
	
	
	
}
