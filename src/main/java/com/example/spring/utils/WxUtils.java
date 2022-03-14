package com.example.spring.utils;

import com.example.spring.config.Config;
import com.zjiecode.wxpusher.client.WxPusher;
import com.zjiecode.wxpusher.client.bean.Message;
import com.zjiecode.wxpusher.client.bean.MessageResult;
import com.zjiecode.wxpusher.client.bean.Result;

import java.util.List;

public class WxUtils {

  public static Result<List<MessageResult>> sendWarningMessage(String content) {
    Message message = new Message();
    message.setAppToken(Config.APP_TOKEN);
    message.setContentType(Message.CONTENT_TYPE_TEXT);
    message.setContent(content);
    message.setTopicId(Config.WARNING_TOPIC_ID);
    message.setUrl(Config.DOMAIN_URL + "/myapp"); //可选参数
    return WxPusher.send(message);
  }
}
