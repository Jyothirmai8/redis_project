package com.example.redis_project.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.redis_project.entity.Employee;

@Component
@CacheConfig(cacheNames = "EmployeeService")
public class EmployeeService {
	
@Cacheable	
public Employee getEmployee(int id,String name) {
	return new Employee(id,name);
}
}
