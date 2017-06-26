package career.admin.student.controller;

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

import career.admin.student.service.StudentService;
import career.common.common.CommandMap;
import career.common.common.CommonLoginUtil;

@Controller
public class StudentController {
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="studentService")
    private StudentService studentService;
    
    private CommonLoginUtil commonLoginUtil;
    
    @RequestMapping(value="/admin/student/studentInsert.do")
    public ModelAndView studentInsert(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/student/student_insert");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> areaList = studentService.selectAreaList(commandMap.getMap());
        
        mv.addObject("AreaList", areaList);
        return mv;
    }

    @RequestMapping(value="/admin/student/studentInsertDone.do")
    public ModelAndView studentInsertDone(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> loginData = studentService.selectUserId(commandMap.getMap());
        Map<String, Object> schoolData = studentService.selectSchoolData(commandMap.getMap());
        if(schoolData != null) {
        	mv.addObject("RESULT", 2);
        } else if(loginData == null) {
        	mv.addObject("RESULT", 0);
        	commonLoginUtil = new CommonLoginUtil();
            commandMap.put("student_pass", commonLoginUtil.aesEncode((String)commandMap.get("student_pass")));
            studentService.insertStudent(commandMap.getMap());
        } else {
        	mv.addObject("RESULT", 1);
        }
        
        return mv;
    }
    
    @RequestMapping(value="/admin/student/studentList.do")
    public ModelAndView studentList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/student/student_list");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> studentList = studentService.selectStudentList(commandMap.getMap());
        
        mv.addObject("studentList", studentList);
        return mv;
    }
    
    
    @RequestMapping(value="/admin/student/studentUpdate.do")
    public ModelAndView studentUpdate(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/student/student_update");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> studentData = studentService.selectStudent(commandMap.getMap());
        List<Map<String, Object>> areaList = studentService.selectAreaList(commandMap.getMap());
        
        mv.addObject("studentData", studentData);
        mv.addObject("areaList", areaList);
        return mv;
    }
    
    @RequestMapping(value="/admin/student/studentUpdateDone.do")
    public ModelAndView studentUpdateDone(CommandMap commandMap) throws Exception{
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
            commandMap.put("student_pass", commonLoginUtil.aesEncode((String)commandMap.get("student_pass")));
        }
        
        studentService.updateStudent(commandMap.getMap());
        mv.setView(new RedirectView("/admin/student/studentList.do"));
        return mv;
    }
    
    @RequestMapping(value="/admin/student/schoolSelect.do")
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
        
        List<Map<String, Object>> schoolList = studentService.selectSchoolList(commandMap.getMap());
       	mv.addObject("RESULT", 0);
       	mv.addObject("schoolList", schoolList);
        
        return mv;
    }
    
    @RequestMapping(value="/admin/student/studentDetail.do")
    public ModelAndView studentDetail(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/student/student_detail");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> studentData = studentService.selectStudent(commandMap.getMap());
        List<Map<String, Object>> areaList = studentService.selectAreaList(commandMap.getMap());
        
        mv.addObject("studentData", studentData);
        mv.addObject("areaList", areaList);
        return mv;
    }
    
    @RequestMapping(value="/admin/student/studentDelete.do")
    public ModelAndView studentDelete(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView();
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        studentService.deleteStudent(commandMap.getMap());
        mv.setView(new RedirectView("/admin/student/studentList.do"));
        return mv;
    }
}
