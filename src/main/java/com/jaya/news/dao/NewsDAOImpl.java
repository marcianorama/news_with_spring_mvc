/**
 * 
 */
package com.jaya.news.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaya.news.model.News;

/**
 * @author MATET
 * 
 */
@Repository
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<News> getAllListNews() {
	return sessionFactory
		.getCurrentSession()
		.createQuery(
			"from News n join fetch n.userId order by n.newsId desc")
		.list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.NewsDAO#getListLimit(int)
     */
    @Override
    public List<News> getListLimit(int limit) {
	List<News> listNewsLimit = null;
	try {
	    Criteria criteria = sessionFactory.getCurrentSession()
		    .createCriteria(News.class);
	    criteria.addOrder(Order.desc("visits"));
	    criteria.setMaxResults(limit);
	    listNewsLimit = criteria.list();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return listNewsLimit;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.NewsDAO#countList()
     */
    @Override
    public Long countList() {
	return (Long) sessionFactory.getCurrentSession()
		.createCriteria(News.class)
		.setProjection(Projections.rowCount()).uniqueResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.NewsDAO#getListRelated(java.lang.String, int)
     */
    @Override
    public List<News> getListRelated(String title, int newsId) {
	List<News> listNewsRelated = null;
	try {
	    Criteria criteria = sessionFactory.getCurrentSession()
		    .createCriteria(News.class);
	    criteria.add(Restrictions.ilike("title", title));
	    criteria.add(Restrictions.ne("newsId", newsId));
	    criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
	    listNewsRelated = criteria.list();

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.NewsDAO#getListNewsByCategory(int)
     */
    @Override
    public List<News> getListNewsByCategory(int catId) {
	List<News> listNewsByCaetegory = null;
	try {
	    Criteria criteria = sessionFactory.getCurrentSession()
		    .createCriteria(News.class);
	    criteria.add(Restrictions.eq("catId", catId));
	    criteria.addOrder(Order.desc("newsId"));
	    listNewsByCaetegory = criteria.list();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return listNewsByCaetegory;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.NewsDAO#getNewsById(int)
     */
    @Override
    public News getNewsById(int id) {
	News news = null;
	try {
	    Criteria criteria = sessionFactory.getCurrentSession()
		    .createCriteria(News.class);
	    criteria.createAlias("userId", "u");
	    criteria.add(Restrictions.eq("id", id));
	    news = (News) criteria.uniqueResult();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return news;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.NewsDAO#addNews(com.jaya.news.model.News)
     */
    @Override
    public void addNews(News news) {
	sessionFactory.getCurrentSession().save(news);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.NewsDAO#updateNews(com.jaya.news.model.News)
     */
    @Override
    public void updateNews(News news) {
	try {
	    // News n = (News) sessionFactory.getCurrentSession()
	    // .createQuery("from News n where n.newsId=:newsId")
	    // .setParameter("newsId", news.getNewsId()).uniqueResult();
	    // n.setTitle(news.getTitle());
	    // n.setContent(news.getContent());
	    // n.setUserId(news.getUserId());
	    // n.setCatId(news.getCatId());
	    // n.setYoutubeVideo(news.getYoutubeVideo());

	    sessionFactory.getCurrentSession().merge(news);
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.NewsDAO#deleteNews(com.jaya.news.model.News)
     */
    @Override
    public void deleteNews(News news) {
	try {
	    sessionFactory.getCurrentSession().delete(news);
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
}
