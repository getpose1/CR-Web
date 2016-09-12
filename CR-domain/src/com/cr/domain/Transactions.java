package com.cr.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transactions {
	
    private String transactionId;

    private Date created;

    private Integer createdBy;

    private Long subTotalAmount = 0L;
    
    private Long taxAmount = 0L;
    
    private Long totalAmount = 0L;

    private String type;
    
    private List<DetailsTransaction> listDetailsTransaction = new ArrayList<>();

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public List<DetailsTransaction> getListDetailsTransaction() {
		return listDetailsTransaction;
	}

	public void setListDetailsTransaction(List<DetailsTransaction> listDetailsTransaction) {
		this.listDetailsTransaction = listDetailsTransaction;
	}

	public Long getSubTotalAmount() {
		return subTotalAmount;
	}

	public void setSubTotalAmount(Long subTotalAmount) {
		this.subTotalAmount = subTotalAmount;
	}

	public Long getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Long taxAmount) {
		this.taxAmount = taxAmount;
	}
   
}