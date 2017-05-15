package career.admin.notice.service;

import java.util.List;
import java.util.Map;

public interface NoticeService {
	List<Map<String, Object>> selectNoticeList(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectNotice(Map<String, Object> map) throws Exception;
	
	int insertNotice(Map<String, Object> map) throws Exception;
	int updateNotice(Map<String, Object> map) throws Exception;
	int deleteNotice(Map<String, Object> map) throws Exception;
}
