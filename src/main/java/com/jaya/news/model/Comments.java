/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaya.news.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author MATET
 */
@Entity
@Table(name = "comments")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c") })
public class Comments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "commnt_id")
    private Integer commntId;
    @Basic(optional = false)
    @Column(name = "news_id")
    private int newsId;
    @Basic(optional = false)
    @Column(name = "poster_name")
    @NotEmpty(message = "Name is required!")
    private String posterName;
    @Basic(optional = false)
    @Lob
    @Column(name = "comment")
    @NotEmpty(message = "Comment is required!")
    private String comment;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Comments() {
    }

    public Comments(Integer commntId) {
	this.commntId = commntId;
    }

    public Comments(Integer commntId, int newsId, String posterName,
	    String comment, Date date) {
	this.commntId = commntId;
	this.newsId = newsId;
	this.posterName = posterName;
	this.comment = comment;
	this.date = date;
    }

    public Integer getCommntId() {
	return commntId;
    }

    public void setCommntId(Integer commntId) {
	this.commntId = commntId;
    }

    public int getNewsId() {
	return newsId;
    }

    public void setNewsId(int newsId) {
	this.newsId = newsId;
    }

    public String getPosterName() {
	return posterName;
    }

    public void setPosterName(String posterName) {
	this.posterName = posterName;
    }

    public String getComment() {
	return comment;
    }

    public void setComment(String comment) {
	this.comment = comment;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (commntId != null ? commntId.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are
	// not set
	if (!(object instanceof Comments)) {
	    return false;
	}
	Comments other = (Comments) object;
	if ((this.commntId == null && other.commntId != null)
		|| (this.commntId != null && !this.commntId
			.equals(other.commntId))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "com.sample.dto.Comments[ commntId=" + commntId + " ]";
    }

}
