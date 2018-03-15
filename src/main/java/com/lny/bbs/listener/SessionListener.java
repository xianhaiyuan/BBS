package com.lny.bbs.listener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lny.bbs.pojo.User;
import com.lny.bbs.service.UserService;

@WebListener
public class SessionListener implements HttpSessionListener  {
	
	private UserService userService;
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		session.setMaxInactiveInterval(60 * 30);
		System.out.println("session create");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		User user = (User) se.getSession().getAttribute("user");
		if(user !=null) {
			this.userService = WebApplicationContextUtils
					.getWebApplicationContext(se.getSession().getServletContext()).getBean(UserService.class);
			userService.setUnOnline(user.getId());
			System.out.println("session destroy");
		}
	}
}
