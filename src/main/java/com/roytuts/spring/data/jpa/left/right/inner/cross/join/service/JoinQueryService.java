package com.roytuts.spring.data.jpa.left.right.inner.cross.join.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.entity.Department;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.entity.Employee;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.entity.PaymentRequestEntity;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.repository.DepartmentRepository;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.repository.EmployeeRepository;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.repository.PaymentRepository;

@Service
public class JoinQueryService {

	@Resource
	private DepartmentRepository departmentRepository;

	@Resource
	private EmployeeRepository employeeRepository;
	@Resource
	private PaymentRepository paymentRepository;

	public List<DeptEmpDto> getDeptEmployeesLeftJoin() {
		List<DeptEmpDto> list = departmentRepository.fetchEmpDeptDataLeftJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	public List<DeptEmpDto> getDeptEmployeesRightJoin() {
		List<DeptEmpDto> list = departmentRepository.fetchEmpDeptDataRightJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	/*
	 * public List<DeptEmpDto> getDeptEmployeesInnerJoin() { List<DeptEmpDto> list =
	 * employeeRepository.fetchEmpDeptDataInnerJoin("Suman"); list.forEach(l ->
	 * System.out.println(l)); return list; }
	 */
	
	public List<Employee> getDeptEmployeesInnerJoin() {
		List<Employee> list = employeeRepository.fetchEmpDeptDataInnerJoin("TelComm");
		list.forEach(l -> System.out.println(l.toString()));
		return null;
	}
	
	public List<Department> getDeptEmployeesInnerJoin1() {
		List<Department> list = departmentRepository.fetchEmpDeptDataInnerJoin("TelComm");
		list.forEach(l -> System.out.println(l.toString()));
		return list;
	}

	public List<DeptEmpDto> getDeptEmployeesCrossJoin() {
		List<DeptEmpDto> list = employeeRepository.fetchEmpDeptDataCrossJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}
	
	public PaymentRequestEntity getPaymentDetail(long paymentRequestId) {
		var response = paymentRepository.getPayments(paymentRequestId);
		ObjectMapper mapper = new ObjectMapper(); 
		try {
			System.out.print(mapper.writeValueAsString(response));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
