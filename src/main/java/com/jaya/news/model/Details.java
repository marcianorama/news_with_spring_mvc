/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaya.news.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MATET
 */
@Entity
@Table(name = "details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Details.findAll", query = "SELECT d FROM Details d")})
public class Details implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fb")
    private String fb;
    @Basic(optional = false)
    @Column(name = "tw")
    private String tw;
    @Basic(optional = false)
    @Column(name = "ins")
    private String ins;
    @Basic(optional = false)
    @Lob
    @Column(name = "twitterbox")
    private String twitterbox;

    public Details() {
    }

    public Details(Integer id) {
        this.id = id;
    }

    public Details(Integer id, String fb, String tw, String ins, String twitterbox) {
        this.id = id;
        this.fb = fb;
        this.tw = tw;
        this.ins = ins;
        this.twitterbox = twitterbox;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getTw() {
        return tw;
    }

    public void setTw(String tw) {
        this.tw = tw;
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }

    public String getTwitterbox() {
        return twitterbox;
    }

    public void setTwitterbox(String twitterbox) {
        this.twitterbox = twitterbox;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Details)) {
            return false;
        }
        Details other = (Details) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sample.dto.Details[ id=" + id + " ]";
    }
    
}
