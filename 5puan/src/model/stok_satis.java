/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Kürşat
 */
@Entity
@Table (name = "stok_satis")
public class stok_satis {
    @Id
    private int ss_id;
   @Column
    private int ss_adet;
    @Column
    private double ss_fiyat;   
    @Column
    private double ss_birimfiyat;
    @Column
    private String u_kod;
    @Column
    private String ss_tarih;

    public String getU_kod() {
        return u_kod;
    }

    public void setU_kod(String u_kod) {
        this.u_kod = u_kod;
    }
    
    
     public String getSs_tarih() {
        return ss_tarih;
    }

    public void setSs_tarih(String ss_tarih) {
        this.ss_tarih = ss_tarih;
    }
    
    
    public int getSs_id() {
        return ss_id;
    }

    public void setSs_id(int ss_id) {
        this.ss_id = ss_id;
    }
    public int getSs_adet() {
        return ss_adet;
    }

    public void setSs_adet(int ss_adet) {
        this.ss_adet = ss_adet;
    }

    public double getSs_fiyat() {
        return ss_fiyat;
    }

    public void setSs_fiyat(double ss_fiyat) {
        this.ss_fiyat = ss_fiyat;
    }

   

    public double getSs_birimfiyat() {
        return ss_birimfiyat;
    }

    public void setSs_birimfiyat(double ss_birimfiyat) {
        this.ss_birimfiyat = ss_birimfiyat;
    }

    
}
