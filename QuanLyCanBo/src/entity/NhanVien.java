package entity;

public class NhanVien extends CanBo {
	private String congViec;

	public NhanVien() {
		super();
	}

	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}

	public NhanVien(String hoTen, int tuoi) {
		super(hoTen, tuoi);

	}

	public NhanVien(String hoTen, int tuoi, gioiTinh gioiTinh, String diaChi, String congViec) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.congViec = congViec;
	}

	@Override
	public String toString() {
		return "Nhan　Vien [　Ho　Ten()=" + getHoTen() + ", Tuoi()=" + getTuoi() + ", Gioi　Tinh()=" + getGioiTinh()
				+ ", DiaChi()=" + getDiaChi() + ", congViec=" + congViec + "]";
	}
}
