package com.cisc181.core;

import static org.junit.Assert.*;

import com.cisc181.eNums.eMajor;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	private static ArrayList<Course> courses = new ArrayList();
	private static ArrayList<Semester> semesters = new ArrayList();
	private static ArrayList<Section> sections = new ArrayList();
	private static ArrayList<Student> students = new ArrayList();
	private static ArrayList<Enrollment> enrollments = new ArrayList();

	@BeforeClass
	public static void setup() throws PersonException {

		/** Three Course records */
		Course course_1 = new Course();
		course_1.setCourseID(UUID.randomUUID());
		course_1.setCourseName("Physics 1");
		course_1.setGradePoints(3);
		course_1.setMajor(eMajor.PHYSICS);
		courses.add(course_1);

		Course course_2 = new Course();
		course_2.setCourseID(UUID.randomUUID());
		course_2.setCourseName("Java");
		course_2.setGradePoints(3);
		course_2.setMajor(eMajor.COMPSI);
		courses.add(course_2);

		Course course_3 = new Course();
		course_3.setCourseID(UUID.randomUUID());
		course_3.setCourseName("Clinical Pharmacology");
		course_3.setGradePoints(3);
		course_3.setMajor(eMajor.NURSING);
		courses.add(course_3);

		/** Two Semesters, one for Fall, and one for Spring */
		Semester Fall = new Semester();
		Fall.setSemesterID(UUID.randomUUID());
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, Calendar.SEPTEMBER, 1);
		Fall.setStartDate(calendar.getTime());
		calendar.set(2016, Calendar.DECEMBER, 16);
		Fall.setEndDate(calendar.getTime());
		semesters.add(Fall);

		Semester Spring = new Semester();
		Spring.setSemesterID(UUID.randomUUID());
		calendar.set(2017, Calendar.FEBRUARY, 5);
		Spring.setStartDate(calendar.getTime());
		calendar.set(2017, Calendar.MAY, 21);
		Spring.setEndDate(calendar.getTime());
		semesters.add(Spring);

		/**
		 * Two Sections for each Course & Semester A For-each loop is used
		 */
		for (Semester sem : semesters) {
			for (Course cour : courses) {
				Section sect = new Section();
				sect.setCourseID(cour.getCourseID());
				sect.setSemesterID(sem.getSemesterID());
				sect.setRoomID(10);
				sections.add(sect);

				sect = new Section();
				sect.setCourseID(cour.getCourseID());
				sect.setSemesterID(sem.getSemesterID());
				sect.setRoomID(25);
				sections.add(sect);

			}

		}

		/** Ten student records */

		Student student_1 = new Student("Joe", "N", "Grimes", new Date(), eMajor.NURSING, "555 Main Ave",
				"(312)-555-5555", "djfggjkn@udel.edu");
		students.add(student_1);

		Student student_2 = new Student("Barry", "N", "Paul", new Date(), eMajor.NURSING, "565 George Ave",
				"(312)-553-5444", "rfvefvn@udel.edu");
		students.add(student_2);

		Student student_3 = new Student("Kim", "L", "Kard", new Date(), eMajor.BUSINESS, "434 Flouresenct Ave",
				"(312)-335-7566", "vdvbdvn@udel.edu");
		students.add(student_3);

		Student student_4 = new Student("Lori", "L", "Flour", new Date(), eMajor.BUSINESS, "678 Wallabee Ave",
				"(312)-535-6787", "hfdvjbhd@udel.edu");
		students.add(student_4);

		Student student_5 = new Student("Kimberly", "Y", "Sean", new Date(), eMajor.PHYSICS, "789 Bobby Ave",
				"(312)-677-6786", "nnkbjr.edu");
		students.add(student_5);

		Student student_6 = new Student("Paul", "J", "Thomas", new Date(), eMajor.PHYSICS, "678 Piper Ave",
				"(312)-567-1234", "vbklhb@udel.edu");
		students.add(student_6);

		Student student_7 = new Student("Paublo", "L", "Road", new Date(), eMajor.CHEM, "888 Philip Ave",
				"(312)-111-1111", "kjkbmny@udel.edu");
		students.add(student_7);

		Student student_8 = new Student("Chris", "O", "Forest", new Date(), eMajor.CHEM, "333 Plier Ave",
				"(312)-444-4444", "myitivnf@udel.edu");
		students.add(student_8);

		Student student_9 = new Student("John", "R", "Valesquez", new Date(), eMajor.COMPSI, "777 Grove Ave",
				"(312)-010-2222", "tivgtgi@udel.edu");
		students.add(student_9);

		Student student_10 = new Student("Ryan", "J", "Tod", new Date(), eMajor.COMPSI, "222 Ricket Ave",
				"(312)-776-3345", "vnftigt@udel.edu");
		students.add(student_10);

	}

	/** My own GPA values for the scores */
	public double GradeValue(double score) {
		double GPA = 0;

		if ((score <= 100) && (score >= 90)) {
			GPA = 4;
		}
		if ((score <= 89) && (score >= 80)) {
			GPA = 3;
		}
		if ((score <= 79) && (score >= 74)) {
			GPA = 2;

		}
		if ((score <= 73) && (score >= 66)) {
			GPA = 1;
		} else if (score <= 65) {
			GPA = 0;
		}

		return GPA;
	}

	/** The major of one of the student records is changed */
	@Test
	public void MajorChange() {
		students.get(9).seteMajor(eMajor.BUSINESS);
		assertEquals(students.get(9).geteMajor(), eMajor.BUSINESS);
	}

}