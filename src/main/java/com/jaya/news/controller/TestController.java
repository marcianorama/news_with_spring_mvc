/**
 * 
 */
package com.jaya.news.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jaya.news.model.News;
import com.jaya.news.service.NewsService;

/**
 * @author MATET
 * 
 */
@Controller
public class TestController {

    @Autowired
    private NewsService newsService;

    // @RequestMapping(value = "/", method = RequestMethod.GET)
    // public ModelAndView index(HttpServletRequest req, HttpServletResponse
    // res) {
    // ModelAndView modelandView = new ModelAndView("index");
    // modelandView.addObject("listNews", this.newsService.listNews());
    // return modelandView;
    // }
    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView model) throws IOException {
	try {
	    List<News> listNewsLimit = newsService.getNewsByLimit(6);
	    for (News news : listNewsLimit) {
		System.err.println("image -> "+news.getImage());
	    }
	    model.addObject("listNewsLimit", listNewsLimit);
	    model.setViewName("index");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }
}
