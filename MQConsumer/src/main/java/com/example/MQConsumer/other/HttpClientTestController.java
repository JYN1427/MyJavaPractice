package com.example.MQConsumer.other;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/07/16 22:19:37
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/httpclienttestcontroller")
public class HttpClientTestController {

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(@RequestParam("id") String id, HttpServletRequest request) {
        String s = getIpAndPort(request);
        System.out.print("id=" + id);
        System.out.println(" IP端口=" + s);

        try {
            // 直接睡1分钟
            Thread.sleep(60000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok " + id;
    }


    private String getIpAndPort(HttpServletRequest request) {
        String clientIp = request.getHeader("X-Forwarded-For");
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("HTTP_CLIENT_IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }

        int clientPort = request.getRemotePort();

        return clientIp + ":" + clientPort;
    }

}
