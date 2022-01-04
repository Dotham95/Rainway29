package frontend;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;
import entity.PositionName;
import utils.ScannerUtil;

public class Exercise5Test2 {
	/*
	 * Question 1: Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
	 */
	public void question1a() {
		System.out.println("Mời bạn nhập vào 3 số nguyên");
		int a, b, c;
		System.out.println("Nhập vào số a");
		a = ScannerUtil.scanInt();
		System.out.println("Nhập vào số b");
		b = ScannerUtil.scanInt();
		System.out.println("Nhập vào số c");
		c = ScannerUtil.scanInt();
		System.out.println("Bạn vừa nhập vào các số: " + a + " " + b + " " + c);
	}

	public void question1b() {
		int[] numbers;
		System.out.println("Nhập vào số lượng phần tử của ");
		int n = ScannerUtil.scanInt();

		numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("Nhập vào số thứ %d => numbers[%d] = ", i + 1, i);
			numbers[i] = ScannerUtil.scanInt();
		}
		System.out.println("---------Mang vua nhap----------");
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("numbers[%d] = %d\n", i, numbers[i]);
		}
	}

	/* Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình */
	public void question2() {
		System.out.println("Mời bạn nhập vào 2 số thực");
		float a, b;
		System.out.println("Nhập vào số a");
		a = ScannerUtil.scanFloat();
		System.out.println("Nhập vào số b");
		b = ScannerUtil.scanFloat();
		System.out.println("Bạn vừa nhập vào các số: " + a + " " + b);
	}

	/* Question 4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ */
	public void question4() {
		int year, month, day;
		System.out.println("Mời bạn nhập vào năm sinh: ");
		year = ScannerUtil.scanInt();
		System.out.println("Mời bạn nhập vào tháng sinh: ");
		month = ScannerUtil.scanInt();
		System.out.println("Mời bạn nhập vào ngày sinh: ");
		day = ScannerUtil.scanInt();
		LocalDate dateBirth = LocalDate.of(year, month, day);
		System.out.println("Ngày sinh nhật của bạn là: " + dateBirth);
	}

	/*
	 * Question 5: Viết lệnh cho phép người dùng tạo account (viết thành method) Đối
	 * với property Position, Người dùng nhập vào 1 2 3 4 5 và vào chương trình sẽ
	 * chuyển thành Position.Dev, Position.Test, Position.ScrumMaster, Position.PM
	 */
	public void question5() {
		System.out.println("Mời bạn nhập vào thông tin account cần tạo");
		Account account = new Account();
		System.out.println("Mời bạn nhập ID: ");
		account.id = ScannerUtil.scanInt();
		System.out.println("Mời bạn nhập email: ");
		account.email = ScannerUtil.scanStr();
		System.out.println("Mời bạn nhập userName: ");
		account.userName = ScannerUtil.scanStr();
		System.out.println("Mời bạn nhập fullName: ");
		account.fullName = ScannerUtil.scanStr();
		System.out.println(
				"Mời bạn nhập Position (Nhập các số từ 1 đến 4 tương ứng với: 1.Dev, 2.Test, 3.Scrum_Master, 4.PM): ");
		int posName = ScannerUtil.scanInt();
		switch (posName) {
		case 1:
			Position position1 = new Position(1, PositionName.DEV);
			account.position = position1;
			break;
		case 2:
			Position position2 = new Position(2, PositionName.TEST);
			account.position = position2;
			break;
		case 3:
			Position position3 = new Position(3, PositionName.SCRUM_MASTER);
			account.position = position3;
			break;
		case 4:
			Position position4 = new Position(4, PositionName.PM);
			account.position = position4;
			break;
		}
		System.out.println("Thông tin Account vừa nhập");
		System.out.println("ID là: " + account.id);
		System.out.println("Email là: " + account.email);
		System.out.println("UserName là: " + account.userName);
		System.out.println("FullName là: " + account.fullName);
		System.out.println("Position là: " + account.position.name);
	}

	/*
	 * Question 6: Viết lệnh cho phép người dùng tạo department (viết thành method)
	 */
	public void question6() {
		System.out.println("Mời bạn nhập vào thông tin department cần tạo");
		Department department = new Department();
		System.out.println("Mời bạn nhập ID: ");
		department.id = ScannerUtil.scanInt();
		System.out.println("Mời bạn nhập DepartmentName: ");
		department.name = ScannerUtil.scanStr();
		System.out.println("Thông tin department vừa nhập");
		System.out.println("ID là: " + department.id);
		System.out.println("DepartmentName: " + department.name);
	}

	/* Question 7: Nhập số chẵn từ console */
	public void question7() {
		while (true) {
			System.out.println("Mời bạn nhập vào 1 số chẵn: ");
			int a = ScannerUtil.scanInt();
			if (a % 2 == 0) {
				System.out.println("Bạn vừa nhập vào số:" + a);
				return;
			} else {
				System.out.println("Bạn đã nhập sai, đây không phải là số chẵn");
			}
		}
	}

	/*
	 * Question 8: Viết chương trình thực hiện theo flow sau: Bước 1: Chương trình
	 * in ra text "mời bạn nhập vào chức năng muốn sử dụng" Bước 2: Nếu người dùng
	 * nhập vào 1 thì sẽ thực hiện tạo account Nếu người dùng nhập vào 2 thì sẽ thực
	 * hiện chức năng tạo department Nếu người dùng nhập vào số khác thì in ra text
	 * "Mời bạn nhập lại" và quay trở lại bước 1
	 */
	public void question8() {
		int choose;
		while (true) {
			System.out.println("Mời bạn chọn chức năng: 1. Tạo Account, 2. Tạo Department");
			choose = ScannerUtil.scanInt();
			if (choose == 1 || choose == 2) {
				switch (choose) {
				case 1:
					question5();
					break;
				case 2:
					question6();
					break;
				}
				return;
			} else {
				System.out.println("Mời bạn nhập lại: ");
			}
		}
	}

	/*
	 * Question 9: Viết method cho phép người dùng thêm group vào account theo flow
	 * sau: Bước 1: In ra tên các usernames của user cho người dùng xem Bước 2: Yêu
	 * cầu người dùng nhập vào username của account Bước 3: In ra tên các group cho
	 * người dùng xem Bước 4: Yêu cầu người dùng nhập vào tên của group Bước 5: Dựa
	 * vào username và tên của group người dùng vừa chọn, hãy thêm account vào group
	 * đó .
	 */
	public void question9() {
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing_System";
		group1.createDate = Date(2021, 12, 14);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		group2.createDate = Date(2021, 12, 24);

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Sale";
		group3.createDate = Date(2021, 10, 05);

		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "chi90@gmail.com";
		acc1.userName = "Thuychi";
		acc1.fullName = "Nguyen thuy Chi";
		acc1.createDate = Date(2021, 11, 10);

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "ngoclan@gmail.com";
		acc2.userName = "Lanngoc";
		acc2.fullName = "Ninh Duong Lan Ngoc";
		acc2.createDate = Date(2021, 03, 17);

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "tranxin@gmail.com";
		acc3.userName = "tranthanh";
		acc3.fullName = "Huynh Tran Thanh";
		acc3.createDate = Date(2021, 10, 19);

		Account[] accArray = { acc1, acc2, acc3 };
		Group[] groupArray = { group1, group2, group3 };
		System.out.println("Danh sách User đang có trên hệ thống: ");

		for (Account account : accArray) {
			System.out.println(account.userName);
		}
		System.out.println("Mời bạn nhập vào UserName của account: ");
		String userName = ScannerUtil.scanStr();
		// lay ra account co ten trung voi ten vua nhap
		Account accountSelected = null;
		for (Account account : accArray) {
			if (userName.equals(account.getUserName())) {
				accountSelected = account;
				break;
			}
		}
		System.out.println("Danh sách Group đang có trên hệ thống: ");
		for (int i1 = 0; i1 < groupArray.length; i1++) {
			System.out.println(groupArray[i1].name);
		}
		System.out.println("Mời bạn nhập vào tên Group: ");
		String groupName = ScannerUtil.scanStr();
		//
		Group groupSelected = null;
		for (Group group : groupArray) {
			if (groupName.equals(group.getName())) {
				groupSelected = group;
				break;
			}
		}
		groupSelected.setAccounts(new Account[] { accountSelected });
		System.out.println("-----Ket qua la-------");
		System.out.println(groupSelected);
	}

	private Date Date(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Question 10:
	 * 
	 * Tiếp tục Question 8 và Question 9 Bổ sung thêm vào bước 2 của Question 8 như
	 * sau: Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào
	 * account Bổ sung thêm Bước 3 của Question 8 như sau: Sau khi người dùng thực
	 * hiện xong chức năng ở bước 2 thì in ra dòng text để hỏi người
	 * dùng"Bạn có muốn thực hiện chức năng khác không?". Nếu người dùng chọn"Có"
	 * thì quay lại bước 1, nếu người dùng chọn"Không" thì kết thúc chương trình (sử
	 * dụng lệnh return để kết thúc chương trình)
	 */
	public void question10() {
		int choose;
		while (true) {
			System.out.println("Mời bạn chọn chức năng: 1. Tạo Account, 2. Tạo Department, 3. Add Group vào Account");
			choose = ScannerUtil.scanInt();
			switch (choose) {
			case 1:
				question5();
				break;
			case 2:
				question6();
				break;
			case 3:
				question9();
				break;
			case 0:
				System.out.println("Good Bye, See you again!!!");
				return;
			default:
				System.out.print("Xin mời bạn nhập lại, ");
				System.out.println("Hoặc chọn 0 để thoát chương trình!!!!");
			}
		}
	}

	/*
	 * Question 11: Tiếp tục Question 10 Bổ sung thêm vào bước 2 của Question 8 như
	 * sau: Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account vào 1
	 * nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau: Bước 1: In ra tên các
	 * usernames của user cho người dùng xem 6 Bước 2: Yêu cầu người dùng nhập vào
	 * username của account Bước 3: Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
	 * Bước 4: Thêm account vào group chương trình vừa chọn ngẫu nhiên
	 */
	public void question11() {
		int choose;
		while (true) {
			System.out.println(
					"Mời bạn chọn chức năng: 1. Tạo Account, 2. Tạo Department, 3. Add Group vào Account, 4.Thêm Account vào 1 nhóm ngẫu nhiên");
			choose = ScannerUtil.scanInt();
			switch (choose) {
			case 1:
				question5();
				break;
			case 2:
				question6();
				break;
			case 3:
				question9();
				break;
			case 4:
				addAccountToGroup();
				break;
			case 0:
				System.out.println("Good Bye, See you again!!!");
				return;
			default:
				System.out.print("Xin mời bạn nhập lại, ");
				System.out.println("Hoặc chọn 0 để thoát chương trình!!!!");
			}
		}
	}

	private void addAccountToGroup() {
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing_System";
		group1.createDate = Date(2021, 12, 14);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		group2.createDate = Date(2021, 12, 24);

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Sale";
		group3.createDate = Date(2021, 10, 05);

		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "chi90@gmail.com";
		acc1.userName = "Thuychi";
		acc1.fullName = "Nguyen thuy Chi";
		acc1.createDate = Date(2021, 11, 10);

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "ngoclan@gmail.com";
		acc2.userName = "Lanngoc";
		acc2.fullName = "Ninh Duong Lan Ngoc";
		acc2.createDate = Date(2021, 03, 17);

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "tranxin@gmail.com";
		acc3.userName = "tranthanh";
		acc3.fullName = "Huynh Tran Thanh";
		acc3.createDate = Date(2021, 10, 19);

		Account[] accArray = { acc1, acc2, acc3 };
		Group[] groupArray = { group1, group2, group3 };

		System.out.println("Danh sách User đang có trên hệ thống: ");

		for (Account account : accArray) {
			System.out.println(account.userName);
		}
		System.out.println("Mời bạn nhập vào UserName của account: ");
		String userName = ScannerUtil.scanStr();

		for (Account account : accArray) {
			if (userName.equals(account.getUserName())) {
				break;
			}
		}
		System.out.println("Danh sách Group đang có trên hệ thống: ");
		for (int i1 = 0; i1 < groupArray.length; i1++) {
			System.out.println(groupArray[i1].name);
		}
		Random random = new Random();
		int indexGroup = random.nextInt(2);
		int indexAccount = -1;
		for (int j = 0; j < accArray.length; j++) {
			if (accArray[j].userName.equals(userName)) {
				indexAccount = j;
			}
		}
		if (indexAccount < 0) {
			System.out.println("Kiểm tra lại thông tin bạn nhập, không có Account này trên hệ thống");
		} else {
			for (int j = 0; j < accArray.length; j++) {
				if (accArray[j].userName.equals(userName)) {
					Group[] gpAdd = { groupArray[indexGroup] };
					accArray[j].groups = gpAdd;
					System.out.println("Bạn vừa Add group: " + accArray[indexAccount].groups[0].name + " cho Account: "
							+ accArray[indexAccount].userName);
				}
			}
		}
	}
}