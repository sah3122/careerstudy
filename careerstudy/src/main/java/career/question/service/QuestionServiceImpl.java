package career.question.service;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import career.question.dao.QuestionDAO;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="questionDAO")
	private QuestionDAO questionDAO;
	
	@Override
	public Map<String, Object> selectQuestion(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return questionDAO.selectQuestion(map);
	}

}
