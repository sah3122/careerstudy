package career.admin.notice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import career.common.dao.AbstractDAO;

@Repository("noticeDAO")
public class NoticeDAO extends AbstractDAO{
	
	public List<Map<String, Object>> selectNoticeList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("notice.selectNoticeList", map);
	}
	
	public Map<String, Object> selectNotice(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("notice.selectNotice", map);
	}
	
	public int insertNotice(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) insert("notice.insertNotice", map);
	}
	
	public int updateNotice(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("notice.updateNotice", map);
	}
	
	public int deleteNotice(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("notice.deleteNotice", map);
	}
}
