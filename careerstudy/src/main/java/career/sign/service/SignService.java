package career.sign.service;

import java.util.List;
import java.util.Map;

public interface SignService {

	List<Map<String, Object>> selectAreaList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectSchoolList(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectStudent(Map<String, Object> map) throws Exception;
	Map<String, Object> selectUser(Map<String, Object> map) throws Exception;
	
	int insertUser(Map<String, Object> map) throws Exception;
	int updateStudent(Map<String, Object> map) throws Exception;
	int deleteStudent(Map<String, Object> map) throws Exception;
	
}
