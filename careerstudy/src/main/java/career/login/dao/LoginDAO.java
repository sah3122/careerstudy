package career.login.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import career.common.dao.AbstractDAO;

@Repository("loginDAO")
public class LoginDAO extends AbstractDAO {
	
	public Map<String, Object> selectUser(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("login.selectUser", map);
	}
}
