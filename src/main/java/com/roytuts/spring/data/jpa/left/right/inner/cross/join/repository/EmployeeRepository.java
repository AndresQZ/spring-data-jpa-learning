package com.roytuts.spring.data.jpa.left.right.inner.cross.join.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.entity.Department;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	/*
	 * @Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
	 * + "FROM Department d INNER JOIN d.employees e") List<DeptEmpDto>
	 * fetchEmpDeptDataInnerJoin();
	 */
	
	/*
	 * "SELECT new com.payclip.payment.request.model.jpa.transactions.PaymentRequestPayments("
	 * + "prp.paymentRequestId, prp.paymentId, prp.message, prp. createdAt) " +
	 * "FROM PaymentRequestPayments prp JOIN PaymentRequestEntity pr " + "ON
	 * prp.paymentRequestId = pr.paymentRequestId WHERE prp.paymentRequestId = ?1
	 */	
	/*
	 * @Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.entity.Employee(e.name, e.email, e.address, e.id) "
	 * + "FROM Employee e JOIN Department d ON e.depId = d.id WHERE e.name = ?1")
	 */
	
	@Query("SELECT e FROM Employee e WHERE e.name=?1")
	List<Employee> fetchEmpDeptDataInnerJoin(String name);

	@Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
			+ "FROM Department d, Employee e")
	List<DeptEmpDto> fetchEmpDeptDataCrossJoin();

}
