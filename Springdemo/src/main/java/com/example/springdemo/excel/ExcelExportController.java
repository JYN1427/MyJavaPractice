package com.example.springdemo.excel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/07/05 21:41:52
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/export")
public class ExcelExportController {

    @Autowired
    private ExcelExportService excelExportService;

    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    public String exportExcel(HttpServletResponse response, @RequestParam("useCursor") boolean useCursor)
    {
        excelExportService.exportExcel(response, useCursor);

        return "ok";
    }

}
