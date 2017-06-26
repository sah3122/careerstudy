package career.sign.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import career.sign.dao.SignDAO;

@Service("signService")
public class SignServiceImpl implements SignService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="signDAO")
	private SignDAO signDAO;
	
	@Override
	public List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return signDAO.selectAreaList(map);
	}
	
	@Override
	public List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return signDAO.selectSchoolList(map);
	}
	
	@Override
	public Map<String, Object> selectStudent(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return signDAO.selectStudent(map);
	}
	
	@Override
	public Map<String, Object> selectUser(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return signDAO.selectUser(map);
	}
	
	@Override
	public int insertUser(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return signDAO.insertUser(map);
	}
	
	@Override
	public int updateStudent(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return signDAO.updateStudent(map);
	}
	
	@Override
	public int deleteStudent(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return signDAO.deleteStudent(map);
	}

}
