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
	public void Test3question1() {
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
	public void Test3question2() {
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
	public void Test3question4() {
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
	public void Test3question1c() {
		Integer salary = 5000;
		System.out.printf("%2.2f", (float) salary);
	}

	/*
	 * Question 2: Khai báo 1 String có value = "1234567" Hãy convert String đó ra
	 * số int
	 */
	public void Test3question2c() {
		String a = "1234567";
		int i = Integer.parseInt(a);
		System.out.println(i);
	}

	/*
	 * Question 3: Khởi tạo 1 số Integer có value là chữ "1234567" Sau đó convert số
	 * trên thành datatype int
	 */
	public void Test3question3c() {
		Integer i = 1234567;
		int j = i.intValue();
		System.out.println(j);
	}

	/* -----------Exercise 4: String------------------ */
	/*
	 * Question 1: Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các
	 * từ có thể cách nhau bằng nhiều khoảng trắng );
	 */

	public void Test3question1d() {
		System.out.println("Mời bạn nhập vào một chuỗi");
		String s = ScannerUtil.scanStr();
		// Phương thức split() tách chuỗi này theo biểu thức chính quy(regular
		// expression) và trả về mảng chuỗi.
		String[] words = s.split(" ");
		// Phương thức length() đếm.
		System.out.println("Số kí tự của chuỗi là: " + words.length);
	}

	/*
	 * Question 2: Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
	 */
	public void Test3question2d() {
		System.out.println("Mời bạn nhập vào chuỗi 1");
		String s1 = ScannerUtil.scanStr();
		System.out.println("Mời bạn nhập vào chuỗi 2");
		String s2 = ScannerUtil.scanStr();
		System.out.println("Kết quả sau khi nối chuỗi là: " + s1 + " " + s2);
	}

	/*
	 * Question 3: Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên
	 * chưa viết hoa chữ cái đầu thì viết hoa lên
	 */
	public void Test3question3d() {
		System.out.println("Mời bạn nhập vào Tên: ");
		String name = ScannerUtil.scanStr();
		// Phương thức toUpperCase() chuyển đối chuỗi thành dạng chữ hoa
		String firstCharacter = name.substring(0, 1).toUpperCase();
		String leftCharacter = name.substring(1);
		// System.out.println("char at:" + name.charAt(1));
		name = firstCharacter + leftCharacter;
		System.out.println(name);
	}

	/*
	 * Question 4: Viết chương trình để người dùng nhập vào tên và in từng ký tự
	 * trong tên của người dùng ra
	 */
	public void Test3question4d() {
		System.out.println("Mời bạn nhập vào Tên: ");
		String name = ScannerUtil.scanStr();
		name = name.toUpperCase();
		for (int i = 0; i < name.length(); i++) {
			System.out.println("Ký tự thứ " + i + " là: " + name.charAt(i));
		}
	}

	/*
	 * Question 5: Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
	 * dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
	 */
	public void Test3question5d() {
		System.out.println("Mời bạn nhập vào Họ: ");
		String firstName = ScannerUtil.scanStr();
		System.out.println("Mời bạn nhập vào Tên: ");
		String lastName = ScannerUtil.scanStr();
		System.out.println("Họ tên đầy đủ của bạn là: " + firstName.concat(lastName));
	}

	/*
	 * Question 6: Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
	 * sau đó hệ thống sẽ tách ra họ, tên , tên đệm
	 */
	public void Test3question6d() {
		String surName = "", middleName = "", firstName = "";
		System.out.println("Mời bạn nhập vào họ tên đầy đủ: ");
		String fullName = ScannerUtil.scanStr();
		// Phương thức trim() được sử dụng để xóa khoảng trẳng ở đầu và cuối của chuỗi.
		fullName = fullName.trim();
		String[] words = fullName.split(" ");
		surName = words[0];
		firstName = words[words.length - 1];
		for (int i = 1; i <= words.length - 2; i++) {
			middleName += words[i] + " ";
		}
		System.out.println("Họ của bạn là: " + surName);
		System.out.println("Tên đệm của bạn là: " + middleName);
		System.out.println("Tên của bạn là: " + firstName);
	}
	/*
	 * Question 7: Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
	 * chuẩn hóa họ và tên
	 */

	public void Test3question7d() {
		System.out.println("Mời bạn nhập vào họ tên đầy đủ: ");
		String fullName = ScannerUtil.scanStr();
		fullName = fullName.trim();
		// Phương thức replaceAll() trả về một chuỗi thay thế tất cả các chuỗi ký tự phù
		// hợp với regex.
		fullName = fullName.replaceAll("\\s+", " ");
		String[] words = fullName.split(" ");
		fullName = "";

		for (String word : words) {
			String firstCharacter = word.substring(0, 1).toUpperCase();
			String leftCharacter = word.substring(1);
			word = firstCharacter + leftCharacter;
			fullName += word + " ";
		}
		System.out.println("Họ tên sau khi chuẩn hóa của bạn là: " + fullName);
	}

	/*
	 * Question 8: In ra tất cả các group có chứa chữ "Java"
	 */
	// Phương thức contains() tìm kiếm chuỗi ký tự trong chuỗi này. Nó trả về true
	// nếu chuỗi các giá trị char được tìm thấy trong chuỗi này, nếu không trả về
	// false.
	public void Test3question8d() {
		String[] groupNames = { "Java Basic", "Java nâng cao", "Java ứng dụng trong công việc",
				"Ngôn ngữ Gia Va từ A-Z" };
		for (String groupName : groupNames) {
			if (groupName.contains("Java")) {
				System.out.println(groupName);
			}
		}
	}

	/*
	 * Question 9: In ra tất cả các group "Java"
	 */
	public void Test3question9d() {
		String[] groupNames = { "Java", "MySQL", "C++", "Pyton" };
		for (String groupName : groupNames) {
			if (groupName.equals("Java")) {
				System.out.println(groupName);
			}
		}
	}

	/*
	 * Question 10 (Optional): Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
	 * Nếu có xuất ra “OK” ngược lại “KO”. Ví dụ “word” và “drow” là 2 chuỗi đảo
	 * ngược nhau.
	 */
	public void Test3question10d() {
		// Reverse() trong StringBuilder đảo ngược chuỗi.
		String reverse = "";
		System.out.println("Mời bạn nhập vào chuỗi 1");
		String s1 = ScannerUtil.scanStr();
		System.out.println("Mời bạn nhập vào chuỗi 2");
		String s2 = ScannerUtil.scanStr();
		for (int i = s1.length() - 1; i >= 0; i--) {
			reverse += s1.substring(i, i + 1);
		}
		if (s2.equals(reverse)) {
			System.out.println("Đây là chuỗi đảo ngược !");
		} else {
			System.out.println("Đây không phải chuỗi đảo ngược");
		}
	}

	/*
	 * Question 11 (Optional): Count special Character Tìm số lần xuất hiện ký tự
	 * "a" trong chuỗi
	 */
	public void Test3question11d() {
		System.out.println("Mời bạn nhập vào 1 chuỗi ");
		String s = ScannerUtil.scanStr();
		int count = 0;
		// Phương thức charAt() trả về một ký tự tại một ví trí cụ thể.
		for (int i = 0; i < s.length(); i++) {
			if ('a' == s.charAt(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

	/*
	 * Question 12 (Optional): Reverse String Đảo ngược chuỗi sử dụng vòng lặp
	 */
	public void Test3question12d() {
		String reverse = "";
		System.out.println("Mời bạn nhập vào chuỗi");
		String s = ScannerUtil.scanStr();
		for (int i = s.length() - 1; i >= 0; i--) {
			reverse += s.charAt(i);
		}
		System.out.println(reverse);
	}
}