package com.example.spring.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.spring.aop.OperationLog;
import com.example.spring.config.Config;
import com.example.spring.entity.WxFollower;
import com.example.spring.repository.WxRepository;
import com.zjiecode.wxpusher.client.WxPusher;
import com.zjiecode.wxpusher.client.bean.CreateQrcodeReq;
import com.zjiecode.wxpusher.client.bean.CreateQrcodeResp;
import com.zjiecode.wxpusher.client.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/wx")
public class WxController {

  private WxRepository wxRepository;

  @Autowired
  private void setWxRepository(WxRepository wxRepository) {
    this.wxRepository = wxRepository;
  }

  @RequestMapping("/followers")
  public ModelAndView wxFollowers() {
    List<WxFollower> wxFollowerList = wxRepository.findAll();
    ModelAndView mv = new ModelAndView();
    mv.addObject("followers", wxFollowerList);
    mv.setViewName("wx_followers");
    return mv;
  }

  @OperationLog(description = "wx user follow")
  @RequestMapping("/follow")
  public void wxFollow(@RequestBody String jsonData) {
    JSONObject jsonObject = JSON.parseObject(jsonData);
    JSONObject data = jsonObject.getJSONObject("data");
    WxFollower wxFollower = new WxFollower();
    wxFollower.setId((int) data.get("id"));
    wxFollower.setAppId((int) data.get("appId"));
    wxFollower.setAppName((String) data.get("appName"));
    wxFollower.setSource((String) data.get("source"));
    wxFollower.setTime((long) data.get("time"));
    wxFollower.setUid((String) data.get("uid"));
    Object extra = data.get("extra");
    if (extra != null) {
      wxFollower.setExtra((String) extra);
    }
    wxRepository.save(wxFollower);
  }

  @OperationLog(description = "create QR code")
  @RequestMapping("/createQrcode/{param}")
  public ModelAndView createQrcode(@PathVariable String param) {
    CreateQrcodeReq createQrcodeReq = new CreateQrcodeReq();
    createQrcodeReq.setAppToken(Config.APP_TOKEN);
    createQrcodeReq.setExtra(param);
    createQrcodeReq.setValidTime(60 * 60 * 24);
    Result<CreateQrcodeResp> appTempQrcode = WxPusher.createAppTempQrcode(createQrcodeReq);
    String qrcodeUrl = "";
    if (appTempQrcode.isSuccess()) {
      CreateQrcodeResp data = appTempQrcode.getData();
      qrcodeUrl = data.getUrl();
    }
    ModelAndView mv = new ModelAndView();
    mv.addObject("param", param);
    mv.addObject("qrcode_url", qrcodeUrl);
    mv.setViewName("qrcode");
    return mv;
  }
}
