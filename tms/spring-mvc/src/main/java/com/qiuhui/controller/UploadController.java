
package com.qiuhui.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

	
	
	@GetMapping("/upload")
	public String uploadGet(@RequestHeader String referer,@RequestHeader(name="user-Agent") String userAgent,@CookieValue String cust,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		
//		System.out.println(referer);
//		System.out.println(userAgent);
		String user = Base64Utils.encodeToUrlSafeString("小男孩".getBytes());
		System.out.println(user);
		//System.out.println(new String(Base64Utils.decode(user.getBytes())));
		
		//Cookie cookie = new Cookie("cust",URLEncoder.encode("小男孩"));
		Cookie cookie = new Cookie("cust",user);
		cookie.setDomain("localhost");
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24*30);
		cookie.setComment("account");
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		
		Cookie[] cookies = request.getCookies();
		
		for(Cookie coo : cookies) {
			if("cust".equals(coo.getName())) {
				System.out.println(coo.getValue());
				System.out.println(new String(Base64Utils.decode(coo.getValue().getBytes())));
//				System.out.println(URLDecoder.decode(coo.getValue()));
			}
		}
		System.out.println("-------------");
		System.out.println(cust);
		System.out.print(URLDecoder.decode(cust));
		
		System.out.println(new String(Base64Utils.decode(cust.getBytes())));
		
		return "upload/upload";
	}
	
	@PostMapping("/upload")
	public String uploadPost(@RequestParam(name="fileName") MultipartFile photo
			,RedirectAttributes redirectAttributes
			) {
		if(!photo.isEmpty()) {
		String name = photo.getName();//上传文件的input框的name属性
		String fileName= photo.getOriginalFilename();//文件名
		String size = FileUtils.byteCountToDisplaySize(photo.getSize());//文件的大小
		String mime = photo.getContentType();//mime类型
		System.out.println(name);
		System.out.println(fileName);
		System.out.println(size);
		System.out.println(mime);
		
		try {
			byte[] buffer = photo.getBytes();
			OutputStream out = new FileOutputStream("e:/upload/"+fileName);
			out.write(buffer);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} else {
			System.out.println("请选择文件");
			redirectAttributes.addFlashAttribute("message", "请选择文件");
		}
		
		
		return "redirect:/upload";
		
	}
	
}
