package com.example.controllers;

import com.example.pojos.Dept;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
@Api(description = "测试控制器")
public class TestController {

    @ApiOperation(value = "注册员工接口",notes = "注册方法")
    @RequestMapping(value = "/regEmp",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    public String regEmp(){
        return "RegEmployee";
    }

    @ApiOperation(value = "测试获取信息",notes = "测试方法")
    @RequestMapping(value = "/info",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    public @ResponseBody Map<String,Object> getInfo(){
        Map<String,Object> objectMap = new HashMap<>();
        try {
            objectMap.put("dept", new Dept(5,"赵六","上海市浦东新区"));
            objectMap.put("success",true);
        }catch (Exception e){
            objectMap.put("success",false);
        }
        return objectMap;
    }
}
