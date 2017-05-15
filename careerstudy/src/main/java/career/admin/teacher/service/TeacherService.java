package career.admin.teacher.service;

import java.util.List;
import java.util.Map;

public interface TeacherService {
	Map<String, Object> selectUserId(Map<String, Object> map) throws Exception;
	Map<String, Object> selectTeacher(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectTeacherList(Map<String, Object> map) throws Exception;
	
	int insertTeacher(Map<String, Object> map) throws Exception;
	int insertSchool(Map<String, Object> map) throws Exception;
	int updateTeacher(Map<String, Object> map) throws Exception;
	int deleteTeacher(Map<String, Object> map) throws Exception;
	
}
