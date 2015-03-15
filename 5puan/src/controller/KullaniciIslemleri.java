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
import model.kullanici;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Kursat
 */
public class KullaniciIslemleri {
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();
    Transaction ts = session.beginTransaction();
    
    
    
    
    
    public int KullaniciEkle(String username,String password){
        
        String QUERY = "from kullanici";
        int ekle=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<kullanici> liste = new ArrayList();
        while (it.hasNext()) {            
             kullanici usr = (kullanici) it.next();
             liste.add(usr);
        }
        if(username.trim().equals("")&&password.trim().equals("")){
            JOptionPane.showMessageDialog(null,"Kullanıcı adı veya şifre alanı boş bırakılamaz");
            return 1;
        }
        else{
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).getUsername().equals(username)){
                
                ekle=1;
            }
        }
        if(ekle==0){
        model.kullanici usr = new kullanici();
        usr.setUsername(username);
        usr.setPassword(password);
        usr.setK_yetki("2");
        JOptionPane.showMessageDialog(null,"Başari ile Eklendi");
        session.saveOrUpdate(usr);
        ts.commit();   
        }
        else
            JOptionPane.showMessageDialog(null,"Boyle bir kullanıcı zaten mevcut");
        }
        return ekle;
    }
    public DefaultTableModel KullaniciGetir()
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        String QUERY = "from kullanici";
       
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<kullanici> liste = new ArrayList();
        DefaultTableModel tm = new DefaultTableModel();
        while (it.hasNext()) {            
             kullanici usr = (kullanici) it.next();
             
             liste.add(usr);
        }
        tm.addColumn("Kullanıcı no");
        tm.addColumn("Kullanıcı Adı");
        tm.addColumn("Kullanıcı Şifresi");
        tm.addColumn("Yetki");
        
        for(int j=0;j<liste.size();j++){
            tm.addRow(new Object[]{liste.get(j).getK_id(),liste.get(j).getUsername(),liste.get(j).getPassword(),liste.get(j).getK_yetki()});
        }
        
        return tm;
    }
    
    public void KullaniciSil(String username){
        String QUERY = "from kullanici";
        int sil=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<kullanici> liste = new ArrayList();
        while (it.hasNext()) {            
             kullanici usr = (kullanici) it.next();
             liste.add(usr);
        }
      
        
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).getUsername().equals(username)){
                sil=1;
            }
        }
        if(sil==1){
            try{
        Query query = session.createQuery("delete from kullanici where username=:username");
        query.setString("username", username);
        query.executeUpdate();
        System.out.println(query.executeUpdate());
        if(username.equals("Admin"))
            JOptionPane.showMessageDialog(null,"Admin silinemez!");
        else          
            ts.commit();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Önce bu kullanıcıya ait personeli siliniz\n "+ex);
            }
                }
        else if(sil==0){
            JOptionPane.showMessageDialog(null,"Böyle bir kullanıcı adı mecut değil");
        }
    }
    
}
