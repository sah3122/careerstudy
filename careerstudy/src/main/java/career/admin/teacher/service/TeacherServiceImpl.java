package career.admin.teacher.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import career.admin.teacher.dao.TeacherDAO;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{

	@Resource(name="teacherDAO")
	private TeacherDAO teacherDAO;
	
	@Override
	public Map<String, Object> selectTeacher(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.selectTeacher(map);
	}
	@Override
	public Map<String, Object> selectSchoolData(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.selectSchoolData(map);
	}
	@Override
	public Map<String, Object> selectUserId(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.selectUserId(map);
	}
	
	@Override
	public List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.selectAreaList(map);
	}
	
	@Override
	public List<Map<String, Object>> selectTeacherList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.selectTeacherList(map);
	}

	@Override
	public int insertTeacher(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.insertTeacher(map);
	}

	@Override
	public int insertSchool(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.insertSchool(map);
	}

	@Override
	public int updateTeacher(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.updateTeacher(map);
	}

	@Override
	public int deleteTeacher(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.deleteTeacher(map);
	}

}
