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
		System.out.println("~~~~~~~CHƯƠNG TRÌNH QL TÀI KHOẢN~~~~~~~");
		menu();

	}

	private void menu() {
		int selected = 0;
		do {
			System.out.println("Mời bạn chọn chức năng muốn sử dụng");
			System.out.println("1. In danh sách TK");
			System.out.println("2. Tìm tài khoản theo username");
			System.out.println("3. Xoá tài khoản");
			System.out.println("4. Tạo tài khoản mới");
			System.out.println("5. Sửa tài khoản");
			System.out.println("6. Thoát chương trình");
			selected = ScannerUtil.scanInt();
			switch (selected) {
			case 1:
				printListAccount();
				break;
			case 2:
				findAccount();
				break;
			case 3:
				deleteAccount();
				break;
			case 4:
				createAccount();
				break;
			case 5:
				editAccount();
				break;
			case 6:
				System.out.println("Thoát chương trình");

			default:
				System.out.println("Sai chức năng");
				break;
			}

		} while (selected != 2);
	}

	private void editAccount() {
		System.out.println("-------------5.Sửa tài khoản---------");
	}

	private void createAccount() {
		System.out.println("-------------4.Tạo tài khoản mới---------");
		Account account = new Account();
		account.scanInfo();
		try {
			if (accController.createAccount(account)) {
				System.out.println("Bạn đã tạo tài khoản thành công");
			} else {
				System.out.println("Bạn đã tạo tài khoản thất bại");
			}
		} catch (SQLException e) {
			System.err.println("Lỗi sql =>" + e.getMessage());

		}
	}

	private void deleteAccount() {
		System.out.println("-------------3.Xoá tài khoản theo username---------");
		System.out.println("Mời bạn nhập vào UserName cần xoá");
		String userName = ScannerUtil.scanStr();

		try {
			System.out.println(accController.delAccountByUserName(userName));
		} catch (SQLException e) {
			System.err.println("Lỗi sql =>" + e.getMessage());
		}
	}

	private void findAccount() {
		System.out.println("-------------2.Tìm tài khoản theo username---------");
		System.out.println("Mời bạn nhập vào UserName cần tìm");
		String userName = ScannerUtil.scanStr();
		Account account = null;
		try {
			account = accController.findAccountByUserName(userName);
		} catch (SQLException e) {
			System.err.println("Lỗi sql =>" + e.getMessage());

		}
		if (account != null) {
			System.out.println(account);
		} else {
			System.out.println("Xin lỗi không tìm thấy tài khoản phù hợp");
		}
	}

	/**
	 * Phương thức in danh sách Account
	 */
	private void printListAccount() {
		System.out.println("---------------1: In dach sách tài khoản-------------");
		List<Account> listAcc = new ArrayList<Account>();
		try {
			listAcc.addAll(accController.getAllAccount());
		} catch (Exception e) {
			System.err.println("Xảy ra lỗi =>" + e.getMessage());
		}
		if (listAcc.isEmpty()) {
			System.out.println("Danh sách tài khoản rỗng");
		} else {
			System.out.println(String.format("%3s  |%30s  |%10s   |%15s", "ID", "Email", "UserName", "FullName"));
			System.out.println("----------------------------------------------------------------------");
			for (Account account : listAcc) {
				System.out.println(account.table());
			}
		}
	}
}
