/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.kategori;
import model.marka;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Kursat
 */
public class KategoriIslemleri {
    
     SessionFactory sf = HibernateUtil.getSessionFactory();
     Session session = sf.openSession();
     Transaction ts = session.beginTransaction();
     
     
     public void kategoriEkle(kategori ktgr){
        String QUERY = "from  kategori";
        int ekle=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<kategori> liste = new ArrayList();
        while (it.hasNext()) {            
             kategori ktgr2 = (kategori) it.next();
             liste.add(ktgr2);
        }
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).getKategori_ad().equals(ktgr.getKategori_ad())){
                JOptionPane.showMessageDialog(null,"Bu Kategori Zaten Mevcut");
                ekle=1;
            }
        }
        if(ekle==0){
        session.saveOrUpdate(ktgr);
        ts.commit();
        }
     }
     
     public String[] kategoriGetir(){
        String QUERY = "from  kategori";
        int ekle=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<kategori> liste = new ArrayList();
        while (it.hasNext()) {            
             kategori ktgr2 = (kategori) it.next();
             liste.add(ktgr2);
        }
        String obj[] = new String[liste.size()];
         for (int i = 0; i < liste.size(); i++) {
             obj[i]= liste.get(i).getKategori_ad();
             
         }
         return obj;
     }
}
    

