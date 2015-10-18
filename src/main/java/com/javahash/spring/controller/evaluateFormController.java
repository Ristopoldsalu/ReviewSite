package com.javahash.spring.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javahash.spring.main.Business;
import com.javahash.spring.main.NewComment;
import com.javahash.spring.mysql.JDBCMySQLmain;

@Controller
public class evaluateFormController {

	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String addComment(
			@ModelAttribute("SpringWeb") NewComment newComment, ModelMap model) {
		Business business = null;
		try {
			JDBCMySQLmain demo = new JDBCMySQLmain();

			business = demo.getBusinessInfo(newComment.getName());
			model.addAttribute("businesses", demo.getBusinesses(newComment.getName()));
			model.addAttribute("typeOfPlaces", demo.getTypeOfPlaces());
			demo.setNewComment(newComment.getName(),
					newComment.getPersonName(), business.getBusId(),
					newComment.getComment(), newComment.getGrade());

			System.out.println(demo.getBusinessInfo(newComment.getName())
					.getAverageScore()+"sadfasdf");
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute(newComment.getName());
		return "helloworld";
	}

}