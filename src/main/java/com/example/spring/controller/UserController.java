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
  public String userLogin(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
    User user = userRepository.findUserByName(username);
    if (user == null) {
      return "user does not exist";
    }
    if (!user.getPassword().equals(password)) {
      return "password is incorrect";
    }
    HttpSession session = request.getSession();
    session.setAttribute("currentUser", user);
    return "login success: " + user;
  }

  @RequestMapping("/logout")
  public ModelAndView logout(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.invalidate();
    ModelAndView mv = new ModelAndView();
    mv.setViewName("login");
    return mv;
  }

  @RequestMapping("/loginStatus")
  public ModelAndView loginStatus(HttpServletRequest request) {
    HttpSession session = request.getSession();
    User currentUser = (User) session.getAttribute("currentUser");
    String username = null;
    if (currentUser != null) {
      username = currentUser.getName();
    }
    ModelAndView mv = new ModelAndView();
    mv.addObject("username", username);
    mv.setViewName("login_status");
    return mv;
  }
}
