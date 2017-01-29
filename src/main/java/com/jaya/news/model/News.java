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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author MATET
 */
@Entity
@Table(name = "news")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n") })
public class News implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "news_id")
    private Integer newsId;
    @Basic(optional = false)
    @Column(name = "title")
    @NotEmpty(message = "Title is required!")
    private String title;
    @Basic(optional = false)
    @Lob
    @Column(name = "content")
    @NotEmpty(message = "Content is required!")
    @Size(min = 190, max = 1000000)
    private String content;
    // @Basic(optional = false)
    // @Column(name = "user_id")
    // private int userId;
    @Basic(optional = false)
    @Column(name = "cat_id")
    private int catId;
    @Basic(optional = false)
    @Lob
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Lob
    @Column(name = "youtube_video")
    private String youtubeVideo;
    @Basic(optional = false)
    @Column(name = "dateposted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateposted;
    @Basic(optional = false)
    @Column(name = "visits")
    private int visits;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users userId;

    public News() {
    }

    public News(Integer newsId) {
	this.newsId = newsId;
    }

    // public News(Integer newsId, String title, String content, int userId,
    // int catId, String image, String youtubeVideo, Date dateposted,
    // int visits) {
    // this.newsId = newsId;
    // this.title = title;
    // this.content = content;
    // this.userId = userId;
    // this.catId = catId;
    // this.image = image;
    // this.youtubeVideo = youtubeVideo;
    // this.dateposted = dateposted;
    // this.visits = visits;
    // }

    public Integer getNewsId() {
	return newsId;
    }

    public void setNewsId(Integer newsId) {
	this.newsId = newsId;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    // public int getUserId() {
    // return userId;
    // }
    //
    // public void setUserId(int userId) {
    // this.userId = userId;
    // }

    public int getCatId() {
	return catId;
    }

    /**
     * @return the userId
     */
    public Users getUserId() {
	return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(Users userId) {
	this.userId = userId;
    }

    public void setCatId(int catId) {
	this.catId = catId;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    public String getYoutubeVideo() {
	return youtubeVideo;
    }

    public void setYoutubeVideo(String youtubeVideo) {
	this.youtubeVideo = youtubeVideo;
    }

    public Date getDateposted() {
	return dateposted;
    }

    public void setDateposted(Date dateposted) {
	this.dateposted = dateposted;
    }

    public int getVisits() {
	return visits;
    }

    public void setVisits(int visits) {
	this.visits = visits;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (newsId != null ? newsId.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are
	// not set
	if (!(object instanceof News)) {
	    return false;
	}
	News other = (News) object;
	if ((this.newsId == null && other.newsId != null)
		|| (this.newsId != null && !this.newsId.equals(other.newsId))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "com.sample.dto.News[ newsId=" + newsId + " ]";
    }

}
