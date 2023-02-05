package com.tj.exercise.springaopdemo.controller;

import com.tj.exercise.springaopdemo.dto.AopDemoDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tj
 * @Date: 2023/2/4 23:26
 */
@RestController
@RequestMapping("/aopInterViewDemo")
public class AopInterViewDemoController {
    @PostMapping("/getTitle")
    public String GetTtitle(@RequestBody AopDemoDto dto) {
        return dto.getTitle();
    }
}
