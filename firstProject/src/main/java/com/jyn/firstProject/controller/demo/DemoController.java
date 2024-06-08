package com.jyn.firstProject.controller.demo;

import com.jyn.firstProject.entities.vo.demo.DemoRequest;
import com.jyn.firstProject.entities.vo.demo.DemoResponse;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/03/04 21:53:06
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/demoController")
public class DemoController {

    // http://127.0.0.1:8001/demoController/demo2?id=1
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public DemoResponse demo(@RequestParam("id") String id) {
        return new DemoResponse();
    }

    // http://127.0.0.1:8001/demoController/demo2
    @RequestMapping(value = "/demo2", method = RequestMethod.POST)
    public DemoResponse demo2(@RequestBody DemoRequest demoRequest) {
        return new DemoResponse();
    }

    @RequestMapping(value = "/szy", method = RequestMethod.POST)
    public DemoResponse talent(@RequestBody DemoRequest demoRequest) {
        DemoResponse demoResponse = new DemoResponse();
        demoResponse.setDesc("我是一个小天才美少女爸爸");
        return demoResponse;
    }
}
