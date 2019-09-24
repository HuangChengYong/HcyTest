package com.example.dao;

import com.example.pojos.Dept;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 部门实体接口
 */
@Repository
public interface IDeptDao extends CrudRepository<Dept,Integer> {
}
