package career.admin.video.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import career.admin.gallery.service.AdminGalleryService;
import career.admin.video.service.AdminVideoService;
import career.common.common.CommandMap;
import career.common.common.CommonLoginUtil;
import career.common.util.FileUtils;
import career.common.util.Session;

@Controller
public class AdminVideoController {
	Logger log = Logger.getLogger(this.getClass());
    
	@Value("#{props['common.localVideoPath']}")
	private String videoFilePath;
	
    @Resource(name="adminVideoService")
    private AdminVideoService adminVideoService;
    
    @Resource(name="fileUtils")
    private FileUtils fileUtils;
    
    @RequestMapping(value="/admin/video/videoList.do")
    public ModelAndView videoList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/video/video_list");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> videoList = adminVideoService.selectVideoList(commandMap.getMap());
        
        mv.addObject("videoList", videoList);
        return mv;
    }
    
    @RequestMapping(value="/admin/video/videoInsert.do")
    public ModelAndView insertMain(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/video/video_insert");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> areaList = adminVideoService.selectAreaList(commandMap.getMap());
        
        mv.addObject("AreaList", areaList);
        
        return mv;
    }
    
    @RequestMapping(value="/admin/video/videoInsertDone.do")
    public ModelAndView videoInsertDone(CommandMap commandMap, HttpServletRequest request) throws Exception{
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
        
        adminVideoService.insertVideo(commandMap.getMap(), request, videoFilePath);
        
        mv.setView(new RedirectView("/admin/video/videoList.do"));
        return mv;
    }
    
    @RequestMapping(value="/admin/video/schoolSelect.do")
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
        
        List<Map<String, Object>> schoolList = adminVideoService.selectSchoolList(commandMap.getMap());
       	mv.addObject("RESULT", 0);
       	mv.addObject("schoolList", schoolList);
        
        return mv;
    }
    
    @RequestMapping(value="/admin/video/videoDetail.do")
    public ModelAndView videoDetail(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/video/video_detail");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> videoData = adminVideoService.selectVideo(commandMap.getMap());
        List<Map<String, Object>> fileList = adminVideoService.selectFileList(commandMap.getMap());
        
        mv.addObject("videoData", videoData);
        mv.addObject("fileList", fileList);
        return mv;
    }
    
    @RequestMapping(value="/admin/video/videoUpdate.do")
    public ModelAndView videoUpdate(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/video/video_update");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> videoData = adminVideoService.selectVideo(commandMap.getMap());
        List<Map<String, Object>> fileList = adminVideoService.selectFileList(commandMap.getMap());
        
        mv.addObject("videoData", videoData);
        mv.addObject("fileList", fileList);
        return mv;
    }
    
    @RequestMapping(value="/admin/video/videoUpdateDone.do")
    public ModelAndView videoUpdateDone(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView();
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        adminVideoService.updateVideo(commandMap.getMap());
        mv.setView(new RedirectView("/admin/video/videoList.do"));
        return mv;
    }
    
    @RequestMapping(value="/admin/video/videoDelete.do")
    public ModelAndView videoDelete(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/video/video_update");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        adminVideoService.deleteVideo(commandMap.getMap());
        mv.setView(new RedirectView("/admin/video/videoList.do"));
        return mv;
    }
}
