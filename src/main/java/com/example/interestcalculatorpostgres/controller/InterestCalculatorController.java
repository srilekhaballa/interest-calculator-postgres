package com.example.interestcalculatorpostgres.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.interestcalculatorpostgres.dao.HomeLoan;
import com.example.interestcalculatorpostgres.dao.TotalInterest;
import com.example.interestcalculatorpostgres.service.InterestCalculatorService;
import com.example.interestcalculatorpostgres.utils.*;
import com.lowagie.text.DocumentException;

@RestController
@RequestMapping
public class InterestCalculatorController {

	@Autowired
	private InterestCalculatorService interestCalculatorService;

	@PostMapping("/get")
	public ResponseEntity<?> getInterestDetails (@Valid @RequestBody HomeLoan hl) {
		if (hl.getTenure() <= 0  && hl.getLoanAmount() <= 0 ) {   
			return new ResponseEntity<String>("loanAmount and tenure are invalid", HttpStatus.CONFLICT);
		}
		if (String.valueOf(hl.getTenure()) == null && String.valueOf(hl.getLoanAmount()) == null) {
			return new ResponseEntity<String>("loanAmount and tenure are invalid", HttpStatus.CONFLICT);
		}
		if (String.valueOf(hl.getTenure()).matches("[a-z]*") &&
				String.valueOf(hl.getLoanAmount()).matches("[a-z]*")) { 
			return new ResponseEntity<String>("loanAmount and tenure are invalid",HttpStatus.CONFLICT); 
		}
		return new ResponseEntity<TotalInterest>(interestCalculatorService.getInterestDetails(hl),HttpStatus.OK);
	}
	
	@PostMapping("/getLoanDetailsPDF")
	public void exportToPDF(HttpServletResponse response,@Valid @RequestBody HomeLoan hl) throws DocumentException, IOException {
		response.setContentType("loan_Details.pdf");
		TotalInterest ti = interestCalculatorService.getInterestDetails(hl);
		TotalInterestPDFExporter exporter = new TotalInterestPDFExporter(ti);
		exporter.export(response);
	}

}