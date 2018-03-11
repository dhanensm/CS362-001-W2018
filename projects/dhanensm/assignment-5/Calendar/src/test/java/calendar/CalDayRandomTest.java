package calendar;
import java.util.Calendar;
import java.util.Random;

import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;
public class CalDayRandomTest {
	private static final long TestTimeout = (60 * 500 * 1)/4; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur
        }
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur
        }

		//add valid appointments
	 @Test
	  public void randomtest01()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
  		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


  		System.out.println("Start testing...");

  	 try{
  		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
  			 long randomseed =System.currentTimeMillis(); //10
   //			System.out.println(" Seed:"+randomseed );
  			 Random random = new Random(randomseed);

  				int startHour=ValuesGenerator.getRandomIntBetween(random, -10, 30);
  				int startMinute=ValuesGenerator.RandInt(random);
  				int startDay=ValuesGenerator.RandInt(random);
  				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
  				int startYear=ValuesGenerator.RandInt(random);
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

					int startHour2=ValuesGenerator.getRandomIntBetween(random, -10, 30);
					int startMinute2=ValuesGenerator.RandInt(random);
					int startDay2=ValuesGenerator.RandInt(random);
					int startMonth2=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int startYear2=ValuesGenerator.RandInt(random);
					String title2="Birthday Party";
					String description2="This is my birthday party.";

					Appt appt2 = new Appt(startHour2,
  								 startMinute2 ,
  								 startDay2 ,
  								 startMonth2 ,
  								 startYear2 ,
  								 title2,
  								description2);

					GregorianCalendar testcal = new GregorianCalendar();
				 	CalDay day = new CalDay(testcal);

					day.addAppt(appt);
					day.addAppt(appt2);

					elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
					if((iteration%10000)==0 && iteration!=0 )
							System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

					}
					}catch(NullPointerException e){

					}
	 }
	 @Test
	  public void test01b()  throws Throwable  {
			CalDay day = new CalDay();
			assertEquals(false, day.isValid());
	 }
	 //tests greg constructor
	 @Test
	  public void test_bug_report()  throws Throwable  {
			GregorianCalendar testcal = new GregorianCalendar();
 			CalDay day = new CalDay(testcal);
			assertEquals(true, day.isValid());
	 }
	 //testing appointment is added to listAppt
	 @Test
	 	public void test03b() throws Throwable{
			GregorianCalendar testcal = new GregorianCalendar();
 			CalDay day = new CalDay(testcal);
			Appt test = new Appt(1, 1, 1, 1, 2018, "Test", "Test desciption");
			day.addAppt(test);
			assertEquals(1, day.getAppts().size());
		}
		//testing second appointment is added to listAppt
		//testing third appt added in correct order
 	 @Test
 	 	public void test04b() throws Throwable{
 			GregorianCalendar testcal = new GregorianCalendar();
  		CalDay day = new CalDay(testcal);
			//hour, min, day, month, year
 			Appt test = new Appt(1, 1, 1, 1, 2018, "Test", "Test desciption");
 			day.addAppt(test);
			Appt test2 = new Appt(1, 3, 1, 1, 2018, "Test 2", "Test desciption 2");
			day.addAppt(test2);
 			assertEquals(2, day.getAppts().size());
			Appt test3 = new Appt(1, 1, 2, 1, 2018, "Test 3", "Test desciption 3");
 			day.addAppt(test3);
			Appt test4 = new Appt(1, 1, 2, 1, 2018, "Test 4", "Test desciption 4");
			day.addAppt(test4);
			assertEquals(4, day.getAppts().size());
 		}
		//test
		@Test
			public void test05b() throws Throwable{
				GregorianCalendar testcal = new GregorianCalendar();
	 			CalDay day = new CalDay(testcal);
				assertEquals(0, day.getSizeAppts());
			}
			//check to string with appointment
			@Test
	 	 	public void test06b() throws Throwable{
	 			GregorianCalendar testcal = new GregorianCalendar();
	  		CalDay day = new CalDay(testcal);
				//hour, min, day, month, year
	 			Appt test = new Appt(1, 1, day.getDay(), day.getMonth(), 2018, "test", "test description");
	 			day.addAppt(test);
				//assertEquals("02/12/2018", day.toString().todayDate);
	 			//assertEquals("\t --- "+day.getMonth() + "/" + day.getDay() + "/" + day.getYear()+" --- \n" + " --- -------- Appointments ------------ --- \n\n" + day.getMonth() + "/" + day.getDay() + "/" + day.getYear()+" at 1:01am, test, test description\n", test.toString());

			}
			//getDay
			@Test
				public void test07b() throws Throwable{
					GregorianCalendar testcal = new GregorianCalendar();
		 			CalDay day = new CalDay(testcal);
					assertEquals(testcal.get(testcal.DAY_OF_MONTH), day.getDay());
					//should be testcal.DAY_OF_MONTH+1
				}
				//getYear
				@Test
					public void test08b() throws Throwable{
						GregorianCalendar testcal = new GregorianCalendar();
			 			CalDay day = new CalDay(testcal);
						assertEquals(2018, day.getYear());
				}
				//getMonth
				/*@Test
				public void test09b() throws Throwable{
					GregorianCalendar testcal = new GregorianCalendar();
				 	CalDay day = new CalDay(testcal);
					assertEquals(testcal.MONTH, (day.getMonth())+1);
				}*/
				//check to string withOUT appointment
				@Test
				public void test10b() throws Throwable{
					CalDay day = new CalDay();
					assertEquals("", day.toString());
					//assertEquals("\t --- " + day.getMonth()+ "/" + day.getDay() + "/" + day.getYear() + " --- \n" + " --- -------- Appointments ------------ --- \n\n", day.toString());
				}
				//iterator with not valid days
				@Test
				public void test12b() throws Throwable{
					CalDay day = new CalDay();
					//day.toString();
					assertEquals(null, day.iterator());
				}
				//testing appointment is added to listAppt
		 	 /*@Test
		 	 	public void test13() throws Throwable{
		  		CalDay day = new CalDay();
		 			Appt test = new Appt(-1, 1, 1, 1, 2018, "Test", "Test desciption");
		 			day.addAppt(test);
		 			assertEquals(0, day.getAppts().size());
		 		}*/
				//add appointment with first start hour larger
				@Test
		  	 	public void test14b() throws Throwable{
		  			GregorianCalendar testcal = new GregorianCalendar();
		   		CalDay day = new CalDay(testcal);
		  			Appt test = new Appt(3, 1, 1, 1, 2018, "Test", "Test desciption");
		  			day.addAppt(test);
		 			Appt test2 = new Appt(1, 2, 1, 1, 2018, "Test 2", "Test desciption 2");
		 			day.addAppt(test2);
		  			assertEquals(2, day.getAppts().size());
		  	}
				@Test
				public void test15b() throws Throwable{
					GregorianCalendar testcal = new GregorianCalendar();
					CalDay vday = new CalDay(testcal);
					Iterator i = vday.iterator();
				}
				//checks range on addAppt
				@Test
				public void test16b() throws Throwable{
					GregorianCalendar testcal = new GregorianCalendar();
					CalDay day = new CalDay(testcal);

					//hour, min, day, month, year
		 			Appt test = new Appt(20, 1, 1, 3, 2018, "Test", "Test desciption");
		 			day.addAppt(test);
					assertEquals(test, day.getAppts().get(0));
					Appt test2 = new Appt(2, 1, 1, 3, 2018, "Test 2", "Test desciption 2");
					day.addAppt(test2);
					assertEquals(test, day.getAppts().get(1));
					Appt test4 = new Appt(3, 1, 1, 3, 2018, "Test 2", "Test desciption 2");
					day.addAppt(test4);
					assertEquals(test, day.getAppts().get(2));
		 			Appt test3 = new Appt(3, 1, 1, 3, 2018, "Test", "Test desciption");
		 			day.addAppt(test3);
					assertEquals(test, day.getAppts().get(3));

					assertEquals(4, day.getSizeAppts());
				}
				@Test
				public void test17b() throws Throwable{
					GregorianCalendar testcal = new GregorianCalendar();
					CalDay day = new CalDay(testcal);

					Appt test = new Appt(2, 1, 1, 3, 2018, "Test", "Test desciption");
		 			day.addAppt(test);
					Appt test2 = new Appt(2, 1, 1, 4, 2018, "Test", "Test desciption");
		 			day.addAppt(test2);

					assertNotNull(day.toString());
				}
				@Test
				public void test18b() throws Throwable{
					GregorianCalendar testcal = new GregorianCalendar();
					CalDay day = new CalDay(testcal);
					assertNotNull(day.iterator());
				}
}
