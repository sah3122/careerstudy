package career.admin.video.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import career.common.dao.AbstractDAO;

@Repository("adminVideoDAO")
public class AdminVideoDAO extends AbstractDAO{
	
	public List<Map<String, Object>> selectVideoList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("video.selectVideoList", map);
	}
	
	public List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("video.selectAreaList", map);
	} 
	
	public List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("video.selectSchoolList", map);
	}
	
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("video.selectFileList", map);
	}
	//////////////////////////////////
	public Map<String, Object> selectVideo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("video.selectVideo", map);
	}
	
	public void insertFile(Map<String, Object> map) throws Exception{
	    insert("video.insertFile", map);
	}
	
	public int insertVideo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) insert("video.insertVideo", map);
	}
	
	public int updateVideo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("video.updateVideo", map);
	}
	
	public int deleteVideo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("video.deleteVideo", map);
	}
}
