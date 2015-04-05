package com.gmail.at.sichyuriyy;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class Task4Test {
	
	String exampleOfNumber;
	boolean answer;
	
	public Task4Test(String exampleOfNumber, boolean answer) {
		this.exampleOfNumber = exampleOfNumber;
		this.answer = answer;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		Object [][]data = new Object[][]{
				{"11 11 11", true},
				{"11-11-11", true},
				{"12-1233-111111", false},
				{"+1 (931) 12 12 12", true}
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void test() {
		assertEquals(Task4.testNumber(exampleOfNumber), answer);
	}

}
