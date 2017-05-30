package career.admin.teacher.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import career.admin.teacher.service.TeacherService;
import career.common.common.CommandMap;
import career.common.common.CommonLoginUtil;
import career.common.util.FileUtils;

@Controller
public class TeacherController {
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="teacherService")
    private TeacherService teacherService;
    
    @Resource(name="fileUtils")
    private FileUtils fileUtils;
    
    private CommonLoginUtil commonLoginUtil;
    
    @RequestMapping(value="/admin/teacher/teacherInsert.do")
    public ModelAndView teacherInsert(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/teacher/teacher_insert");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> areaList = teacherService.selectAreaList(commandMap.getMap());
        
        mv.addObject("AreaList", areaList);
        return mv;
    }

    @RequestMapping(value="/admin/teacher/teacherInsertDone.do")
    public ModelAndView teacherInsertDone(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> loginData = teacherService.selectUserId(commandMap.getMap());
        Map<String, Object> schoolData = teacherService.selectSchoolData(commandMap.getMap());
        if(schoolData != null) {
        	mv.addObject("RESULT", 2);
        } else if(loginData == null) {
        	mv.addObject("RESULT", 0);
        	commonLoginUtil = new CommonLoginUtil();
            commandMap.put("teacher_pass", commonLoginUtil.aesEncode((String)commandMap.get("teacher_pass")));
            teacherService.insertSchool(commandMap.getMap());
            teacherService.insertTeacher(commandMap.getMap());
        } else {
        	mv.addObject("RESULT", 1);
        }
        
        return mv;
    }
    
    @RequestMapping(value="/admin/teacher/teacherList.do")
    public ModelAndView teacherList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/teacher/teacher_list");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> teacherList = teacherService.selectTeacherList(commandMap.getMap());
        
        mv.addObject("teacherList", teacherList);
        return mv;
    }
    
    
    @RequestMapping(value="/admin/teacher/teacherUpdate.do")
    public ModelAndView teacherUpdate(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/teacher/teacher_update");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> teacherData = teacherService.selectTeacher(commandMap.getMap());
        List<Map<String, Object>> areaList = teacherService.selectAreaList(commandMap.getMap());
        
        mv.addObject("teacherData", teacherData);
        mv.addObject("areaList", areaList);
        return mv;
    }
    
    @RequestMapping(value="/admin/teacher/teacherUpdateDone.do")
    public ModelAndView teacherUpdateDone(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView();
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        if(commandMap.getMap().get("password_check").toString().equals("true")){
        	commonLoginUtil = new CommonLoginUtil();
            commandMap.put("teacher_pass", commonLoginUtil.aesEncode((String)commandMap.get("teacher_pass")));
        }
        
        teacherService.updateTeacher(commandMap.getMap());
        mv.setView(new RedirectView("/admin/teacher/teacherList.do"));
        return mv;
    }
    
    @RequestMapping(value="/admin/teacher/teacherDetail.do")
    public ModelAndView teacherDetail(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/teacher/teacher_detail");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> teacherData = teacherService.selectTeacher(commandMap.getMap());
        List<Map<String, Object>> areaList = teacherService.selectAreaList(commandMap.getMap());
        
        mv.addObject("teacherData", teacherData);
        mv.addObject("areaList", areaList);
        return mv;
    }
    
    @RequestMapping(value="/admin/teacher/teacherDelete.do")
    public ModelAndView teacherDelete(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView();
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        teacherService.deleteTeacher(commandMap.getMap());
        mv.setView(new RedirectView("/admin/teacher/teacherList.do"));
        return mv;
    }
}
