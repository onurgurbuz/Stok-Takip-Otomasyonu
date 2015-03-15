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
@Table(name = "kategori")
public class kategori {
    @Id
    private int kategori_id;
    @Column
    private String kategori_ad;

    /**
     * @return the kategori_id
     */
    public int getKategori_id() {
        return kategori_id;
    }

    /**
     * @param kategori_id the kategori_id to set
     */
    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    /**
     * @return the kategori_ad
     */
    public String getKategori_ad() {
        return kategori_ad;
    }

    /**
     * @param kategori_ad the kategori_ad to set
     */
    public void setKategori_ad(String kategori_ad) {
        this.kategori_ad = kategori_ad;
    }
}
