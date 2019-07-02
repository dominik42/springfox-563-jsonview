/*
 * Copyright (c) 2019 todo42 Software GmbH
 *                    Blomberger Str. 6
 *                    04758 Oschatz
 *
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information
 * of todo42 Software GmbH ("Confidential Information").
 * You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license
 * agreement you entered into with todo42 Software GmbH.
 *
 */

package de.todo42;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;

/**
 * @author Dominik
 *
 */
@RestController
@RequestMapping("/person")
public class Controller {

	
	@JsonView(Views.SimplePerson.class)
	@GetMapping(value = "/simple")
	@ApiOperation(value = "return only a simple view of the person")
	public Person getSimplePerson() {
		return new Person();
	}

	@GetMapping
	@ApiOperation(value = "return all attributes of the person")
	public Person getFullPerson() {
		return new Person();
	}
}
