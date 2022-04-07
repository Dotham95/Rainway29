package com.vti.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.entity.fillter.AccountFillter;
import com.vti.entity.form.CreateAccountForm;
import com.vti.service.IAccountService;

@RestController
@RequestMapping("/v2/api/accounts")
@CrossOrigin("*")
@Validated
public class AccountController {
	@Autowired
	IAccountService acService;
	@Autowired
	ModelMapper modelMapper;

	public AccountController() {
	}

	@GetMapping
	public Page<AccountDTO> getAllAccounts(Pageable pageable, AccountFillter fillter) {
		Page<Account> entityPages = acService.getAll(pageable, fillter);
		List<AccountDTO> listAccountDTOs = modelMapper.map(entityPages.getContent(), new TypeToken<List<AccountDTO>>() {
		}.getType());
		Page<AccountDTO> pageAccountDTO = new PageImpl<>(listAccountDTOs, pageable, entityPages.getTotalElements());
		return pageAccountDTO;
	}

	@GetMapping("/{id}")
	public AccountDTO getAccountById(@PathVariable(value = "id") int id) {
		Account entity = acService.getAccountById(id);
		AccountDTO dto = modelMapper.map(entity, AccountDTO.class);
		return dto;
	}

	@GetMapping(value = "/name/{name}/exists")
	public AccountDTO existsByName(@PathVariable(name = "name") String name) {
		Account entity = acService.getAccountByUserName(name);
		AccountDTO dto = modelMapper.map(entity, AccountDTO.class);
		return dto;
	}

	@PostMapping
	public Account createAccount(@RequestBody @Valid CreateAccountForm form) {
		return acService.createAccount(form);
	}

	@PutMapping("/{id}")
	public Account updateAccount(@PathVariable(name = "id") int id, @RequestBody() CreateAccountForm form) {
		Account account = acService.updateAccount(id, form);
		return account;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") int id) {
		acService.deleteAccount(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteAccounts(@RequestParam(name = "ids") List<Integer> ids) {
		acService.deleteAccounts(ids);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
