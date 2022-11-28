package com.tgi.springBanking.specification;

import java.time.LocalDateTime;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.tgi.springBanking.Entity.TransactionHistory;

public class TransactionHistorySpecification implements Specification<TransactionHistory> {

	private SearchCriteria criteria;
	private LocalDateTime fromDate ;
	private LocalDateTime toDate;

	public TransactionHistorySpecification(SearchCriteria criteria) {
		super();
		this.criteria = criteria;
		this.fromDate = criteria.getValue1();
		this.toDate = criteria.getValue2();
	}

	@Override
	public Predicate toPredicate(Root<TransactionHistory> root, CriteriaQuery<?> query,CriteriaBuilder builder) {

		if (criteria.getOperation().equalsIgnoreCase(">")) { 
            return builder.greaterThanOrEqualTo(
              root.<String> get(criteria.getKey()), criteria.getValue().toString());
        } 
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
              root.<String> get(criteria.getKey()), criteria.getValue().toString());
        } 
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                  root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }else if (criteria.getOperation().equalsIgnoreCase("--")) {
        
            return builder.between(root.get(criteria.getKey()), fromDate, toDate);

  	        }
 	        

	

		return null;
	}
}
