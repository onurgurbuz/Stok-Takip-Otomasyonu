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

import model.personel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Kursat
 */
public class PersoneIslemleri {
     SessionFactory sf = HibernateUtil.getSessionFactory();
     Session session = sf.openSession();
     Transaction ts = session.beginTransaction();
        
        
        
    public void personelEkle(personel prsnl){
        String QUERY = "from personel";
        int ekle=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<personel> liste = new ArrayList();
        while (it.hasNext()) {            
             personel prsnl2 = (personel) it.next();
             liste.add(prsnl2);
        }
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).getK_id()==prsnl.getK_id()){
                JOptionPane.showMessageDialog(null,"Bu kullanıcı numarası kullanılmaktadır..!");
                ekle=1;
            }
        }
        
        if(ekle==0){
        session.saveOrUpdate(prsnl);
        ts.commit();
        }
    }
    public int personelSil(String p_id){
        String QUERY = "from personel";
        int sil=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<personel> liste = new ArrayList();
        while (it.hasNext()) {            
             personel prsnl = (personel) it.next();
             liste.add(prsnl);
        }
        for(int i=0;i<liste.size();i++){
            if(Integer.toString(liste.get(i).getP_id()).equals(p_id))
                
                sil=1;
        }
        if(sil==0){
            return sil;
            
        }
        else{
             try {
                Query query = session.createQuery("delete from personel where p_id=:p_id");
                query.setString("p_id",p_id);
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
    
    public DefaultTableModel PersonelGetir(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        String QUERY = "from personel";
       
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<personel> liste = new ArrayList();
        DefaultTableModel tm = new DefaultTableModel();
        while (it.hasNext()) {            
             personel persnl = (personel) it.next();
             
             liste.add(persnl);
        }
        tm.addColumn("Persnl No");
        tm.addColumn("Ad");
        tm.addColumn("Soyad");
        tm.addColumn("Telefon");
        tm.addColumn("Adres");
        tm.addColumn("Maaş");
        tm.addColumn("Puantaj");
        tm.addColumn("k_id");
        
         for(int j=0;j<liste.size();j++){
            tm.addRow(new Object[]{liste.get(j).getP_id(),liste.get(j).getP_adi(),liste.get(j).getP_soyadi(),liste.get(j).getP_telefon(),
            liste.get(j).getP_adresi(),liste.get(j).getP_maas(),liste.get(j).getP_puantaj(),liste.get(j).getK_id()});
        }
        return tm;
    }
}
