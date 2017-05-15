package career.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import career.common.util.Session;

public class SessionCheckInterceptor extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(request.getRequestURL().indexOf("login") != -1){
			return true;
		}
		HttpSession session = request.getSession(false);
		
		if(session == null){
			if(request.getRequestURL().indexOf("admin") != -1){
				response.sendRedirect(request.getContextPath()+"/admin/login/loginMain.do");
			} else {
				/*response.sendRedirect(request.getContextPath()+"/login/loginMain.do");*/
				//운영 사이트만들면 true를 없애고 redirect를 걸어준다.
				return true;
			}
			return false;
		}
		
		Session se = (Session)session.getAttribute("session");
		
		if(se == null){
			if(request.getRequestURL().indexOf("admin") != -1){
				response.sendRedirect(request.getContextPath()+"/admin/login/loginMain.do");
			} else {
				/*response.sendRedirect(request.getContextPath()+"/login/loginMain.do");*/
				return true;
			}
			return false;
		}
		
		return true;
	}

}
