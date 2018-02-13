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
		appt.setStartHour(0);
		assertEquals(true, appt.getValid());
		appt.setStartHour(23);
		assertEquals(true, appt.getValid());
		appt.setStartHour(21);
		assertEquals(true, appt.getValid());

		appt.setStartMinute(100);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(-1);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(0);
		assertEquals(true, appt.getValid());
		appt.setStartMinute(59);
		assertEquals(true, appt.getValid());
		appt.setStartMinute(40);
		assertEquals(true, appt.getValid());

		appt.setStartDay(60);
		assertEquals(false, appt.getValid());
		appt.setStartDay(-1);
		assertEquals(false, appt.getValid());
		appt.setStartDay(1);
		assertEquals(true, appt.getValid());
		appt.setStartDay(CalendarUtil.NumDaysInMonth(startYear,startMonth-1));
		assertEquals(true, appt.getValid());
		appt.setStartDay(2);
		assertEquals(true, appt.getValid());
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
		assertEquals(2018, appt.getStartYear());
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

			assertEquals("\t1/15/2018 at 1:30pm"  + " ," +  appt.getTitle()+ ", "+  appt.getDescription()+"\n", appt.toString());
			appt.setStartHour(12);
			//undid
			assertEquals("\t1/15/2018 at 12:30pm"  + " ," +  appt.getTitle()+ ", "+  appt.getDescription()+"\n", appt.toString());
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
		//check start month
		@Test(expected=ArrayIndexOutOfBoundsException.class)
		public void test08() throws Throwable {
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

			appt.setStartMonth(60);
			assertEquals(false, appt.getValid());
			appt.setStartMonth(0);
			assertEquals(false, appt.getValid());
			appt.setStartMonth(1);
			assertEquals(true, appt.getValid());
			appt.setStartMonth(12);
			assertEquals(true, appt.getValid());
			appt.setStartMonth(2);
			assertEquals(true, appt.getValid());
		}
		//test number of days in the month in is valid
		/*@Test
		public void test09() throws Throwable{
			int startHour=21;
 		 int startMinute=30;
 		 int startDay=15;
 		 int startMonth=02;
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

		assertEquals(true, appt.getValid());
	}*/
	@Test
	public void test10() throws Throwable{
		int startHour=21;
	 int startMinute=30;
	 int startDay=15;
	 int startMonth=03;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";
	 //Construct a new Appointment object with the initial data
	 Appt appt1 = new Appt(startHour,
						startMinute ,
						startDay ,
						startMonth ,
						startYear ,
						title,
					 description);

		Appt appt2 = new Appt(startHour,
							 startMinute ,
							 startDay ,
							 startMonth ,
							 startYear ,
							 title,
		 					description);

		appt2.setStartHour(20);
		assertEquals(1, appt1.compareTo(appt2));
	}
	//checks the values surrounding 11 hours
	@Test
	public void test11() throws Throwable{
		int startHour=11;
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

		assertEquals("\t1/15/2018 at 11:30am"  + " ," +  appt.getTitle()+ ", "+  appt.getDescription()+"\n", appt.toString());
	}
	@Test
	public void test12() throws Throwable{
		int startHour=11;
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

		assertFalse(appt.isRecurring());

		int[] days = {2,5};
		int recurBy = 1;
		int recurIncrement = 1;
		int recurNumber = 20;

		appt.setRecurrence(days, recurBy, recurIncrement, recurNumber);

		assertEquals(20, appt.getRecurNumber());
		assertEquals(1, appt.getRecurBy());
		assertEquals(days, appt.getRecurDays());
		assertEquals(1, appt.getRecurIncrement());

		assertTrue(appt.isRecurring());
}
}
