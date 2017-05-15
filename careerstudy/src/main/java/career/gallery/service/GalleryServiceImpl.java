package career.gallery.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import career.gallery.dao.GalleryDAO;

@Service("galleryService")
public class GalleryServiceImpl implements GalleryService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="galleryDAO")
	private GalleryDAO galleryDAO;
	
	@Override
	public List<Map<String, Object>> selectGalleryList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return galleryDAO.selectGalleryList(map);
	}
	
	@Override
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) galleryDAO.selectFileList(map);
	}
	
	@Override
	public Map<String, Object> selectGalleryPagingList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) galleryDAO.selectGalleryPagingList(map);
	}
	
	@Override
	public Map<String, Object> selectGallery(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) galleryDAO.selectGallery(map);
	}
	
	@Override
	public int updateGalleryCount(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return galleryDAO.updateGalleryCount(map);
	}
}
