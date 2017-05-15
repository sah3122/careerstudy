package career.login.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import career.common.common.CommandMap;
import career.common.common.CommonLoginUtil;
import career.common.util.Session;
import career.login.service.LoginService;

@Controller
public class LoginController {
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="loginService")
    private LoginService loginService;
     
    CommonLoginUtil commonLoginUtil;
    
    @RequestMapping(value="/login/careerLogin.do")
    public ModelAndView careerLogin(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/login/career_login");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        return mv;
    }
    
    @RequestMapping(value="/login/careerLoginDone.do")
    public ModelAndView careerLoginDone(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        commonLoginUtil = new CommonLoginUtil();
    	String encText = commonLoginUtil.aesEncode(((String)commandMap.get("login_password")));
    	commandMap.put("login_password", encText);
    	
    	Map<String, Object> userData = loginService.selectUser(commandMap.getMap());
    	
    	if(userData != null && userData.get("USER_DELETE_AT").equals("N")){
    		//세션 처리
    		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        	HttpSession session = request.getSession(true);
        	Session se = new Session();
        	se.setUserId(userData.get("USER_ID").toString());
        	se.setUserIdx(userData.get("USER_IDX").toString());
        	se.setUserName(userData.get("USER_NAME").toString());
        	se.setUserCode(userData.get("USER_CODE").toString());
        	se.setUserSchool(userData.get("USER_SCHOOL").toString());
        	se.setUserArea(userData.get("USER_AREA").toString());
    		session.setAttribute("session", se);
        	
    		mv.addObject("RESULT", 0);
    	} else {
    		mv.addObject("RESULT", 1);
    	}
        
        return mv;
    }
    
    @RequestMapping(value="/login/careerLogout.do")
    public ModelAndView careerLogout(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView();
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	HttpSession session = request.getSession(true);
    	session.invalidate();
    	
    	mv.setView(new RedirectView("/main/careerMain.do"));
        return mv;
    }
}
