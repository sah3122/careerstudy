package career.question.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import career.common.dao.AbstractDAO;

@Repository("questionDAO")
public class QuestionDAO extends AbstractDAO {
	
	public Map<String, Object> selectQuestion(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("question.selectQuestion", map);
	}
}
