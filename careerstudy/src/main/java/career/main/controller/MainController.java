package career.main.controller;

import java.util.Iterator;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import career.common.common.CommandMap;
import career.main.service.MainService;

@Controller
public class MainController {
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="mainService")
    private MainService mainService;
     
    @RequestMapping(value="/main/careerMain.do")
    public ModelAndView careerMain(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/main/career_main");
        
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
    
    @RequestMapping(value="/main/careerIntro.do")
    public ModelAndView careerIntro(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/main/career_intro");
        
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
    
    @RequestMapping(value="/main/careerWork.do")
    public ModelAndView careerWork(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/main/career_work");
        
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
