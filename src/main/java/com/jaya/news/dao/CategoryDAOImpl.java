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

import com.jaya.news.model.Category;

/**
 * @author MATET
 * 
 */

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.CategoryDAO#getCategoryByid(int)
     */
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getCategoryByCatId(int catId) {
	List<Category> listCategory = null;
	try {
	    Criteria criteria = sessionFactory.getCurrentSession()
		    .createCriteria(Category.class);
	    criteria.add(Restrictions.eq("catId", catId));
	    listCategory = criteria.list();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return listCategory;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.CategoryDAO#getAllCategory()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getAllCategory() {
	return sessionFactory.getCurrentSession().createQuery("from Category")
		.list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.CategoryDAO#getCategory(int)
     */
    @Override
    public Category getCategory(int catId) {
	Category category = null;
	try {
	    Criteria criteria = sessionFactory.getCurrentSession()
		    .createCriteria(Category.class);
	    criteria.add(Restrictions.eq("catId", catId));
	    category = (Category) criteria.uniqueResult();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return category;
    }

}
