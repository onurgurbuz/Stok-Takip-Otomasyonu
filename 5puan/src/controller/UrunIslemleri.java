/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.urun;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Kursat
 */
public class UrunIslemleri {
     SessionFactory sf = HibernateUtil.getSessionFactory();
     Session session = sf.openSession();
     Transaction ts = session.beginTransaction();
     
     public void urunEkle(urun gelenUrn){
        String QUERY = "from urun";
        int ekle=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<urun> liste = new ArrayList();
        while (it.hasNext()) {            
             urun urn = (urun) it.next();
             liste.add(urn);
        }
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).getU_barkod()==gelenUrn.getU_barkod()){
                JOptionPane.showMessageDialog(null,"Bu Urun Zaten Mevcut");
                ekle=1;
            }
        }
        
        if(ekle==0){
        session.saveOrUpdate(gelenUrn);
        ts.commit();
        }
    }
     public String[] urunAdiGetir(){
          String QUERY = "from urun";
        int ekle=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<String> liste = new ArrayList();
        while (it.hasNext()) {            
              urun urn = (urun) it.next();
             liste.add(urn.getU_adi());
        }
        String str[] = new String[liste.size()];
         for (int i = 0; i < liste.size(); i++) {
             str[i]= liste.get(i);
             
         }
         return str;
         
     }
     public DefaultTableModel urunGetir(String u_adi,DefaultTableModel tm){
         
         
        String QUERY = "from urun where u_adi =:u_adi";
       
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        sorgu.setParameter("u_adi",u_adi);
        Iterator it = sorgu.iterate();
        ArrayList<urun> liste = new ArrayList();
        
        while (it.hasNext()) {            
             urun urn = (urun) it.next();

             liste.add(urn);
        }
         
        
         for(int i=0;i<liste.size();i++){
             tm.addRow(new Object[]{liste.get(i).getU_barkod(),liste.get(i).getU_adi(),liste.get(i).getU_marka(),
             liste.get(i).getU_kategori(),liste.get(i).getU_birim(),liste.get(i).getU_gelis(),liste.get(i).getU_satis(),
             liste.get(i).getU_raf(),liste.get(i).getU_kdv()});
         }
         
         
         return tm;
         
     }
     public DefaultTableModel urunGetir(){
         String QUERY = "from urun";
       
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<urun> liste = new ArrayList();
        DefaultTableModel tm = new DefaultTableModel();
        while (it.hasNext()) {            
             urun urn = (urun) it.next();

             liste.add(urn);
        }
         tm.addColumn("Barkod No");
         tm.addColumn("Ürün Adı");
         tm.addColumn("Marka");
         tm.addColumn("Kategori");
         tm.addColumn("Birim");
         tm.addColumn("Geliş Fiyatı");
         tm.addColumn("Satış Fiyatı");
         tm.addColumn("Raf");
         tm.addColumn("KDV");
        
         for(int i=0;i<liste.size();i++){
             tm.addRow(new Object[]{liste.get(i).getU_barkod(),liste.get(i).getU_adi(),liste.get(i).getU_marka(),
             liste.get(i).getU_kategori(),liste.get(i).getU_birim(),liste.get(i).getU_gelis(),liste.get(i).getU_satis(),
             liste.get(i).getU_raf(),liste.get(i).getU_kdv()});
         }
         
         
         return tm;
         
     }
}
