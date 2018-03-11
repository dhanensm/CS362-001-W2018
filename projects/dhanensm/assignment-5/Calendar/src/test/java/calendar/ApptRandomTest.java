package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
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
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {

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
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}
				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		 System.out.println("Done testing...");
	 }
	 @Test //(expected=ArrayIndexOutOfBoundsException.class)
		public void randomtest02()  throws Throwable  {

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
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
						 if (methodName.equals("setTitle")){
							 String newTitle=(String) ValuesGenerator.getString(random);
							 appt.setTitle(newTitle);
						}
						 else if (methodName.equals("setRecurrence")){
							 int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
							 int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
							 int recur=ApptRandomTest.RandomSelectRecur(random);
							 int recurIncrement = ValuesGenerator.RandInt(random);
							 int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
							 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}
				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
							if((iteration%10000)==0 && iteration!=0 )
										System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		 System.out.println("Done testing...");
	 }
	 @Test //(expected=ArrayIndexOutOfBoundsException.class)
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
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -10, 70);
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
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
						 if (methodName.equals("setTitle")){
							 String newTitle=(String) ValuesGenerator.getString(random);
							 appt.setTitle(newTitle);
						}
						 else if (methodName.equals("setRecurrence")){
							 int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
							 int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
							 int recur=ApptRandomTest.RandomSelectRecur(random);
							 int recurIncrement = ValuesGenerator.RandInt(random);
							 int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
							 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}
				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
							if((iteration%10000)==0 && iteration!=0 )
										System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		 System.out.println("Done testing...");
	 }
	 @Test //(expected=ArrayIndexOutOfBoundsException.class)
	 public void randomtest04()  throws Throwable  {

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
			if(!appt.getValid())continue;
		 for (int i = 0; i < NUM_TESTS; i++) {
				 String methodName = ApptRandomTest.RandomSelectMethod(random);
						if (methodName.equals("setTitle")){
							String newTitle=(String) ValuesGenerator.getString(random);
							appt.setTitle(newTitle);
					 }
						else if (methodName.equals("setRecurrence")){
							int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
							int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
							int recur=ApptRandomTest.RandomSelectRecur(random);
							int recurIncrement = ValuesGenerator.RandInt(random);
							int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
							appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
					 }
			 }

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
						 if((iteration%10000)==0 && iteration!=0 )
									 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

		 }
	 }catch(NullPointerException e){

	 }

		System.out.println("Done testing...");
	}
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void randomtest05()  throws Throwable  {

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
			 int startMonth=ValuesGenerator.getRandomIntBetween(random, -10, 30);
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
		 if(!appt.getValid())continue;
		for (int i = 0; i < NUM_TESTS; i++) {
				String methodName = ApptRandomTest.RandomSelectMethod(random);
					 if (methodName.equals("setTitle")){
						 String newTitle=(String) ValuesGenerator.getString(random);
						 appt.setTitle(newTitle);
					}
					 else if (methodName.equals("setRecurrence")){
						 int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						 int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						 int recur=ApptRandomTest.RandomSelectRecur(random);
						 int recurIncrement = ValuesGenerator.RandInt(random);
						 int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
					}
			}

			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
						if((iteration%10000)==0 && iteration!=0 )
									System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

		}
	}catch(NullPointerException e){

	}

	 System.out.println("Done testing...");
 	}
	//check setRecurDays
	@Test
	 public void randomtest06()  throws Throwable  {

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
			if(!appt.getValid())continue;
		 for (int i = 0; i < NUM_TESTS; i++) {
				 String methodName = ApptRandomTest.RandomSelectMethod(random);
						if (methodName.equals("setTitle")){
							String newTitle=(String) ValuesGenerator.getString(random);
							appt.setTitle(newTitle);
					 }
						else if (methodName.equals("setRecurrence")){
							int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
							int[] recurDays= null;	//ValuesGenerator.generateRandomArray(random, sizeArray);
							int recur=ApptRandomTest.RandomSelectRecur(random);
							int recurIncrement = ValuesGenerator.RandInt(random);
							int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
							appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
					 }
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
	  public void test01b()  throws Throwable  {
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
	 public void test02b()  throws Throwable  {
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
	 public void test03b()  throws Throwable  {
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
	 public void test04b()  throws Throwable  {
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
	  public void test05b()  throws Throwable  {
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
	  public void test06b()  throws Throwable  {
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
 	  public void test07b()  throws Throwable  {
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
		public void test08b() throws Throwable {
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
	public void test10b() throws Throwable{
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
	public void test11b() throws Throwable{
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
	public void test12b() throws Throwable{
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
