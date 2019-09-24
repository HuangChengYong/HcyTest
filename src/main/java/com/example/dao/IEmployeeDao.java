package com.example.dao;

import com.example.pojos.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 员工实体接口
 */
@Repository
public interface IEmployeeDao extends CrudRepository<Employee,Integer> {
}
