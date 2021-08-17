package com.example.spring.interceptor;

import com.example.spring.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginInterceptor implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(UserLoginInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
    HttpSession session = request.getSession();
    User currentUser = (User) session.getAttribute("currentUser");
    if (currentUser == null) {
      logger.info("no login user to access: " + request.getRequestURI());
      response.sendRedirect("loginPage");
      return false;
    }
    return true;
  }

}
