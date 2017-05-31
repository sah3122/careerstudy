package career.question.controller;

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
import career.question.service.QuestionService;

@Controller
public class QuestionController {
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="questionService")
    private QuestionService questionService;
     
    
    @RequestMapping(value="/question/questionDetail.do")
    public ModelAndView questionDetail(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("/question/question_detail");
        
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
        
        commandMap.getMap().put("question_school_idx", se.getUserSchool());
        commandMap.getMap().put("question_area_idx", se.getUserArea());
        
        Map<String, Object> questionData = questionService.selectQuestion(commandMap.getMap());
        
        mv.addObject("questionData", questionData);
        return mv;
    }
}
