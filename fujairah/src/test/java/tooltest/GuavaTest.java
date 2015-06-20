package tooltest;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.*;
import com.google.common.math.DoubleMath;
import com.google.common.math.IntMath;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
* Created by yuhao.zx on 2015/4/6.
*/
public class GuavaTest extends TestCase{

    @Test
    public void testMath(){
        boolean rs = DoubleMath.isPowerOfTwo(1024D);
        boolean rs2 = DoubleMath.isPowerOfTwo(1025D);
        Assert.assertTrue(rs);
        Assert.assertTrue(!rs2);
        BigInteger bi = DoubleMath.roundToBigInteger(12.33, RoundingMode.UP);
        Assert.assertTrue(bi.equals(new BigInteger("13")));

        //阶乘
        System.out.println(DoubleMath.factorial(3));

        Assert.assertTrue(DoubleMath.log2(8)==3);

        //第二个参数是对结果取整
        System.out.println(DoubleMath.log2(8.55,RoundingMode.HALF_DOWN));

        //判断是否存在小数
        System.out.println(DoubleMath.isMathematicalInteger(12d));
        System.out.println(DoubleMath.isMathematicalInteger(12.000000004000000000001d));

        //计算均差，保留4位有效数字
        System.out.println(DoubleMath.mean(12,21,22,33.1332));

        System.out.println(IntMath.checkedAdd(1999999999,1999999999));


    }

    @Test
    public void testJoiner(){
        Joiner joiner = Joiner.on("; ").skipNulls();

        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));


    }
    @Test
    public void testCache() throws  Exception{
        LoadingCache<String, String> map = CacheBuilder.newBuilder()
        .maximumSize(1000)
        .expireAfterWrite(2, TimeUnit.SECONDS)
        .build(new CacheLoader<String, String>() {
            public String load(String key) throws Exception {
                return "from data base";
            }
        });

        map.put("key", "value");
        Thread.sleep(1000);
        System.out.println(map.get("key"));
        Thread.sleep(1000);
        System.out.println(map.get("key"));
        Objects.hashCode("key");

    }
    @Test
    public void testImmutableSet(){
        ImmutableSet<String> immSet = ImmutableSet.of("time","life");


        ImmutableSet.Builder<String> builder = ImmutableSet.builder();
        ImmutableSet<String> immutableSet = builder.add("RED").addAll(immSet).build();

        immSet.add("dsf");

//        ImmutableList.of()
    }

    @Test
    public void testMultiSet(){
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("you");
        multiset.add("you");
        multiset.add("and");
        multiset.add("me");
        multiset.add("me");
        System.out.println(multiset.count("me"));
    }

    @Test
    public void testHashMulti(){
        HashMultimap<String,String> multimap = HashMultimap.create();
        multimap.put("t1","name1");
        multimap.put("t1","name2");

        System.out.println(multimap.get("t1"));
    }

    @Test
    public void testBiMap(){
        //键唯一，值也唯一
        HashBiMap<String,String> hashBiMap = HashBiMap.create();
        hashBiMap.put("1sname","yuhao");
        String name = hashBiMap.inverse().get("yuhao");
        System.out.println(name);
        hashBiMap.put("2sname","yuhao");

    }

    @Test
    public void testMapMakerMaximumSize(){
//        ConcurrentMap<String, Object> map1 =
//                new MapMaker().concurrencyLevel(32).maximumSize(4).makeMap();
//        map1.put("name1",1);
//        map1.put("name2",2);
//        map1.put("name3",3);
//        map1.put("name4",4);
//        System.out.println(map1.keySet());

    }

    @Test
    public void testMapMakeRexpiration() throws Exception{
//        ConcurrentMap<String, Object> map1 = new MapMaker().concurrencyLevel(32).
//                expireAfterWrite(3, TimeUnit.SECONDS).makeComputingMap(new Function<String, Object>() {
//            @Override
//            public Object apply(String input) {
//                System.out.println("obtain data from DB");
//                return 999;
//            }
//        });
//        map1.put("key1",1);
//        map1.put("key2",2);
//        map1.put("key3",3);
//        map1.put("key4",4);
//
//        System.out.println("key1:"+map1.get("key1"));
//
//        Thread.sleep(2000);
//
///        System.out.println("key1:"+map1.get("key1"));
//
//        Thread.sleep(2000);
///
//        System.out.println("key1:"+map1.get("key1"));

    }

    @Test
    public void testMapMakeWeakValues(){
        ConcurrentMap<Object, Object> map1 = new MapMaker().concurrencyLevel(32).weakValues().makeMap();
        Date now = new Date();
        Object key = new Object();
        map1.put(key,now);
        now = null;
//        key = null;
        System.out.println(map1.keySet());
        System.gc();
        System.out.println(map1.keySet());
    }

    @Test
    public void testMapMakeEvictionListener() throws Exception{
//        MapEvictionListener mapEvictionListener = new MapEvictionListener() {
//            @Override
//            public void onEviction(Object key, Object value) {
//                System.out.println("key="+key+"is evicted, do something else?");
//            }
//        };
//        ConcurrentMap<Object, Object> map1 = new MapMaker().concurrencyLevel(32).weakKeys().
//                evictionListener(mapEvictionListener).makeMap();
//
//        Date now = new Date();
//        Object key = new Object();
//        Object key1 = new Object();
//
//        map1.put(key,now);
//        map1.put(key1,now);
//
//        key = null;
//        key1= null;
//        System.out.println(map1.keySet());
//
//        System.gc();
//
//        System.out.println(map1.keySet());
//
//        while (true){
//
//        }
    }


    @Test
    public void testCollections(){
        System.out.println("集合的排序和比较");
        List<Integer> list = new ArrayList<Integer>();
        list.add(6);
        list.add(8);
        list.add(1);
        list.add(7);
        list.add(3);
        Collections.sort(list,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return ComparisonChain.start().compare(o1, o2).result();
            }
        });

        for(Integer ele : list){
            System.out.println(ele);
        }

        Comparator<Foo> comparator1 = new Comparator<Foo>() {
            @Override
            public int compare(Foo o1, Foo o2) {
                if(o1.sex > o2.sex){
                    return 1;
                }else{
                    return -1;
                }
            }
        };

        Comparator<Foo> comparator2 = new Comparator<Foo>() {
            @Override
            public int compare(Foo o1, Foo o2) {
                if(o1.age > o2.age){
                    return 1;
                }else{
                    return -1;
                }
            }
        };

        //应该注意填写顺序
        Ordering<Foo> order = Ordering.compound(Arrays.asList(comparator1,comparator2));

        List<Foo> foolist = new ArrayList<Foo>();
        foolist.add(new Foo(1,34));
        foolist.add(new Foo(2,31));
        foolist.add(new Foo(1,99));
        foolist.add(new Foo(2,55));

        Collections.sort(foolist,order);




        for(Foo ele : foolist){
            System.out.println(ele.sex+" "+ele.age);
        }

        //对collection集合的数据操作会直接对foolist进行操作
        Collection<Foo> collection = Collections2.filter(foolist, new Predicate<Foo>() {
            @Override
            public boolean apply(Foo input) {
                if(input.sex == 1){
                    return false;
                }
                return true;
            }
        });


//        collection.remove(foo1);

        System.out.println("---------------------");
        for(Foo ele : collection){
            System.out.println(ele.sex+" "+ele.age);
        }
        System.out.println("---------------------");

        //不合理的添加会抛异常：java.lang.IllegalArgumentException
//        collection.add(new Foo(1,100));
        collection.add(new Foo(2,100));
        for(Foo ele : collection){
            System.out.println(ele.sex+" "+ele.age);
        }

        Collection<Foo1> revert = Collections2.transform(collection, new Function<Foo, Foo1>() {
            @Override
            public Foo1 apply(Foo input) {
                return new Foo1("性别："+ (input.sex==1?"男":"女"),"年龄："+ input.age);
            }
        });


        //小心坑了，任何宿主对象的改动将影响生成的集合
        collection.add(new Foo(2,9889));
        for(Foo1 ele : revert){
            System.out.println(ele.sex+" "+ele.age);
        }

    }

    @Test
    public void testFilter(){
        List<Foo> foolist = new ArrayList<Foo>();
        foolist.add(new Foo(1,34));
        foolist.add(new Foo(2,31));
        foolist.add(new Foo(1,99));
        foolist.add(new Foo(2,55));
        Collection<Foo> collection = Collections2.filter(foolist, new Predicate<Foo>() {
            @Override
            public boolean apply(Foo input) {
                if(input.sex == 1){
                    return false;
                }
                return true;
            }
        });

        for(Foo ele : collection){
            System.out.println(ele.sex+" "+ele.age);
        }

    }
    @Test
    public void testtransform(){

    }


    public void testOrdering(){
        List<Foo> foolist = new ArrayList<Foo>();
        foolist.add(new Foo(1,34));
        foolist.add(new Foo(2,31));
        foolist.add(new Foo(1,99));
        foolist.add(new Foo(2,55));
        Collections.sort(foolist,new Comparator<Foo>(){
            @Override
            public int compare(Foo o1, Foo o2) {
                return ComparisonChain.start()
                        .compare(o1.sex, o2.sex)
                        .compare(o1.age,o2.age).result();
            }
        });
    }


    class Foo{

        //1:男   2:女
        Integer sex;

        Integer age;

        Foo(Integer sex,Integer age){
            this.sex = sex;
            this.age = age;
        }
    }

    class Foo1{

        //1:男   2:女
        String sex;

        String age;

        Foo1(String sex,String age){
            this.sex = sex;
            this.age = age;
        }
    }


    public void testRangSet(){
        RangeSet<Double> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(new Double(1L),new Double(20L)));
        rangeSet.add(Range.closed(new Double(19L),new Double(25L)));
        rangeSet.add(Range.open(new Double(26L), new Double(250L)));
        System.out.println(rangeSet);
        System.out.println(rangeSet.asRanges());
        System.out.println(rangeSet.rangeContaining(new Double(27L)));



    }

    public void testTable(){
        Table<String, Integer, String> aTable = HashBasedTable.create();

        for (char a = 'A'; a <= 'C'; ++a) {
            for (Integer b = 1; b <= 3; ++b) {
                aTable.put(Character.toString(a), b, String.format("%c%d", a, b));
            }
        }

        System.out.println(aTable.column(2));
        System.out.println(aTable.row("B"));
        System.out.println(aTable.get("B", 2));

        System.out.println(aTable.contains("D", 1));
        System.out.println(aTable.containsColumn(3));
        System.out.println(aTable.containsRow("C"));
        System.out.println(aTable.columnMap());
        System.out.println(aTable.rowMap());

        System.out.println(aTable.remove("B", 3));


    }
}
