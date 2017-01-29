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

import com.jaya.news.model.Users;

/**
 * @author MATET
 * 
 */
@Repository
public class UsersDAOImpl implements UsersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.UserDAO#getAllUser()
     */
    @Override
    public List<Users> getAllUser() {
	// TODO Auto-generated method stub
	return sessionFactory.getCurrentSession().createQuery("from Users")
		.list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.jaya.news.dao.UsersDAO#findUsersWhereUserAndPassword(java.lang.String
     * , java.lang.String)
     */
    @Override
    public Users findUsersWhereUserAndPassword(Users users) {
	return (Users) sessionFactory
		.getCurrentSession()
		.createQuery(
			"from Users u where u.username=:username and u.password=:password")
		.setParameter("username", users.getUsername())
		.setParameter("password", users.getPassword()).uniqueResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.UsersDAO#findUsersById()
     */
    @Override
    public Users findUsersById(int id) {
	// TODO Auto-generated method stub
	return (Users) sessionFactory.getCurrentSession()
		.createQuery("from Users u where u.id=:id")
		.setParameter("id", id).uniqueResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.dao.UsersDAO#findUsersByUserName(java.lang.String)
     */
    @Override
    public Users findUsersByUserName(String username) {
	// TODO Auto-generated method stub
	return (Users) sessionFactory.getCurrentSession()
		.createQuery("from Users u where u.username=:username")
		.setParameter("username", username).uniqueResult();
    }

}
