package frontend;

import testingsystem.TestingSystem1;
import utils.ScannerUtil;

public class MainTest {
	public static void main(String[] args) {
		int input = 0;
		TestingSystem1 testSystem1 = new TestingSystem1();
		System.out.println("Bat dau chuong trinh: ");

		while (input != 100) {
			System.out.println("Nhap vao cau hoi : (100 = Thoat chuong trinh");
			input = ScannerUtil.scanInt();

			switch (input) {
			case 1:
				System.out.println("Cau tra loi 1.");
				testSystem1.question1();
				break;
			case 2:
				System.out.println("Cau tra loi 2.");
				testSystem1.question2();
				break;
			case 100:
				System.out.println("Thoat chuong trinh");
				break;
			}
			System.out.println("======================");
		}
	}
}
