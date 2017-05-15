package career.admin.video.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import career.admin.gallery.dao.AdminGalleryDAO;
import career.admin.video.dao.AdminVideoDAO;
import career.common.util.FileUtils;
import career.common.util.Session;

@Service("adminVideoService")
public class AdminVideoServiceImpl implements AdminVideoService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="fileUtils")
    private FileUtils fileUtils;

	@Resource(name="adminVideoDAO")
	private AdminVideoDAO adminVideoDAO;
	
	@Override
	public List<Map<String, Object>> selectVideoList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) adminVideoDAO.selectVideoList(map);
	}

	@Override
	public List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) adminVideoDAO.selectAreaList(map);
	}
	
	@Override
	public List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) adminVideoDAO.selectSchoolList(map);
	}
	
	@Override
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) adminVideoDAO.selectFileList(map);
	}
	
	@Override
	public void insertVideo(Map<String, Object> map, HttpServletRequest request, String videoFilePath) throws Exception {
		// TODO Auto-generated method stub
		adminVideoDAO.insertVideo(map);
		
		List<Map<String,Object>> list = fileUtils.parseInsertVideoInfo(map, request, videoFilePath);
	    
        for(int i=0, size=list.size(); i<size; i++){
        	adminVideoDAO.insertFile(list.get(i));
        }
	}
	
	@Override
	public int updateVideo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return adminVideoDAO.updateVideo(map);
	}

	@Override
	public int deleteVideo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return adminVideoDAO.deleteVideo(map);
	}
	
	@Override
	public Map<String, Object> selectVideo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) adminVideoDAO.selectVideo(map);
	}

}
