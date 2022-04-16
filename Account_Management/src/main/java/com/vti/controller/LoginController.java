//package com.vti.controller;
//
//import java.security.Principal;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.vti.dto.AccountDTO;
//import com.vti.dto.UserDTO;
//import com.vti.entity.Account;
//import com.vti.entity.User;
//import com.vti.service.IAccountService;
//
//
//@RestController
//@RequestMapping(value = "api/v2/login")
//public class LoginController {
//
//	@Autowired
//	private ModelMapper modelMapper;
//	@Autowired
//	private IAccountService accountService;
//
//	@GetMapping()
//	public LoginInfoDto login(Principal principal) {
//		String username = principal.getName();
//		Account account = accountService.getAccountByUserName(username);
//		LoginInfoDto dto = modelMapper.map(account, LoginInfoDto.class);
//				
//		return dto;
//	}
//
//}
