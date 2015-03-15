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

@Entity
@Table(name = "musteri")
public class musteri {
    @Id
    private int m_id;
    @Column
    private String m_adi;
    @Column
    private String m_soyadi;
    @Column
    private String m_telefon;
    @Column
    private String m_adres;
    @Column
    private int m_borc;
    @Column
    private int m_iskonto;


    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_adi() {
        return m_adi;
    }

    public void setM_adi(String m_adi) {
        this.m_adi = m_adi;
    }

    public String getM_soyadi() {
        return m_soyadi;
    }

    public void setM_soyadi(String m_soyadi) {
        this.m_soyadi = m_soyadi;
    }

    public String getM_telefon() {
        return m_telefon;
    }

    public void setM_telefon(String m_telefon) {
        this.m_telefon = m_telefon;
    }

    public String getM_adres() {
        return m_adres;
    }

    public void setM_adres(String m_adres) {
        this.m_adres = m_adres;
    }

    public int getM_borc() {
        return m_borc;
    }

    public void setM_borc(int m_borc) {
        this.m_borc = m_borc;
    }

    public int getM_iskonto() {
        return m_iskonto;
    }

    public void setM_iskonto(int m_iskonto) {
        this.m_iskonto = m_iskonto;
    }
}