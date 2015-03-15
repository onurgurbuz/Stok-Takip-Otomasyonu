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
@Table(name = "urun")
public class urun {
    @Id
    private int u_id;
    @Column
    private String u_barkod;
    @Column
    private String u_adi;
    @Column
    private String u_marka;
    @Column
    private String u_kategori;
    @Column
    private String u_birim;
    @Column
    private double u_gelis;
    @Column
    private double u_satis;
    @Column
    private String u_raf;
    @Column
    private int u_kdv;
    @Column
    private int u_adet;

    public int getU_adet() {
        return u_adet;
    }

    public void setU_adet(int u_adet) {
        this.u_adet = u_adet;
    }

    
     public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
    
    
    public String getU_barkod() {
        return u_barkod;
    }

    public void setU_barkod(String u_barkod) {
        this.u_barkod = u_barkod;
    }

    public String getU_adi() {
        return u_adi;
    }

    public void setU_adi(String u_adi) {
        this.u_adi = u_adi;
    }

    public String getU_marka() {
        return u_marka;
    }

    public void setU_marka(String u_marka) {
        this.u_marka = u_marka;
    }

    public String getU_kategori() {
        return u_kategori;
    }

    public void setU_kategori(String u_kategori) {
        this.u_kategori = u_kategori;
    }

    public String getU_birim() {
        return u_birim;
    }

    public void setU_birim(String u_birim) {
        this.u_birim = u_birim;
    }

    public double getU_gelis() {
        return u_gelis;
    }

    public void setU_gelis(double u_gelıs) {
        this.u_gelis = u_gelıs;
    }

    public double getU_satis() {
        return u_satis;
    }

    public void setU_satis(double u_satis) {
        this.u_satis = u_satis;
    }

    public String getU_raf() {
        return u_raf;
    }

    public void setU_raf(String u_raf) {
        this.u_raf = u_raf;
    }

    public int getU_kdv() {
        return u_kdv;
    }

    public void setU_kdv(int u_kdv) {
        this.u_kdv = u_kdv;
    }
    
}
