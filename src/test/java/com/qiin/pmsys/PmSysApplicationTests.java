package com.qiin.pmsys;

import com.qiin.pmsys.util.MailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;

@SpringBootTest
class PmSysApplicationTests {

    @Autowired
    private MailUtil mailUtil;
    @Test
    void contextLoads() {
    }
    @Test
    public void Test() {
//        System.out.println(((86*0.2)+(91*0.2)+(85*0.2)+(85*0.2)+(91*8)+(90*6))/(0.2+0.2+0.2+0.2+8+6));
        System.out.println((72*0.15)+(88.3*0.35)+(100*0.1)+(60*0.1)+(60*0.15)+(60*0.15));
    }

}
