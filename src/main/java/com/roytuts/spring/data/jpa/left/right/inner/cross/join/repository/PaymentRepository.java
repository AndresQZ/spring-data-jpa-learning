package com.roytuts.spring.data.jpa.left.right.inner.cross.join.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto;
import com.roytuts.spring.data.jpa.left.right.inner.cross.join.entity.PaymentRequestEntity;

public interface PaymentRepository extends JpaRepository<PaymentRequestEntity, Integer> {
	
	@Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
			+ "FROM Department d, Employee e")
	List<DeptEmpDto> fetchEmpDeptDataCrossJoin();
	/*
	 * @Query("SELECT pr FROM PaymentRequestEntity pr JOIN PaymentRequestPayments d ON d.paymentRequestId = pr.id  WHERE pr.id=?1"
	 * ) List<PaymentRequestEntity> getPayments(long id);
	 */
	
	@Query("SELECT pr FROM PaymentRequestEntity pr WHERE pr.id=?1")
	PaymentRequestEntity getPayments(long id);
}
