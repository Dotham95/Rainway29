package testingsystem;

import java.text.SimpleDateFormat;
import java.util.Date;

import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;
import entity.PositionName;

public class TestingSystem1 {
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

	public TestingSystem1() {
		department1 = new Department(1, "Dev");
		department2 = new Department(2, "Sale");
		department3 = new Department(3, "Marketing");

		listDepartments[0] = department1;
		listDepartments[1] = department2;
		listDepartments[2] = department3;

		account1 = new Account(1, "chi90@gmail.com", "Thuychi", "Nguyen thuy Chi", department1, position1, groupAcc1);
		account2 = new Account(2, "ngoclan@gmail.com", "Lanngoc", "Ninh Duong Lan Ngoc", department3, position3,
				groupAcc2);
		account3 = new Account(3, "tranxin@gmail.com", "tranthanh", "Huynh Tran Thanh", department3, position2,
				groupAcc3);
		account4 = new Account(4, "denvau89@gmail.com", "DenVau", "Nguyen Duc Cuong", department2, position4,
				groupAcc3);

		listAccounts[0] = account1;
		listAccounts[1] = account2;
		listAccounts[2] = account3;
		listAccounts[3] = account4;

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

	}

	/*
	 * -------------Exercise 1 (Optional): Flow Control (IF) ----------------------
	 */
	/*
	 * Question 1: Ki???m tra account th??? 2 N???u kh??ng c?? ph??ng ban (t???c l?? department
	 * == null) th?? s??? in ra text "Nh??n vi??n n??y ch??a c?? ph??ng ban" N???u kh??ng th?? s???
	 * in ra text "Ph??ng ban c???a nh??n vi??n n??y l?? ..."
	 */

	public void question1() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[1];
			if (a.getDepartment() == null) {
				System.out.println("Nh??n vi??n" + a.getUserName() + "ch??a c?? ph??ng ban.");
			} else {
				System.out.println("Ph??ng ban c???a" + a.getUserName() + "l??:" + a.getDepartment().getName());
			}
		}
	}

	/*
	 * Question 2: Ki???m tra account th??? 2 N???u kh??ng c?? group th?? s??? in ra text
	 * "Nh??n vi??n n??y ch??a c?? group" N???u c?? m???t trong 1 ho???c 2 group th?? s??? in ra
	 * text "Group c???a nh??n vi??n n??y l?? Java Fresher, C# Fresher" N???u c?? m???t trong 3
	 * Group th?? s??? in ra text "Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u
	 * group" N???u c?? m???t trong 4 group tr??? l??n th?? s??? in ra text "Nh??n vi??n n??y l??
	 * ng?????i h??ng chuy???n, tham gia t???t c??? c??c group"
	 */

	public void question2() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[1];
			if (a.getGroups() == null) {
				System.out.println("Nh??n vi??n" + " " + a.getUserName() + " " + "ch??a c?? group");
			} else {
				int j = a.getGroups().length;
				if (j == 1 || j == 2) {
					System.out.println("Group c???a nh??n vi??n n??y l?? Java Fresher, C# Fresher");
				}
				if (j == 3) {
					System.out.println("Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u group");
				}
				if (j >= 4) {
					System.out.println("Nh??n vi??n n??y l?? ng?????i h??ng chuy???n, tham gia t???t c??? c??c group");
				}
			}
		}
	}

	/* -------------------- TERNARY ----------------------- */
	/*
	 * Question 3: S??? d???ng to??n t??? ternary ????? l??m Question 1
	 */
	public void question3() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[1];
			System.out.println(a.getDepartment() == null ? "Nh??n vi??n n??y ch??a c?? ph??ng ban."
					: "Ph??ng ban c???a" + a.getUserName() + "l??:" + a.getDepartment().getName());
		}
	}

	/*
	 * Question 4: S??? d???ng to??n t??? ternary ????? l??m y??u c???u sau: Ki???m tra Position c???a
	 * account th??? 1 N???u Position = Dev th?? in ra text "????y l?? Developer" N???u kh??ng
	 * ph???i th?? in ra text "Ng?????i n??y kh??ng ph???i l?? Developer"
	 */
	public void question4() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[0];
			System.out.println(a.getPosition() == position1 ? "????y l?? Developer" : "Ng?????i n??y kh??ng ph???i l?? Developer");
		}
	}

	/*
	 * -------------------SWITCH CASE ------------------------------
	 */

	/*
	 * Question 5: L???y ra s??? l?????ng account trong nh??m th??? 1 v?? in ra theo format
	 * sau: N???u s??? l?????ng account = 1 th?? in ra "Nh??m c?? m???t th??nh vi??n" N???u s??? l?????ng
	 * account = 2 th?? in ra "Nh??m c?? hai th??nh vi??n" N???u s??? l?????ng account = 3 th??
	 * in ra "Nh??m c?? ba th??nh vi??n" C??n l???i in ra "Nh??m c?? nhi???u th??nh vi??n"
	 */
	public void question5() {
		for (int i = 0; i < listGroups.length; i++) {
			Group b = listGroups[1];
			if (b.getAccounts() == null) {
				System.out.println("Group ch??a c?? th??nh vi??n n??o tham gia");
			} else {
				int countAccInGroup = b.getAccounts().length;
				switch (countAccInGroup) {
				case 1:
					System.out.println("Nh??m c?? m???t th??nh vi??n");
					break;
				case 2:
					System.out.println("Nh??m c?? hai th??nh vi??n");
					break;
				case 3:
					System.out.println("Nh??m c?? ba th??nh vi??n");
					break;
				default:
					System.out.println("Nh??m c?? nhi???u th??nh vi??n");
					break;
				}
			}
		}
	}

	/*
	 * Question 6: S??? d???ng switch case ????? l??m l???i Question 2
	 */
	public void question6() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[0];
			if (a.getGroups() == null) {
				System.out.println("Nh??n vi??n" + a.getUserName() + "ch??a c?? group");
			} else {
				switch (a.getGroups().length) {
				case 1:
					System.out.println("Group c???a nh??n vi??n n??y l?? Java Fresher, C# Fresher");
					break;
				case 2:
					System.out.println("Group c???a nh??n vi??n n??y l?? Java Fresher, C# Fresher");
					break;
				case 3:
					System.out.println("Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u group");
					break;
				default:
					System.out.println("Nh??n vi??n n??y l?? ng?????i h??ng chuy???n, tham gia t???t c??? c??c group");
					break;
				}
			}
		}
	}

	/*
	 * Question 7: S??? d???ng switch case ????? l??m l???i Question 4
	 */
	public void question7() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[0];
			switch (a.getPosition().getId()) {
			case 1:
				System.out.println("????y l?? Developer");
				break;
			default:
				System.out.println("Ng?????i n??y kh??ng ph???i l?? Developer");
				break;
			}
		}
	}

	/*-------------------FOREACH------------------------*/
	/*
	 * Question 8: In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n ph??ng
	 * ban c???a h???
	 */
	public void question8() {
		Account[] accountArray = { account1, account2, account3, account4 };
		for (Account account : accountArray) {
			System.out.println("Account Info: " + account.getId() + " Email: " + account.getEmail() + " Name: "
					+ account.getFullName() + " " + account.getDepartment());
			System.out.println("-----------------------------");
		}
	}

	/*
	 * Question 9: In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name
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
	 * Question 10: In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n
	 * ph??ng ban c???a h??? theo ?????nh d???ng nh?? sau: Th??ng tin account th??? 1 l??: Email:
	 * NguyenVanA@gmail.com Full name: Nguy???n V??n A Ph??ng ban: Sale Th??ng tin
	 * account th??? 2 l??: Email: NguyenVanB@gmail.com Full name: Nguy???n V??n B Ph??ng
	 * ban: Marketting
	 */
	public void question10() {
		Account[] accountArray = { account1, account2, account3, account4 };
		for (int i = 0; i < accountArray.length; i++) {
			System.out.println("Th??ng tin account th??? " + (i + 1) + " " + "l??:");
			System.out.println("Email l??: " + accountArray[i].getEmail());
			System.out.println("Full name l??: " + accountArray[i].getFullName());
			System.out.println("Ph??ng ban l??: " + accountArray[i].getDepartment().getName());
			System.out.println("-----------------------------");
		}
	}

	/*
	 * Question 11: In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name theo ?????nh d???ng
	 * sau: Th??ng tin department th??? 1 l??: Id: 1 Name: Sale Th??ng tin department th???
	 * 2 l??: Id: 2 Name: Marketing
	 */
	public void question11() {

		Department[] depArray1 = { department1, department2, department3 };
		for (int i = 0; i < depArray1.length; i++) {
			System.out.println("Th??ng tin department th??? " + (i + 1) + " " + "l??:");
			System.out.println("Id: " + depArray1[i].getId());
			System.out.println("Name: " + depArray1[i].getName());
			System.out.println("-----------------------------");
		}
	}
	/*
	 * Question 12: Ch??? in ra th??ng tin 2 department ?????u ti??n theo ?????nh d???ng nh??
	 * Question 10
	 */

	public void question12() {

		Department[] depArray2 = { department1, department2, department3 };
		for (int i = 0; i < 2; i++) {
			System.out.println("Th??ng tin department th??? " + (i + 1) + " " + "l??:");
			System.out.println("Id: " + depArray2[i].getId());
			System.out.println("Name: " + depArray2[i].getName());
			System.out.println("-----------------------------");
		}
	}
	/*
	 * Question 13: In ra th??ng tin t???t c??? c??c account ngo???i tr??? account th??? 2
	 */

	public void question13() {
		Account[] accountArray = { account1, account2, account3, account4 };
		for (int i = 0; i < accountArray.length; i++) {
			if (i != 1) {
				System.out.println("Th??ng tin account th??? " + (i + 1) + " " + "l??:");
				System.out.println("Email l??: " + accountArray[i].getEmail());
				System.out.println("Full name l??: " + accountArray[i].getFullName());
				System.out.println("Ph??ng ban l??: " + accountArray[i].getDepartment().getName());
				System.out.println("-----------------------------");
			}
		}
	}

	/*
	 * Question 14: In ra th??ng tin t???t c??? c??c account c?? id < 4
	 */
	public void question14() {
		Account[] accountArray = { account1, account2, account3, account4 };
		for (int i = 0; i < accountArray.length; i++) {
			if (i < 4) {
				System.out.println("Th??ng tin account th??? " + (i + 1) + " " + "l??:");
				System.out.println("Email l??: " + accountArray[i].getEmail());
				System.out.println("Full name l??: " + accountArray[i].getFullName());
				System.out.println("Ph??ng ban l??: " + accountArray[i].getDepartment().getName());
				System.out.println("-----------------------------");
			}
		}
	}
	/*
	 * Question 15: In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20
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
	 * Question 16: L??m l???i c??c Question ??? ph???n FOR b???ng c??ch s??? d???ng WHILE k???t h???p
	 * v???i l???nh break, continue
	 */
	// Question 10
	public void question10b() {
		Account[] accountArray = { account1, account2, account3, account4 };
		int i = 0;
		while (i < accountArray.length) {
			System.out.println("Th??ng tin account th??? " + (i + 1) + " " + "l??:");
			System.out.println("Email l??: " + accountArray[i].getEmail());
			System.out.println("Full name l??: " + accountArray[i].getFullName());
			System.out.println("Ph??ng ban l??: " + accountArray[i].getDepartment().getName());
			System.out.println("-----------------------------");
			i++;
		}
	}

//Question 11
	public void question11b() {

		Department[] depArray1 = { department1, department2, department3 };
		int i = 0;
		while (i < depArray1.length) {
			System.out.println("Th??ng tin department th??? " + (i + 1) + " " + "l??:");
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
			System.out.println("Th??ng tin department th??? " + (i + 1) + " " + "l??:");
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
				System.out.println("Th??ng tin account th??? " + (i + 1) + " " + "l??:");
				System.out.println("Email l??: " + accountArray[i].getEmail());
				System.out.println("Full name l??: " + accountArray[i].getFullName());
				System.out.println("Ph??ng ban l??: " + accountArray[i].getDepartment().getName());
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
			if (i < 4) {
				System.out.println("Th??ng tin account th??? " + (i + 1) + " " + "l??:");
				System.out.println("Email l??: " + accountArray[i].getEmail());
				System.out.println("Full name l??: " + accountArray[i].getFullName());
				System.out.println("Ph??ng ban l??: " + accountArray[i].getDepartment().getName());
				System.out.println("-----------------------------");
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
	 * Question 17: L??m l???i c??c Question ??? ph???n FOR b???ng c??ch s??? d???ng DO-WHILE k???t
	 * h???p v???i l???nh break, continue
	 */
//Question 10
	public void question10c() {
		Account[] accountArray = { account1, account2, account3, account4 };
		int i = 0;
		do {
			System.out.println("Th??ng tin account th??? " + (i + 1) + " " + "l??:");
			System.out.println("Email l??: " + accountArray[i].getEmail());
			System.out.println("Full name l??: " + accountArray[i].getFullName());
			System.out.println("Ph??ng ban l??: " + accountArray[i].getDepartment().getName());
			System.out.println("-----------------------------");
			i++;
		} while (i < accountArray.length);
	}

//Question 11
	public void question11c() {

		Department[] depArray1 = { department1, department2, department3 };
		int i = 0;
		do {
			System.out.println("Th??ng tin department th??? " + (i + 1) + " " + "l??:");
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
			System.out.println("Th??ng tin department th??? " + (i + 1) + " " + "l??:");
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
				System.out.println("Th??ng tin account th??? " + (i + 1) + " " + "l??:");
				System.out.println("Email l??: " + accountArray[i].getEmail());
				System.out.println("Full name l??: " + accountArray[i].getFullName());
				System.out.println("Ph??ng ban l??: " + accountArray[i].getDepartment().getName());
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
				System.out.println("Th??ng tin account th??? " + (i + 1) + " " + "l??:");
				System.out.println("Email l??: " + accountArray[i].getEmail());
				System.out.println("Full name l??: " + accountArray[i].getFullName());
				System.out.println("Ph??ng ban l??: " + accountArray[i].getDepartment().getName());
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
	 * Question 1: Khai b??o 1 s??? nguy??n = 5 v?? s??? d???ng l???nh System out printf ????? in
	 * ra s??? nguy??n ????
	 */
	public void question1d() {
		int i = 5;
		System.out.printf("%d%n", i);
	}

	/*
	 * Question 2: Khai b??o 1 s??? nguy??n = 100 000 000 v?? s??? d???ng l???nh System out
	 * printf ????? in ra s??? nguy??n ???? th??nh ?????nh d???ng nh?? sau: 100,000,000
	 */
	public void question2d() {
		int i = 100000000;
		System.out.printf("%,d%n", i);
	}

	/*
	 * Question 3: Khai b??o 1 s??? th???c = 5,567098 v?? s??? d???ng l???nh System out printf
	 * ????? in ra s??? th???c ???? ch??? bao g???m 4 s??? ?????ng sau
	 */
	public void question3d() {
		float c = 5.567098f;
		System.out.printf("%5.4f%n", c);
	}

	/*
	 * Question 4: Khai b??o H??? v?? t??n c???a 1 h???c sinh v?? in ra h??? v?? t??n h???c sinh ????
	 * theo ?????nh d???ng nh?? sau: H??? v?? t??n: "Nguy???n V??n A" th?? s??? in ra tr??n console
	 * nh?? sau: T??n t??i l?? "Nguy???n V??n A" v?? t??i ??ang ?????c th??n.
	 */
	public void question4d() {
		String a = "Nguy???n V??n A";
		System.out.printf("T??n t??i l?? \"" + a + "\" v?? t??i ??ang ?????c th??n\n");
	}

	/*
	 * Question 5: L???y th???i gian b??y gi??? v?? in ra theo ?????nh d???ng sau: 24/04/2020
	 * 11h:16p:20s
	 */
	public void question5d() {
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
	}
}
