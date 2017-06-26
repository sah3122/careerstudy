package career.gallery.controller;

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

import career.common.common.CommandMap;
import career.common.util.Session;
import career.gallery.service.GalleryService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class GalleryController {
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="galleryService")
    private GalleryService galleryService;
     
    @RequestMapping(value="/career/gallery/galleryList.do")
    public ModelAndView openCareerGalleryMain(CommandMap commandMap, HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("/career/gallery/gallery_list");
        
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
        if(se != null){
        	commandMap.getMap().put("schoolIdx", se.getUserSchool());
        } else {
        	commandMap.getMap().put("schoolIdx", null);
        }
        List<Map<String, Object>> galleryList = galleryService.selectGalleryList(commandMap.getMap());
        Map<String, Object> galleryPagingList = galleryService.selectGalleryPagingList(commandMap.getMap());
        
        mv.addObject("galleryList", galleryPagingList.get("result"));
        mv.addObject("paginationInfo", (PaginationInfo)galleryPagingList.get("paginationInfo"));
        return mv;
    }
    
    @RequestMapping(value="/career/gallery/galleryDetail.do")
    public ModelAndView openCareerBoardDetail(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/career/gallery/gallery_detail");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        galleryService.updateGalleryCount(commandMap.getMap());
        Map<String, Object> galleryData = galleryService.selectGallery(commandMap.getMap());
        List<Map<String, Object>> fileList = galleryService.selectFileList(commandMap.getMap());
        
        mv.addObject("galleryData", galleryData);
        mv.addObject("fileList", fileList);
        
        return mv;
    }
}
