package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
	 }
	 //breaking is valid with crap
	 @Test
	 public void test02()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);

		appt.setStartHour(42);
		assertEquals(false, appt.getValid());
		appt.setStartHour(-1);
		assertEquals(false, appt.getValid());
		appt.setStartHour(21);

		appt.setStartMinute(100);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(-1);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(40);

		appt.setStartDay(60);
		assertEquals(false, appt.getValid());
		appt.setStartDay(-1);
		assertEquals(false, appt.getValid());
		appt.setStartDay(2);
	}
	//check month and year
	@Test
	 public void test03()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						description);

		appt.setStartMonth(1);
		appt.setStartYear(2018);

		assertEquals(1, appt.getStartMonth());
		assertEquals(true, appt.getStartYear());
	}
	//testing null strings
	@Test
	 public void test04()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title=null;
		String description= null;
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						description);

		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());
	}
	 //test represntationApp for printable hour > 11
	 @Test
	  public void test05()  throws Throwable  {
			int startHour=13;
			int startMinute=30;
			int startDay=15;
			int startMonth=01;
			int startYear=2018;
			String title="Birthday Party";
			String description="This is my birthday party.";
			//Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour,
							 startMinute ,
							 startDay ,
							 startMonth ,
							 startYear ,
							 title,
							description);

			assertEquals("\t"+ appt.getStartDay() +  "1:30pm"  + " ," +  appt.getTitle()+ ", "+  appt.getDescription()+"\n", appt.toString());
			appt.setStartHour(12);
			assertEquals("\t"+ appt.getStartDay() +  "12:30pm"  + " ," +  appt.getTitle()+ ", "+  appt.getDescription()+"\n", appt.toString());
	 }
	 @Test
	  public void test06()  throws Throwable  {
			int startHour=700;
			int startMinute=30;
			int startDay=15;
			int startMonth=01;
			int startYear=2018;
			String title="Birthday Party";
			String description="This is my birthday party.";
			//Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour,
							 startMinute ,
							 startDay ,
							 startMonth ,
							 startYear ,
							 title,
							description);

			assertEquals(null, appt.toString());
		}
		@Test
 	  public void test07()  throws Throwable  {
 			int startHour=700;
 			int startMinute=30;
 			int startDay=15;
 			int startMonth=01;
 			int startYear=2018;
 			String title="Birthday Party";
 			String description="This is my birthday party.";
 			//Construct a new Appointment object with the initial data
 			Appt appt = new Appt(startHour,
 							 startMinute ,
 							 startDay ,
 							 startMonth ,
 							 startYear ,
 							 title,
 							description);
			assertEquals(0, appt.getRecurNumber());
		}

}
