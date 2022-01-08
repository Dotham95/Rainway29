package entity;

import java.util.ArrayList;

import utils.ScannerUtil;

public class TuyenSinh implements ITuyenSinh {
	ArrayList<ThiSinh> listThiSinh = new ArrayList<ThiSinh>();

	@Override
	public void addNew() {
		System.out.println("Mời bạn nhập vào tên thí sinh:");
		String ten = ScannerUtil.scanStr();
		System.out.println("Mời bạn nhập vào địa chỉ thí sinh:");
		String diaChi = ScannerUtil.scanStr();
		System.out.println("Mời bạn nhập vào mức ưu tiên thí sinh:");
		int uuTien = ScannerUtil.scanInt();
		System.out.println("Mời bạn nhập vào khối thí sinh chọn các khối A, B, C:");
		String khoiThi = ScannerUtil.scanStr();
		ThiSinh thiSinh = new ThiSinh(khoiThi, ten, diaChi, uuTien, );
		listThiSinh.add(thiSinh);
	}

	@Override
	public void showInfo() {
		for (ThiSinh thiSinh : listThiSinh) {
			System.out.println(thiSinh);
		}

	}

	@Override
	public void findById(int id) {
		for (ThiSinh thiSinh : listThiSinh) {
			if (thiSinh.getSoBD() == id) {
				System.out.println(thiSinh);
			}
		}

	}
}
