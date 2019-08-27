package com.yamhto.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;


/**
 * 扩展 {@link org.apache.commons.lang3.time.DateUtils}，以便于程序的开发。
 * @author licj
 *
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static final String yyyyMMddRegex = "^(?:(?:(?:(?=\\d{2}(?:(?:[02468][048])|(?:[13579][26])))\\d{4}02(?!00)[0-2]\\d))|(?:\\d{4}(?:(?:(?:(?:0[469])|(?:11))(?!00)(?:(?:[0-2]\\d)|(?:30)))|(?:(?:(?:0[13578])|(?:1[02]))(?!00)(?:(?:[0-2]\\d)|(?:3[01])))|(?:02(?!(?:00)|(?:29))[0-2]\\d))))$";

    private static DateFormat DATE_FORMAT_ONE = new SimpleDateFormat("yyyy年MM月dd日");
    public final static SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("yyyyMMdd");
    public final static SimpleDateFormat FORMAT_TIME = new SimpleDateFormat("MMddHHmmss");

	/** 是否月初
	 * @param date
	 * @return
	 */
	public static boolean isFirstDayOfMonth(Date date) {
		return toCalendar(date).get(Calendar.DATE) == 1;
	}
	
	/** 是否季度初
	 * @param date
	 * @return
	 */
	public static boolean isFirstDayOfQuarter (Date date) {
		Calendar cal = toCalendar(date);
		return (cal.get(Calendar.DATE) == 1) && (cal.get(Calendar.MONTH) % 3 == 0);
	}

	/** 季度第一天
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfQuarter(Date date) {
		Calendar cal = toCalendar(date);
		int mon = cal.get(Calendar.MONTH);
		
		// 第1季度
		if (mon >= Calendar.JANUARY && mon <= Calendar.MARCH) {
			cal.set(Calendar.MONTH, Calendar.JANUARY);
		}
		// 第2季度
		if (mon >= Calendar.APRIL && mon <= Calendar.JUNE) {
			cal.set(Calendar.MONTH, Calendar.APRIL);
		}
		// 第3季度
		if (mon >= Calendar.JULY && mon <= Calendar.SEPTEMBER) {
			cal.set(Calendar.MONTH, Calendar.JULY);
		}
		// 第4季度
		if (mon >= Calendar.OCTOBER && mon <= Calendar.DECEMBER) {
			cal.set(Calendar.MONTH, Calendar.OCTOBER);
		}
		cal.set(Calendar.DAY_OF_MONTH, 1);

		return cal.getTime();
	}
	
	/** 季度最后一天
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfQuarter(Date date) {
		Calendar cal = toCalendar(date);
		int mon = cal.get(Calendar.MONTH);
		
		// 第1季度
		if (mon >= Calendar.JANUARY && mon <= Calendar.MARCH) {
			cal.set(Calendar.MONTH, Calendar.MARCH);
			cal.set(Calendar.DAY_OF_MONTH, 31);
		}
		// 第2季度
		if (mon >= Calendar.APRIL && mon <= Calendar.JUNE) {
			cal.set(Calendar.MONTH, Calendar.JUNE);
			cal.set(Calendar.DAY_OF_MONTH, 30);
		}
		// 第3季度
		if (mon >= Calendar.JULY && mon <= Calendar.SEPTEMBER) {
			cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
			cal.set(Calendar.DAY_OF_MONTH, 30);
		}
		// 第4季度
		if (mon >= Calendar.OCTOBER && mon <= Calendar.DECEMBER) {
			cal.set(Calendar.MONTH, Calendar.DECEMBER);
			cal.set(Calendar.DAY_OF_MONTH, 31);
		}

		return cal.getTime();
	}
	
	/** 是否年初
	 * @param date
	 * @return
	 */
	public static boolean isFirstDayOfYear(Date date) {
		Calendar cal = toCalendar(date);
		return cal.get(Calendar.MONTH) == Calendar.JANUARY && cal.get(Calendar.DATE) == 1;
	}
	
	/** 年初第一天
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfYear(Date date) {
		Calendar cal = toCalendar(date);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		return cal.getTime();
	}
	
	/**
	 * <p>目的：比较两个日期的时间间隔</p>
	 * <p>承诺：只允许endDate大于 beginDate，不保证传入小于的响应结果是否准确</p>
	 * @param beginDate 被比较时间
	 * @param endDate 比较时间
	 * @return 时间间隔
	 */
	public static int getBetweenDays(Date beginDate, Date endDate) {
		if (beginDate.compareTo(endDate) > 0) {
			throw new RuntimeException("无法处理的日期比较");
		}
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(beginDate);
		int beginYear = calendar.get(Calendar.YEAR);
		int beginDays = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(endDate);
		int endYear = calendar.get(Calendar.YEAR);
		int endDays = calendar.get(Calendar.DAY_OF_YEAR);
		return endYear > beginYear ? endDays + (calendar.isLeapYear(beginYear) ? 366 : 365) - beginDays :endDays - beginDays;
	}
	
	/*
     * 格式化Date
     */
    public static String dateString(Date time) {
        return FORMAT_DATE.format(time);
    }

    /*
     * 格式化Time
     */
    public static String timeString(Date time) {
        return FORMAT_TIME.format(time);
    }

    /**
     * 获取指定日期的星期 0-星期日 1-星期一 5 - 星期五 6 -星期六
     * 
     * @param date
     * @return
     */
    public static Integer getWeekOfSepcDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * @param date
     * @return
     */
    public static String getWeek(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String week = sdf.format(date);
        return week;
    }

    /**
     * 将账单年月转为日期类型返回当月1号
     * 
     * @param stmtDate
     * @return
     * @throws RuntimeException
     */
    public static Date parseStmtDate(String stmtDate) throws RuntimeException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        sdf.setLenient(false);

        if (stmtDate.length() != 6 || !StringUtils.isNumeric(stmtDate)) {
            throw new RuntimeException();
        }
        try {
            return sdf.parse(stmtDate);
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 获取当前月指定日子的日期
     * 
     * @param specDay
     *            小于等于28 大于等于1
     * @return
     */
    public static Date getCurrMonthSpecDayDate(Date paramDate, int specDay) {
        Calendar c = Calendar.getInstance();
        c.setTime(paramDate);

        c.set(Calendar.DAY_OF_MONTH, specDay);

        return c.getTime();
    }

    /**
     * 获得月底最后一天的日期
     * 
     * @return
     */
    public static Date getLastDayOfMonth(Date batchDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(batchDate);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }

    /**
     * 获得给定两个日期之间相隔的月数，算到日
     * 
     * @param from
     * @param to
     * @return
     */
    public static int getMonthInterval(Date from, Date to) {
        Calendar f = Calendar.getInstance();
        f.setTime(from);
        Calendar t = Calendar.getInstance();
        t.setTime(to);
        int year = t.get(Calendar.YEAR) - f.get(Calendar.YEAR);
        int month = t.get(Calendar.MONTH) - f.get(Calendar.MONTH);
        return year * 12 + month;
    }

    /**
     * 获得两个日期间隔天数
     * 
     * @param from
     * @param to
     * @return
     */
    public static int getIntervalDays(Date from, Date to) {
        long interval = to.getTime() - from.getTime();
        int result = (int) (interval / (1000 * 3600 * 24));
        return result;
    }

    /**
     * 判断给定日期是否月底
     * 
     * @param date
     * @return
     */
    public static boolean isMonthEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        return c.get(Calendar.DATE) == 1;
    }

    /**
     * 判断middDate是否在startDate,endDate区间(startDate<middDate<=endDate)
     * 
     * @param startDate
     * @param middDate
     * @param endDate
     * @return boolean
     */
    public static boolean dateBetwen_IncludeRightEQ(Date startDate, Date middDate, Date endDate) {
        return dateCompare(middDate, startDate) > 0 && dateCompare(endDate, middDate) >= 0;
    }

    /**
     * 判断middDate是否在startDate,endDate区间(startDate<=middDate<=endDate)
     * 
     * @param startDate
     * @param middDate
     * @param endDate
     * @return boolean
     */
    public static boolean dateBetwen_BothSidesEqual(Date startDate, Date middDate, Date endDate) {
        return dateCompare(middDate, startDate) >= 0 && dateCompare(endDate, middDate) >= 0;
    }

    /**
     * 判断middDate是否在startDate,endDate区间(startDate<middDate<endDate)
     * 
     * @param startDate
     * @param middDate
     * @param endDate
     * @return boolean
     */
    public static boolean dateBetwen_BothSidesNoEqual(Date startDate, Date middDate, Date endDate) {
        return dateCompare(middDate, startDate) > 0 && dateCompare(endDate, middDate) > 0;
    }

    /**
     * 得到最近的一个日期 getSoonDate(这里用一句话描述这个方法的作用)
     * 
     * @param date
     * @param cycle
     * @return Date
     * @exception
     * @since 1.0.0
     */
    public static Date getSoonDate(Date date, int cycle) {
        Date nextdate = DateUtils.setDays(date, cycle);
        if (dateCompare(nextdate, date) < 1) {
            return DateUtils.addMonths(nextdate, 1);
        }
        return nextdate;
    }

    /**
     * 日期比较
     * 
     * @param date1
     * @param date2
     * @return int date1 > date2 =1；date1 = date2 =0；date1 <date2 =-1
     * @exception
     * @since 1.0.0
     */
    public static int dateCompare(Date date1, Date date2) {
        return dateCompare(DateFormatUtils.ISO_DATE_FORMAT.format(date1), DateFormatUtils.ISO_DATE_FORMAT.format(date2));
    }

    /**
     * 日期比较(精确到秒)
     * 
     * @param date1
     * @param date2
     * @return int date1 > date2 =1；date1 = date2 =0；date1 <date2 =-1
     * @exception
     * @since 1.0.0
     */
    public static int dateCompareT14(Date date1, Date date2) {
        return dateCompare(DateFormatUtils.ISO_DATETIME_FORMAT.format(date1),
                DateFormatUtils.ISO_DATETIME_FORMAT.format(date2));
    }

    /**
     * 日期比较
     * 
     * @param date1
     * @param date2
     * @return int date1 > date2 =1；date1 = date2 =0；date1 <date2 =-1
     * @exception
     * @since 1.0.0
     */
    public static int dateCompare(String date1, String date2) {
        int i = 0;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        try {
            i = sm.parse(date1).compareTo(sm.parse(date2));
        } catch (ParseException e) {
            throw new RuntimeException("日期字符串无法解析");
        }
        return i;
    }

    /**
     * 判断middDate是否在startDate,endDate区间，包含等于
     * 
     * @param startDate
     * @param middDate
     * @param endDate
     * @return boolean
     * @exception
     * @since 1.0.0
     */
    public static boolean dateBetwen_IncludeEQ(Date startDate, Date middDate, Date endDate) {
        return dateCompare(middDate, startDate) >= 0 && dateCompare(endDate, middDate) >= 0;
    }

    /**
     * 判断middDate是否在startDate,endDate区间，包含等于
     * 
     * @param startDate
     * @param middDate
     * @param endDate
     * @return boolean
     * @exception
     * @since 1.0.0
     */
    public static boolean dateBetwen_IncludeEQ(String startDate, String middDate, String endDate) {
        return dateCompare(middDate, startDate) >= 0 && dateCompare(endDate, middDate) >= 0;
    }

    /**
     * 判断middDate是否在startDate,endDate区间，不包含等于
     * 
     * @param startDate
     * @param middDate
     * @param endDate
     * @return boolean
     * @exception
     * @since 1.0.0
     */
    public static boolean dateBetwen(String startDate, String middDate, String endDate) {
        return dateCompare(middDate, startDate) > 0 && dateCompare(endDate, middDate) > 0;
    }

    /**
     * 判断middDate是否在startDate,endDate区间，不包含等于
     * 
     * @param startDate
     * @param middDate
     * @param endDate
     * @return boolean
     * @exception
     * @since 1.0.0
     */
    public static boolean dateBetwen(Date startDate, Date middDate, Date endDate) {
        return dateCompare(middDate, startDate) > 0 && dateCompare(endDate, middDate) > 0;
    }

    /**
     * 格式化开始日期 startDateStamp
     * 
     * @param date
     * @return Date XXXX-XX-XX:00:00:00
     * @exception
     * @since 1.0.0
     */
    public static Date startDateStamp(Date date) {
        return DateUtils.truncate(date, Calendar.DATE);
    }

    /**
     * 格式化结束日期 endDateStamp
     * 
     * @param date
     * @return Date XXXX-XX-XX:23:59:59
     * @exception
     * @since 1.0.0
     */
    public static Date endDateStamp(Date date) {
        Calendar endday = Calendar.getInstance();
        endday.setTime(date);
        endday.set(Calendar.HOUR_OF_DAY, 23);
        endday.set(Calendar.MINUTE, 59);
        endday.set(Calendar.SECOND, 59);
        return endday.getTime();
    }

    /**
     * Convert a Date into a Calendar object.
     * 
     * @param date
     *            the date to convert to a Calendar
     * @return the created Calendar
     * @throws NullPointerException
     *             if null is passed in
     * @since 2.6
     */
    public static Calendar toCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    /**
     * 获取月份第一天的日期
     */
    public static Date getMontdFirst(Date date) {
        if (date == null)
            return null;
        Calendar c = toCalendar(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return date;
    }

    /**
     * 得到日期中天数,例如20120204返回4
     * 
     * @param date
     * @return day
     */
    public static int getDayOfDate(Date date) {
        int day = 0;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        day = c.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    /**
     * 年月日和月份相加
     * 
     * @param
     * @throws Exception
     */
    public static Date getDateAddMount(Date date, Integer amount) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, amount);
        return rightNow.getTime();
    }

    /**
     * 年份相加
     * 
     * @param
     * @throws Exception
     */
    public static Date getDateAddYear(Date date, Integer amount) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR, amount);
        return rightNow.getTime();
    }

    /**
     * 日期大小比较
     * 
     * @param expiryDate
     * @param
     * @return
     */
    public static boolean isExpiry(Date rescheduleEndDate, Date expiryDate) {
        DateFormat df = new SimpleDateFormat("yyyyMM");
        long expiry = Long.parseLong(df.format(expiryDate));
        long reschedule = Long.parseLong(df.format(rescheduleEndDate));
        return reschedule <= expiry;
    }

    /**
     * 获取时间（参数时间yyyyMMdd+当前时间的时分秒HHmmss）
     * 
     * @param
     * @param
     * @return
     */
    public static Date getParametersDateTime(Date parametersDate) {

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String dateStr1 = df.format(parametersDate);
        DateFormat df2 = new SimpleDateFormat("HHmmss");
        String dateStr2 = df2.format(new Date());
        DateFormat df3 = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        try {
            date = df3.parse(dateStr1 + dateStr2);
        } catch (ParseException ignore) {
            ;
        }
        return date;
    }

    /**
     * 获得与指定日期相加给定天数的日期
     * 
     * @param date
     * @param
     * @return
     */
    public static Date getDayAfter(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day);
        return c.getTime();
    }

    /**
     * 获得与给定日期相差给定月份的日期
     * 
     * @param date
     * @param month
     * @return
     */
    public static Date getMonthAfter(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }

    /**
     * 获得与给定日期相差给定年份的日期
     * 
     * @param date
     * @param year
     * @return
     */
    public static Date getYearAfter(Date date, int year) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, year);
        return c.getTime();
    }

    public static String getYYYYMMDDForDate(Date date) {

        return DATE_FORMAT_ONE.format(date);
    }

    /**
     * 获取指定日期的时间
     * 
     * @param bizDate
     * @return
     */
    public static Date yyyyMMddHHmmss(Date bizDate) {
        // 业务日期
        Calendar biz = Calendar.getInstance();
        biz.setTimeInMillis(bizDate.getTime());
        // 当前时间
        Calendar now = Calendar.getInstance();
        // 设置时分秒
        biz.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY));
        biz.set(Calendar.MINUTE, now.get(Calendar.MINUTE));
        biz.set(Calendar.SECOND, now.get(Calendar.SECOND));

        return biz.getTime();
    }

    /**
     * 获取指定时间
     * 
     * @param hour
     * @param minute
     * @param intervalDays
     * @return
     */
    public static Date makeSpecialTime(int hour, int minute, int second, int intervalDays) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, minute);
        return org.apache.commons.lang3.time.DateUtils.addDays(c.getTime(), intervalDays);
    }

    /**
     * 给的日期所在月的第一天
     * 
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = toCalendar(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }
    
    /**
     * @Description 获取上月天数
     * @param date 指定日期
     * @return
     */
    public static int getLastMonthDays(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 指定时间增加秒数
     * 
     * @param date
     * @param second
     * @return
     */
    public static Date addSecond(Date date, Integer second) {
        Calendar calendar = toCalendar(date);
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * 判断给定的日期是否是当年
     * 
     * @param date
     * @param bizDate
     * @return <b>true:给定的日期为当年 ; false:给定的日期不在当年</b>
     */
    public static boolean isCurrentYear(Date date, Date bizDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(bizDate);
        int currentYear = calendar.get(Calendar.YEAR);
        calendar = toCalendar(date);
        int givenYear = calendar.get(Calendar.YEAR);
        return currentYear == givenYear;
    }

    /**
     * 判断给定的日期是否当季
     * 
     * @param date
     * @param bizDate
     * @return <b>true:给定的日期在当季；false:给定的日期不在当季</b>
     */
    public static boolean isCurrentQuarter(Date date, Date bizDate) {
        Date firstDayOfQuarter = DateUtils.getFirstDayOfQuarter(bizDate);
        Date lastDayOfQuarter = DateUtils.getLastDayOfQuarter(bizDate);
        return date.after(firstDayOfQuarter) && date.before(lastDayOfQuarter);
    }

    /**
     * 判断给定的日期是否在当月
     * 
     * @param date
     * @param bizDate
     * @return <b>true:给定的日期在当月；false:给定的日期不在当月</b>
     */
    public static boolean isCurrentMonth(Date date, Date bizDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(bizDate);
        int currYear = calendar.get(Calendar.YEAR);
        int currMonth = calendar.get(Calendar.MONTH);
        calendar = toCalendar(date);
        int givenYear = calendar.get(Calendar.YEAR);
        int givenMonth = calendar.get(Calendar.MONTH);
        return currYear == givenYear && currMonth == givenMonth;
    }

    /**
     * 判断给定的日期是否为今日
     * 
     * @param date
     * @param bizDate
     * @return <b>true:给定的日期是今日；false:给定的日期不是今日</b>
     */
    public static boolean isCurrentDay(Date date, Date bizDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(bizDate);
        int currYear = calendar.get(Calendar.YEAR);
        int currMonth = calendar.get(Calendar.MONTH);
        int currDay = calendar.get(Calendar.DAY_OF_MONTH);
        calendar = toCalendar(date);
        int givenYear = calendar.get(Calendar.YEAR);
        int givenMonth = calendar.get(Calendar.MONTH);
        int givenDay = calendar.get(Calendar.DAY_OF_MONTH);
        return currYear == givenYear && currMonth == givenMonth && currDay == givenDay;
    }

    /**
     * <p>
     * 日期是否在此区间
     * </p>
     * <p>
     * 精确到毫秒
     * </p>
     * 
     * @param startTime
     *            开始日期
     * @param middleTime
     *            中间日期
     * @param endTime
     *            结束日期
     * @return
     */
    public static boolean isDateBetween(Date startTime, Date middleTime, Date endTime) {
        return middleTime.compareTo(startTime) > 0 && middleTime.compareTo(endTime) < 0;
    }

    /**
     * 19位平台服务流水号 <h1>(年月日时分秒毫秒+2为随机数)<h1>
     * 
     * @return
     */
    public static String getServiceTraceNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String nowdate = sdf.format(new Date());
        int randonstr = (int) (Math.random() * 90) + 10;
        return nowdate + String.valueOf(randonstr);
    }

    /**
     * 使用特定模式将日期对象格式化为字符串
     * 
     * @param date
     * @param pattern
     * @return 格式化后的日期字符串
     * @throws IllegalArgumentException
     *             如果参数日期或模式为空，或者日期模式有误
     */
    public static String formatDate2String(Date date, String pattern) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 获取两个时间段内的所有日期
     * 
     * @param begin大于end 如2015-06-01为begin 2015-05-06为end
     * @throws ParseException
     */
    public static List<Date> getTimeSlot(Date begin, Date end) {
        double between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
        double day = between / (24 * 3600);
        // System.out.println(day+"between"+
        // between+"begin"+begin.getTime()/1000+"end"+end.getTime()/1000);
        int size = (int) day;
        List<Date> timeSlot = new ArrayList<Date>();
        for (int i = 0; i < size; i++) {
            Calendar cd = Calendar.getInstance();
            cd.setTime(begin);
            cd.add(Calendar.DATE, i);// 增加一天
            timeSlot.add(cd.getTime());
        }
        return timeSlot;
    }

    /**
     * 获取两个日期之间相差的天数
     * 
     * @param begin
     * @param end
     * @return
     */
    public static int getBetweenDateNum(Date begin, Date end) {

        begin = org.apache.commons.lang3.time.DateUtils.ceiling(begin, Calendar.DAY_OF_MONTH);
        end = org.apache.commons.lang3.time.DateUtils.ceiling(end, Calendar.DAY_OF_MONTH);
        double between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
        double day = between / (24 * 3600);
        return (int) day;
    }

    /**
     * 判断一个日期字符串是否符合yyyyMMdd格式
     * 
     * @param dateString
     * @return
     */
    public static boolean isyyyyMMddPatternDateString(String dateString) {
        if (StringUtils.isBlank(dateString)) {
            return false;
        }
        return dateString.matches(yyyyMMddRegex);
    }

    public static boolean isyyyyMMddPatternDate(Date date) {
        SimpleDateFormat sfd = new SimpleDateFormat("yyyyMMdd");
        String dataStr = sfd.format(date);
        return isyyyyMMddPatternDateString(dataStr);
    }
    
    /**
     * 
     * @Description 给定日期是否是上旬的最后一天
     * @param date
     * @return
     */
    public static boolean isFirstInquiryLastDay (Date date) {
    	String dates = dateString(date);
    	if ("10".equals(dates.substring(6))) {
    		return true;
    	}
    	
    	return false;
    
    }
    
    
    /**
     * 
     * @Description 是否是中旬的最后一天
     * @param date
     * @return
     */
    public static boolean isMiddleInquiryLastDay (Date date) {
    	String dates = dateString(date);
    	if ("20".equals(dates.substring(6))) {
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * 
     * @Description 是否是下旬的最后一天
     * @param date
     * @return
     */
    public static boolean isThirdInquiryLastDay (Date date) {
    	
    	return isMonthEnd(date);
    }
    
    /**
     * 
     * @Description 是否是询末
     * @param date
     * @return
     */
    public static boolean isInquiryLastDay (Date date) {
    	if (isFirstInquiryLastDay(date)) {
    		return true;
    	}
    	
    	if (isMiddleInquiryLastDay(date)) {
    		return true;
    	}
    	
    	if (isThirdInquiryLastDay(date)) {
    		return true;
    	}
    	
    	return false;
    }
    
    public static Timestamp endTime(String endTime) {
	    String str = endTime.toString() + " 23:59:59";
	    return Timestamp.valueOf(str);
	}

	public static Timestamp startTime(String startTime) {
	    String str = startTime.toString() + " 00:00:00";
	    return Timestamp.valueOf(str);
	}
}
