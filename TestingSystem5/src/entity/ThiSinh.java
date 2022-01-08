package entity;

public class ThiSinh extends KhoiThi {
	public ThiSinh(String name) {
		super(name);

	}

	public static int COUNT = 0;
	private int soBD;
	private String ten;
	private String diaChi;
	private int uuTien;
	private KhoiThi khoiThi;

	public int getSoBD() {
		return soBD;
	}

	public void setSoBD(int soBD) {
		this.soBD = soBD;
	}

//	@Override
//	public String toString() {
//		return "ThiSinh [Số báo danh =" + soBD + ", Tên thí sinh =" + ten + ", Địa chỉ =" + diaChi + ", Mức ưu tiên ="
//				+ uuTien + ", Thí sinh thi khối " + .getName() + "thi các môn: " + KhoiThi.getKhoi() + "]";
//	}

	public KhoiThi getKhoiThi() {
		return khoiThi;
	}

	public ThiSinh(String ten, String diaChi, int uuTien, KhoiThi khoiThi) {
		super(khoi);
		this.ten = ten;
		this.diaChi = diaChi;
		this.uuTien = uuTien;
		this.khoiThi = khoiThi;
	}

	@Override
	public String toString() {
		return "ThiSinh [soBD=" + soBD + ", ten=" + ten + ", diaChi=" + diaChi + ", uuTien=" + uuTien + ", khoiThi="
				+ khoiThi + ", Thí sinh thi khối()=" + getName() + "thi các môn:()=" + getKhoi() + "]";
	}

	public void setKhoiThi(KhoiThi khoiThi) {
		this.khoiThi = khoiThi;
	}

}
