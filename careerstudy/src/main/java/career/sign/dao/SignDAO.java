package career.sign.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import career.common.dao.AbstractDAO;

@Repository("signDAO")
public class SignDAO extends AbstractDAO {

	public List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("sign.selectAreaList", map);
	} 
	
	public List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("sign.selectSchoolList", map);
	}
	
	public Map<String, Object> selectUser(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) selectOne("sign.selectUser", map);
	}
	
	public int insertUser(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) insert("sign.insertUser", map);
	}

}
