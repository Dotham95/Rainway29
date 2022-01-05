/*Question 1: inheritance
Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên.
Mỗi cán bộ cần quản lý các dữ liệu: Họ tên, tuổi, giới tính(name, nữ,
khác), địa chỉ.
Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
Cấp kỹ sư có thuộc tính riêng: Nghành đào tạo.
Các nhân viên có thuộc tính riêng: công việc.
Hãy xây dựng các lớp CongNhan, KySu, NhanVien kế thừa từ lớp
CanBo.*/

package entity;

public class CanBo {

	private String hoTen;
	private int tuoi;
	private gioiTinh gioiTinh;
	private String diaChi;

	public enum gioiTinh {
		MALE, FEMALE, UNKNOWN
	}

	public CanBo(String hoTen, int tuoi) {
		super();
		this.hoTen = hoTen;
		this.tuoi = tuoi;
	}

	public CanBo(String hoTen, int tuoi, gioiTinh gioiTinh, String diaChi) {
		super();
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}

	public CanBo() {
		super();
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public gioiTinh getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(gioiTinh gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "CanBo [hoTen=" + hoTen + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + "]";
	}

}
