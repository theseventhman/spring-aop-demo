package com.tj.exercise.springaopdemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exercise.springaopdemo.dto.AopDemoDto;



@RestController
@RequestMapping("/aopDemo")
public class AopDemoController {
    @PostMapping("/getTitle") 
	public String GetTtitle(@RequestBody AopDemoDto dto) {
		return dto.getTitle();
	}
}
