package com.bupt.travel.utils;

import com.bupt.travel.contant.MsgContants;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

/**
 * 腾讯云发送短信的工具类
 */
public class MessageUtils {

    public static void sendMessage(String phone,String message){

        try {
            SmsSingleSender ssender = new SmsSingleSender(MsgContants.AppID, MsgContants.AppKey);
            SmsSingleSenderResult result = ssender.send(0, "86", phone,
                    MsgContants.contentTemplate+message, "", "");
            System.out.print(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
    }

}
