package org.doggytty.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created by doggy on 17-6-27.
 */
public class DateUtils {

    // 给定日期是否在90天以内
    public static boolean isIn90(Date t) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        long nowTime = todayEnd.getTimeInMillis();
        long preTime = t.getTime();
        //90 * 86400 * 1000L;
        return nowTime - preTime < 7776000000L;
    }


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date t1 = sdf.parse("2017-05-01 16:32:24");
        boolean result = DateUtils.isIn90(t1);
        System.out.println(result);

        System.out.println(StringUtils.isAlpha("asdfjasdf"));
        System.out.println(StringUtils.isAlpha("极大#好地方"));
    }

}
