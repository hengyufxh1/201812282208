package com.itstar.commons.unit;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Date;

public class RobotTest {
	public static void main(String[] args) throws AWTException {
		Robot r = new Robot();
		Long a = new Date().getTime();
		System.out.println("延时前:" + a);
		r.delay(2000);
		Long b = new Date().getTime();
		System.out.println("延时后:" + b);
		System.out.println("延时时间:" + (b-a) +"ms");
	}
}
