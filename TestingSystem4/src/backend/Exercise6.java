package backend;

import entity.VietnamesePhone;
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
}
