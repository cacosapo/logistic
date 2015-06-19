package com.mkyong.common;

import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mkyong.persistence.HibernateUtil;

public class App 
{
	
	@PersistenceContext(unitName="crm") Session session1;
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        UserDetails usr= new UserDetails();
        
        Lane ln = new Lane();
        ln.setLaneId("AB");
        ln.setSource("A");
        ln.setDestination("B");
        ln.setWeigth(10);
        
        usr.setUserId(1);
        usr.setUserName("Joao");
        Stock stock = new Stock();
        
        stock.setStockCode("4716");
        stock.setStockName("GANM");
        
//        session.save(stock);
        session.save(usr);
        session.save(ln);
       
        Query query = session.createQuery("from Stock");
        java.util.List list = query.list();
        for (Object object : list) {
			System.out.println(((Stock)object).getStockCode());
			System.out.println(((Stock)object).getStockName());
		}
        System.out.println(list);
        
        //session.delete(stock);
        
        session.getTransaction().commit();
        
        
    }
}
