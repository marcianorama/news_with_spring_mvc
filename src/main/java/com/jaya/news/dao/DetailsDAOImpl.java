/**
 * 
 */
package com.jaya.news.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaya.news.model.Details;

/**
 * @author MATET
 * 
 */
@Repository
public class DetailsDAOImpl implements DetailsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.DetailsDAO#getAllDetails()
     */
    @Override
    public List<Details> getAllDetails() {
	return sessionFactory.getCurrentSession().createQuery("from Details")
		.list();
    }

}
