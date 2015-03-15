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
import model.musteri;
import model.personel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Kursat
 */
public class MusteriIslemleri {
     SessionFactory sf = HibernateUtil.getSessionFactory();
     Session session = sf.openSession();
     Transaction ts = session.beginTransaction();
     
     
     
     public void musteriEkle(musteri mstri){
         session.saveOrUpdate(mstri);
         ts.commit();
     }
     
     
     public int musteriSil(String m_id){
         String QUERY = "from musteri";
        int sil=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<musteri> liste = new ArrayList();
        while (it.hasNext()) {            
             musteri mstri = (musteri) it.next();
             liste.add(mstri);
        }
         for(int i=0;i<liste.size();i++){
            if(Integer.toString(liste.get(i).getM_id()).equals(m_id))
                
                sil=1;
        }
        if(sil==0){
            return sil;
            
        }
         else{
             try {
                Query query = session.createQuery("delete from musteri where m_id=:m_id");
                query.setString("m_id",m_id);
                query.executeUpdate();
                ts.commit();
                return sil;
            } 
             catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Bir hata var "+e);
            }
             
        }
         return sil;
     }
     
     
     
     public DefaultTableModel musteriGetir(){
         String QUERY = "from musteri";
       
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<musteri> liste = new ArrayList();
        DefaultTableModel tm = new DefaultTableModel();
        while (it.hasNext()) {            
             musteri mstri = (musteri) it.next();

             liste.add(mstri);
        }
        
        tm.addColumn("Musteri No");
        tm.addColumn("Adi");
        tm.addColumn("Soyadi");
        tm.addColumn("Telefon");
        tm.addColumn("Adres");
        tm.addColumn("Borç");
        tm.addColumn("İskonto");
        
        for(int j=0;j<liste.size();j++){
            tm.addRow(new Object[]{liste.get(j).getM_id(),liste.get(j).getM_adi(),liste.get(j).getM_soyadi(),
            liste.get(j).getM_telefon(),liste.get(j).getM_adres(),liste.get(j).getM_borc(),
            liste.get(j).getM_iskonto()});
            
        }
        
        return tm;
     }
}
