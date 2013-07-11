package com.ufjf.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Classe com os metodos essenciais para utiliza��o do Hibernate pelos DAOs
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	/**
	 * Fun��o para iniciar as configura��es do Hibernate
	 * @exception ExceptionInInitializerError;
	 * @return void
	 */
	private static void start() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/**
	 * Fun��o que inicia uma sess�o do Hibernate para conex�o com o banco
	 * @return Session
	 * @throws Exception
	 */
	public static Session getInstance() throws Exception {
		if(sessionFactory == null){
			start();
		}
		return sessionFactory.openSession();
	}
	

}
