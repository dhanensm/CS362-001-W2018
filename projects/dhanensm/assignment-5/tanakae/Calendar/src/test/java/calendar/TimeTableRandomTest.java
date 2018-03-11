package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.LinkedList;

import org.junit.Test;

import java.util.*;


import static org.junit.Assert.*;


/**
* Random Test Generator  for TimeTable class.
*/


public class TimeTableRandomTest {

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

	/**
	* Generate Random Tests that tests TimeTable Class.
	*/

	//testing the deleteAppt function
	@Test
	public void randomtest01()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		long randomseed =System.currentTimeMillis();
		Random r = new Random(randomseed);
		int nulled = ValuesGenerator.getRandomIntBetween(r, 0, 1);

		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				LinkedList<Appt> applist = new LinkedList<Appt>();
				int appNum = ValuesGenerator.RandInt(random);

				for(int i=0; i<appNum; i++){
					Appt appt = null;
					applist.add(appt);
				}

				TimeTable test = new TimeTable();
				int remove = ValuesGenerator.getRandomIntBetween(random, 0, appNum);

				for(int j=0; j<remove-1; j++){
					int location = ValuesGenerator.getRandomIntBetween(random, 0, applist.size()-1);
					if(location==remove)
					location--;
					test.deleteAppt(applist, applist.get(location));
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}
	//test null for delete
	@Test
	public void randomtest02()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				LinkedList<Appt> applist = new LinkedList<Appt>();
				int appNum = ValuesGenerator.RandInt(random);

				for(int i=0; i<appNum; i++){
					int startHour=ValuesGenerator.RandInt(random);
					int startMinute=ValuesGenerator.RandInt(random);
					int startDay=ValuesGenerator.getRandomIntBetween(random, -10, 30);
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
					applist.add(appt);
				}

				TimeTable test = new TimeTable();
				int remove = ValuesGenerator.getRandomIntBetween(random, 0, appNum);

				for(int j=0; j<remove-1; j++){
					int location = ValuesGenerator.getRandomIntBetween(random, 0, applist.size()-1);
					if(location==remove)
					location--;
					test.deleteAppt(applist, applist.get(location));
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}
	@Test
	public void randomtest03()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int startHour=ValuesGenerator.RandInt(random);
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

				LinkedList<Appt> applist = null;

				TimeTable test = new TimeTable();
				test.deleteAppt(applist, appt);

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}
	@Test
	public void randomtest04()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				LinkedList<Appt> applist = null;

				TimeTable test = new TimeTable();
				test.deleteAppt(applist, null);

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}
	@Test(expected=DateOutOfRangeException.class)
	public void randomtest05()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				GregorianCalendar cal1 = new GregorianCalendar(2018, ValuesGenerator.getRandomIntBetween(random, 1, 12), ValuesGenerator.getRandomIntBetween(random, 1, 30));
				CalDay day1 = new CalDay(cal1);
				GregorianCalendar cal2 = new GregorianCalendar(2019, ValuesGenerator.getRandomIntBetween(random, 1, 12), ValuesGenerator.getRandomIntBetween(random, -10, 30));
				CalDay day2 = new CalDay(cal2);
				GregorianCalendar cal3 = new GregorianCalendar(2019, ValuesGenerator.getRandomIntBetween(random, 1, 12), ValuesGenerator.getRandomIntBetween(random, -10, 30));
				CalDay day3 = new CalDay(cal3);

				//hour, minute, day, month, year
				Appt appt1 = new Appt(ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), ValuesGenerator.getRandomIntBetween(random, 1, 12), 2018, "Jan 1", "testing");
				Appt appt2 = new Appt(ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), ValuesGenerator.getRandomIntBetween(random, 1, 12), 2019, "Feb 1", "testing again");
				Appt appt3 = new Appt(ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), ValuesGenerator.getRandomIntBetween(random, 1, 12), 2019, "Feb 12", "testing again");
				Appt appt4 = new Appt(ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), ValuesGenerator.getRandomIntBetween(random, 1, 12), 2019, "Feb 12", "testing again");
				Appt appt5 = new Appt(ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), ValuesGenerator.getRandomIntBetween(random, 1, 12), 2019, "Feb 12", "testing again");

				TimeTable testtable = new TimeTable();

				LinkedList<Appt> allappts = new LinkedList<Appt>();
				testtable.getApptRange(allappts, cal1, cal2);

				day1.addAppt(appt1);
				day2.addAppt(appt2);
				day2.addAppt(appt3);
				day2.addAppt(appt4);
				allappts.add(appt1);
				allappts.add(appt2);
				allappts.add(appt3);
				allappts.add(appt4);
				allappts.add(appt5);

				int[] recurDaysArr={2,3};
				appt2.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
				testtable.getApptRange(allappts, cal1, cal2);

				appt3.setRecurrence(recurDaysArr, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
				testtable.getApptRange(allappts, cal2, cal1);

				appt4.setRecurrence(recurDaysArr, Appt.RECUR_BY_YEARLY, 1, Appt.RECUR_NUMBER_FOREVER);
				testtable.getApptRange(allappts, cal2, cal3);

				LinkedList<Appt> removedlist = new LinkedList<Appt>();
				removedlist = testtable.deleteAppt(allappts, allappts.get(0));
				//removedlist = testtable.deleteAppt(allappts, allappts.get(1));

				//assertEquals(4, allappts.size());

				Appt nullappt = null;
				allappts.add(nullappt);
				removedlist = testtable.deleteAppt(allappts, allappts.get(5));
				removedlist = testtable.deleteAppt(allappts, allappts.get(4));

				//assertEquals(2, allappts.size());

				testtable.getApptRange(allappts, cal3, cal2);


				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}
	@Test(expected=DateOutOfRangeException.class)
	  public void test01b()  throws Throwable  {
			GregorianCalendar cal1 = new GregorianCalendar(2018, 1, 1);
			CalDay day1 = new CalDay(cal1);
			GregorianCalendar cal2 = new GregorianCalendar(2018, 2, 1);
			CalDay day2 = new CalDay(cal2);
			GregorianCalendar cal3 = new GregorianCalendar(2019, 2, 1);
			CalDay day3 = new CalDay(cal3);

			Appt appt1 = new Appt(8, 30, 1, 1, 2018, "Jan 1", "testing");
			Appt appt2 = new Appt(14, 0, 1, 2, 2018, "Feb 1", "testing again");

			LinkedList<Appt> allappts = new LinkedList<Appt>();


			TimeTable testtable = new TimeTable();
			testtable.getApptRange(allappts, cal1, cal2);

			day1.addAppt(appt1);
			day2.addAppt(appt2);
			allappts.add(appt1);
			allappts.add(appt2);

			assertEquals(2, allappts.size());

			testtable.getApptRange(allappts, cal1, cal2);

			//out of order
			testtable.getApptRange(allappts, cal2, cal1);
		}
		@Test(expected=DateOutOfRangeException.class)
		public void test02b() throws Throwable{
			GregorianCalendar cal1 = new GregorianCalendar(2018, 1, 1);
			CalDay day1 = new CalDay(cal1);
			GregorianCalendar cal2 = new GregorianCalendar(2018, 2, 1);
			CalDay day2 = new CalDay(cal2);
			GregorianCalendar cal3 = new GregorianCalendar(2019, 3, 1);
			CalDay day3 = new CalDay(cal3);

			Appt appt1 = new Appt(8, 30, 1, 1, 2018, "Jan 1", "testing");
			Appt appt2 = new Appt(14, 0, 1, 2, 2018, "Feb 1", "testing again");
			Appt appt3 = new Appt(13, 0, 1, 2, 2018, "Feb 12", "testing again");
			Appt appt4 = new Appt(7, 0, 1, 2, 2018, "Feb 12", "testing again");
			Appt appt5 = new Appt(-7, 0, 1, 2, 2018, "Feb 12", "testing again");

			TimeTable testtable = new TimeTable();

			LinkedList<Appt> allappts = new LinkedList<Appt>();
			testtable.getApptRange(allappts, cal1, cal2);

			day1.addAppt(appt1);
			day2.addAppt(appt2);
			day2.addAppt(appt3);
			day2.addAppt(appt4);
			allappts.add(appt1);
			allappts.add(appt2);
			allappts.add(appt3);
			allappts.add(appt4);
			allappts.add(appt5);

			assertEquals(5, allappts.size());

			int[] recurDaysArr={2,3};
			appt2.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			testtable.getApptRange(allappts, cal2, cal3);

			appt3.setRecurrence(recurDaysArr, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
			testtable.getApptRange(allappts, cal2, cal3);

			appt4.setRecurrence(recurDaysArr, Appt.RECUR_BY_YEARLY, 1, Appt.RECUR_NUMBER_FOREVER);
			testtable.getApptRange(allappts, cal2, cal3);

			LinkedList<Appt> removedlist = new LinkedList<Appt>();
			removedlist = testtable.deleteAppt(allappts, allappts.get(0));
			//removedlist = testtable.deleteAppt(allappts, allappts.get(1));

			//assertEquals(4, allappts.size());

			Appt nullappt = null;
			allappts.add(nullappt);
			removedlist = testtable.deleteAppt(allappts, allappts.get(5));
			removedlist = testtable.deleteAppt(allappts, allappts.get(4));

			//assertEquals(2, allappts.size());

			testtable.getApptRange(allappts, cal3, cal2);

		}
		//undids
		@Test
		public void test03b() throws Throwable{
			GregorianCalendar cal1 = new GregorianCalendar(2018, 1, 1);
			CalDay day1 = new CalDay(cal1);
			GregorianCalendar cal2 = new GregorianCalendar(2018, 2, 1);
			CalDay day2 = new CalDay(cal2);
			GregorianCalendar cal3 = new GregorianCalendar(2019, 2, 1);
			CalDay day3 = new CalDay(cal3);

			Appt appt1 = new Appt(8, 30, 1, 1, 2018, "Jan 1", "testing");
			Appt appt2 = new Appt(14, 0, 1, 2, 2018, "Feb 1", "testing again");

			LinkedList<Appt> allappts = new LinkedList<Appt>();
			LinkedList<CalDay> alldays = new LinkedList<CalDay>();

			TimeTable testtable = new TimeTable();
			alldays = testtable.getApptRange(allappts, cal1, cal2);

			day1.addAppt(appt1);
			day2.addAppt(appt2);
			allappts.add(appt1);
			allappts.add(appt2);

			//assertEquals(appt1, alldays.get(0).getAppts().get(0));

			int[] pv={0,1};
			LinkedList<Appt> permuted = new LinkedList<Appt>();
			permuted = testtable.permute(allappts, pv);
		}
}
