package com.qiuhui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qiuhui.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@GetMapping("/{id}")
	public ModelAndView customerView(@PathVariable Integer id,Model model) {
		//service.findCustomerById(id);
		/*Customer cust = new Customer("rose","henan");
		model.addAttribute("cust",cust);
		return "/customer/view";*/
		Customer cust = new Customer("rose","henan");
		ModelAndView modelView = new ModelAndView("/customer/view");
/*		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/customer/view");
*/		modelView.addObject("cust", cust);
		return modelView;
	}
	
	@GetMapping("/new")
	public String customerNew() {
		
		return "/customer/new";
	}
	
	@PostMapping("/new")
	public String customerSave(Customer cust) {
		
//		Customer cust = new Customer();
//		cust.setName(name);
//		cust.setAddress(address);
//		System.out.println(name +"--->"+ address);
		System.out.println(cust.getName()+"---》" + cust.getAddress());
//		service.save(cust)
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/list")
	public String customerList() {
		return "/customer/list";
	}
	
	
	/*@GetMapping("/new")
	public String customerNew() {
		return "/customer/new";
	}
	
	@GetMapping("/list")
	public String customerList() {
		return "/customer/list";
	}
	@PostMapping("/new")
	public String customerView(String name ,String address) {
		
		System.out.println("formValue--》name是" + name + ",address是" + address );
		Customer cust = new Customer(name,address);
		return "redirect:/customer/list";
	}*/
	

	/*@GetMapping("/{typeName:d-\\d+}/{id:\\d+}")
	public String customerView(@PathVariable String typeName,@PathVariable Integer id) {
		
		System.out.println("我的typeName是"+ typeName);
		System.out.println("我的id是"+ id);
		return "/customer/view";
	}*/
	
	
	
/*	@GetMapping("/{id:\\d+}")
	public String customerView(@PathVariable Integer id) {
		System.out.println("我的id是"+ id);
		return "/customer/view";
	}
*/
	
	/*	@GetMapping("view")
	public String customerView() {
		
		return "/customer/view";
	}
*/	/*@PostMapping
	public String customerView() {
		
	}
	
	@RequestMapping
	public String customerView() {
		
	}*/
	
	
}
