package com.example.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

  @RequestMapping({"/", "/index"})
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("index");
    return mv;
  }

  @RequestMapping("/myErrorPage")
  public ModelAndView error() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("my_error");
    return mv;
  }

  @RequestMapping("/hello")
  public ModelAndView hello(@RequestParam String name) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("name", name);
    mv.setViewName("hello");
    return mv;
  }
}
