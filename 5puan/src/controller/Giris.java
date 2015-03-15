/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.kullanici;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import view.AdminPanel;

/**
 *
 * @author Kursat
 */
public class Giris {

    public Giris() {
    }
    public int Giris(String username,String password){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        String QUERY = "from kullanici";
       
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<kullanici> liste = new ArrayList();
        int giris=0;
        while (it.hasNext()) {            
             kullanici usr = (kullanici) it.next();
             liste.add(usr);
        }
        for(int i = 0;i<liste.size();i++){
            if(liste.get(i).getPassword().equals(password)&&liste.get(i).getUsername().equals(username)){
                if(liste.get(i).getK_yetki().equals("1"))
                    giris=1;
                else
                    giris=2;
        }
            
        }
        return giris;
    }
}
