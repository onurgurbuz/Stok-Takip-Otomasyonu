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
@Table(name = "marka")
public class marka {
    @Id
    private int m_id;
    @Column
    private String m_adi;

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
    
}
