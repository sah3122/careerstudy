package career.admin.question.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import career.admin.question.service.AdminQuestionService;
import career.common.common.CommandMap;
import career.common.util.Session;

@Controller
public class AdminQuestionController {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="adminQuestionService")
    private AdminQuestionService adminQuestionService;
    
    @RequestMapping(value="/admin/question/questionList.do")
    public ModelAndView questionList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/question/question_list");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> questionList = adminQuestionService.selectQuestionList(commandMap.getMap());
        
        mv.addObject("questionList", questionList);
        return mv;
    }
    
    @RequestMapping(value="/admin/question/questionInsert.do")
    public ModelAndView insertMain(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/question/question_insert");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> areaList = adminQuestionService.selectAreaList(commandMap.getMap());
        
        mv.addObject("AreaList", areaList);
        
        return mv;
    }
    
    @RequestMapping(value="/admin/question/questionInsertDone.do")
    public ModelAndView questionInsertDone(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView();
        
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
        
        commandMap.getMap().put("writer_name", se.getUserName());
        commandMap.getMap().put("writer_idx", se.getUserIdx());
        
        adminQuestionService.insertQuestion(commandMap.getMap());
        
        mv.setView(new RedirectView("/admin/question/questionList.do"));
        return mv;
    }
    
    @RequestMapping(value="/admin/question/schoolSelect.do")
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
        
        List<Map<String, Object>> schoolList = adminQuestionService.selectSchoolList(commandMap.getMap());
       	mv.addObject("RESULT", 0);
       	mv.addObject("schoolList", schoolList);
        
        return mv;
    }
    
    @RequestMapping(value="/admin/question/questionEmpty.do")
    public ModelAndView questionEmpty(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> questionEmpty = adminQuestionService.questionEmpty(commandMap.getMap());
        if(questionEmpty == null) {
        	mv.addObject("RESULT", 0);
        } else {
        	mv.addObject("RESULT", 1);
        }
        return mv;
    }
    
    @RequestMapping(value="/admin/question/questionUpdate.do")
    public ModelAndView questionUpdate(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/question/question_update");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> questionData = adminQuestionService.selectQuestion(commandMap.getMap());
        
        mv.addObject("questionData", questionData);
        return mv;
    }
    
    @RequestMapping(value="/admin/question/questionUpdateDone.do")
    public ModelAndView questionUpdateDone(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView();
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        adminQuestionService.updateQuestion(commandMap.getMap());
        mv.setView(new RedirectView("/admin/question/questionList.do"));
        return mv;
    }
    
    @RequestMapping(value="/admin/question/questionDelete.do")
    public ModelAndView questionDelete(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/question/question_update");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        adminQuestionService.deleteQuestion(commandMap.getMap());
        mv.setView(new RedirectView("/admin/question/questionList.do"));
        return mv;
    }
}
