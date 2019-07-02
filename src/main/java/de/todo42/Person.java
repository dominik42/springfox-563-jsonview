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

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class Person {

	private String firstName;
	private String lastName;

	@JsonView(Views.SimplePerson.class)
	private String nickName;
	
	
	public Person() {
		this.firstName = "Dominik";
		this.lastName = "Hirt";
		this.nickName = "Dom";
		
	}
}
