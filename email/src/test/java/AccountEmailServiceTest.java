/**
 * Created by hybian on 2017/1/13.
 */
import static junit.framework.Assert.assertEquals;
import javax.mail.Message;

import org.junit.After;
import org.junit.Before;
import  org.junit.Test;
import  org.springframework.context.ApplicationContext;
import  org.springframework.context.support.ClassPathXmlApplicationContext;
import com.icegreen.greenmail.util.*;

public class AccountEmailServiceTest {
    private GreenMail greenMail;

    @Before
    public void StartMailServer() throws Exception{
        greenMail = new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("xyq921123@sina.com","hehe!!!!!!!");
        greenMail.start();
    }

    @Test
    public void TestSendEmail() throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");

        String subject = "Test";
        String htmlText = "<h3>Test haha </h3>";
        accountEmailService.sendMail("944014033@qq.com",subject,htmlText);

        greenMail.waitForIncomingEmail(2000, 1);

        Message[] msgs = greenMail.getReceivedMessages();
        assertEquals(1, msgs.length);
    }

    @After
    public void stopMailServer() throws Exception{
        greenMail.stop();
    }
}
