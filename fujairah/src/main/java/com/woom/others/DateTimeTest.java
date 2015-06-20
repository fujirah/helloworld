package com.woom.others;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yuhao.zx on 15-5-7.
 */
public class DateTimeTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        SimpleDateFormat sdf1 =
                new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date day = sdf.parse("2015-04-15 23:00:00");
            calendar.setTime(day);
            calendar.add(Calendar.DAY_OF_MONTH, 31);
            String top = sdf1.format(calendar.getTime());
            top += " 00:00:00";
            Date d = sdf.parse(top);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
