package career.sign.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import career.common.common.CommandMap;
import career.common.common.CommonLoginUtil;
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
}
