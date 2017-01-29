/**
 * 
 */
package com.jaya.news.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Logger;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jaya.news.model.Category;
import com.jaya.news.model.News;
import com.jaya.news.model.Users;
import com.jaya.news.service.NewsService;

/**
 * @author MATET
 * 
 */
@Controller
public class AdminController {

    private static final Logger logger = Logger
	    .getLogger(AdminController.class);
    @Autowired
    private NewsService newsService;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    ServletContext context;

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public ModelAndView login(ModelAndView model, HttpServletRequest request,
	    HttpServletResponse response) throws IOException {
	try {
	    Users users = new Users();
	    model.addObject("usersBean", users);
	    model.setViewName("login");
	} catch (Exception e) {

	}
	return model;
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    public ModelAndView executeLogin(ModelAndView model,
	    HttpServletRequest request, HttpServletResponse response,
	    @ModelAttribute("usersBean") Users users, @Valid Users usersBean,
	    BindingResult result, RedirectAttributes redirectAttr)
	    throws IOException {
	try {
	    if (result.hasErrors()) {
		logger.info("HAS ERRORS");
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

		redirectAttr.addFlashAttribute("message", "LOGIN FAILED");
		model.setViewName("redirect:login");
	    } else {
		logger.info("SUCCESS LOGIN");
		request.getSession().setAttribute("LOGGEDIN_USER", users);
		request.getSession().setAttribute("userLogin",
			users.getUsername());
		Users u = newsService.findUsersByUsernameAndPassword(users);
		if (u != null) {
		    redirectAttr.addFlashAttribute("message", "LOGIN SUCCESS");
		} else {
		    redirectAttr.addFlashAttribute("message",
			    "LOGIN FAILED USER OR PASSWORD NOT MATCH");
		}
		model.setViewName("redirect:login/admin");
	    }
	} catch (Exception e) {

	}
	return model;
    }

    @RequestMapping(value = { "/admin/addnews" }, method = RequestMethod.GET)
    public ModelAndView addnews(ModelAndView model,
	    @RequestParam Map<String, String> requestParams,
	    HttpServletRequest req) throws IOException {
	try {
	    List<Category> listCategory = newsService.getAllCategory();
	    News news = new News();
	    model.addObject("listCategory", listCategory);
	    if (req.getParameter("newsId") != null) {
		req.getSession().setAttribute("newsId",
			req.getParameter("newsId"));
		model.addObject("news", newsService.getNewsById(Integer
			.parseInt(req.getParameter("newsId"))));
		model.addObject("editNews", "editing");
	    } else {
		model.addObject("news", news);
	    }
	    model.setViewName("admin/addnews");
	} catch (Exception e) {

	}
	return model;
    }

    @RequestMapping(value = { "/login/admin" }, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model,
	    @RequestParam Map<String, String> pathVariablesMap,
	    HttpServletRequest req) throws IOException {
	try {
	    model.setViewName("admin/content");
	} catch (Exception e) {

	}
	return model;
    }

    @RequestMapping(value = "/admin/addnews", method = RequestMethod.POST)
    public ModelAndView addNewsPost(@ModelAttribute("news") @Valid News news,
	    BindingResult result, SessionStatus status, HttpServletRequest req,
	    RedirectAttributes redirectAttr,
	    @RequestParam(value = "file", required = false) MultipartFile file) {
	ModelAndView modelAndView = new ModelAndView();
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
	    modelAndView.setViewName("redirect:/admin/addnews");
	    return modelAndView;
	} else {
	    if (file != null) {
		if (!file.isEmpty()) {
		    try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");

			File dir = new File(rootPath + File.separator
				+ "tmpFiles");
			if (!dir.exists())
			    dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
				+ File.separator
				+ file.getOriginalFilename().replaceAll(
					"[^a-zA-Z0-9.-]", ""));

			BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			logger.info("Server File Location="
				+ serverFile.getAbsolutePath());

			logger.info("You successfully uploaded file="
				+ file.getOriginalFilename());
			news.setTitle(req.getParameter("title").trim());
			news.setContent(req.getParameter("content").trim());
			news.setImage(file.getOriginalFilename());
			news.setYoutubeVideo(req.getParameter("youtubeVideo")
				.trim());
			news.setCatId(Integer.parseInt(req
				.getParameter("cat_id")));
			Users users = newsService.findUsersByUserName(req
				.getSession().getAttribute("userLogin")
				.toString().trim());
			news.setUserId(users);
			newsService.addNews(news);
			redirectAttr.addFlashAttribute("messageAddNewsSuccess",
				"ADD NEWS DATA SUCCESS");
			modelAndView.setViewName("redirect:/admin/addnews");
			// }
			return modelAndView;
		    } catch (Exception e) {
			e.printStackTrace();
			redirectAttr.addFlashAttribute("messageAddNewsFailed",
				"ADD NEWS DATA FAILED");
			logger.info("You failed to upload "
				+ file.getOriginalFilename() + " => "
				+ e.getMessage());
			modelAndView.setViewName("redirect:/admin/addnews");
			return modelAndView;
		    }
		} else {
		    redirectAttr.addFlashAttribute("messageAddNewsFailed",
			    "ADD NEWS DATA FAILED");
		    logger.info("You failed to upload "
			    + file.getOriginalFilename()
			    + " because the file was empty.");
		    modelAndView.setViewName("redirect:/admin/addnews");
		    return modelAndView;
		}
	    } else {
		News newsUpdate = newsService.getNewsById(Integer.parseInt(req
			.getSession().getAttribute("newsId").toString()));
		newsUpdate.setTitle(req.getParameter("title").trim());
		newsUpdate.setContent(req.getParameter("content").trim());
		newsUpdate.setYoutubeVideo(req.getParameter("youtubeVideo")
			.trim());
		newsUpdate
			.setCatId(Integer.parseInt(req.getParameter("cat_id")));
		Users users = newsService.findUsersByUserName(req.getSession()
			.getAttribute("userLogin").toString().trim());
		newsUpdate.setUserId(users);
		newsService.updateNews(newsUpdate);
		redirectAttr.addFlashAttribute("messageUpdateNewsSuccess",
			"UPDATE NEWS DATA SUCCESS");
		modelAndView.setViewName("redirect:/admin/managenews");
	    }

	}
	return modelAndView;

    }

    @RequestMapping(value = "/admin/deletenews", method = RequestMethod.GET)
    public ModelAndView deleteNews(HttpServletRequest request,
	    RedirectAttributes redirectAttr) {
	try {
	    News news = newsService.getNewsById(Integer.parseInt(request
		    .getParameter("newsId").toString()));
	    newsService.deleteNews(news);
	    redirectAttr.addFlashAttribute("messageDeleteNews", "DELETE DATA SUCCESS");
	} catch (Exception e) {
	    redirectAttr.addFlashAttribute("messageDeleteNews", "DELETE DATA FAILED");
	    e.printStackTrace();
	}

	return new ModelAndView("redirect:/admin/managenews");
    }

    @RequestMapping(value = { "/admin/managenews" }, method = RequestMethod.GET)
    public ModelAndView managenews(ModelAndView model,
	    @RequestParam Map<String, String> requestParams,
	    HttpServletRequest req) throws IOException {
	try {
	    PagedListHolder<News> newsList = null;
	    String type = requestParams.get("type");
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

	    model.setViewName("admin/managenews");
	} catch (Exception e) {

	}
	return model;
    }

    @RequestMapping(value = "/login/admin/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:/login";
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
