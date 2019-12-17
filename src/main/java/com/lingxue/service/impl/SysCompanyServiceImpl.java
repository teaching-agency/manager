package com.lingxue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingxue.mapper.SysCompanyMapper;
import com.lingxue.model.entity.SysCompany;
import com.lingxue.service.ISysCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 *@Author Wisdom
 *@date 2019/12/16 19:14
 *@description 公司=====》impl
 *return
 */
@Service
public class SysCompanyServiceImpl extends ServiceImpl<SysCompanyMapper,SysCompany> implements ISysCompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysCompanyServiceImpl.class);

    @Value("${spring.mail.username}")
    private String from;

    @Value("${customize.emailTo}")
    private String to;

    @Autowired
    private JavaMailSender mailSender;

    /**
     *@Author 86151
     *@Date 2019/12/17 11:02
     *Description 发送邮件  ====》impl
     @Param
     *return
     */
    @Override
    public void sendSimpleMail(HttpServletRequest request) throws MessagingException {
        HttpSession session = request.getSession();

        String uuid = null;

        //创建6位字节码
        for (int i = 0; i < 5; i++) {
            //注意replaceAll前面的是正则表达式
            uuid = UUID.randomUUID().toString().replaceAll("-","").substring(0,6);
        }

        // 构建简单邮件对象，见名知意
        MimeMessage msg = mailSender.createMimeMessage();

        // *** 关键 (此处做邮件抄送的,若是不做有可能存在邮箱信息被当成垃圾信息处理)***
        try {
            msg.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(from));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        MimeMessageHelper helper = new MimeMessageHelper(msg,true,"utf-8");

        StringBuffer sb = new StringBuffer();
        sb.append("<h1>尊敬的用户,您好:</h1>")
                .append("<span style='color:#F00'>本次请求的邮件验证码为:</span>" + uuid + ",本验证码5分钟内有效，请及时输入。（请勿泄露此验证码）")
                .append("<p style='text-align:left'>如非本人操作，请忽略该邮件。</p>")
                .append("(这是一封自动发送的邮件，请不要直接回复）");

        // 设定邮件参数
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject("验证码");
        helper.setText(sb.toString(),true);

        mailSender.send(msg);

        //设置session
        session.setAttribute("emailCode",uuid);
        session.setMaxInactiveInterval(300);  //300秒
    }
}
