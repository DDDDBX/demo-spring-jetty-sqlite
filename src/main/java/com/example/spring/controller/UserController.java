package com.example.spring.controller;

import com.example.spring.entity.User;
import com.example.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @RequestMapping("/loginPage")
  public ModelAndView loginPage() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("login");
    return mv;
  }

  @RequestMapping("/login")
  public ModelAndView userLogin(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
    User user = userRepository.findUserByName(username);
    ModelAndView mv = new ModelAndView();
    mv.setViewName("login_status");
    String message;
    if (user == null) {
      message = "user does not exist";
    } else {
      if (!user.getPassword().equals(password)) {
        message = "password is incorrect";
      }
      else {
        message = "login success: " + user;
        mv.addObject("currentUser", user);
      }
    }
    HttpSession session = request.getSession();
    session.setAttribute("currentUser", user);
    mv.addObject("message", message);
    return mv;
  }

  @RequestMapping("/logout")
  public ModelAndView logout(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.invalidate();
    ModelAndView mv = new ModelAndView();
    mv.setViewName("login_status");
    return mv;
  }

  @RequestMapping("/loginStatus")
  public ModelAndView loginStatus(HttpServletRequest request) {
    HttpSession session = request.getSession();
    User currentUser = (User) session.getAttribute("currentUser");
    ModelAndView mv = new ModelAndView();
    mv.addObject("currentUser", currentUser);
    mv.setViewName("login_status");
    return mv;
  }
}
