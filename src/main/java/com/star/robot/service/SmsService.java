package com.star.robot.service;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.Date;
import java.util.Random;


public class SmsService {



    /**
     * 日志对象
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    // 短信应用SDK AppID
    static int appid = Integer.parseInt("1400198026"); // 1400开头
    // 短信应用SDK AppKey
    static String appkey = "43fa764eb65e19291e1362cfa5f9480e";
    // 短信模板ID，需要在短信应用中申请
    static int templateId = Integer.parseInt("308716");
    // 签名
    static String smsSign = "倍凯科技"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`

    /**
     * 短信发送
     *
     * @param mobile
     * @param mobile
     * @return {"result":0,"errmsg":"OK","ext":"","sid":"2019:4813254269021345758","fee":1}
     */
    public static SmsSingleSenderResult sendMsg(String mobile) {
        SmsSingleSenderResult result = null;
        try {
            //生成验证码
            String code = createCharacter();
            String[] params = {code};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            result = ssender.sendWithParam("86", mobile, templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
//            request.getSession().setAttribute("VALIDATE_CODE", code);
//            request.getSession().setAttribute("SEND_TIME", new Date());
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        } catch (com.github.qcloudsms.httpclient.HTTPException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String createCharacter() {
        char[] codeSeq = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        Random random = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String r = String.valueOf(codeSeq[random.nextInt(codeSeq.length)]);//random.nextInt(10));
            s.append(r);
        }
        return s.toString();
    }


}
