package testingsystem;

import utils.ScannerUtil;

public class TestingSystem3 {
	private int b;

	/*
	 * Exercise 1 (Optional): Datatype Casting Question 1: Khai báo 2 số lương có
	 * kiểu dữ liệu là float. Khởi tạo Lương của Account 1 là 5240.5 $ Khởi tạo
	 * Lương của Account 2 là 10970.055$ Khai báo 1 số int để làm tròn Lương của
	 * Account 1 và in số int đó ra Khai báo 1 số int để làm tròn Lương của Account
	 * 2 và in số int đó ra
	 */
	public void question1() {
		float Salary1;
		float Salary2;
		Salary1 = (float) 5240.5;
		Salary2 = (float) 10970.055;
		System.out.println("Salary1: " + Salary1 + "|| Salary2: " + Salary2);
		int roundSalary1 = (int) Salary1;
		int roundSalary2 = (int) Salary2;
		System.out.println("roundSalary1: " + roundSalary1 + " || roundSalary2: " + roundSalary2);
	}

	/*
	 * Question 2: Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ
	 * thêm có số 0 ở đầu cho đủ 5 chữ số)
	 */
	public void question2() {
		int min = 0;
		int max = 99999;
		int a = (int) (Math.random() * max) + min;
		while (a < 10000) {
			a = a * 10;
		}
		System.out.println("Số ngẫu nhiên: " + a);
	}

	/*
	 * Question 4: Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của
	 * chúng
	 */
	public void question4() {
		System.out.println("Mời bạn nhập vào a = ");
		int a = ScannerUtil.scanInt();
		do {
			System.out.println("Mời bạn nhập vào b = ");
			int b = ScannerUtil.scanInt();
			if (b == 0) {
				System.out.println("Vui lòng nhập b khác 0 !");
			}
		} while (b == 0);
		System.out.println("Thương của a/b: " + (float) a / (float) b);
	}

	/*--------------Exercise 3(Optional): Boxing & Unboxing--------------------*/
	/*
	 * Question 1: Khởi tạo lương có datatype là Integer có giá trị bằng 5000. Sau
	 * đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2
	 * số sau dấu thập phân)
	 */
	public void question1c() {
		Integer salary = 5000;
		System.out.printf("%2.2f", (float) salary);
	}

	/*
	 * Question 2: Khai báo 1 String có value = "1234567" Hãy convert String đó ra
	 * số int
	 */
	public void question2c() {
		String a = "1234567";
		int i = Integer.parseInt(a);
		System.out.println(i);
	}

	/*
	 * Question 3: Khởi tạo 1 số Integer có value là chữ "1234567" Sau đó convert số
	 * trên thành datatype int
	 */
	public void question3c() {
		Integer i = 1234567;
		int j = i.intValue();
		System.out.println(j);
	}
}
