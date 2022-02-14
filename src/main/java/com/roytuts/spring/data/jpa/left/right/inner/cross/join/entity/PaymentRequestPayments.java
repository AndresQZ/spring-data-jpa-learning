package com.roytuts.spring.data.jpa.left.right.inner.cross.join.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "payment_request_payments")
public class PaymentRequestPayments implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "message")
	private String message;
	
	
	//@Column(name = "payment_id")
	//private String paymentId;
	
	@Column(name = "payment_request_id")
	private String paymentRequestId;

	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id", insertable = false, updatable = false)
	//@Fetch(FetchMode.JOIN)
	private PaymentRequestEntity paymentRequestEntity;
	
	public PaymentRequestEntity getPaymentRequestEntity() {
		return paymentRequestEntity;
	}

	public void setPaymentRequestEntity(PaymentRequestEntity paymentRequestEntity) {
		this.paymentRequestEntity = paymentRequestEntity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public String getPaymentRequestId() {
		return paymentRequestId;
	}

	public void setPaymentRequestId(String paymentRequestId) {
		this.paymentRequestId = paymentRequestId;
	}
	
	

}
