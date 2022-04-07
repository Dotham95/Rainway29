package com.vti.entity.enumerate;

public enum DepartmentName {
	GD("Giám đốc"), PGD("Phó giám đốc"), HC("Hành chính"), SALE("Sale"), MARKETING("Marketing"), KT("Kế toán"),
	TC("Tài chính"), TK("Thiết kế"), AN("An ninh");

	private String value;

	private DepartmentName(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static DepartmentName convertEnumName(String value) {
		if (value == null) {
			return null;
		}

		for (DepartmentName e : DepartmentName.values()) {
			if (e.name().equals(value)) {
				return e;
			}
		}
		return null;
	}

	public static DepartmentName of(String value) {
		if (value == null) {
			return null;
		}

		for (DepartmentName name : DepartmentName.values()) {
			if (name.getValue().equals(value)) {
				return name;
			}
		}

		return null;
	}
}
