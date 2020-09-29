package com.wellsfargo.fsd.lms.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.lms.dao.LoanDao;
import com.wellsfargo.fsd.lms.enitity.Loan;
import com.wellsfargo.fsd.lms.exception.LoanException;
import com.wellsfargo.fsd.lms.service.LoanService;

@Controller
@RequestMapping("/user")
public class LoanUserController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping("/list")
	public ModelAndView doDisplayLoans() {
		return new ModelAndView("loanListPage", "loans",loanService.getAllLoans());
	}
	
}
