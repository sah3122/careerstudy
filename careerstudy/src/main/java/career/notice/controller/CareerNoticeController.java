package career.notice.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import career.board.service.BoardService;
import career.common.common.CommandMap;
import career.notice.service.CareerNoticeService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class CareerNoticeController {
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="careerNoticeService")
    private CareerNoticeService careerNoticeService;
     
    @RequestMapping(value="/career/notice/noticeList.do")
    public ModelAndView noticeList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/career/notice/notice_list");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        List<Map<String, Object>> noticeList = careerNoticeService.selectNoticeList(commandMap.getMap());
        Map<String, Object> noticePagingList = careerNoticeService.selectNoticePagingList(commandMap.getMap());
        
        mv.addObject("paginationInfo", (PaginationInfo)noticePagingList.get("paginationInfo"));
        mv.addObject("noticeList", noticePagingList.get("result"));
        
        return mv;
    }
    
    @RequestMapping(value="/career/notice/noticeDetail.do")
    public ModelAndView noticeDetail(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/career/notice/notice_detail");
        
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        
        careerNoticeService.updateNoticeCount(commandMap.getMap());
        Map<String, Object> noticeData = careerNoticeService.selectNotice(commandMap.getMap());
        
        mv.addObject("noticeData", noticeData);
        
        return mv;
    }
}
