package career.admin.gallery.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AdminGalleryService {
	List<Map<String, Object>> selectGalleryList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectGallery(Map<String, Object> map) throws Exception;
	
	void insertGallery(Map<String, Object> map, HttpServletRequest request, String imgFilePath) throws Exception;
	int updateGallery(Map<String, Object> map) throws Exception;
	int deleteGallery(Map<String, Object> map) throws Exception;
}
