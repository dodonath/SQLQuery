package com.peerislands.sqlenhancer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peerislands.sqlenhancer.dto.ApiResponseDto;
import com.peerislands.sqlenhancer.dto.Select;
import com.peerislands.sqlenhancer.service.SqlEnhancerService;
import com.peerislands.sqlenhancer.util.ResponseMessage;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;

/**
 * This controller class handles all end points for Sql Enhancer 
 * 
 * in this class implemented json to sql conversion
 *  
 * @author Dodo Nath
 * 
 * 
 */

@Slf4j
@OpenAPIDefinition(info = @Info(title = "SqlEnhancer", version = "1.1", description = "Sql defination"))
@RestController
@RequestMapping("/sqlEnhancer/sqlQuery")
public class SqlController {
	
	@Autowired
	private SqlEnhancerService service;
	
	
	/**
	 * This method serves as a controller for the UI
	 * @param input
	 * @param header
	 * @return
	 */
	@Operation(description = "Convert a json to Sql")
	@PostMapping
	public ResponseEntity<?> converJsonToSql(@RequestBody Select input,@RequestHeader HttpHeaders header) {
		try {
			log.info("Starting the parsing for the json");
			String sql  = service.getSqlString(input);
			return new ResponseEntity<>(new ApiResponseDto(true,sql),HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage(),e);
			return new ResponseEntity<>(new ApiResponseDto(false,ResponseMessage.ERROR_MESSAGE),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
