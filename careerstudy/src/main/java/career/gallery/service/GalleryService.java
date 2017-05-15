package career.gallery.service;

import java.util.List;
import java.util.Map;

public interface GalleryService {

	List<Map<String, Object>> selectGalleryList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectGalleryPagingList(Map<String, Object> map) throws Exception;
	Map<String, Object> selectGallery(Map<String, Object> map) throws Exception;
	int updateGalleryCount(Map<String, Object> map) throws Exception;
}
