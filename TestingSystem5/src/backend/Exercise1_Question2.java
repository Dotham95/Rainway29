package backend;

import entity.TuyenSinh;
import utils.ScannerUtil;

public class Exercise1_Question2 {
	TuyenSinh tuyenSinh = new TuyenSinh();

	public void question2() {
		loadMenu();
	}

	private void loadMenu() {
		while (true) {
			System.out.println("~~~~~~~~~~ Mời bạn lựa chọn chức năng bạn muốn sử dụng ~~~~~~~");
			System.out.println("1. Thêm mới thí sinh");
			System.out.println("2. Hiện thị thông tin của thí sinh");
			System.out.println("3. Tìm kiếm theo số báo danh.");
			System.out.println("4. Thoát khỏi chương trình");
			int selected = ScannerUtil.scanInt();
			switch (selected) {
			case 1:
				tuyenSinh.addNew();
				break;
			case 2:
				tuyenSinh.showInfo();
				break;
			case 3:
				System.out.println("Nhập vào ID cần tìm kiếm: ");
				int id = ScannerUtil.scanInt();
				tuyenSinh.findById(id);
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