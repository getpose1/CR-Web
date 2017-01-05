package com.cr.domain;

public class DetailsTransaction {
    private Integer detailTransactionId;

    private String transactionId;

    private Long baseAmount;

    private Long discountAmount;

    private Integer quantity;
    
    private Long subTotal;
    
    private Products product;

    public Integer getDetailTransactionId() {
        return detailTransactionId;
    }

    public void setDetailTransactionId(Integer detailTransactionId) {
        this.detailTransactionId = detailTransactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Long getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(Long baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Long getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Long subTotal) {
		this.subTotal = subTotal;
	}
    
}