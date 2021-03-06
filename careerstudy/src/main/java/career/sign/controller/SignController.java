package career.sign.controller;

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

import career.common.common.CommandMap;
import career.common.common.CommonLoginUtil;
import career.common.util.Session;
import career.sign.service.SignService;

@Controller
public class SignController {
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="signService")
    private SignService signService;
     
    private CommonLoginUtil commonLoginUtil;
    
    @RequestMapping(value="/sign/careerSign.do")
    public ModelAndView careerSign(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/sign/career_sign");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> areaList = signService.selectAreaList(commandMap.getMap());
        
        mv.addObject("AreaList", areaList);
        
        return mv;
    }
    
    @RequestMapping(value="/sign/schoolSelect.do")
    public ModelAndView schoolSelect(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> schoolList = signService.selectSchoolList(commandMap.getMap());
       	mv.addObject("RESULT", 0);
       	mv.addObject("schoolList", schoolList);
        
        return mv;
    }
    
    @RequestMapping(value="/sign/idCheck.do")
    public ModelAndView idCheck(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> idCheck = signService.selectUser(commandMap.getMap());
        if(idCheck == null){
        	mv.addObject("RESULT", 0);
        } else {
        	mv.addObject("RESULT", 1);
        }
        
        return mv;
    }
    
    @RequestMapping(value="/sign/signUp.do")
    public ModelAndView signUp(CommandMap commandMap) throws Exception{
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
        commandMap.put("sign_password", commonLoginUtil.aesEncode((String)commandMap.get("sign_password")));
        signService.insertUser(commandMap.getMap());
        mv.addObject("RESULT", 0);
        return mv;
    }
    
    @RequestMapping(value="/sign/signDetail.do")
    public ModelAndView signDetail(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("/sign/career_detail");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        HttpSession session = request.getSession(true);
    	Session se = (Session) session.getAttribute("session");
        
        commandMap.getMap().put("student_idx", se.getUserIdx());
        Map<String, Object> studentData = signService.selectStudent(commandMap.getMap());
        List<Map<String, Object>> areaList = signService.selectAreaList(commandMap.getMap());
        
        mv.addObject("studentData", studentData);
        mv.addObject("areaList", areaList);
        return mv;
    }
    
    @RequestMapping(value="/sign/signUpdate.do")
    public ModelAndView signUpdate(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/sign/career_update");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> studentData = signService.selectStudent(commandMap.getMap());
        List<Map<String, Object>> areaList = signService.selectAreaList(commandMap.getMap());
        
        mv.addObject("studentData", studentData);
        mv.addObject("areaList", areaList);
        return mv;
    }
    
    @RequestMapping(value="/sign/signUpdateDone.do")
    public ModelAndView signUpdateDone(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView();
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        signService.updateStudent(commandMap.getMap());
    	
        mv.setView(new RedirectView("/sign/signDetail.do"));
        return mv;
    }
    
    @RequestMapping(value="/sign/signDelete.do")
    public ModelAndView signDelete(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView();
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        signService.deleteStudent(commandMap.getMap());
        
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	HttpSession session = request.getSession(true);
    	session.invalidate();
    	
        mv.setView(new RedirectView("/main/careerMain.do"));
        return mv;
    }
    
}
