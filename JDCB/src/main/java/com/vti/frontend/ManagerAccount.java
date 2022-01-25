package com.vti.frontend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.presentation.AccountControllerImpl;
import com.vti.backend.presentation.IAccountController;
import com.vti.entity.Account;
import com.vti.utils.ScannerUtil;

public class ManagerAccount {

	private IAccountController accController;

	public ManagerAccount() {
		accController = new AccountControllerImpl();
		System.out.println("~~~~~~~Chuong trinh QL Tai khoan~~~~~~~");
		menu();

	}

	private void menu() {
		int selected = 0;
		do {
			System.out.println("Moi ban chon chuc nang");
			System.out.println("1. In danh sach TK");
			System.out.println("2. Thoat chuong trinh");
			selected = ScannerUtil.scanInt();
			switch (selected) {
			case 1:
				printListAccount();
				break;
			case 2:
				System.out.println("Thoat chuong trinh");

			default:
				System.out.println("Sai chuc nang");
				break;
			}

		} while (selected != 2);
	}

	/**
	 * Phuong thuc in danh sach Account
	 */
	private void printListAccount() {
		System.out.println("~~~~~1: In danh sach tai khoan");
		List<Account> listAcc = new ArrayList<Account>();
		try {
			listAcc.addAll(accController.getAllAccount());
		} catch (Exception e) {
			System.err.println("Xay ra loi =>" + e.getMessage());
		}
		if (listAcc.isEmpty()) {
			System.out.println("Danh sach rong");
		} else {
			for (Account account : listAcc) {
				System.out.println(account);
			}
		}
//		try {
//			List<Account> listAcc = accController.getAllAccount();
//			for (Account acc : iterable) {
//				
//			
//		} catch (SQLException e) {
//			System.err.println("Xay ra loi =>" + e.getMessage());
//		}
//		for (Account acc : iterable) {
//			
//		}
//	}
	}
}
