package career.video.service;

import java.util.List;
import java.util.Map;

public interface VideoService {

	List<Map<String, Object>> selectVideoList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectVideoPagingList(Map<String, Object> map) throws Exception;
	Map<String, Object> selectVideo(Map<String, Object> map) throws Exception;
	int updateVideoCount(Map<String, Object> map) throws Exception;
}
