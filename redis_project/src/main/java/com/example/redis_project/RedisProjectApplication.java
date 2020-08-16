package com.example.redis_project;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.redis_project.entity.Employee;
import com.example.redis_project.service.EmployeeService;
@EnableCaching
@EnableScheduling
@SpringBootApplication
public class RedisProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisProjectApplication.class, args);
	}
	@Autowired
	private EmployeeService eservice;
	
	@Scheduled(fixedDelay = 500)
	public void empInfo() {
		int index=new Random().nextInt(list.size());
		String emp=search(index);
		
		Employee e=eservice.getEmployee(index, emp);  //cache
		
		System.out.println("employee record is "+e.getId()+"    name is "+e.getName());
	}
	
	private String search(int index) {
		return list.get(index);
	}
	private static final List<String> list=Arrays.asList("Rajesh","Santosh","Aparna","Saranya","Bhupendra","Mohan");

}
