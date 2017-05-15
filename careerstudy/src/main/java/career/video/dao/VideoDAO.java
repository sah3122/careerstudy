package career.video.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import career.common.dao.AbstractDAO;

@Repository("videoDAO")
public class VideoDAO extends AbstractDAO {

	public List<Map<String, Object>> selectVideoList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("video.selectVideoList", map);
	}
	
	public Map<String, Object> selectVideoPagingList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectPagingList("video.selectVideoPagingList", map);
	}
	
	public Map<String, Object> selectVideo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("video.selectVideo", map);
	}
	
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("video.selectFileList", map);
	}
	
	public int updateVideoCount(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("video.updateVideoCount", map);
	}
}
