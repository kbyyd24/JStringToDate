package cn.edu.swpu.cins;

import java.sql.Date;
import java.util.Calendar;

/**
 * Transform String to Date
 * @author gaoyx
 *
 */
public class DateTransfer {
	
	public static final boolean longType = false;
	
	public static final boolean formatType = true;
	
	private String date;
	private boolean type;
	private String regex;
	
	private long time;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	
	/**
	 * Default type is false, means the date is an Unix time stamp
	 * @param date the String need to transform
	 */
	public DateTransfer(String date) {
		this.date = date;
	}
	
	/**
	 * Set the date and the type
	 * @param date the String need to transform
	 * @param type the given DateTransfer field
	 */
	public DateTransfer(String date, boolean type) {
		this.date = date;
		this.type = type;
	}
	
	/**
	 * Set the date , the type and the regex for date
	 * @param date the String need to transform
	 * @param type the given DateTransfer field
	 * @param the regex to split date
	 */
	public DateTransfer(String date, boolean type, String regex) {
		this.date = date;
		this.type = type;
		this.regex = regex;
	}
	
	/**
	 * execute transfer action
	 */
	public void transform() {
		if (type) {
			splitDate();
		} else {
			time = Long.parseLong(date);
		}
	}
	
	private void splitDate() {
		String[] values = date.split(" ");
		this.setDay(values[0]);
		if (values.length == 2)
			this.setTime(values[1]);
		else
			this.setTime("00:00:00");
	}

	private void setDay(String day) {
		String[] values = day.split(regex);
		this.year = Integer.parseInt(values[0]);
		this.month = Integer.parseInt(values[1]);
		this.day = Integer.parseInt(values[2]);
	}
	
	private void setTime(String time) {
		String[] values = time.split(":");
		this.hour = Integer.parseInt(values[0]);
		this.minute = Integer.parseInt(values[1]);
		this.second = Integer.parseInt(values[2]);
	}
	
	/**
	 * get Unix time stamp
	 * @return Unix time stamp
	 */
	public long getTime() {
		return time;
	}
	
	/**
	 * get Date instance
	 * @return date instance
	 */
	public Date getDate() {
		return new Date(time);
	}
	
	/**
	 * get Calendar instance
	 * @return calendar instance
	 */
	public Calendar getCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDate());
		return calendar;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public int getSecond() {
		return second;
	}
}
