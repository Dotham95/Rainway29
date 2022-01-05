package TestingSystem;

import java.util.ArrayList;
import java.util.Scanner;

import entity.NhanVien;

public class TestingSystem4 {
	private ArrayList<NhanVien> nhanVienList;
	private Scanner sc;

	public TestingSystem4() {
		nhanVienList = new ArrayList<NhanVien>();
		sc = new Scanner(System.in);
	}

	public void question1() {
	}

	public void question2() {
		menu();
	}

	public void menu() 
	{
		while (true) {
			System.out.println("~~~~~~~~~~Lựa chọn chức năng bạn muốn sử dụng~~~~~~~");
		System.out.println("1. Thêm mới cán bộ");
		System.out.println("2. Tìm kiếm theo họ tên");
		System.out.println("3. Hiện thị thông tin về danh sách các cán bộ");
		System.out.println("4. Nhập vào tên của cán bộ và delete cán bộ đó");
		System.out.println("5. Thoát khỏi chương trình");
		int menuChoose = sc.nextInt(); switch (menuChoose) {
		case 1:
			addStaff(); 
			break;
		case 2: 
			findByName();
		break; 
		case 3:
		     printListStaff();
		break; 
		case 4:
			deleteByName();
		break; 
		case 5:
		return;
		default:
		System.out.println("Lựa chọn đúng số trên menu"); break;
		}
	}
}

	private void deleteByName() {
		
		
	}

	private void printListStaff() {
		
		
	}

	private void findByName() {
		// TODO Auto-generated method stub
		
	}

	private void addStaff() {
		// TODO Auto-generated method stub
		
	}
}
