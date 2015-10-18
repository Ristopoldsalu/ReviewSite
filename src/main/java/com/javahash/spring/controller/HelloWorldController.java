package com.javahash.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javahash.spring.main.NewComment;
import com.javahash.spring.mysql.JDBCMySQLmain;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public String hello(
			@RequestParam(value = "name", required = false) String name,
			Model model) {
		try {
			JDBCMySQLmain demo = new JDBCMySQLmain();
			model.addAttribute("typeOfPlaces", demo.getTypeOfPlaces());
			if (demo.getTypeOfPlaces() != null) {
				System.out.println("midagi tuli "
						+ demo.getTypeOfPlaces().size());
				ArrayList<String> listi = demo.getTypeOfPlaces();
				for (int i = 0; i < listi.size(); i++) {
					System.out.println(listi.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("name", name);
		// returns the view name
		return "helloworld";

	}

	@RequestMapping("/change")
	public String change(
			@RequestParam(value = "name", required = false, defaultValue = "Restoran") String name,
			Model model) {

		try {
			JDBCMySQLmain demo = new JDBCMySQLmain();
			model.addAttribute("businesses", demo.getBusinesses(name));
			model.addAttribute("typeOfPlaces", demo.getTypeOfPlaces());
			System.out
					.println("midagi tuli " + demo.getBusinesses(name).size());

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("name", name);
		// returns the view name
		return "helloworld";

	}

	@RequestMapping("/evaluate")
	public ModelAndView goEvaluate(
			@RequestParam(value = "name", required = false) String name,
			Model model) {
		
			System.out.println(name + "asdfasdfasd");
		try {
			System.out.println(name + "asdfasdfasd");
			JDBCMySQLmain demo = new JDBCMySQLmain();
			
			model.addAttribute("business", demo.getBusinessInfo(name));
			System.out.println("siin jookseb kokku");
			System.out.println(demo.getBusinessInfo(name).getAverageScore()+"jjkjkjkj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		ArrayList<Integer>numbers = new ArrayList<Integer>();
		numbers.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		model.addAttribute("numbers", numbers);
		model.addAttribute("name", name);
		// returns the view name
		return new ModelAndView("evaluateForm", "command", new NewComment());
	}
}