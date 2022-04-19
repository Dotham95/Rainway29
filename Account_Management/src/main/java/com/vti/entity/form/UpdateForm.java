package com.vti.entity.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.vti.dto.DTOCodeMessage;
import com.vti.entity.config.DepartmentNotExists;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateForm {
	@NotBlank(message = "The name mustn't be null value")
	@Length(max = 50, message = "The name's length is max 50 characters")
	private String username;

	@NotBlank(message = DTOCodeMessage.MSG_CODE_101)
	@Pattern(regexp = "^\\w+@[a-zA-Z]+.[a-zA-Z]+.{0,1}[a-zA-Z]+$", message = DTOCodeMessage.MSG_CODE_101)
	private String email;

	@NotBlank(message = "The fullname mustn't be null value")
	private String fullName;

	@Positive(message = "{Department.form.name.GreaterThan}")
	@DepartmentNotExists
	private int departmentId;
	@Positive(message = "PositionId > 0")
	private int positionId;

}
