package com.ht.easypoi.controller;

import com.ht.easypoi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ht
 * @create 2019-12-13 14:27
 */
@Controller
@Api(tags = "导出Excel")
public class UserExcelController {

    @Autowired
    private UserService userService;

    @GetMapping("/export/beforeExcel")
    @ApiOperation(value = "导出功能优化前的性能测试")
    public void beforeExcel(@ApiParam(value = "测试的数量",required = true) @RequestParam() Integer num,
                            HttpServletRequest request, HttpServletResponse response){
        userService.beforeExcel(request,response,num);
    }

    @GetMapping("/export/afterExcel")
    @ApiOperation(value = "导出功能优化前的性能测试")
    public void afterExcel(@ApiParam(value = "测试的数量",required = true) @RequestParam() Integer num,
                           HttpServletRequest request, HttpServletResponse response){
        userService.AfterExcel(request,response,num);
    }
}
