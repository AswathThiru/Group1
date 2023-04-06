package com.axis.exception;

public class UserNameNotFoundException extends Exception {

	 public 	UserNameNotFoundException(String username) {
		   System.out.println(username+" not found");
	   }
}
