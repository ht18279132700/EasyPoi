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

    @GetMapping("/export/easypoiSingleExcelView")
    @ApiOperation(value = "注解导出View用法")
    public void EasypoiSingleExcelView(@ApiParam(value = "测试的数量",required = true) @RequestParam() Integer num,
                            HttpServletRequest request, HttpServletResponse response){
        userService.easypoiSingleExcelView(request,response,num);
    }

    @GetMapping("/export/nowExcel")
    @ApiOperation(value = "普通导出用户")
    public void nowExcel(@ApiParam(value = "测试的数量",required = true) @RequestParam() Integer num,
                           HttpServletRequest request, HttpServletResponse response){
        userService.nowExcel(request,response,num);
    }

    @GetMapping("/export/bigExcel")
    @ApiOperation(value = "Excel大数据导出")
    public void bigExcel(@ApiParam(value = "测试的数量",required = true) @RequestParam() Integer num,
                           HttpServletRequest request, HttpServletResponse response){
        userService.bigExcel(request,response,num);
    }
}
