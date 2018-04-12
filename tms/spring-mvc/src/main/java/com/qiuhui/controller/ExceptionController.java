package com.qiuhui.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.qiuhui.exception.NotFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(NotFoundException.class)
	public String notFound() {
		return "error/500";
	}
}
