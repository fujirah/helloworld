package tooltest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.woom.tools.algorithm.Utils.DataUnit;
import com.woom.tools.common.json.JsonBO;
import com.woom.tools.common.json.JsonUtil;
import com.woom.tools.orginal.math.MathUtils;
import com.woom.tools.orginal.thread.Entity;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuhao.zx on 15-1-5.
 */
public class FooTester extends TestCase {
    private  static final double LOW_RATIO = 0.8;

    @Test
    public void testFoo(){
//        System.out.println("[{\"name\":\"\u4e09\u73af\u4ee5\u5185\",\"id\":2799},{\"name\":\"\u4e09\u73af\u5230\u56db\u73af\u4e4b\u95f4\",\"id\":2819},{\"name\":\"\u56db\u73af\u5230\u4e94\u73af\u4e4b\u95f4\",\"id\":2839},{\"name\":\"\u4e94\u73af\u5230\u516d\u73af\u4e4b\u95f4\",\"id\":2840},{\"name\":\"\u7ba1\u5e84\",\"id\":4137},{\"name\":\"\u5317\u82d1\",\"id\":4139},{\"name\":\"\u5b9a\u798f\u5e84\",\"id\":4211}]");
//        String a = "{DEDUCT:{exchangeCommFee:1010684,freeCommFee:0,id:2896709,refundExchangeFee" +
//                ":50,refundFreeFee:0,shouldDeductFee:0,shouldRefundFee:0}}";
//        System.out.println(a.length());

//        StringBuilder a = new StringBuilder();
//        a.append("112");
//        a.append("we23,");
//        a.deleteCharAt(a.length()-1);
//        System.out.println(a.toString());
//        System.out.println("\65533");
        String attr = "{\"DEDUCT\":{\"exchangeCommFee\":157931,\"freeCommFee\":0,\"id\":3127050,\"shouldDeductFee\":0},\"REFUND\":{\"exchangeCommFee\":159237,\"freeCommFee\":0,\"id\":3127050,\"shouldDeductFee\":0}}";
        Map<String,Object> rs1 = JsonUtil.json2Map(attr,Object.class);
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        rs1.put("test1",s.format(new Date()));
        System.out.println(JsonUtil.map2Json(rs1));
    }
    @Test
    public void testPriority(){
        Comparator<Integer> comparator = new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                if(a > b) {
                    return 1;
                }else if(a < b){
                    return -1;
                }
                return 0;
            }
        };
        Queue<Integer> priorityQueue =  new PriorityQueue<Integer>(81,comparator);
        priorityQueue.add(45);
        priorityQueue.add(99);
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(4);
        priorityQueue.add(11);
        priorityQueue.remove(3);
        priorityQueue.add(2);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

    }
    @Test
    public void test234234() throws Exception {
//        System.out.println("sdfasdf,".substring(0,"sdfasdf,".length()-1));
//        System.out.println(Long.valueOf(" 3343 4343".trim()));
        try {
            throw new Exception();
        }catch (Exception e){
            throw e;
        }
    }
    @Test
    public void testEquals(){
        Long a = 1000L;
        Assert.assertTrue(!a.equals(1000));
        Assert.assertTrue(a.equals(1000L));
        Assert.assertTrue(a==1000);
        Assert.assertTrue(a==1000L);
    }


    @Test
    public void testDouble(){
        Long a = 8000L;
        Long b = 10000L;
        double rs = (double)a/(double)b;
        Assert.assertTrue(rs >= LOW_RATIO);
        System.out.println(rs);
        a = 7999L;
        rs = (double)a/(double)b;
        Assert.assertTrue(rs < LOW_RATIO);
        System.out.println(rs);
    }

    /**
     * 测试表明：double*Long=double
     */
    @Test
    public void testX(){
        Long a = 9999L;
        Double b = 0.9;
        System.out.println(a*b);
    }

    @Test
    public void testListRemove(){
        List<String> list = new LinkedList();
        Assert.assertTrue(list.isEmpty());
        list.add("good");
        Assert.assertTrue(list.size()==1);
        Assert.assertTrue(list.get(0).equals("good"));
        list.add("bad");
        Assert.assertTrue(list.size()==2);
        list.remove(0);
        Assert.assertTrue(list.size()==1);
        Assert.assertTrue(list.get(0).equals("bad"));
    }

    @Test
    public void testDouble1(){
        double rs = computer(299L,600000L,12L,12L);
        System.out.println(rs);
    }

    private Double computer(Long ratio,Long baseFee,Long itemPrice,Long itemNum){
        double up;

        if(baseFee == null){
            baseFee = 0L;
        }

        if(ratio == null || ratio <= 0L){
            return (double)baseFee / 100;
        }

        up = itemPrice * itemNum * (double)ratio / 10000 + baseFee / 100;
        return  up;
    }


    public final static int    DEPOSITDETAIL_OPERATE_FREEZING_APPEND = 10;
    @Test
    public void testEquals1(){
        Integer a = new Integer(10);
        Assert.assertTrue(a == DEPOSITDETAIL_OPERATE_FREEZING_APPEND);

    }

    @Test
    public void testMathUtils(){
        BigDecimal bd = MathUtils.convertRatioToDisplay(1000);
        System.out.println(bd.toString());
    }

    @Test
    public void testHashMap(){
        Map<Entity,Integer> map = new HashMap<Entity, Integer>();
        for(int i = 0;i<100;i++)
            map.put((new Entity((int)Math.random()*100)),(int)(Math.random()*10)) ;
        System.out.println(map.size());
        map.put((new Entity((int)Math.random()*100)),(int)(Math.random()*10)) ;
        LinkedList<String> list = new LinkedList<String>();
        list.add("good");
        list.add("gooddf");
        list.add("gooddf");
        System.out.println(list.size());
    }

    @Test
    public void testHashMapPut(){
//        Map<String,String> map = new ConcurrentHashMap<String, String>();
//        map.put("hello",null);

        Map<String,String> map1 = new HashMap<String, String>();
        map1.put("hello",null);
    }
    @Test
    public void testConCurrentHashmap(){
        Map<String,String> map = new ConcurrentHashMap<String, String>();
        map.get("1000");
    }

    @Test
    public void testNullAddString(){
        Integer a = null;
        System.out.println(a+"_Switch");
    }

    @Test
    public void testListAdd(){
        List<String> str = new ArrayList<String>();
        List<String> str2 = new ArrayList<String>();
        str.add("good");
        str.add("bad");
        str2.add("nice");
        str2.add("well");
        List<String> str3 = new LinkedList<String>();
        str3.addAll(str);
        str3.addAll(str2);
        System.out.println(str3);
    }

    @Test
    public void testFastJson(){
        JsonBO jb = new JsonBO();
        jb.setBaseFee("11000");
        jb.setTopFee(0L);
        jb.setName("name");

        JsonBO jb1 = new JsonBO();
        jb1.setBaseFee("dfasf");
        jb1.setTopFee(50L);
        jb1.setName("fas");


        Map<String,JsonBO> map = new HashMap<String, JsonBO>();
        map.put("key1",jb);
        map.put("key2",jb1);
        String rs = JSONObject.toJSONString(map);
        System.out.println(rs);

        Map<String,JsonBO> r = JsonUtil.json2Map(rs,JsonBO.class);
        System.out.println(r.get("key1").getName());
        System.out.println(r.get("key2").getName());
    }

    @Test
    public void testCast(){
        BigDecimal b   =   new   BigDecimal(3829.6242000000007);
        System.out.println(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

}
