package com.example.spring.controller;

import com.example.spring.config.Config;
import com.example.spring.sse.SseEmitterServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/sse")
public class SseEmitterController {

  @RequestMapping("")
  public ModelAndView sse() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("domain_url", Config.DOMAIN_URL);
    mv.setViewName("log");
    return mv;
  }

  /**
   * 用于创建连接
   */
  @GetMapping("/connect/{userId}")
  public SseEmitter connect(@PathVariable String userId) {
    return SseEmitterServer.connect(userId);
  }

  @GetMapping("/push/{message}")
  public ResponseEntity<String> push(@PathVariable(name = "message") String message) {
    SseEmitterServer.batchSendMessage(message);
    return ResponseEntity.ok("WebSocket 已推送消息给所有人");
  }
}
