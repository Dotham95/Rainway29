package entity;

import java.util.ArrayList;

import entity.CanBo.gioiTinh;
import utils.ScannerUtil;

public class QLCB {
	private ArrayList<CanBo> mangCanBo;

	public QLCB() {
		mangCanBo = new ArrayList<>();
		int selected = 0;
		do {
			System.out.println("~~~~~~~~~~Mời bạn lựa chọn chức năng bạn muốn sử dụng~~~~~~~");
			System.out.println("1. Thêm mới cán bộ");
			System.out.println("2. Tìm kiếm theo họ tên");
			System.out.println("3. Hiện thị thông tin về danh sách các cán bộ");
			System.out.println("4. Nhập vào tên của cán bộ và delete cán bộ đó");
			System.out.println("5. Thoát khỏi chương trình");

			selected = ScannerUtil.scanInt();
			switch (selected) {
			case 1: {
				addCanBo();
				break;
			}
			case 2: {
				findByName();
				break;
			}
			case 3: {
				printMangCanBo();
				break;
			}
			case 4: {
				deleteByName();
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

	private void deleteByName() {
		System.out.println("Nhập tên cần xóa thông tin: ");
		String delName = ScannerUtil.scanStr();
		mangCanBo.removeIf(canBo -> canBo.getHoTen().equals(delName));
		printMangCanBo();
	}

	private void findByName() {
		System.out.println("Nhập vào tên muốn tìm kiếm: ");
		String findName = ScannerUtil.scanStr();
		for (CanBo canBo : mangCanBo) {
			if (canBo.getHoTen().equals(findName)) {
				System.out.println(canBo);
			}
		}
	}

// Phương thức in danh sách cán bộ
	private void printMangCanBo() {
		System.out.println("Danh sách Cán bộ");

		System.out.println("~~~~~~~~~~~~~~~~~~~Công nhân:~~~~~~~~~~~~~~~~~~~");

		System.out.printf("%20s |%5s | %5s| %5s| %3s \n ", "Họ và tên", "Tuổi", "Giới tính", "Địa chỉ", "Bậc");
		for (CanBo canBo : mangCanBo) {
			if (canBo instanceof CongNhan) {
				CongNhan cNhan = (CongNhan) canBo;
				System.out.printf("%19s | %4d | %8s | %6s | %3d  \n", cNhan.getHoTen(), cNhan.getTuoi(),
						cNhan.getGioiTinh(), cNhan.getDiaChi(), cNhan.getBac());
			}
		}

		System.out.println("~~~~~~~~~~~~~~~~~~~~Kỹ sư:~~~~~~~~~~~~~~~~~~~~~~~");

		System.out.printf("%20s |%5s | %5s| %5s| %5s  \n", "Họ và tên", "Tuổi", "Giới tính", "Địa chỉ",
				"Ngành đào tạo ");
		for (CanBo canBo : mangCanBo) {
			if (canBo instanceof KySu) {
				KySu kySu = (KySu) canBo;
				System.out.printf("%19s | %4d | %8s | %6s | %3s  \n", kySu.getHoTen(), kySu.getTuoi(),
						kySu.getGioiTinh(), kySu.getDiaChi(), kySu.getNganhDaoTao());
			}
		}

		System.out.println("~~~~~~~~~~~~~~~~~~~Nhân Viên:~~~~~~~~~~~~~~~~~~~~~~");

		System.out.printf(" %20s | %5s | %5s| %5s| %5s \n", "Họ và tên", "Tuổi", "Giới tính", "Địa chỉ", "Công việc");
		for (CanBo canBo : mangCanBo) {
			if (canBo instanceof NhanVien) {
				NhanVien nhanVien = (NhanVien) canBo;
				System.out.printf(" %19s | %4d | %8s | %6s | %3s  \n", nhanVien.getHoTen(), nhanVien.getTuoi(),
						nhanVien.getGioiTinh(), nhanVien.getDiaChi(), nhanVien.getCongViec());
			}
		}
	}

// Phương thức thêm cán bộ

	private void addCanBo() {
		int selected = ScannerUtil.scanInt();
		do {
			System.out.println("~~~~~~Bạn muốn thêm mới cán bộ vui lòng chọn chức năng ~~~~~~");
			System.out.println("1- Thêm mới công nhân");
			System.out.println("2- Thêm mới kỹ sư ");
			System.out.println("3- Thêm mới nhân viên");
			System.out.println("4- Thoát");
			selected = ScannerUtil.scanInt();

			switch (selected) {
			case 1: {
				System.out.println("~~~~~~~Thêm mới công nhân~~~~~~");
				System.out.print("~~~~~~Mời bạn nhập vào tên công nhân ~~~~~");
				String hoTen = ScannerUtil.scanStr();
				System.out.print("~~~~~~Mời bạn nhập vào tuổi công nhân ~~~~~");
				int tuoi = ScannerUtil.scanInt();
				System.out.println("~~~~~~Mời bạn nhập vào giới tính: 1.Male, 2.Female, 3.Unknown: ~~~~~");
				int gioitinhCN = ScannerUtil.scanInt();
				gioiTinh gender = null;
				switch (gioitinhCN) {
				case 1:
					gender = gioiTinh.MALE;
					break;
				case 2:
					gender = gioiTinh.FEMALE;
					break;
				case 3:
					gender = gioiTinh.UNKNOWN;
					break;
				}
				System.out.print("~~~~~~Mời bạn nhập vào địa chỉ của công nhân ~~~~~");
				String diaChi = ScannerUtil.scanStr();
				System.out.print("~~~~~~Mời bạn nhập vào bậc của công nhân 1->10~~~~~");
				int bac = ScannerUtil.scanInt();

				// Tạo ra đối tượng công nhân
				CanBo c = new CongNhan(hoTen, tuoi, gender, diaChi, bac);

				// them can bo vao mang
				mangCanBo.add(c);

				break;
			}
			case 2: {
				System.out.println("~~~~~~~Thêm mới kỹ sư~~~~~~");
				System.out.print("~~~~~~Mời bạn nhập vào tên kỹ sư~~~~~");
				String hoTen = ScannerUtil.scanStr();
				System.out.print("~~~~~~Mời bạn nhập vào tuổi kỹ sư~~~~~");
				int tuoi = ScannerUtil.scanInt();
				System.out.println("~~~~~~Mời bạn nhập vào giới tính: 1.Male, 2.Female, 3.Unknown: ~~~~~");
				int gioitinhKS = ScannerUtil.scanInt();
				gioiTinh gender = null;
				switch (gioitinhKS) {
				case 1:
					gender = gioiTinh.MALE;
					break;
				case 2:
					gender = gioiTinh.FEMALE;
					break;
				case 3:
					gender = gioiTinh.UNKNOWN;
					break;
				}
				System.out.print("~~~~~~Mời bạn nhập vào địa chỉ của kỹ sư ~~~~~");
				String diaChi = ScannerUtil.scanStr();
				System.out.print("~~~~~~Mời bạn nhập vào ngành đào tạo~~~~~");
				String nganhDaoTao = ScannerUtil.scanStr();

				// Tao ra doi tuong ky su
				CanBo c = new KySu(hoTen, tuoi, gender, diaChi, nganhDaoTao);

				// them can bo vao mang
				mangCanBo.add(c);

				break;
			}
			case 3: {
				System.out.println("~~~~~~~Thêm mới nhân viên~~~~~~");
				System.out.print("~~~~~~Mời bạn nhập vào tên nhân viên~~~~~");
				String hoTen = ScannerUtil.scanStr();
				System.out.print("~~~~~~Mời bạn nhập vào tuổi nhân viên~~~~~");
				int tuoi = ScannerUtil.scanInt();
				System.out.println("~~~~~~Mời bạn nhập vào giới tính: 1.Male, 2.Female, 3.Unknown: ~~~~~");
				int gioitinhNV = ScannerUtil.scanInt();
				gioiTinh gender = null;
				switch (gioitinhNV) {
				case 1:
					gender = gioiTinh.MALE;
					break;
				case 2:
					gender = gioiTinh.FEMALE;
					break;
				case 3:
					gender = gioiTinh.UNKNOWN;
					break;
				}
				System.out.print("~~~~~~Mời bạn nhập vào địa chỉ của nhân viên ~~~~~");
				String diaChi = ScannerUtil.scanStr();
				System.out.print("~~~~~~Mời bạn nhập vào công việc của nhân viên~~~~~");
				String congViec = ScannerUtil.scanStr();

				// Tao ra doi tuong nhan vien
				CanBo c = new NhanVien(hoTen, tuoi, gender, diaChi, congViec);

				// them can bo vao mang
				mangCanBo.add(c);
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
}
