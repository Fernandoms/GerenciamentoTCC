package com.ufjf.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Classe com os métodos essenciais para utilização do Hibernate pelos DAOs
 * 
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static Transaction transaction;
	private static Session session;

	/**
	 * Função para iniciar as configurações do Hibernate
	 * 
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
	 * Função que inicia uma sessão do Hibernate para conexão com o banco
	 * 
	 * @return Session
	 * @throws Exception
	 */
	public static Session getInstance() throws Exception {
		if (sessionFactory == null) {
			start();
		}
		return sessionFactory.openSession();
	}
	
    /**
     * Retorna todos os registros da tabela (classe) informada
     * @param objClass
     * @return List<Object>
     */
	@SuppressWarnings({ "finally", "rawtypes", "unchecked"})
    public static List<Object> findAll(Class objClass){
        List<Object> lista = null;
        Query query = null;
        try {
        	session = getInstance();
            transaction = session.beginTransaction();
            query = session.createQuery("From "+objClass.getName());
            lista = (List<Object>) query.list();
        } catch (HibernateException e) { 
            transaction.rollback();
            System.err.println(e.fillInStackTrace());
        } finally {
            session.close();
            return lista;
        }
    }
     
    /**
     * Retorna apenas um objeto referente a classe e id informados
     * @param objClass
     * @param id
     * @return Object
     */
    @SuppressWarnings({ "finally", "rawtypes" })
    public static Object find(Class objClass, long id){
        Object objGet = null;
        try {
            session = getInstance();
            transaction = session.beginTransaction();
            objGet = session.get(objClass, id);
        } catch (HibernateException e) { 
            transaction.rollback();
            System.err.println(e.fillInStackTrace());
        } finally {
            session.close();
            return objGet;
        }
    }
     
    /**
     * Atualiza ou salva um objeto passado por parâmetro retornando {@code true} caso tenha sucesso e {@code false} caso não atualize.
     * @param obj 
     * @return boolean
     * @exception HibernateException em caso de erro de transação, executando um {@code rollback} nas modificações.
     */
    @SuppressWarnings("finally")
    public static boolean saveOrUpdate(Object obj){
        try{
        	session = getInstance();
            transaction = session.beginTransaction();
            session.saveOrUpdate(obj);
            transaction.commit();
        } catch (HibernateException e) { 
        	transaction.rollback();
            System.err.println(e.fillInStackTrace());
            return false;
        } finally {
        	session.close();
            return true;
        }
    }
    
    /**
     * Salva um objeto passado por parâmetro retornando {@code true} caso tenha sucesso e {@code false} caso não atualize.
     * @param obj 
     * @return boolean
     * @exception HibernateException em caso de erro de transação, executando um {@code rollback} nas modificações.
     */
    @SuppressWarnings("finally")
    public static boolean save(Object obj){
        try{
        	session = getInstance();
            transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
        } catch (HibernateException e) { 
        	transaction.rollback();
            System.err.println(e.fillInStackTrace());
            return false;
        } finally {
        	session.close();
            return true;
        }
    }
     
    /**
     * Atualiza o objeto passado por parâmetro retornando {@code true} caso tenha sucesso e {@code false} caso não atualize.
     * @param obj 
     * @return boolean
     * @exception HibernateException em caso de erro de transação, executando um {@code rollback} nas modificações.
     */
    @SuppressWarnings("finally")
    public static boolean update(Object obj){
        try{
        	session = getInstance();
        	transaction = session.beginTransaction();
        	session.update(obj);
            transaction.commit();
        } catch (HibernateException e) { 
        	transaction.rollback();
            System.err.println(e.fillInStackTrace());
            return false;
        } finally {
        	session.close();
            return true;
        }
    }
     
    /**
     * Exclui o objeto passado por parâmetro
     * @param obj 
     * @return boolean
     * @exception HibernateException em caso de erro de transação, executando um {@code rollback} nas modificações.
     */
    @SuppressWarnings("finally")
	public static boolean delete(Object obj){
        try{
        	session = getInstance();
            transaction = session.beginTransaction();
            session.delete(obj);
            transaction.commit();
        } catch (HibernateException e) { 
        	transaction.rollback();
            System.err.println(e.fillInStackTrace());
            return false;
        } finally {
        	session.close();
            return true;
        }
    }
}
