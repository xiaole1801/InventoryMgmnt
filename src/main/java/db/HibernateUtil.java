package db;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.Transaction; 
import java.util.List;

import java.io.Serializable;  


public class HibernateUtil {
  
    private static SessionFactory sessionFactory = null;
    private static Session session = null;
  
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
//            return new Configuration().configure().buildSessionFactory();
        	Configuration conf = new Configuration().configure();
//        	return new Configuration().configure().buildSessionFactory(new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry());
        	return conf.buildSessionFactory(new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry());
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static Session openSession() {
    	sessionFactory = buildSessionFactory();
        return sessionFactory.openSession();
    }
  
    public static void shutdown() {
        // Close caches and connection pools
      if(session.isOpen())
        session.close();
    	sessionFactory.close();
    }
    
    
    //娣诲姞
    public static void add(Object obj){
    	Transaction tx = null;
    	try {
   			session = HibernateUtil.openSession();
   			tx = session.beginTransaction();
   			session.save(obj);
   			//session.persist(obj);//鍥炴粴浜�鑰宲ersist()鏂规硶鍦ㄦ病鏈夊紑鍚簨鍔＄殑鏃跺�锛屽畠鏍规湰涓嶄細鍘绘墽琛岋紝鍗虫病鏈夐偅鏉℃彃鍏ヨ鍙�   			
    	     tx.commit();
    	}finally{
    		if(session!=null){
   				shutdown();
   			}
   		}
   	}
    
    //淇敼
    public static void update(Object obj){
    	Transaction tx = null;
    	try {
    		session = HibernateUtil.openSession();
    		tx = session.beginTransaction();
    		session.update(obj);
    		tx.commit();
    	}finally{
    		if(session!=null){
    			shutdown();
    		}
    	}
    }
    	
    //鍒犻櫎
    public static void delete(Object obj){
    	Transaction tx = null;
    	try {
    		session = HibernateUtil.openSession();
    		tx = session.beginTransaction();
    		session.delete(obj);
    		tx.commit();
    	}finally{
    		if(session!=null){
    			shutdown();
    		}
    	}
    }
    
    //鏌ユ壘
    public static Object findById(Class clazz,Serializable id){
    	try {
    		session = HibernateUtil.openSession();
    		Object obj = session.get(clazz, id);
   			return obj;
   		}finally{
   			if(session!=null){
   				shutdown();
   			}
   		}
    }
    
    public static List queryBySql(Class clazz, String queryStr){
    	try {
    		session = HibernateUtil.openSession();
    		Query qeryResult = session.createSQLQuery(queryStr).addEntity(clazz);
    		return qeryResult.list();
   		}finally{
   			if(session!=null){
   				shutdown();
   			}
   		}
    }
  
}