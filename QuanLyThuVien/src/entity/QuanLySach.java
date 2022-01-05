package entity;

import java.time.LocalDate;
import java.util.ArrayList;

import utils.ScannerUtil;

public class QuanLySach {
	public static int ID = 0;
	private ArrayList<Document> documentList;

	public QuanLySach() {
		documentList = new ArrayList<>();
		int selected = 0;
		do {
			System.out.println("~~~~~~~~~~Mời bạn lựa chọn chức năng bạn muốn sử dụng~~~~~~~");
			System.out.println("1. Thêm mới tài liệu.");
			System.out.println("2. Xoá tài liệu theo mã tài liệu.");
			System.out.println("3. Hiện thị thông tin tài liệu.");
			System.out.println("4. Tìm kiếm tài liệu theo loại.");
			System.out.println("5. Thoát khỏi chương trình");

			selected = ScannerUtil.scanInt();
			switch (selected) {
			case 1: {
				addDocument();
				break;
			}
			case 2: {
				delDocument();
				break;
			}
			case 3: {
				printListDocument();
				break;
			}
			case 4: {
				findByCategory();
				break;
			}
			case 5: {
				System.out.println("~~~~~~~GoodBye~~~~~~");
				break;
			}
			default:
				System.out.println("Bạn đã chọn sai chức năng mời chọn lại");
			}

		} while (selected != 5);
	}

	private void findByCategory() {
		// TODO Auto-generated method stub
		System.out.println("Mời bạn nhập vào loại tài liệu bạn cần tìm kiếm 1.Sách, 2.Báo, 3.Tạp chí");
		int chooseCategory = ScannerUtil.scanInt();
		switch (chooseCategory) {
		case 1:
			for (Document document : documentList) {
				if (document instanceof Book) {
					System.out.println(document);
				}
			}
			break;
		case 2:
			for (Document document : documentList) {
				if (document instanceof Magazine) {
					System.out.println(document);
				}
			}
			break;
		case 3:
			for (Document document : documentList) {
				if (document instanceof Article) {
					System.out.println(document);
				}
			}
			break;
		default:
			System.out.println("Bạn đã chọn sai chức năng mời chọn lại!!");
			break;

		}
	}

	// Phương thức thêm tài liệu
	private void addDocument() {
		int selected = ScannerUtil.scanInt();
		do {
			System.out.println("~~~~~~Bạn muốn thêm mới tài liệu vui lòng chọn chức năng ~~~~~~");
			System.out.println("1- Thêm mới Sách");
			System.out.println("2- Thêm mới Báo ");
			System.out.println("3- Thêm mới Tạp chí");
			System.out.println("4- Thoát");
			selected = ScannerUtil.scanInt();
			switch (selected) {
			case 1: {
				System.out.println("~~~~~~~Thêm mới Sách~~~~~~");
				System.out.print("~~~~~~Mời bạn nhập vào tên nhà xuất bản ~~~~~");
				String nhaXuatBan = ScannerUtil.scanStr();
				System.out.print("~~~~~~Mời bạn nhập vào số bản phát hành ~~~~~");
				int soBanPhatHanh = ScannerUtil.scanInt();
				System.out.println("~~~~~~Mời bạn nhập vào tên tác giả ~~~~~");
				String tenTacGia = ScannerUtil.scanStr();
				System.out.print("~~~~~~Mời bạn nhập vào số trang ~~~~~");
				int soTrang = ScannerUtil.scanInt();
				ID++;
				Document d = new Book(ID, nhaXuatBan, soBanPhatHanh, tenTacGia, soTrang);
				documentList.add(d);
				break;
			}
			case 2: {
				System.out.println("~~~~~~~Thêm mới Báo~~~~~~");
				System.out.print("~~~~~~Mời bạn nhập vào tên nhà xuất bản ~~~~~");
				String nhaXuatBan = ScannerUtil.scanStr();
				System.out.print("~~~~~~Mời bạn nhập vào số bản phát hành ~~~~~");
				int soBanPhatHanh = ScannerUtil.scanInt();
				System.out.println("~~~~~~Mời bạn nhập vào ngày phát hành ~~~~~");
				int day = ScannerUtil.scanInt();
				System.out.println("~~~~~~Mời bạn nhập vào tháng phát hành ~~~~~");
				int month = ScannerUtil.scanInt();
				System.out.println("~~~~~~Mời bạn nhập vào năm phát hành ~~~~~");
				int year = ScannerUtil.scanInt();
				LocalDate ngayPhatHanh = LocalDate.of(year, month, day);
				ID++;
				Document d = new Article(ID, nhaXuatBan, soBanPhatHanh, ngayPhatHanh);
				documentList.add(d);
				break;
			}
			case 3: {
				System.out.println("~~~~~~~Thêm mới Tạp chí~~~~~~");
				System.out.print("~~~~~~Mời bạn nhập vào tên nhà xuất bản ~~~~~");
				String nhaXuatBan = ScannerUtil.scanStr();
				System.out.print("~~~~~~Mời bạn nhập vào số bản phát hành ~~~~~");
				int soBanPhatHanh = ScannerUtil.scanInt();
				System.out.println("~~~~~~Mời bạn nhập vào số phát hành~~~~~");
				int soPhatHanh = ScannerUtil.scanInt();
				System.out.println("~~~~~~Mời bạn nhập vào ngày phát hành ~~~~~");
				int day1 = ScannerUtil.scanInt();
				System.out.println("~~~~~~Mời bạn nhập vào tháng phát hành ~~~~~");
				int month1 = ScannerUtil.scanInt();
				System.out.println("~~~~~~Mời bạn nhập vào năm phát hành ~~~~~");
				int year1 = ScannerUtil.scanInt();
				LocalDate thangPhatHanh = LocalDate.of(year1, month1, day1);
				ID++;

				Document d = new Magazine(ID, nhaXuatBan, soBanPhatHanh, soBanPhatHanh, thangPhatHanh);
				documentList.add(d);
				break;
			}
			case 4: {
				break;
			}
			default:
				System.out.println("Bạn đã chọn sai chức năng mời chọn lại");
			}
		} while (selected != 4);
	}

	private void printListDocument() {
		for (Document document : documentList) {
			System.out.println(document);
		}
	}

	private void delDocument() {
		System.out.println("Mời bạn nhập vào mã tài liệu muốn xóa: ");
		int idDel = ScannerUtil.scanInt();
		Boolean flagCheckExists = false;
		for (Document document : documentList) {
			if (document.getId() == idDel) {
				flagCheckExists = true;
			}
		}
		if (flagCheckExists) {
			documentList.removeIf(document -> document.getId() == idDel);
			for (Document document : documentList) {
				System.out.println("Xóa tài liệu thành công, danh sách tài liệu còn lại là :");
				System.out.println(document);
			}
		} else {
			System.out.println("Mã tài liệu bạn nhập không có trên hệ thống xin mời bạn nhập lại");
		}
	}
}
