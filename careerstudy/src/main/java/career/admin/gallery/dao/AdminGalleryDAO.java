package career.admin.gallery.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import career.common.dao.AbstractDAO;

@Repository("adminGalleryDAO")
public class AdminGalleryDAO extends AbstractDAO{
	
	public List<Map<String, Object>> selectGalleryList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("gallery.selectGalleryList", map);
	}
	
	public List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("gallery.selectAreaList", map);
	} 
	
	public List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("gallery.selectSchoolList", map);
	}
	
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("gallery.selectFileList", map);
	}
	//////////////////////////////////
	public Map<String, Object> selectGallery(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("gallery.selectGallery", map);
	}
	
	public void insertFile(Map<String, Object> map) throws Exception{
	    insert("gallery.insertFile", map);
	}
	
	public int insertGallery(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) insert("gallery.insertGallery", map);
	}
	
	public int updateGallery(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("gallery.updateGallery", map);
	}
	
	public int deleteGallery(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("gallery.deleteGallery", map);
	}
}
