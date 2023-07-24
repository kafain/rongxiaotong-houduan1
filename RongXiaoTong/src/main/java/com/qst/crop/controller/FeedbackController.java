package com.qst.crop.controller;

import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.Advice;
import com.qst.crop.service.AdviceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Feedback")
@CrossOrigin
public class FeedbackController {

    @Autowired
    private AdviceService adviceService;

    @ApiOperation(value = "添加反馈信息")
    @PostMapping("/addFeedback/{advice}/{telephonenumber}")
    public Result addFeedback(@PathVariable("advice") String advice,
                                 @PathVariable("telephonenumber") String telephonenumber) {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        Advice advice1 = new Advice();
        advice1.setUserName(name);
        advice1.setAdvice(advice);
        advice1.setPhonenumber(telephonenumber);

        adviceService.add(advice1);
        return new Result(true, StatusCode.OK, "提交成功", advice1);
    }

    @ApiOperation(value = "查询所有反馈信息")
    @GetMapping("/selectAllFeedback")
    public Result selectAllFeedback(){
        List<Advice> advice = adviceService.selectAll();
        return new Result(true, StatusCode.OK, "查询成功", advice);
    }
}
