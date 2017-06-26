package career.admin.student.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import career.common.dao.AbstractDAO;

@Repository("studentDAO")
public class StudentDAO extends AbstractDAO{
	
	public Map<String, Object> selectUserId(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("student.selectUserId", map);
	}
	
	public Map<String, Object> selectStudent(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("student.selectStudent", map);
	}
	
	public Map<String, Object> selectSchoolData(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("student.selectSchoolData", map);
	}
	
	public List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("student.selectSchoolList", map);
	}
	
	public List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("student.selectAreaList", map);
	}
	
	public List<Map<String, Object>> selectStudentList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("student.selectStudentList", map);
	}
	
	public int insertStudent(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) insert("student.insertStudent", map);
	}
	
	public int insertSchool(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) insert("student.insertSchool", map);
	}
	
	public int updateStudent(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("student.updateStudent", map);
	}
	
	public int deleteStudent(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("student.deleteStudent", map);
	}

}
