package career.video.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import career.gallery.dao.GalleryDAO;
import career.video.dao.VideoDAO;

@Service("videoService")
public class VideoServiceImpl implements VideoService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="videoDAO")
	private VideoDAO videoDAO;
	
	@Override
	public List<Map<String, Object>> selectVideoList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return videoDAO.selectVideoList(map);
	}
	
	@Override
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) videoDAO.selectFileList(map);
	}
	
	@Override
	public Map<String, Object> selectVideoPagingList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) videoDAO.selectVideoPagingList(map);
	}
	
	@Override
	public Map<String, Object> selectVideo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) videoDAO.selectVideo(map);
	}
	
	@Override
	public int updateVideoCount(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return videoDAO.updateVideoCount(map);
	}
}
