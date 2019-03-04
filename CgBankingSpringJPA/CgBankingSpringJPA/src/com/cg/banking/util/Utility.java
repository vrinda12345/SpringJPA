package com.cg.banking.util;

public class Utility {
	public static int generatePin() {
		return (int)(1000 + Math.random()*10000);
	}
}
