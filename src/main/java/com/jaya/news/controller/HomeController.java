/**
 * 
 */
package com.jaya.news.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jaya.news.model.Category;
import com.jaya.news.model.Comments;
import com.jaya.news.model.Details;
import com.jaya.news.model.News;
import com.jaya.news.model.Pages;
import com.jaya.news.model.Users;
import com.jaya.news.service.NewsService;

import org.apache.log4j.Logger;

/**
 * @author MATET
 * 
 */
@Controller
public class HomeController {

    private static final Logger logger = Logger.getLogger(HomeController.class);
    @Autowired
    private NewsService newsService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model,
	    @RequestParam Map<String, String> pathVariablesMap,
	    HttpServletRequest req) throws IOException {
	try {
	    PagedListHolder<News> newsList = null;
	    String type = pathVariablesMap.get("type");
	    List<News> listNewsLimit = newsService.getNewsByLimit(6);
	    List<Category> listCategory = newsService.getAllCategory();
	    List<Pages> listPages = newsService.getAllPages();
	    List<Users> listUsers = newsService.getAllUsers();
	    List<Details> listDetails = newsService.getAllDetails();

	    if (null == type) {
		// First Request, Return first set of list
		newsList = new PagedListHolder<News>();
		newsList.setSource(newsService.getAllListNews());
		newsList.setPageSize(6);
		req.getSession().setAttribute("newsList", newsList);
		printPageDetails(newsList);
	    } else if ("next".equals(type)) {
		// Return next set of list
		newsList = (PagedListHolder<News>) req.getSession()
			.getAttribute("newsList");
		newsList.nextPage();
		printPageDetails(newsList);
	    } else if ("prev".equals(type)) {
		// Return previous set of list
		newsList = (PagedListHolder<News>) req.getSession()
			.getAttribute("newsList");
		newsList.previousPage();
		printPageDetails(newsList);
	    } else {
		// Return spesific index set of list
		logger.info("type -> " + type);
		newsList = (PagedListHolder<News>) req.getSession()
			.getAttribute("newsList");
		int pageNum = Integer.parseInt(type);
		newsList.setPage(pageNum);
		printPageDetails(newsList);
	    }
	    model.addObject("listCategory", listCategory);
	    model.addObject("listPages", listPages);
	    model.addObject("listUsers", listUsers);
	    model.addObject("listDetails", listDetails);
	    model.addObject("listNewsLimit", listNewsLimit);
	    model.setViewName("pages/index");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = { "/category" }, method = RequestMethod.GET)
    public ModelAndView category(ModelAndView model,
	    @RequestParam Map<String, String> requestParams,
	    HttpServletRequest req) throws IOException {
	try {

	    Integer catId = Integer.parseInt(requestParams.get("catId"));
	    String type = requestParams.get("type");
	    PagedListHolder<News> newsList = null;

	    req.getSession().setAttribute("categoryId", catId);
	    if (null == type) {
		// First Request, Return first set of list
		newsList = new PagedListHolder<News>();
		newsList.setSource(newsService.getListNewsByCategory(catId));
		newsList.setPageSize(6);
		req.getSession().setAttribute("newsList", newsList);
		printPageDetails(newsList);
	    } else if ("next".equals(type)) {
		// Return next set of list
		newsList = (PagedListHolder<News>) req.getSession()
			.getAttribute("newsList");
		newsList.nextPage();
		printPageDetails(newsList);
	    } else if ("prev".equals(type)) {
		// Return previous set of list
		newsList = (PagedListHolder<News>) req.getSession()
			.getAttribute("newsList");
		newsList.previousPage();
		printPageDetails(newsList);
	    } else {
		// Return spesific index set of list
		logger.info("type -> " + type);
		newsList = (PagedListHolder<News>) req.getSession()
			.getAttribute("newsList");
		int pageNum = Integer.parseInt(type);
		newsList.setPage(pageNum);
		printPageDetails(newsList);
	    }

	    List<Category> listCategory = newsService.getAllCategory();
	    List<Pages> listPages = newsService.getAllPages();
	    List<Users> listUsers = newsService.getAllUsers();
	    List<Details> listDetails = newsService.getAllDetails();
	    List<News> mostReadLimit = newsService.getNewsByLimit(6);
	    // List<News> listNewsByCategory = newsService
	    // .getListNewsByCategory(catId);
	    Category category = newsService.getCategory(catId);
	    // model.addObject("listNewsByCategory", listNewsByCategory);
	    model.addObject("listCategory", listCategory);
	    model.addObject("listPages", listPages);
	    model.addObject("listUsers", listUsers);
	    model.addObject("listDetails", listDetails);
	    model.addObject("category", category);
	    model.addObject("mostReadLimit", mostReadLimit);

	    model.setViewName("pages/category");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = { "/pages" }, method = RequestMethod.GET)
    public ModelAndView pages(ModelAndView model,
	    @RequestParam Map<String, String> requestParams,
	    HttpServletRequest req) throws IOException {
	try {
	    Integer pageId = Integer.parseInt(requestParams.get("pageId"));

	    List<News> mostReadLimit = newsService.getNewsByLimit(6);
	    List<Category> listCategory = newsService.getAllCategory();
	    List<Pages> listPages = newsService.getAllPages();
	    List<Users> listUsers = newsService.getAllUsers();
	    List<Details> listDetails = newsService.getAllDetails();
	    Pages page = newsService.getPagesById(pageId);

	    model.addObject("listPages", listPages);
	    model.addObject("listUsers", listUsers);
	    model.addObject("listDetails", listDetails);
	    model.addObject("mostReadLimit", mostReadLimit);
	    model.addObject("listCategory", listCategory);
	    model.addObject("pageContent", page);

	    model.setViewName("pages/page");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = { "/news" }, method = RequestMethod.GET)
    public ModelAndView news(ModelAndView model,
	    @RequestParam Map<String, String> requestParams,
	    HttpServletRequest req) throws IOException {
	try {
	    Integer newsId = Integer.parseInt(requestParams.get("newsId"));
	    String title = requestParams.get("title");
	    List<News> mostReadLimit = newsService.getNewsByLimit(6);
	    List<Category> listCategory = newsService.getAllCategory();
	    List<Pages> listPages = newsService.getAllPages();
	    List<Users> listUsers = newsService.getAllUsers();
	    List<Details> listDetails = newsService.getAllDetails();
	    List<News> listRelatedNews = newsService.getListRelated(title,
		    newsId);
	    News news = newsService.getNewsById(newsId);
	    List<Comments> listCommentsByNewsId = newsService
		    .getListCommentsByNewsId(newsId);

	    Comments comments = new Comments();

	    req.getSession().setAttribute("newsId", newsId);
	    req.getSession().setAttribute("title", title);

	    model.addObject("listPages", listPages);
	    model.addObject("listUsers", listUsers);
	    model.addObject("listDetails", listDetails);
	    model.addObject("mostReadLimit", mostReadLimit);
	    model.addObject("listCategory", listCategory);
	    model.addObject("listRelatedNews", listRelatedNews);
	    model.addObject("news", news);
	    model.addObject("listCommentByNewsId", listCommentsByNewsId);
	    model.addObject("comments", comments);

	    model.setViewName("pages/news");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = "/addcomments", method = RequestMethod.POST)
    public ModelAndView addComments(
	    @ModelAttribute("comments") @Valid Comments comments,
	    BindingResult result, SessionStatus status, HttpServletRequest req,
	    RedirectAttributes redirectAttr) {
	ModelAndView modelAndViewComments = new ModelAndView(
		"redirect:/news?title="
			+ req.getSession().getAttribute("title") + "&newsId="
			+ req.getSession().getAttribute("newsId"));
	ModelAndView modelAndView = new ModelAndView("redirect:/news?title="
		+ req.getSession().getAttribute("title") + "&newsId="
		+ req.getSession().getAttribute("newsId"));

	if (result.hasErrors()) {
	    logger.info("ERROR ");
	    for (Object object : result.getAllErrors()) {
		if (object instanceof FieldError) {
		    FieldError fieldError = (FieldError) object;
		    redirectAttr.addFlashAttribute(fieldError.getField(),
			    messageSource.getMessage(fieldError, null));
		    logger.info("fieldError-> " + fieldError.getField());
		    logger.info("Message -> "
			    + messageSource.getMessage(fieldError, null));
		}
	    }
	    return modelAndViewComments;
	} else {
	    redirectAttr.addFlashAttribute("messAddComment",
		    "Comment Successfull Add");
	    comments.setNewsId(Integer.parseInt(req.getSession()
		    .getAttribute("newsId").toString()));
	    newsService.addComments(comments);
	    logger.info("SUCCESS ADD COMMENT");
	    return modelAndView;
	}
    }

    private void printPageDetails(PagedListHolder newsList) {

	logger.info("curent page - newsList.getPage() :" + newsList.getPage());

	logger.info("Total Num of pages - newsList.getPageCount :"
		+ newsList.getPageCount());

	logger.info("is First page - newsList.isFirstPage :"
		+ newsList.isFirstPage());

	logger.info("is Last page - newsList.isLastPage :"
		+ newsList.isLastPage());
    }
}
