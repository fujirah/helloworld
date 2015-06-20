package com.woom.others;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import sun.util.resources.LocaleData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuhao.zx on 14-12-20.
 */
public class DateUtils {

    public static void main(String[] args) {
        DateTime startTime = new DateTime(2014,12,14,0,0,0);
        DateTime endTime = new DateTime(2014,12,20,0,0,0);
        System.out.println(DateUtils.howManyWeekends(startTime.toDate(),endTime.toDate()));
    }


    public static int howManyWeekends(Date start,Date end){
//        LocalDate startDate = new LocalDate(start);
//        LocalDate endDate = new LocalDate(end);
        DateTime startDate = new DateTime(start).toDateMidnight().toDateTime();
        DateTime endDate = new DateTime(end).toDateMidnight().toDateTime();
        int days = Days.daysBetween(startDate, endDate).getDays()+1;
        //如果比一天还小，那么返回0
        if(days <= 1)
            return 0;

        int times = days/7;
        int rest = days%7;

        int startw = startDate.dayOfWeek().get();
        int endw = endDate.dayOfWeek().get();

        //这种情况下，首尾星期六和星期天没有连起来，所以不算，需要减去
        if(startw == 7 && endw == 6){
            times--;
        }

        //如果是7倍数，那么直接返回
        if(rest == 0)
            return times;

        //如果剩余的天数能够覆盖星期六和星期天，那么天数+1
        if(startw != 7 && (endw ==7 || startw > endw)){
            times+=1;
        }

        return times;
    }
}
