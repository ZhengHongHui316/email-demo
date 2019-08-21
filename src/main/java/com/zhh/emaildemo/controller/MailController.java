package com.zhh.emaildemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

/**
 * <p>Title: MailController</p>
 * <p>Description: TODO</p>
 * <p>Copyright: Copyright (c) 2019 佛山市网景科技有限公司</p>
 *
 * @author zhh
 * @version 1.0
 * @date 2019/8/16 14:50
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    JavaMailSender mailSender;

    @ResponseBody
    @RequestMapping("/send")
    public Object sendEmail() {
        try {
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            //写邮箱 xxxxx@qq.com的形式
            message.setFrom("");
            message.setTo("");
            message.setSubject("测试邮件主题");
            message.setText("测试邮件内容");
            this.mailSender.send(mimeMessage);

            return "sucesss";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "error";
        }
    }
}
