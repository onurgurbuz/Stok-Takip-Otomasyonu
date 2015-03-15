/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.kullanici;
import model.urun;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Kürşat
 */
public class SifreIslemleri {
    int degisim=0;
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();
    Transaction ts = session.beginTransaction();
    
    
    public int  SifreDegistir(String k_adi,String eski_sifre,String yeni_sifre,String yeni_sifre_tekrar){
        String QUERY = "from kullanici";
        Query query = session.createQuery(QUERY);
        Iterator it = query.iterate();
        
        
        
        ArrayList<kullanici> liste = new ArrayList();
        while (it.hasNext()) {            
             kullanici usr = (kullanici) it.next();
             if(usr.getUsername().equals(k_adi))
                liste.add(usr);
        }
        
        if(liste.size()==0){
            degisim=2;//kullanici adi bulunamadi hatasi
            JOptionPane.showMessageDialog(null,liste.get(0).getK_id());
        }else if(liste.get(0).getPassword().equals(eski_sifre)){
            if(yeni_sifre.equals(yeni_sifre_tekrar)){
                String QUERY2 = "UPDATE kullanici set password = :yeni_sifre WHERE username = :k_adi";
                
                Query query2 = session.createQuery(QUERY2);
                query2.setParameter("yeni_sifre",yeni_sifre);
                query2.setParameter("k_adi",k_adi);
                query2.executeUpdate();
                ts.commit();
                degisim =1;                //şifrenin değiştiği durumdur
                
            }
            else
            degisim =4;//yeni şifre ile tekrar uyuşmazlığıdır.
        }
        else{
            degisim =3;//şifrenin yanlis oldugu durumdur.
        }
        
        
        
        
        return degisim;
    }
}
