package com.roytuts.spring.data.jpa.left.right.inner.cross.join.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.entity.Department;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.entity.Employee;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.entity.PaymentRequestEntity;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.service.JoinQueryService;

@RestController
public class JoinQueryController {

	@Autowired
	private JoinQueryService joinQueryService;

	@GetMapping("/dept/employees/left")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesLeftJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesLeftJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/employees/right")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesRightJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesRightJoin(), HttpStatus.OK);
	}
	/*
	 * @GetMapping("/dept/employees/inner") public ResponseEntity<List<DeptEmpDto>>
	 * getDeptEmployeesInnerJoin() { return new
	 * ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesInnerJoin()
	 * , HttpStatus.OK); }
	 */
	
	@GetMapping("/dept/employees/inner")
	public ResponseEntity<List<Employee>> getDeptEmployeesInnerJoin() {
		return new ResponseEntity<List<Employee>>(joinQueryService.getDeptEmployeesInnerJoin(), HttpStatus.OK);
	}
	
	@GetMapping("/dept/departaments/inner")
	public ResponseEntity<List<Department>> getDeptEmployeesInnerJoin1() {
		return new ResponseEntity<List<Department>>(joinQueryService.getDeptEmployeesInnerJoin1(), HttpStatus.OK);
	}
	
	

	@GetMapping("/dept/employees/cross")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesCrossJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesCrossJoin(), HttpStatus.OK);
	}
	
	
	@GetMapping("/payment/details")
	public ResponseEntity<Object> getPaymentDetails(@RequestParam long paymentRequestId) {
		return new ResponseEntity<Object>(joinQueryService.getPaymentDetail(paymentRequestId), HttpStatus.OK);
	}

}
