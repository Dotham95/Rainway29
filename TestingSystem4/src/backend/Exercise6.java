package backend;

import entity.Employee;
import entity.Manager;
import entity.VietnamesePhone;
import entity.Waiter;
import utils.ScannerUtil;

public class Exercise6 {
	public void question1() {
		loadmenuAbstract();
	}

	private void loadmenuAbstract() {
		VietnamesePhone vnPhone = new VietnamesePhone();
		while (true) {
			System.out.println("~~~~~~~~~~ Mời bạn lựa chọn chức năng bạn muốn sử dụng ~~~~~~~");
			System.out.println("1. InsertContact");
			System.out.println("2. RemoveContact");
			System.out.println("3. UpdateContact");
			System.out.println("4. SearchContact");
			System.out.println("5. ShowContact");
			System.out.println("6. Thoát khỏi chương trình");
			int selected = ScannerUtil.scanInt();
			switch (selected) {
			case 1:
				System.out.println("Mời bạn nhập vào tên Contact");
				String name = ScannerUtil.scanStr();
				System.out.println("Mời bạn nhập vào tên số Phone");
				String phone = ScannerUtil.scanStr();
				vnPhone.insertContact(name, phone);
				break;
			case 2:
				System.out.println("Nhập vào tên Contact cần remove");
				String removeName = ScannerUtil.scanStr();
				vnPhone.removeContact(removeName);
				break;
			case 3:
				System.out.println("Nhập tên cần Update: ");
				String name1 = ScannerUtil.scanStr();
				System.out.println("Nhập số Phone mới: ");
				String newPhone = ScannerUtil.scanStr();
				vnPhone.updateContact(name1, newPhone);
				System.out.println("Kết quả là: ");
				vnPhone.searchContact(name1);
				break;
			case 4:
				System.out.println("Nhập vào tên Contact cần tìm kiếm: ");
				String searchName = ScannerUtil.scanStr();
				vnPhone.searchContact(searchName);
				break;
			case 5:
				vnPhone.printContact();
				break;
			case 6:
				return;
			default:
				System.out.println("Bạn đã chọn sai chức năng mời chọn lại!!");
				break;
			}
		}
	}

	public void question2() {
		while (true) {
			System.out.println("~~~~~~~~~~ Mời bạn lựa chọn chức năng bạn muốn sử dụng ~~~~~~~");
			System.out.println("1. Thêm Employee");
			System.out.println("2. Thêm Manager");
			System.out.println("3. Thêm Waiter");
			System.out.println("4. Thoát khỏi chương trình");
			int selected = ScannerUtil.scanInt();
			switch (selected) {
			case 1:
				System.out.println("Mời bạn nhập vào tên Employee");
				String employeeName = ScannerUtil.scanStr();
				System.out.println("Mời bạn nhập vào SalaryRatio");
				Double employeeSalaryRatio = (double) ScannerUtil.scanInt();
				Employee employee = new Employee(employeeName, employeeSalaryRatio);
				employee.displayInfor();
				break;
			case 2:
				System.out.println("Mời bạn nhập vào tên Manager");
				String managerName = ScannerUtil.scanStr();
				System.out.println("Mời bạn nhập vào SalaryRatio");
				Double managerSaralaryRatio = (double) ScannerUtil.scanInt();
				Manager manager = new Manager(managerName, managerSaralaryRatio);
				manager.displayInfor();
				break;
			case 3:
				System.out.println("Mời bạn nhập vào tên Waiter");
				String waiterName = ScannerUtil.scanStr();
				System.out.println("Mời bạn nhập vào SalaryRatio");
				Double waiterSalaryRatio = (double) ScannerUtil.scanInt();
				Waiter waiter = new Waiter(waiterName, waiterSalaryRatio);
				waiter.displayInfor();
				break;
			case 4:
				return;
			default:
				System.out.println("Bạn đã chọn sai chức năng mời chọn lại!!");
				break;
			}
		}
	}
}