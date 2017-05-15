package career.gallery.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import career.common.dao.AbstractDAO;

@Repository("galleryDAO")
public class GalleryDAO extends AbstractDAO {

	public List<Map<String, Object>> selectGalleryList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("gallery.selectGalleryList", map);
	}
	
	public Map<String, Object> selectGalleryPagingList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectPagingList("gallery.selectGalleryPagingList", map);
	}
	
	public Map<String, Object> selectGallery(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("gallery.selectGallery", map);
	}
	
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("gallery.selectFileList", map);
	}
	
	public int updateGalleryCount(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("gallery.updateGalleryCount", map);
	}
}
