package com.allianz.pa.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.allianz.pa.common.consant.PolicyConst;
import com.allianz.pa.common.exception.CustomException;

public class DateUtils {
	private static final Logger logger = Logger.getLogger(DateUtils.class);

	private static ThreadLocal tl4yyyyMMdd = new ThreadLocal() {
		protected synchronized Object initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};

	public static Date parse4yyyyMMdd(String textDate) throws ParseException {
		return ((SimpleDateFormat) tl4yyyyMMdd.get()).parse(textDate);
	}

	public static String format4yyyyMMdd(Date date) {
		return ((SimpleDateFormat) tl4yyyyMMdd.get()).format(date);
	}

	private static ThreadLocal tl4yyyyMMddHHmmss = new ThreadLocal() {
		protected synchronized Object initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	public static Date parse4yyyyMMddHHmmss(String textDate) throws ParseException {
		return ((SimpleDateFormat) tl4yyyyMMddHHmmss.get()).parse(textDate);
	}

	public static String format4yyyyMMddHHmmss(Date date) {
		return ((SimpleDateFormat) tl4yyyyMMddHHmmss.get()).format(date);
	}
    /** 计算年龄 */
    public static Integer getAge(Date birthDay,Date startDate){
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }
        
        if(Beans.isNotEmpty(startDate)){
            cal.setTime(startDate);
        }    
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH)+1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                //monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                //monthNow>monthBirth
                age--;
            }
        }
        return age;
    }
    
    /**
     * format "yyyy-MM-dd"
     */
    public static String dateTo0String(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date).trim();
    }
    
    /**
     * format "yyyy-MM-dd HH:mm:ss"
     */
    public static String dateToString(Date date, String format) {
        if (date == null)
            return null;
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date).trim();

    }
    
    public static boolean isLeapYear(Date startDate, Date endDate){
        if(Beans.isEmpty(startDate) || Beans.isEmpty(endDate)){
            throw new CustomException("1357");
        }
        if(startDate.compareTo(endDate) > 0){
            throw new CustomException("1358");
        }
        try {
            String startDateStr = DateUtils.dateTo0String(startDate); //yyyy-MM-dd
            String endDateStr = DateUtils.dateTo0String(endDate);

            Integer startDateYear = Integer.parseInt(startDateStr.substring(0, 4));
            Integer startDateMonth = Integer.parseInt(startDateStr.substring(5, 7));
            Integer startDateDay = Integer.parseInt(startDateStr.substring(8));

            Integer endDateYear = Integer.parseInt(endDateStr.substring(0, 4));
            Integer endDateMonth = Integer.parseInt(endDateStr.substring(5, 7));
            Integer endDateDay = Integer.parseInt(endDateStr.substring(8));

            if (!DateUtils.isLeapYear(startDateYear) && !DateUtils.isLeapYear(endDateYear)) {
                return false;
            } else if (DateUtils.isLeapYear(startDateYear) && !DateUtils.isLeapYear(endDateYear)) {
                if (startDateMonth < 2) {
                    return true;
                } else if (startDateMonth == 2 && startDateDay < 29) {
                    return true;
                }
            } else if (!DateUtils.isLeapYear(startDateYear) && DateUtils.isLeapYear(endDateYear)) {
                if (endDateMonth > 2) {
                    return true;
                } else if (endDateMonth == 2 && endDateDay == 29) {
                    return true;
                }
            } else if (DateUtils.isLeapYear(startDateYear) && DateUtils.isLeapYear(endDateYear)) {
                if (startDateMonth < 2 || endDateMonth > 2) {
                    return true;
                } else if (startDateMonth == 2 && startDateDay < 29) {
                    return true;
                } else if (endDateMonth == 2 && endDateDay == 29) {
                    return true;
                }
            }
        } catch (Exception e) {
            logger.error(e);
            throw new CustomException(PolicyConst.ErrorCode.systemerror.value);
        }
        return false;
    }
    
    public static boolean isLeapYear(int year) {
        return (year % 400) == 0 || ((year % 4) == 0 && (year % 100)!= 0 );
    }
    
    /**
     * @param date1
     * @param date2
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int betweenMonths(String date1, String date2, String pattern) throws ParseException {
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date d1 = sdf.parse(date1);
        Date d2 = sdf.parse(date2);
		return betweenMonths(d1,d1);
    }

    /**
     * @param d1
     * @param d2
     * @return
     */
    public static int betweenMonths(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
	    Calendar c2 = Calendar.getInstance();
	 
	    c1.setTime(d1);
	    c2.setTime(d2);
	    
	    int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
	  //兼容日期大小与参数位置对结果的影响
	    if (year < 0) {
	        year = -year;
	        return year * 12 + c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
	    }
	    return year * 12 + c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
	}
    
    /**
     * dateEnd>dateStart
     * @param dateStart
     * @param dateEnd
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int betweenDays(String dateStart, String dateEnd, String pattern) throws ParseException {
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date d1 = sdf.parse(dateStart);
        Date d2 = sdf.parse(dateEnd);
        return betweenDays(d1,d2);
    }

    public static int betweenDays(Date d1, Date d2) {
    	int days = (int) ((d2.getTime() - d1.getTime()) / (1000*3600*24));
        return days;
    }
}
