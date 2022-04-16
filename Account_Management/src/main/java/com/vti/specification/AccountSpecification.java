//package com.vti.specification;
//
//import org.springframework.data.jpa.domain.Specification;
//
//import com.vti.entity.Account;
//import com.vti.entity.filter.AccountFillter;
//
//public class AccountSpecification {
//	public static Specification<Account> builWhere(AccountFillter fillter) {
//		Specification<Account> whereRoot = null;
//		if (fillter.getEmail() != null) {
//			whereRoot = new CustomAccountSpecification("email", fillter.getEmail());
//
//		}
//		if (fillter.getUserName() != null) {
//			CustomAccountSpecification whereNew = new CustomAccountSpecification("userName", fillter.getUserName());
//			if (whereRoot == null) {
//				whereRoot = whereNew;
//			} else {
//				whereRoot = whereRoot.or(whereNew);
//			}
//		}
//
//		return whereRoot;
//
//	}
//}
