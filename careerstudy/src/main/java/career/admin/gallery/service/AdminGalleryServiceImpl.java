package career.admin.gallery.service;

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
import career.common.util.FileUtils;
import career.common.util.Session;

@Service("adminGalleryService")
public class AdminGalleryServiceImpl implements AdminGalleryService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="fileUtils")
    private FileUtils fileUtils;

	@Resource(name="adminGalleryDAO")
	private AdminGalleryDAO adminGalleryDAO;
	
	@Override
	public List<Map<String, Object>> selectGalleryList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) adminGalleryDAO.selectGalleryList(map);
	}

	@Override
	public List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) adminGalleryDAO.selectAreaList(map);
	}
	
	@Override
	public List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) adminGalleryDAO.selectSchoolList(map);
	}
	
	@Override
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) adminGalleryDAO.selectFileList(map);
	}
	
	@Override
	public void insertGallery(Map<String, Object> map, HttpServletRequest request, String imgFilePath) throws Exception {
		// TODO Auto-generated method stub
		adminGalleryDAO.insertGallery(map);
		
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map, request, imgFilePath);
	    
        for(int i=0, size=list.size(); i<size; i++){
        	adminGalleryDAO.insertFile(list.get(i));
        }
	}
	
	@Override
	public int updateGallery(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return adminGalleryDAO.updateGallery(map);
	}

	@Override
	public int deleteGallery(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return adminGalleryDAO.deleteGallery(map);
	}
	
	@Override
	public Map<String, Object> selectGallery(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) adminGalleryDAO.selectGallery(map);
	}

}
