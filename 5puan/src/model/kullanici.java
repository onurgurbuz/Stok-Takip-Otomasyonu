/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kursat
 */
@Entity
@Table(name = "kullanici")
    public class kullanici{
    @Id
    private int k_id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String k_yetki;



    
    public int getK_id() {
        return k_id;
    }

    public void setK_id(int k_id) {
        this.k_id = k_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getK_yetki() {
        return k_yetki;
    }

    public void setK_yetki(String k_yetki) {
        this.k_yetki = k_yetki;
    }
    
}
