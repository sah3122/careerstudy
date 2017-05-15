package career.admin.common.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import career.admin.common.dao.AdminDAO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Resource(name="adminDAO")
	private AdminDAO adminDAO;
	
	@Override
	public Map<String, Object> selectUser(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return adminDAO.selectUser(map);
	}
}
