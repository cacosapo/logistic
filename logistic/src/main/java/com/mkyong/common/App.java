package com.mkyong.common;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mkyong.persistence.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Stock stock = new Stock();
        
        stock.setStockCode("4715");
        stock.setStockName("GENM");
        
//        session.save(stock);
       
        Query query = session.createQuery("from Stock");
        java.util.List list = query.list();
        System.out.println(list);
        
        //session.delete(stock);
        
        session.getTransaction().commit();
        
        
    }
}
