package career.notice.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import career.board.dao.BoardDAO;
import career.notice.dao.CareerNoticeDAO;

@Service("careerNoticeService")
public class CareerNoticeServiceImpl implements CareerNoticeService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="careerNoticeDAO")
	private CareerNoticeDAO careerNoticeDAO;
	
	@Override
	public List<Map<String, Object>> selectNoticeList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return careerNoticeDAO.selectNoticeList(map);
	}
	
	@Override
	public Map<String, Object> selectNoticePagingList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) careerNoticeDAO.selectNoticePagingList(map);
	}
	
	@Override
	public Map<String, Object> selectNotice(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) careerNoticeDAO.selectNotice(map);
	}
	
	@Override
	public int updateNoticeCount(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return careerNoticeDAO.updateNoticeCount(map);
	}
}
