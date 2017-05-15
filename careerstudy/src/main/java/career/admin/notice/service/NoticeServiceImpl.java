package career.admin.notice.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import career.admin.common.dao.AdminDAO;
import career.admin.notice.dao.NoticeDAO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Resource(name="noticeDAO")
	private NoticeDAO noticeDAO;
	
	@Override
	public List<Map<String, Object>> selectNoticeList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) noticeDAO.selectNoticeList(map);
	}

	@Override
	public int insertNotice(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.insertNotice(map);
	}
	
	@Override
	public int updateNotice(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.updateNotice(map);
	}

	@Override
	public int deleteNotice(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.deleteNotice(map);
	}
	
	@Override
	public Map<String, Object> selectNotice(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) noticeDAO.selectNotice(map);
	}

}
