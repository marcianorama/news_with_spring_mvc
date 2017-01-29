/**
 * 
 */
package com.jaya.news.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaya.news.model.Comments;

/**
 * @author MATET
 * 
 */
@Repository
public class CommentDAOImpl implements CommentsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.CommentsDAO#getListCommentsByNewsId(int)
     */
    @Override
    public List<Comments> getListCommentsByNewsId(int newsId) {
	List<Comments> listComments = null;
	try {
	    Criteria criteria = sessionFactory.getCurrentSession()
		    .createCriteria(Comments.class);
	    criteria.add(Restrictions.eq("newsId", newsId));
	    criteria.addOrder(Order.desc("commntId"));
	    listComments = criteria.list();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return listComments;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.jaya.news.dao.CommentsDAO#addEmployee(com.jaya.news.model.Comments)
     */
    @Override
    public void addEmployee(Comments comments) {
	sessionFactory.getCurrentSession().save(comments);
    }
}
