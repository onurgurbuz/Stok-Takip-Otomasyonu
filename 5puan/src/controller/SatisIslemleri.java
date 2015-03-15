/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Kürşat
 */
public class SatisIslemleri {
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();
    Transaction ts = session.beginTransaction();
    
    
    public void SatisYap(model.stok_satis satis){
        
         session.saveOrUpdate(satis);
         String QUERY = "select u_adet from urun where u_barkod= :u_kod";
         org.hibernate.Query sorgu = session.createQuery(QUERY);
         sorgu.setParameter("u_kod",satis.getU_kod());
         Iterator it = sorgu.iterate();
         session.saveOrUpdate(satis);
         ts.commit();
    }
    
}
