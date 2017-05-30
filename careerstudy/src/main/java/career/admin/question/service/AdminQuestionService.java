package career.admin.question.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AdminQuestionService {
	List<Map<String, Object>> selectQuestionList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception;
	
	Map<String, Object> questionEmpty(Map<String, Object> map) throws Exception;
	Map<String, Object> selectQuestion(Map<String, Object> map) throws Exception;
	
	void insertQuestion(Map<String, Object> map) throws Exception;
	int updateQuestion(Map<String, Object> map) throws Exception;
	int deleteQuestion(Map<String, Object> map) throws Exception;
}
