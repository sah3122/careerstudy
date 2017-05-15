package career.admin.notice.controller;

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

import career.admin.notice.service.NoticeService;
import career.common.common.CommandMap;
import career.common.common.CommonLoginUtil;
import career.common.util.FileUtils;
import career.common.util.Session;

@Controller
public class NoticeController {
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="noticeService")
    private NoticeService noticeService;
    
    @Resource(name="fileUtils")
    private FileUtils fileUtils;
    
    CommonLoginUtil commonLoginUtil;
    
    @RequestMapping(value="/admin/notice/noticeList.do")
    public ModelAndView noticeList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/notice/notice_list");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> noticeList = noticeService.selectNoticeList(commandMap.getMap());
        
        mv.addObject("noticeList", noticeList);
        return mv;
    }
    
    @RequestMapping(value="/admin/notice/noticeInsert.do")
    public ModelAndView insertMain(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/notice/notice_insert");
        
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
    
    @RequestMapping(value="/admin/notice/noticeInsertDone.do")
    public ModelAndView noticeInsertDone(CommandMap commandMap, HttpServletRequest request) throws Exception{
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
    	
        commandMap.getMap().put("notice_writer", se.getUserName());
        commandMap.getMap().put("writer_idx", se.getUserIdx());
        noticeService.insertNotice(commandMap.getMap());
        
        mv.setView(new RedirectView("/admin/notice/noticeList.do"));
        return mv;
    }
    
    @RequestMapping(value="/admin/notice/noticeDetail.do")
    public ModelAndView noticeDetail(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/notice/notice_detail");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> noticeData = noticeService.selectNotice(commandMap.getMap());
        
        mv.addObject("noticeData", noticeData);
        return mv;
    }
    
    @RequestMapping(value="/admin/notice/noticeUpdate.do")
    public ModelAndView noticeUpdate(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/notice/notice_update");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> noticeData = noticeService.selectNotice(commandMap.getMap());
        
        mv.addObject("noticeData", noticeData);
        return mv;
    }
    
    @RequestMapping(value="/admin/notice/noticeUpdateDone.do")
    public ModelAndView noticeUpdateDone(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView();
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        noticeService.updateNotice(commandMap.getMap());
        mv.setView(new RedirectView("/admin/notice/noticeList.do"));
        return mv;
    }
    
    @RequestMapping(value="/admin/notice/noticeDelete.do")
    public ModelAndView noticeDelete(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/notice/notice_update");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        noticeService.deleteNotice(commandMap.getMap());
        mv.setView(new RedirectView("/admin/notice/noticeList.do"));
        return mv;
    }
}
