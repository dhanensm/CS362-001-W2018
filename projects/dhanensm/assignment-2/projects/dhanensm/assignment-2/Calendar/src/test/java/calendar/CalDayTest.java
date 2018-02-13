package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	//tests that valid is set to false
	 @Test
	  public void test01()  throws Throwable  {
			CalDay day = new CalDay();
			assertEquals(false, day.isValid());
	 }
	 //tests greg constructor
	 @Test
	  public void test02()  throws Throwable  {
			GregorianCalendar testcal = new GregorianCalendar();
 			CalDay day = new CalDay(testcal);
			assertEquals(true, day.isValid());
	 }
	 //testing appointment is added to listAppt
	 @Test
	 	public void test03() throws Throwable{
			GregorianCalendar testcal = new GregorianCalendar();
 			CalDay day = new CalDay(testcal);
			Appt test = new Appt(1, 1, 1, 1, 2018, "Test", "Test desciption");
			day.addAppt(test);
			assertEquals(1, day.getAppts().size());
		}
		//testing second appointment is added to listAppt
 	 @Test
 	 	public void test04() throws Throwable{
 			GregorianCalendar testcal = new GregorianCalendar();
  		CalDay day = new CalDay(testcal);
 			Appt test = new Appt(1, 1, 1, 1, 2018, "Test", "Test desciption");
 			day.addAppt(test);
			Appt test2 = new Appt(1, 2, 1, 1, 2018, "Test 2", "Test desciption 2");
			day.addAppt(test2);
 			assertEquals(2, day.getAppts().size());
 		}
		//test
		@Test
			public void test05() throws Throwable{
				GregorianCalendar testcal = new GregorianCalendar();
	 			CalDay day = new CalDay(testcal);
				assertEquals(0, day.getSizeAppts());
			}
			//check to string with appointment
			@Test
	 	 	public void test06() throws Throwable{
	 			GregorianCalendar testcal = new GregorianCalendar();
	  		CalDay day = new CalDay(testcal);
	 			Appt test = new Appt(1, 1, 1, 1, 2018, "Test", "Test description");
	 			day.addAppt(test);
				day.toString();
	 			assertEquals("\t --- " + day.getMonth()+ "/" + day.getDay() + "/" + day.getYear() + " --- \n" + " --- -------- Appointments ------------ --- \n\n" + "01/01/2018 at 1:01am, Test, Test description\n", test.toString());
	 		}
			//getDay
			@Test
				public void test07() throws Throwable{
					GregorianCalendar testcal = new GregorianCalendar();
		 			CalDay day = new CalDay(testcal);
					assertEquals(testcal.DAY_OF_MONTH, day.getDay());
				}
				//getYear
				@Test
					public void test08() throws Throwable{
						GregorianCalendar testcal = new GregorianCalendar();
			 			CalDay day = new CalDay(testcal);
						assertEquals(testcal.YEAR, day.getYear());
				}
				//getMonth
				@Test
				public void test09() throws Throwable{
					GregorianCalendar testcal = new GregorianCalendar();
				 	CalDay day = new CalDay(testcal);
					assertEquals(testcal.MONTH, day.getMonth());
				}
				//check to string withOUT appointment
				@Test
				public void test10() throws Throwable{

					CalDay day = new CalDay();
					assertEquals("\t --- " + day.getMonth()+ "/" + day.getDay() + "/" + day.getYear() + " --- \n" + " --- -------- Appointments ------------ --- \n\n", day.toString());
				}
				//iterator with not valid days
				@Test
				public void test12() throws Throwable{
					CalDay day = new CalDay();
					//day.toString();
					assertEquals(null, day.iterator());
				}
				//testing appointment is added to listAppt
		 	 @Test
		 	 	public void test13() throws Throwable{
		  		CalDay day = new CalDay();
		 			Appt test = new Appt(-1, 1, 1, 1, 2018, "Test", "Test desciption");
		 			day.addAppt(test);
		 			assertEquals(0, day.getAppts().size());
		 		}
				//add appointment with first start hour larger
				@Test
		  	 	public void test14() throws Throwable{
		  			GregorianCalendar testcal = new GregorianCalendar();
		   		CalDay day = new CalDay(testcal);
		  			Appt test = new Appt(3, 1, 1, 1, 2018, "Test", "Test desciption");
		  			day.addAppt(test);
		 			Appt test2 = new Appt(1, 2, 1, 1, 2018, "Test 2", "Test desciption 2");
		 			day.addAppt(test2);
		  			assertEquals(2, day.getAppts().size());
		  	}
				@Test
				public void test15() throws Throwable{
					GregorianCalendar testcal = new GregorianCalendar();
					CalDay vday = new CalDay(testcal);
					Iterator i = vday.iterator();
				}
//add more unit tests as you needed
}
