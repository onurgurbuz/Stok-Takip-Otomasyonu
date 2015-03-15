/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.marka;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Kursat
 */
public class MarkaIslemeri {
     SessionFactory sf = HibernateUtil.getSessionFactory();
     Session session = sf.openSession();
     Transaction ts = session.beginTransaction();
     
     public void markaEkle(marka mrk){
        String QUERY = "from  marka";
        int ekle=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<marka> liste = new ArrayList();
        while (it.hasNext()) {            
             marka mrk2 = (marka) it.next();
             liste.add(mrk2);
        }
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).getM_adi().equals(mrk.getM_adi())){
                JOptionPane.showMessageDialog(null,"Bu Marka Zaten Mevcut");
                ekle=1;
            }
        }
        
        if(ekle==0){
        session.saveOrUpdate(mrk);
        ts.commit();
        }
     }
     public String[] markaGetir(){
        String QUERY = "from  marka";
        int ekle=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<marka> liste = new ArrayList();
        while (it.hasNext()) {            
             marka mrk2 = (marka) it.next();
             liste.add(mrk2);
        }
        String obj[] = new String[liste.size()];
         for (int i = 0; i < liste.size(); i++) {
             obj[i]= liste.get(i).getM_adi();
             
         }
         return obj;
     }
         
}

    
