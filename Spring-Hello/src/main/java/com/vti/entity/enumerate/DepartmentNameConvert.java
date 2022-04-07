package com.vti.entity.enumerate;

import javax.persistence.AttributeConverter;

public class DepartmentNameConvert implements AttributeConverter<DepartmentName, String>  {

	public String convertToDatabaseColumn(DepartmentName name) {
		if (name == null) {
			return null;
		}

		return name.getValue();
	}

	/*
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
	 * Object)
	 */
	public DepartmentName convertToEntityAttribute(String value) {
		return DepartmentName.of(value);
	}

}

