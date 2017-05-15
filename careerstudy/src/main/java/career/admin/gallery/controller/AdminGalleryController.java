package career.admin.gallery.controller;

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
import career.common.common.CommandMap;
import career.common.common.CommonLoginUtil;
import career.common.util.FileUtils;
import career.common.util.Session;

@Controller
public class AdminGalleryController {
	Logger log = Logger.getLogger(this.getClass());
    
	@Value("#{props['common.localImagePath']}")
	private String imgFilePath;
	
    @Resource(name="adminGalleryService")
    private AdminGalleryService adminGalleryService;
    
    @Resource(name="fileUtils")
    private FileUtils fileUtils;
    
    @RequestMapping(value="/admin/gallery/galleryList.do")
    public ModelAndView noticeList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/gallery/gallery_list");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> galleryList = adminGalleryService.selectGalleryList(commandMap.getMap());
        
        mv.addObject("galleryList", galleryList);
        return mv;
    }
    
    @RequestMapping(value="/admin/gallery/galleryInsert.do")
    public ModelAndView insertMain(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/gallery/gallery_insert");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> areaList = adminGalleryService.selectAreaList(commandMap.getMap());
        
        mv.addObject("AreaList", areaList);
        
        return mv;
    }
    
    @RequestMapping(value="/admin/gallery/galleryInsertDone.do")
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
        
        commandMap.getMap().put("writer_name", se.getUserName());
        commandMap.getMap().put("writer_idx", se.getUserIdx());
        
        adminGalleryService.insertGallery(commandMap.getMap(), request, imgFilePath);
        
        mv.setView(new RedirectView("/admin/gallery/galleryList.do"));
        return mv;
    }
    
    @RequestMapping(value="/admin/gallery/schoolSelect.do")
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
        
        List<Map<String, Object>> schoolList = adminGalleryService.selectSchoolList(commandMap.getMap());
       	mv.addObject("RESULT", 0);
       	mv.addObject("schoolList", schoolList);
        
        return mv;
    }
    
    @RequestMapping(value="/admin/gallery/galleryDetail.do")
    public ModelAndView galleryDetail(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/gallery/gallery_detail");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> galleryData = adminGalleryService.selectGallery(commandMap.getMap());
        List<Map<String, Object>> fileList = adminGalleryService.selectFileList(commandMap.getMap());
        
        mv.addObject("galleryData", galleryData);
        mv.addObject("fileList", fileList);
        return mv;
    }
    
    @RequestMapping(value="/admin/gallery/galleryUpdate.do")
    public ModelAndView galleryUpdate(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/gallery/gallery_update");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        Map<String, Object> galleryData = adminGalleryService.selectGallery(commandMap.getMap());
        List<Map<String, Object>> fileList = adminGalleryService.selectFileList(commandMap.getMap());
        
        mv.addObject("galleryData", galleryData);
        mv.addObject("fileList", fileList);
        return mv;
    }
    
    @RequestMapping(value="/admin/gallery/galleryUpdateDone.do")
    public ModelAndView galleryUpdateDone(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView();
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        adminGalleryService.updateGallery(commandMap.getMap());
        mv.setView(new RedirectView("/admin/gallery/galleryList.do"));
        return mv;
    }
    
    @RequestMapping(value="/admin/gallery/galleryDelete.do")
    public ModelAndView galleryDelete(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/admin/gallery/gallery_update");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        adminGalleryService.deleteGallery(commandMap.getMap());
        mv.setView(new RedirectView("/admin/gallery/galleryList.do"));
        return mv;
    }
}
