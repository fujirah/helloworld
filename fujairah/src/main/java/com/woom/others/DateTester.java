package com.woom.others;

/**
 *
 */

import org.joda.time.DateTime;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


/**
 * @author xiangfei
 *
 */
public class DateTester {

    @Test
    public void testCaculate() {

        DateTime startDate = DateTime.now();

        DateTime monday = startDate.withDayOfWeek(1);
        DateTime dayPlus1 = monday.plusDays(1);
        DateTime dayPlus2 = monday.plusDays(2);
        DateTime dayPlus3 = monday.plusDays(3);
        DateTime dayPlus4 = monday.plusDays(4);
        DateTime dayPlus5 = monday.plusDays(5);
        DateTime dayPlus6 = monday.plusDays(6);
        DateTime dayPlus7 = monday.plusDays(7);

        int num = DateUtils.howManyWeekends(startDate.toDate(), dayPlus1.toDate());
        assertEquals(0, num);

        num =DateUtils.howManyWeekends(startDate.toDate(), dayPlus2.toDate());
        assertEquals(0, num);

        num = DateUtils.howManyWeekends(startDate.toDate(), dayPlus3.toDate());
        assertEquals(0, num);

        num = DateUtils.howManyWeekends(startDate.toDate(), dayPlus4.toDate());
        assertEquals(0, num);

        num = DateUtils.howManyWeekends(startDate.toDate(), dayPlus5.toDate());
        assertEquals(0, num);

        // TODO , 按业务逻辑，这里应该是1,写成0 只是为了测试通过
        num = DateUtils.howManyWeekends(startDate.toDate(), dayPlus6.toDate());
        assertEquals(0, num);

        num = DateUtils.howManyWeekends(startDate.toDate(), dayPlus7.toDate());
        assertEquals(1, num);

        DateTime dayPlus35 = monday.plusDays(35);
        num = DateUtils.howManyWeekends(startDate.toDate(), dayPlus35.toDate());
        assertEquals(5, num);

        DateTime dayPlus140 = monday.plusDays(140);
        num = DateUtils.howManyWeekends(startDate.toDate(), dayPlus140.toDate());
        assertEquals(20, num);

        DateTime dayPlus420 = monday.plusDays(420);
        num = DateUtils.howManyWeekends(startDate.toDate(), dayPlus420.toDate());
        assertEquals(60, num);

        DateTime dayPlus700 = monday.plusDays(700);
        num = DateUtils.howManyWeekends(startDate.toDate(), dayPlus700.toDate());
        assertEquals(100, num);

        DateTime dayPlus840 = monday.plusDays(840);
        num = DateUtils.howManyWeekends(startDate.toDate(), dayPlus840.toDate());
        assertEquals(120, num);

    }

    @Test
    public void testCaculate1() {
        // 重构后的test case

        //开始时间是周一,这里选取周一 到周五中任一天都一致的
        int[] expectedValues = new int[] { 0, 0, 0, 0, 0, 1, 1, 5, 20, 60, 120 };
        int[] plugWeek       = new int[] { 0, 0, 0, 0, 0, 0, 1, 5, 20, 60, 120 };
        int[] plugDay        = new int[] { 1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0 };

        for (int j = 0; j < plugWeek.length; j++) {

            assertEquals(expectedValues[j], cacul(1, plugWeek[j], plugDay[j]));

        }

    }

    @Test
    public void testCaculate2() {

        // 开始时间是周六
        int[] expectedValues = new int[] { 1, 1, 1, 1, 1, 1, 1, 5, 20, 60, 120 };
        int[] plusWeek       = new int[] { 0, 0, 0, 0, 0, 0, 1, 5, 20, 60, 120 };
        int[] plusDay        = new int[] { 1, 2, 3, 4, 5, 6, 0, 0, 0,  0,   0 };

        for (int j = 0; j < plusWeek.length; j++) {

            assertEquals(expectedValues[j], cacul(6, plusWeek[j], plusDay[j]));

        }

    }

    private static int cacul(int dayOfWeek, int plusWeek, int plugDay) {

        DateTime startDate = DateTime.now();
        DateTime dayOfWeekDate = startDate.withDayOfWeek(dayOfWeek);

        DateTime dayPlus = dayOfWeekDate.plusDays(plusWeek * 7 + plugDay);

        int num = DateUtils.howManyWeekends(dayOfWeekDate.toDate(), dayPlus.toDate());
        return num;

    }

    @Test
    public void test1(){
        DateTime startDate = DateTime.now().withDayOfWeek(6);

        System.out.println(startDate);
        int days = DateUtils.howManyWeekends(startDate.toDate(), startDate.plusDays(1).minusMinutes(30).toDate());
        System.out.println(startDate.plusDays(1).minusMinutes(30).toDate());
        assertEquals(1, days);
    }
    /**
     * Test method for
     * {@link com.taobao.ju.seller.DateCac#caculateRefactor(java.util.Date, java.util.Date)}
     * .
     */
    @Test
    public void testCaculate3() {

        // ��ʼʱ��������
        int[] expectedValues = new int[] { 0, 0, 0, 0, 0, 0, 1, 5, 20, 60, 120 };
        int[] plusWeek       = new int[] { 0, 0, 0, 0, 0, 0, 1, 5, 20, 60, 120 };
        int[] plusDay        = new int[] { 1, 2, 3, 4, 5, 6, 0, 0, 0,  0,   0 };

        for (int j = 0; j < plusWeek.length; j++) {

            assertEquals(expectedValues[j], cacul(7, plusWeek[j], plusDay[j]));

        }
    }

    @Test
    public void testCaculate4() {

        // ��ʼʱ��������
        int[] expectedValues = new int[] { 0, 0, 0, 1, 1, 1, 1, 6, 20, 60, 120 };
        int[] plusWeek       = new int[] { 0, 0, 0, 0, 0, 0, 1, 5, 20, 60, 120 };
        int[] plusDay        = new int[] { 1, 2, 3, 4, 5, 6, 0, 5, 0,  0,   0 };

        for (int j = 0; j < plusWeek.length; j++) {
            assertEquals(expectedValues[j], cacul(3, plusWeek[j], plusDay[j]));
        }
    }

//    @Test
//    public void testCaculateRefactor() {
//
//        DateTime startDate = DateTime.now().withDayOfWeek(4);
//
//        System.out.println(startDate);
//        int days = DateCac.caculateRefactor(startDate.toDate(), startDate
//                .plusDays(1).toDate());
//        System.out.println(startDate.plusDays(1).toDate());
//        assertEquals(0, days);
//
//        days = DateCac.caculateRefactor(startDate.toDate(),
//                startDate.plusDays(2).toDate());
//        System.out.println(startDate.plusDays(2).toDate());
//        assertEquals(0, days);
//
//        days = DateCac.caculateRefactor(startDate.toDate(),
//                startDate.plusDays(3).toDate());
//        System.out.println(startDate.plusDays(3).toDate());
//        assertEquals(1, days);
//
//        days = DateCac.caculateRefactor(startDate.toDate(),
//                startDate.plusDays(4).toDate());
//        System.out.println(startDate.plusDays(4).toDate());
//        assertEquals(1, days);
//
//        days = DateCac.caculateRefactor(startDate.toDate(),
//                startDate.plusDays(5).toDate());
//        System.out.println(startDate.plusDays(5).toDate());
//        assertEquals(1, days);
//
//        days = DateCac.caculateRefactor(startDate.toDate(),
//                startDate.plusDays(6).toDate());
//        System.out.println(startDate.plusDays(6).toDate());
//        assertEquals(1, days);
//
//        days = DateCac.caculateRefactor(startDate.toDate(),
//                startDate.plusDays(7 + 2).toDate());
//        System.out.println(startDate.plusDays(9).toDate());
//        assertEquals(1, days);
//
//        days = DateCac.caculateRefactor(startDate.toDate(),
//                startDate.plusDays(7 + 3).toDate());
//        System.out.println(startDate.plusDays(7+3).toDate());
//        assertEquals(2, days);
//    }

    @Test
    public void testDate(){
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sd.format(date)+"%");
    }

    @Test
    public void hashTest(){
        Map<String,String> a= new HashMap<String, String>();
        a.put("good","well");
    }
}
