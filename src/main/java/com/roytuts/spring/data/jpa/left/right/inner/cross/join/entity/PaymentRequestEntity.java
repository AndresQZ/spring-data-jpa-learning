package com.roytuts.spring.data.jpa.left.right.inner.cross.join.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "payment_request")
public class PaymentRequestEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	@Column(name = "merchant_id")
	private String merchantId;
	
	@Column(name = "message")
	private String message;
	
	@JsonManagedReference
	@OneToMany(targetEntity = PaymentRequestPayments.class, mappedBy = "paymentRequestId", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<PaymentRequestPayments> paymentRequestPayments;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Set<PaymentRequestPayments> getPaymentRequestPayments() {
		return paymentRequestPayments;
	}

	public void setPaymentRequestPayments(Set<PaymentRequestPayments> paymentRequestPayments) {
		this.paymentRequestPayments = paymentRequestPayments;
	}

	
	

}
