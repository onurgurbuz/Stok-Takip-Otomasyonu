/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Kursat
 */
@Entity
@Table(name = "personel")
public class personel {
    @Id
    private int p_id;
    @Column
    private String p_adi;
    @Column
    private String p_soyadi;
    @Column
    private String p_adresi;
    @Column
    private int p_puantaj;
    @Column
    private int p_maas;
    @Column
    private int k_id;
    @Column
    private String p_telefon;

    public String getP_telefon() {
        return p_telefon;
    }

    public void setP_telefon(String p_telefon) {
        this.p_telefon = p_telefon;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }
    
    public String getP_adi() {
        return p_adi;
    }

    public void setP_adi(String p_adi) {
        this.p_adi = p_adi;
    }

    public String getP_soyadi() {
        return p_soyadi;
    }

    public void setP_soyadi(String p_soyadi) {
        this.p_soyadi = p_soyadi;
    }

    public String getP_adresi() {
        return p_adresi;
    }

    public void setP_adresi(String p_adres) {
        this.p_adresi = p_adres;
    }

    public int getP_puantaj() {
        return p_puantaj;
    }

    public void setP_puantaj(int p_puantaj) {
        this.p_puantaj = p_puantaj;
    }

    public int getP_maas() {
        return p_maas;
    }

    public void setP_maas(int p_maas) {
        this.p_maas = p_maas;
    }

    public int getK_id() {
        return k_id;
    }

    public void setK_id(int k_id) {
        this.k_id = k_id;
    }
}
