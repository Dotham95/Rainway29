package testingsystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;
import entity.PositionName;

public class TestingSystem2 {
	Department department1, department2, department3;
	Department[] listDepartments = new Department[3];
	Account account1, account2, account3, account4;
	Account[] listAccounts = new Account[4];
	Account[] accGroup1 = { account2 };
	Account[] accGroup2 = { account1, account2 };
	Account[] accGroup3 = { account1, account3 };
	Group group1, group2, group3, group4;
	Group[] listGroups = new Group[4];
	Group[] groupAcc1 = { group2, group3 };
	Group[] groupAcc2 = { group1, group2 };
	Group[] groupAcc3 = { group3 };
	Position position1, position2, position3, position4;
	Position[] listPositions = new Position[4];

	public TestingSystem2() {
		department1 = new Department(1, "Dev");
		department2 = new Department(2, "Sale");
		department3 = new Department(3, "Marketing");

		listDepartments[0] = department1;
		listDepartments[1] = department2;
		listDepartments[2] = department3;

		position1 = new Position(1, PositionName.DEV);
		position2 = new Position(2, PositionName.TEST);
		position3 = new Position(3, PositionName.SCRUM_MASTER);
		position4 = new Position(4, PositionName.PM);

		listPositions[0] = position1;
		listPositions[1] = position2;
		listPositions[2] = position3;
		listPositions[3] = position4;

		group1 = new Group(1, "Java Fresher", accGroup1);
		group2 = new Group(2, "JC# Fresher", accGroup2);
		group3 = new Group(3, "Pyton", accGroup3);
		group4 = new Group(4, "SQL");

		listGroups[0] = group1;
		listGroups[1] = group2;
		listGroups[2] = group3;
		listGroups[3] = group4;

		account1 = new Account(1, "chi90@gmail.com", "Thuychi", "Nguyen thuy Chi", department1, position1, groupAcc1);
		account2 = new Account(2, "ngoclan@gmail.com", "Lanngoc", "Ninh Duong Lan Ngoc", null, position3, groupAcc2);
		account3 = new Account(3, "tranxin@gmail.com", "tranthanh", "Huynh Tran Thanh", department3, position2,
				groupAcc3);
		account4 = new Account(4, "denvau89@gmail.com", "DenVau", "Nguyen Duc Cuong", department2, position4,
				groupAcc3);

		listAccounts[0] = account1;
		listAccounts[1] = account2;
		listAccounts[2] = account3;
		listAccounts[3] = account4;

	}

	/*
	 * -------------Exercise 1 (Optional): Flow Control (IF) ----------------------
	 */
	/*
	 * Question 1: Kiểm tra account thứ 2 Nếu không có phòng ban (tức là department
	 * == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban" Nếu không thì sẽ
	 * in ra text "Phòng ban của nhân viên này là ..."
	 */

	public void question1() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[1];
			if (a.getDepartment() == null) {
				System.out.println("Nhân viên" + a.getUserName() + "chưa có phòng ban.");
			} else {
				System.out.println("Phòng ban của" + a.getUserName() + "là:" + a.getDepartment().getName());
			}
		}
	}

	/*
	 * Question 2: Kiểm tra account thứ 2 Nếu không có group thì sẽ in ra text
	 * "Nhân viên này chưa có group" Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra
	 * text "Group của nhân viên này là Java Fresher, C# Fresher" Nếu có mặt trong 3
	 * Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều
	 * group" Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
	 * người hóng chuyện, tham gia tất cả các group"
	 */

	public void question2() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[1];
			if (a.getGroups() == null) {
				System.out.println("Nhân viên" + " " + a.getUserName() + " " + "chưa có group");
			} else {
				int j = a.getGroups().length;
				if (j == 1 || j == 2) {
					System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
				}
				if (j == 3) {
					System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
				}
				if (j >= 4) {
					System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
				}
			}
		}
	}

	/* -------------------- TERNARY ----------------------- */
	/*
	 * Question 3: Sử dụng toán tử ternary để làm Question 1
	 */
	public void question3() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[1];
			System.out.println(a.getDepartment() == null ? "Nhân viên này chưa có phòng ban."
					: "Phòng ban của" + a.getUserName() + "là:" + a.getDepartment().getName());
		}
	}

	/*
	 * Question 4: Sử dụng toán tử ternary để làm yêu cầu sau: Kiểm tra Position của
	 * account thứ 1 Nếu Position = Dev thì in ra text "Đây là Developer" Nếu không
	 * phải thì in ra text "Người này không phải là Developer"
	 */
	public void question4() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[0];
			System.out.println(a.getPosition().getId() == position1.getId() ? "Đây là Developer"
					: "Người này không phải là Developer");
		}
	}

	/*
	 * -------------------SWITCH CASE ------------------------------
	 */

	/*
	 * Question 5: Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format
	 * sau: Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên" Nếu số lượng
	 * account = 2 thì in ra "Nhóm có hai thành viên" Nếu số lượng account = 3 thì
	 * in ra "Nhóm có ba thành viên" Còn lại in ra "Nhóm có nhiều thành viên"
	 */
	public void question5() {
		for (int i = 0; i < listGroups.length; i++) {
			Group b = listGroups[1];
			if (b.getAccounts() == null) {
				System.out.println("Group chưa có thành viên nào tham gia");
			} else {
				int countAccInGroup = b.getAccounts().length;
				switch (countAccInGroup) {
				case 1:
					System.out.println("Nhóm có một thành viên");
					break;
				case 2:
					System.out.println("Nhóm có hai thành viên");
					break;
				case 3:
					System.out.println("Nhóm có ba thành viên");
					break;
				default:
					System.out.println("Nhóm có nhiều thành viên");
					break;
				}
			}
		}
	}

	/*
	 * Question 6: Sử dụng switch case để làm lại Question 2
	 */
	public void question6() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[0];
			if (a.getGroups() == null) {
				System.out.println("Nhân viên" + a.getUserName() + "chưa có group");
			} else {
				switch (a.getGroups().length) {
				case 1:
					System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
					break;
				case 2:
					System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
					break;
				case 3:
					System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
					break;
				default:
					System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
					break;
				}
			}
		}
	}

	/*
	 * Question 7: Sử dụng switch case để làm lại Question 4
	 */
	public void question7() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[0];
			switch (a.getPosition().getId()) {
			case 1:
				System.out.println("Đây là Developer");
				break;
			default:
				System.out.println("Người này không phải là Developer");
				break;
			}
		}
	}

	/*-------------------FOREACH------------------------*/
	/*
	 * Question 8: In ra thông tin các account bao gồm: Email, FullName và tên phòng
	 * ban của họ
	 */
	public void question8() {
		Account[] accountArray = { account1, account2, account3, account4 };
		for (Account account : accountArray) {
			if (account != null) {
				System.out.println("Account Info: " + account.getId() + " Email: " + account.getEmail() + " Name: "
						+ account.getFullName() + " " + account.getDepartment());
				System.out.println("-----------------------------");
			}
		}
	}

	/*
	 * Question 9: In ra thông tin các phòng ban bao gồm: id và name
	 */
	public void question9() {
		Department[] depArray = { department1, department2, department3 };
		for (Department department : depArray) {
			System.out.println("DepartmentID: " + department.getId() + " DepartmentName: " + department.getName());
			System.out.println("-----------------------------");
		}
	}
	/*----------------------FOR----------------------------------*/

	/*
	 * Question 10: In ra thông tin các account bao gồm: Email, FullName và tên
	 * phòng ban của họ theo định dạng như sau: Thông tin account thứ 1 là: Email:
	 * NguyenVanA@gmail.com Full name: Nguyễn Văn A Phòng ban: Sale Thông tin
	 * account thứ 2 là: Email: NguyenVanB@gmail.com Full name: Nguyễn Văn B Phòng
	 * ban: Marketting
	 */
	public void question10() {
		Account[] accountArray = { account1, account2, account3, account4 };
		for (int i = 0; i < accountArray.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " " + "là:");
			System.out.println("Email là: " + accountArray[i].getEmail());
			System.out.println("Full name là: " + accountArray[i].getFullName());
			System.out.println("Phòng ban là: " + accountArray[i].getDepartment().getName());
			System.out.println("-----------------------------");
		}
	}

	/*
	 * Question 11: In ra thông tin các phòng ban bao gồm: id và name theo định dạng
	 * sau: Thông tin department thứ 1 là: Id: 1 Name: Sale Thông tin department thứ
	 * 2 là: Id: 2 Name: Marketing
	 */
	public void question11() {

		Department[] depArray1 = { department1, department2, department3 };
		for (int i = 0; i < depArray1.length; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " " + "là:");
			System.out.println("Id: " + depArray1[i].getId());
			System.out.println("Name: " + depArray1[i].getName());
			System.out.println("-----------------------------");
		}
	}
	/*
	 * Question 12: Chỉ in ra thông tin 2 department đầu tiên theo định dạng như
	 * Question 10
	 */

	public void question12() {

		Department[] depArray2 = { department1, department2, department3 };
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " " + "là:");
			System.out.println("Id: " + depArray2[i].getId());
			System.out.println("Name: " + depArray2[i].getName());
			System.out.println("-----------------------------");
		}
	}
	/*
	 * Question 13: In ra thông tin tất cả các account ngoại trừ account thứ 2
	 */

	public void question13() {
		Account[] accountArray = { account1, account2, account3, account4 };
		for (int i = 0; i < accountArray.length; i++) {
			if (i != 1) {
				System.out.println("Thông tin account thứ " + (i + 1) + " " + "là:");
				System.out.println("Email là: " + accountArray[i].getEmail());
				System.out.println("Full name là: " + accountArray[i].getFullName());
				System.out.println("Phòng ban là: " + accountArray[i].getDepartment().getName());
				System.out.println("-----------------------------");
			}
		}
	}

	/*
	 * Question 14: In ra thông tin tất cả các account có id < 4
	 */
	public void question14() {
		Account[] accountArray = { account1, account2, account3, account4 };
		for (int i = 0; i < accountArray.length; i++) {
			if (i < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " " + "là:");
				System.out.println("Email là: " + accountArray[i].getEmail());
				System.out.println("Full name là: " + accountArray[i].getFullName());
				System.out.println("Phòng ban là: " + accountArray[i].getDepartment().getName());
				System.out.println("-----------------------------");
			}
		}
	}
	/*
	 * Question 15: In ra các số chẵn nhỏ hơn hoặc bằng 20
	 */

	public void question15() {
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}

	/* ---------------------------WHILE----------------------------- */
	/*
	 * Question 16: Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp
	 * với lệnh break, continue
	 */
	// Question 10
	public void question10b() {
		Account[] accountArray = { account1, account2, account3, account4 };
		int i = 0;
		while (i < accountArray.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " " + "là:");
			System.out.println("Email là: " + accountArray[i].getEmail());
			System.out.println("Full name là: " + accountArray[i].getFullName());
			System.out.println("Phòng ban là: " + accountArray[i].getDepartment().getName());
			System.out.println("-----------------------------");
			i++;
		}
	}

//Question 11
	public void question11b() {

		Department[] depArray1 = { department1, department2, department3 };
		int i = 0;
		while (i < depArray1.length) {
			System.out.println("Thông tin department thứ " + (i + 1) + " " + "là:");
			System.out.println("Id: " + depArray1[i].getId());
			System.out.println("Name: " + depArray1[i].getName());
			System.out.println("-----------------------------");
			i++;
		}
	}

//Question 12
	public void question12b() {

		Department[] depArray2 = { department1, department2, department3 };
		int i = 0;
		while (i < 2) {
			System.out.println("Thông tin department thứ " + (i + 1) + " " + "là:");
			System.out.println("Id: " + depArray2[i].getId());
			System.out.println("Name: " + depArray2[i].getName());
			System.out.println("-----------------------------");
			i++;
		}
	}

//Question 13
	public void question13b() {
		Account[] accountArray = { account1, account2, account3, account4 };
		int i = 0;
		while (i < accountArray.length) {
			if (i != 1) {
				System.out.println("Thông tin account thứ " + (i + 1) + " " + "là:");
				System.out.println("Email là: " + accountArray[i].getEmail());
				System.out.println("Full name là: " + accountArray[i].getFullName());
				System.out.println("Phòng ban là: " + accountArray[i].getDepartment().getName());
				System.out.println("-----------------------------");
			}
			i++;
		}
	}

	// Question 14
	public void question14b() {
		Account[] accountArray = { account1, account2, account3, account4 };
		int i = 0;
		while (i < accountArray.length) {
			// Account acc = accountArray[i];
			if (i < 4) {
				accountArray[i].printInfo(i + 1);
//				System.out.println("Thông tin account thứ " + (i + 1) + " " + "là:");
//				System.out.println("Email là: " + acc.getEmail());
//				System.out.println("Full name là: " + acc.getFullName());
//				if (acc.getDepartment() != null) {
//					System.out.println("Phòng ban là: " + acc.getDepartment().getName());
//				} else {
//					System.out.println("Khong o trong phong ban nao");
//				}
//				System.out.println("-----------------------------");
			}
			i++;
		}
	}

//Question 15
	public void question15b() {
		int i = 1;
		while (i <= 20) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
			i++;
		}
	}

	/* ----------------------DO-WHILE---------------------------------- */
	/*
	 * Question 17: Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết
	 * hợp với lệnh break, continue
	 */
//Question 10
	public void question10c() {
		Account[] accountArray = { account1, account2, account3, account4 };
		int i = 0;
		do {
			System.out.println("Thông tin account thứ " + (i + 1) + " " + "là:");
			System.out.println("Email là: " + accountArray[i].getEmail());
			System.out.println("Full name là: " + accountArray[i].getFullName());
			System.out.println("Phòng ban là: " + accountArray[i].getDepartment().getName());
			System.out.println("-----------------------------");
			i++;
		} while (i < accountArray.length);
	}

//Question 11
	public void question11c() {

		Department[] depArray1 = { department1, department2, department3 };
		int i = 0;
		do {
			System.out.println("Thông tin department thứ " + (i + 1) + " " + "là:");
			System.out.println("Id: " + depArray1[i].getId());
			System.out.println("Name: " + depArray1[i].getName());
			System.out.println("-----------------------------");
			i++;
		} while (i < depArray1.length);
	}

//Question 12
	public void question12c() {

		Department[] depArray2 = { department1, department2, department3 };
		int i = 0;
		do {
			System.out.println("Thông tin department thứ " + (i + 1) + " " + "là:");
			System.out.println("Id: " + depArray2[i].getId());
			System.out.println("Name: " + depArray2[i].getName());
			System.out.println("-----------------------------");
			i++;
		} while (i < 2);
	}

//Question 13
	public void question13c() {
		Account[] accountArray = { account1, account2, account3, account4 };
		int i = 0;
		do {
			if (i != 1) {
				System.out.println("Thông tin account thứ " + (i + 1) + " " + "là:");
				System.out.println("Email là: " + accountArray[i].getEmail());
				System.out.println("Full name là: " + accountArray[i].getFullName());
				System.out.println("Phòng ban là: " + accountArray[i].getDepartment().getName());
				System.out.println("-----------------------------");
			}
			i++;
		} while (i < accountArray.length);
	}

	// Question 14
	public void question14c() {
		Account[] accountArray = { account1, account2, account3, account4 };
		int i = 0;
		do {
			if (i < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " " + "là:");
				System.out.println("Email là: " + accountArray[i].getEmail());
				System.out.println("Full name là: " + accountArray[i].getFullName());
				System.out.println("Phòng ban là: " + accountArray[i].getDepartment().getName());
				System.out.println("-----------------------------");
			}
			i++;
		} while (i < accountArray.length);
	}

//Question 15
	public void question15c() {
		int i = 1;
		do {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
			i++;
		} while (i <= 20);
	}

	/*--------------Exercise 2 (Optional): System out printf-----------------------*/
	/*
	 * Question 1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in
	 * ra số nguyên đó
	 */
	public void question1d() {
		int i = 5;
		System.out.printf("%d%n", i);
	}

	/*
	 * Question 2: Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out
	 * printf để in ra số nguyên đó thành định dạng như sau: 100,000,000
	 */
	public void question2d() {
		int i = 100000000;
		System.out.printf("%,d%n", i);
	}

	/*
	 * Question 3: Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf
	 * để in ra số thực đó chỉ bao gồm 4 số đằng sau
	 */
	public void question3d() {
		float c = 5.567098f;
		System.out.printf("%5.4f%n", c);
	}

	/*
	 * Question 4: Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó
	 * theo định dạng như sau: Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console
	 * như sau: Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
	 */
	public void question4d() {
		String a = "Nguyễn Văn A";
		System.out.printf("Tên tôi là \"" + a + "\" và tôi đang độc thân\n");
	}

	/*
	 * Question 5: Lấy thời gian bây giờ và in ra theo định dạng sau: 24/04/2020
	 * 11h:16p:20s
	 */
	public void question5d() {
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
	}
}
