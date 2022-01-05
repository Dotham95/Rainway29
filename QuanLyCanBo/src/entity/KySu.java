package entity;

public class KySu extends CanBo {
	private String nganhDaoTao;

	public KySu() {
		super();
	}

	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}

	public KySu(String hoTen, int tuoi, gioiTinh gioiTinh, String diaChi, String nganhDaoTao) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.nganhDaoTao = nganhDaoTao;
	}

	@Override
	public String toString() {
		return "Ky Su [HoTen()=" + getHoTen() + ", Tuoi()=" + getTuoi() + ", Gioi Tinh()=" + getGioiTinh()
				+ ", Dia Chi()=" + getDiaChi() + ", nganh Dao Tao=" + nganhDaoTao + "]";
	}
}
