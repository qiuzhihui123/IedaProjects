package com.qiuhui.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiuhui.entity.User;
import com.qiuhui.exception.NotFoundException;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping(value="/page",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String page(@RequestParam(defaultValue="1") Integer p) {
		
		return "当前页为"+ p ;
	}
	
	

	@GetMapping(value="/test")
	public @ResponseBody User test() {
		System.out.println("哈哈哈");
		if(true) {
		throw new NotFoundException();
		}
		User user = new User("哈哈","小狗");
		return user;
	}
	
	@GetMapping(value="/list.json")
	public @ResponseBody List<User> listJson() {
		List<User> userList = Arrays.asList(new User("aa","aaa"),
				new User("bb","bbb"),
				new User("cc","ccc"),
				new User("dd","ddd")
				);
		
		return userList;
	}
	@GetMapping(value="/map.json")
	public @ResponseBody Map<String,User> mapJson() {
		Map<String,User> map = new HashMap<>();
		map.put("11", new User("aa","aaa"));
		map.put("22", new User("bb","bbb"));
		map.put("33", new User("cc","ccc"));
		map.put("44", new User("dd","ddd"));
		
		return map;
	}
	
/*	@GetMapping(value="/test",produces="text/plain;charset=UTF-8")
	public @ResponseBody User test() {
		return "哈哈哈，小狗";
	}
*/	
	@GetMapping("/new")
	public String userNew() {
//		System.out.println("你是不是傻");
		return "/user/new";
	}
	
	@PostMapping("/new")
	public String newUser(String username,String useraddress) {
		
		System.out.println(username +"---->"+ useraddress);
		return "redirect:/user/list";
	}
		
	@GetMapping("/list")
	public String userList(Model model) {
		
		List<User> userList = Arrays.asList(new User("aa","aaa"),
				new User("bb","bbb"),
				new User("cc","ccc"),
				new User("dd","ddd")
				);
		model.addAttribute("userList",userList);
		
		return "/user/list";
	}
	
}
