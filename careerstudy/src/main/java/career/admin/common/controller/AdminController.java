package career.admin.common.controller;

import java.util.Iterator;
import java.util.List;
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

import career.admin.common.service.AdminService;
import career.common.common.CommandMap;
import career.common.common.CommonLoginUtil;
import career.common.util.FileUtils;
import career.common.util.Session;

@Controller
public class AdminController {
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="adminService")
    private AdminService adminService;
    
    @Resource(name="fileUtils")
    private FileUtils fileUtils;
    
    CommonLoginUtil commonLoginUtil;
    
    @RequestMapping(value="/admin/main/adminMain.do")
    public ModelAndView adminMain(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/main/admin_main");
        
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
    
    @RequestMapping(value="/admin/login/loginMain.do")
    public ModelAndView loginMain(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/login/login_main");
        
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
    
    @RequestMapping(value="/admin/login/loginDone.do")
    public ModelAndView loginDone(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView();
        
    	if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
    	
    	commonLoginUtil = new CommonLoginUtil();
    	String encText = commonLoginUtil.aesEncode(((String)commandMap.get("user_password")));
    	commandMap.put("user_password", encText);
    	
    	Map<String, Object> userData = adminService.selectUser(commandMap.getMap());
    	
    	if(userData != null && userData.get("USER_DELETE_AT").equals("N") && userData.get("USER_CODE").equals("000")){
    		//세션 처리
    		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        	HttpSession session = request.getSession(true);
        	Session se = new Session();
        	se.setUserId(userData.get("USER_ID").toString());
        	se.setUserIdx(userData.get("USER_IDX").toString());
        	se.setUserName(userData.get("USER_NAME").toString());
        	se.setUserCode(userData.get("USER_CODE").toString());
    		session.setAttribute("session", se);
        	
    		mv.setView(new RedirectView("/admin/main/adminMain.do"));
    	} else {
    		mv.setView(new RedirectView("/admin/login/loginMain.do"));
    	}
    	
        return mv;
    }
    
    @RequestMapping(value="/admin/login/logoutMain.do")
    public ModelAndView logoutMain(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/login/login_main");
        
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
        return mv;
    }
    
    @RequestMapping(value="/admin/openAdminTables.do")
    public ModelAndView openAdminTables(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/tables");
        
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
    
    @RequestMapping(value="/admin/openAdminForms.do")
    public ModelAndView openAdminForms(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/forms");
        
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
    
    @RequestMapping(value="/admin/openAdminFlot.do")
    public ModelAndView openAdminFlot(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/flot");
        
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
    
    @RequestMapping(value="/admin/openAdminMorris.do")
    public ModelAndView openAdminMorris(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/morris");
        
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
    
    @RequestMapping(value="/admin/openAdminBlank.do")
    public ModelAndView openAdminBlank(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/blank");
        
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
}
