/**
 * 
 */
package com.jaya.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaya.news.dao.CategoryDAO;
import com.jaya.news.dao.CommentsDAO;
import com.jaya.news.dao.DetailsDAO;
import com.jaya.news.dao.NewsDAO;
import com.jaya.news.dao.PagesDAO;
import com.jaya.news.dao.UsersDAO;
import com.jaya.news.model.Category;
import com.jaya.news.model.Comments;
import com.jaya.news.model.Details;
import com.jaya.news.model.News;
import com.jaya.news.model.Pages;
import com.jaya.news.model.Users;

/**
 * @author MATET
 * 
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private PagesDAO pagesDAO;
    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private DetailsDAO detailsDAO;
    @Autowired
    private CommentsDAO commentsDAO;

    @Override
    @Transactional
    public List<News> getAllListNews() {
	// TODO Auto-generated method stub
	return newsDAO.getAllListNews();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getNewsByLimit()
     */
    @Override
    public List<News> getNewsByLimit(int limit) {
	// TODO Auto-generated method stub
	return newsDAO.getListLimit(limit);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getAllCategoryByCatId(int)
     */
    @Override
    public List<Category> getAllCategoryByCatId(int catId) {
	// TODO Auto-generated method stub
	return categoryDAO.getCategoryByCatId(catId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getAllCategory()
     */
    @Override
    public List<Category> getAllCategory() {
	return categoryDAO.getAllCategory();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getAllPages()
     */
    @Override
    public List<Pages> getAllPages() {
	// TODO Auto-generated method stub
	return pagesDAO.getAllPages();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getAllUsers()
     */
    @Override
    public List<Users> getAllUsers() {
	// TODO Auto-generated method stub
	return usersDAO.getAllUser();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getAllDetails()
     */
    @Override
    public List<Details> getAllDetails() {
	// TODO Auto-generated method stub
	return detailsDAO.getAllDetails();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getListRelated(java.lang.String,
     * int)
     */
    @Override
    public List<News> getListRelated(String title, int newsId) {
	// TODO Auto-generated method stub
	return newsDAO.getListRelated(title, newsId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getListNewsByCategory(int)
     */
    @Override
    public List<News> getListNewsByCategory(int catId) {
	// TODO Auto-generated method stub
	return newsDAO.getListNewsByCategory(catId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getCategory()
     */
    @Override
    public Category getCategory(int catId) {
	// TODO Auto-generated method stub
	return categoryDAO.getCategory(catId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getPagesById(int)
     */
    @Override
    public Pages getPagesById(int id) {
	// TODO Auto-generated method stub
	return pagesDAO.getPagesById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getNewsById(int)
     */
    @Override
    public News getNewsById(int id) {
	// TODO Auto-generated method stub
	return newsDAO.getNewsById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getListCommentsByNewsId(int)
     */
    @Override
    public List<Comments> getListCommentsByNewsId(int newsId) {
	// TODO Auto-generated method stub
	return commentsDAO.getListCommentsByNewsId(newsId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.jaya.news.service.NewsService#addComments(com.jaya.news.model.Comments
     * )
     */
    @Override
    public void addComments(Comments comments) {
	commentsDAO.addEmployee(comments);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.jaya.news.service.NewsService#findUsersByUsernameAndPassword(com.
     * jaya.news.model.Users)
     */
    @Override
    public Users findUsersByUsernameAndPassword(Users users) {
	// TODO Auto-generated method stub
	return usersDAO.findUsersWhereUserAndPassword(users);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#addNews(com.jaya.news.model.News)
     */
    @Override
    public void addNews(News news) {
	// TODO Auto-generated method stub
	newsDAO.addNews(news);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#findUsersById(int)
     */
    @Override
    public Users findUsersById(int id) {
	// TODO Auto-generated method stub
	return usersDAO.findUsersById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.jaya.news.service.NewsService#findUsersByUserName(java.lang.String)
     */
    @Override
    public Users findUsersByUserName(String userName) {
	return usersDAO.findUsersByUserName(userName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.jaya.news.service.NewsService#updateNews(com.jaya.news.model.News)
     */
    @Override
    public void updateNews(News news) {
	newsDAO.updateNews(news);

    }

    /* (non-Javadoc)
     * @see com.jaya.news.service.NewsService#deleteNews(com.jaya.news.model.News)
     */
    @Override
    public void deleteNews(News news) {
	newsDAO.deleteNews(news);
    }
}
