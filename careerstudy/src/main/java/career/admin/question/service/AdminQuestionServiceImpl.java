package career.admin.question.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import career.admin.gallery.dao.AdminGalleryDAO;
import career.admin.question.dao.AdminQuestionDAO;
import career.common.util.FileUtils;
import career.common.util.Session;

@Service("adminQuestionService")
public class AdminQuestionServiceImpl implements AdminQuestionService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="adminQuestionDAO")
	private AdminQuestionDAO adminQuestionDAO;
	
	@Override
	public List<Map<String, Object>> selectQuestionList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) adminQuestionDAO.selectQuestionList(map);
	}

	@Override
	public List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) adminQuestionDAO.selectAreaList(map);
	}
	
	@Override
	public List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) adminQuestionDAO.selectSchoolList(map);
	}
	
	@Override
	public void insertQuestion(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		adminQuestionDAO.insertQuestion(map);
	}
	
	@Override
	public int updateQuestion(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return adminQuestionDAO.updateQuestion(map);
	}

	@Override
	public int deleteQuestion(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return adminQuestionDAO.deleteQuestion(map);
	}
	
	@Override
	public Map<String, Object> questionEmpty(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) adminQuestionDAO.questionEmpty(map);
	}
	
	@Override
	public Map<String, Object> selectQuestion(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) adminQuestionDAO.selectQuestion(map);
	}

}
