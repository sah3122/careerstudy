package career.admin.teacher.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import career.common.dao.AbstractDAO;

@Repository("teacherDAO")
public class TeacherDAO extends AbstractDAO{
	
	public Map<String, Object> selectUserId(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("teacher.selectUserId", map);
	}
	
	public Map<String, Object> selectTeacher(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>)selectOne("teacher.selectTeacher", map);
	}
	
	public List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("teacher.selectAreaList", map);
	}
	
	public List<Map<String, Object>> selectTeacherList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("teacher.selectTeacherList", map);
	}
	
	public int insertTeacher(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) insert("teacher.insertTeacher", map);
	}
	
	public int insertSchool(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) insert("teacher.insertSchool", map);
	}
	
	public int updateTeacher(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("teacher.updateTeacher", map);
	}
	
	public int deleteTeacher(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (int) update("teacher.deleteTeacher", map);
	}

}
