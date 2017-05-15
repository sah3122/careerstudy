package career.notice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import career.common.dao.AbstractDAO;

@Repository("careerNoticeDAO")
public class CareerNoticeDAO extends AbstractDAO {

	public List<Map<String, Object>> selectNoticeList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("notice.selectNoticeList", map);
	}
	
	public Map<String, Object> selectNoticePagingList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectPagingList("notice.selectNoticePagingList", map);
	}
	
	public Map<String, Object> selectNotice(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("notice.selectNotice", map);
	}
	
	public int updateNoticeCount(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("notice.updateNoticeCount", map);
	}
	
}
