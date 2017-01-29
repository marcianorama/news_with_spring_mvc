/**
 * 
 */
package com.jaya.news.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaya.news.model.Pages;

/**
 * @author MATET
 * 
 */
@Repository
public class PagesDAOImpl implements PagesDAO {

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.PagesDAO#getAllPages()
     */
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Pages> getAllPages() {
	return sessionFactory.getCurrentSession().createQuery("from Pages")
		.list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.PagesDAO#getPagesById(int)
     */
    @Override
    public Pages getPagesById(int id) {
	Pages pages = null;
	try {
	    Criteria criteria = sessionFactory.getCurrentSession()
		    .createCriteria(Pages.class);
	    criteria.add(Restrictions.eq("id", id));
	    pages = (Pages) criteria.uniqueResult();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return pages;
    }

}
