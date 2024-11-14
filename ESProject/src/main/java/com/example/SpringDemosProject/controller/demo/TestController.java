package com.example.SpringDemosProject.controller.demo;

import com.example.SpringDemosProject.service.demo.ESDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-09-16 11:28:09
 */
@Slf4j
@Controller
@RequestMapping("/es/testcontroller")
public class TestController {

    @Autowired
    private ESDemoService esDemoService;

    @ResponseBody
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test(HttpServletRequest request, HttpServletResponse response) {
        log.info("controller处理逻辑开始...");

        try {
            esDemoService.pageSearchDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("controller处理逻辑结束...");
        return "ok";
    }

}
