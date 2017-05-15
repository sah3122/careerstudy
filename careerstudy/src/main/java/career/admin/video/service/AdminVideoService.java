package career.admin.video.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AdminVideoService {
	List<Map<String, Object>> selectVideoList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectVideo(Map<String, Object> map) throws Exception;
	
	void insertVideo(Map<String, Object> map, HttpServletRequest request, String videoFilePath) throws Exception;
	int updateVideo(Map<String, Object> map) throws Exception;
	int deleteVideo(Map<String, Object> map) throws Exception;
}
