package career.notice.service;

import java.util.List;
import java.util.Map;

public interface CareerNoticeService {

	List<Map<String, Object>> selectNoticeList(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectNoticePagingList(Map<String, Object> map) throws Exception;
	Map<String, Object> selectNotice(Map<String, Object> map) throws Exception;
	
	int updateNoticeCount(Map<String, Object> map) throws Exception;
}
