package career.login.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import career.login.dao.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="loginDAO")
	private LoginDAO loginDAO;
	
	@Override
	public Map<String, Object> selectUser(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return loginDAO.selectUser(map);
	}

}
