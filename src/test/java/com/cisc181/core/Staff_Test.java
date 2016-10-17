package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import com.cisc181.eNums.eTitle;

import org.junit.BeforeClass;
import org.junit.Test;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}

	@Test
	public void TestSalary() {

		/**
		 * Five sample Staff instances are added to the ArrayList with different
		 * salaries
		 */
		Staff Beth = new Staff(com.cisc181.eNums.eTitle.MS);
		Staff Emma = new Staff(com.cisc181.eNums.eTitle.MS);
		Staff Natalie = new Staff(com.cisc181.eNums.eTitle.MRS);
		Staff Carol = new Staff(com.cisc181.eNums.eTitle.MRS);
		Staff Paul = new Staff(com.cisc181.eNums.eTitle.MR);

		Beth.setSalary(20000);
		Emma.setSalary(40000);
		Natalie.setSalary(10000);
		Carol.setSalary(50000);
		Paul.setSalary(80000);

		ArrayList<Staff> Salaries = new ArrayList<Staff>();
		Salaries.add(Beth);
		Salaries.add(Emma);
		Salaries.add(Natalie);
		Salaries.add(Carol);
		Salaries.add(Paul);

		/** The average of the salaries are caluclated. */
		double avg = 0;
		for (Staff employee : Salaries) {
			avg += employee.getSalary() / Salaries.size();
		}

		double totalSalary = 20000 + 40000 + 10000 + 50000 + 80000;

		totalSalary = totalSalary / 5;

		/** This is proven with the assertEquals method. */
		assertEquals(avg, totalSalary, 0);
	}

	/** A test for Staff with an invalid phone number and invalid DOB. */
	@Test
	public void TestException() throws PersonException {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 150);
		Staff employee_1 = new Staff(eTitle.MRS);
		employee_1.setDOB(calendar.getTime());
	}

	@Test
	public void TestException1() throws PersonException {
		Staff employee_1 = new Staff(com.cisc181.eNums.eTitle.MRS);
		employee_1.setPhone("34(312)-555-555514");
	}

}
