package career.admin.student.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import career.admin.student.dao.StudentDAO;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Resource(name="studentDAO")
	private StudentDAO studentDAO;
	
	@Override
	public Map<String, Object> selectStudent(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.selectStudent(map);
	}
	@Override
	public Map<String, Object> selectSchoolData(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.selectSchoolData(map);
	}
	@Override
	public Map<String, Object> selectUserId(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.selectUserId(map);
	}
	
	@Override
	public List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>) studentDAO.selectSchoolList(map);
	}
	@Override
	public List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.selectAreaList(map);
	}
	
	@Override
	public List<Map<String, Object>> selectStudentList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.selectStudentList(map);
	}

	@Override
	public int insertStudent(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.insertStudent(map);
	}

	@Override
	public int insertSchool(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.insertSchool(map);
	}

	@Override
	public int updateStudent(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.updateStudent(map);
	}

	@Override
	public int deleteStudent(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.deleteStudent(map);
	}

}
