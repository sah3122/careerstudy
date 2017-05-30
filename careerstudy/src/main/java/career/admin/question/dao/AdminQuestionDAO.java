package career.admin.question.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import career.common.dao.AbstractDAO;

@Repository("adminQuestionDAO")
public class AdminQuestionDAO extends AbstractDAO{
	
	public List<Map<String, Object>> selectQuestionList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("question.selectQuestionList", map);
	}
	
	public List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("gallery.selectAreaList", map);
	} 
	
	public List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("question.selectSchoolList", map);
	}
	//
	public Map<String, Object> questionEmpty(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("question.questionEmpty", map);
	}
	
	public Map<String, Object> selectQuestion(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("question.selectQuestion", map);
	}
	
	public int insertQuestion(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) insert("question.insertQuestion", map);
	}
	
	public int updateQuestion(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("question.updateQuestion", map);
	}
	
	public int deleteQuestion(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("question.deleteQuestion", map);
	}
}
