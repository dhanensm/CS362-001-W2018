package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
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

			testtable.getApptRange(allappts, cal1, cal2);
			//out of order
			testtable.getApptRange(allappts, cal2, cal1);
		}
		@Test
		public void test02() throws Throwable{
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

			Appt nullappt = null;
			allappts.add(nullappt);
			removedlist = testtable.deleteAppt(allappts, allappts.get(5));
			removedlist = testtable.deleteAppt(allappts, allappts.get(4));

			testtable.getApptRange(allappts, cal3, cal2);

		}
		@Test
		public void test03() throws Throwable{
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

			int[] pv={1,2};
			LinkedList<Appt> permuted = new LinkedList<Appt>();
			permuted = testtable.permute(allappts, pv);
		}

//add more unit tests as you needed
}
