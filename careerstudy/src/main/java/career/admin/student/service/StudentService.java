package career.admin.student.service;

import java.util.List;
import java.util.Map;

public interface StudentService {
	Map<String, Object> selectUserId(Map<String, Object> map) throws Exception;
	Map<String, Object> selectStudent(Map<String, Object> map) throws Exception;
	Map<String, Object> selectSchoolData(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectStudentList(Map<String, Object> map) throws Exception;
	
	int insertStudent(Map<String, Object> map) throws Exception;
	int insertSchool(Map<String, Object> map) throws Exception;
	int updateStudent(Map<String, Object> map) throws Exception;
	int deleteStudent(Map<String, Object> map) throws Exception;
	
}
