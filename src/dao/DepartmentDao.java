package dao;
import entity.Department;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public class DepartmentDao extends Dao<Department>{
	
}