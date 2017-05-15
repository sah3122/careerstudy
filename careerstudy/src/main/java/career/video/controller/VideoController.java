package career.video.controller;

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
import career.gallery.service.GalleryService;
import career.video.service.VideoService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class VideoController {
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="videoService")
    private VideoService videoService;
     
    @RequestMapping(value="/career/video/videoList.do")
    public ModelAndView videoList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/career/video/video_list");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> videoList = videoService.selectVideoList(commandMap.getMap());
        Map<String, Object> videoPagingList = videoService.selectVideoPagingList(commandMap.getMap());
        
        mv.addObject("videoList", videoPagingList.get("result"));
        mv.addObject("paginationInfo", (PaginationInfo)videoPagingList.get("paginationInfo"));
        return mv;
    }
    
    @RequestMapping(value="/career/video/videoDetail.do")
    public ModelAndView videoDetail(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/career/video/video_detail");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        videoService.updateVideoCount(commandMap.getMap());
        Map<String, Object> videoData = videoService.selectVideo(commandMap.getMap());
        List<Map<String, Object>> fileList = videoService.selectFileList(commandMap.getMap());
        
        mv.addObject("videoData", videoData);
        mv.addObject("fileList", fileList);
        
        return mv;
    }
}
