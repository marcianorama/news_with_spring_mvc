/**
 * 
 */
package com.jaya.news.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	return sessionFactory.getCurrentSession().createQuery("from News")
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
	    criteria.addOrder(Order.desc("newsId"));
	    criteria.setMaxResults(limit);
	    listNewsLimit = criteria.list();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return listNewsLimit;
    }

}
