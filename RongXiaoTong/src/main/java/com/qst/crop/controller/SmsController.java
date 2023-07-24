package com.qst.crop.controller;



import com.qst.crop.common.Result;

import com.qst.crop.dao.UserDao;
import com.qst.crop.entity.PasswordParam;
import com.qst.crop.entity.User;
import com.qst.crop.security.util.AliSmsUtil;
import com.qst.crop.security.util.ValidateCodeUtils;
import com.qst.crop.service.UserService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "用户模块接口")
@Component
public class SmsController {
    @Autowired
    private UserDao userDao;
    private static final Logger log = LoggerFactory.getLogger(SmsController.class);

    /**
     * 发送手机短信验证码
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public Result<String> sendMsg(@RequestBody User user, HttpSession session){
        //获取手机号
        String phone = user.getPhone();
        //判断手机号是否存在
        if(StringUtils.isNotEmpty(phone)){
            //生成随机的6位验证码
            String code = ValidateCodeUtils.generateValidateCode(6).toString();
            log.info("code={}",code);
            //调用阿里云提供的短信服务API完成发送短信
            //第一个参数填写阿里云申请的短信签名，第二个参数填写申请的模板code
            AliSmsUtil.sendMessage("来自褚婧雯的短信","SMS_461996065",phone,code);
            //需要将生成的验证码保存到Session
            session.setAttribute(code,phone);
            return Result.success("手机验证码短信发送成功",null);
        }


        return Result.error("短信发送失败",null);
    }
    //@PostMapping("/sendVerificationCode")

}
