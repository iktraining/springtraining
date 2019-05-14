package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/")
public class TestController {

	public TestController() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@RequestMapping("")
	@ResponseBody
	public String test() {
		return "OK";
	}


}
