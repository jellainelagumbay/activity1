package com.fimc.activity1.people.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class PeopleResponse implements Serializable {

	private String firstName;
	private String lastName;
	private String birthDate;
	//private ArrayList<PeopleResponse> peopleList;
}

