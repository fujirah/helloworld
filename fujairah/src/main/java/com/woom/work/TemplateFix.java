package com.woom.work;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuhao.zx on 15-4-30.
 */
public class TemplateFix {
    static String brand = "20034,20019,3889310,29465,20066,20067,20096,29478,46491,46476," +
            "20022,20558,45618,3322567,20021,29878,29512,3346368,21466766,20033," +
            "20008,3569451,3248206,20110,94669233,4535636,107567,9865041,3271216," +
            "29900,29877,21528867,97466,44615,4081602,28005,44203369,3276787,3230964," +
            "29529,22998805,20584,20581,13910764,3625848,41657,20819,3290067,27976," +
            "279868092,20816,8379451,3224818,9553219,10400977,27974,3224828,44611," +
            "27145,3272234,4086889,8066754,29527,84669,159455842,3756916," +
            "84673,4099984,113316,8202421,9025519,3294660,3418473,3346593,20582," +
            "44506,29492,31888,75211622,20578,20579";

    static String cateAndMission = "50008090&1.2;50009211&0.6;1201&1.2;50007218&1.2;110514&0.6;" +
            "50012082&1.2;50022703&1.2;11&0.6;20&1.2;50018004&1.2;" +
            "50002768&1.8;50019780&0.6;50012164&0.6;50012100&1.2;" +
            "1512&0.6;14&0.6;124044001&0.6;50018264&0.6;50011972&1.2;" +
            "50008163&3.0;50020579&3.0;50020332&1.2;50020611&3.0;50020808&3.0;" +
            "27&3.0;50013222&1.2;50020573&1.2;122852001&3.0;50074001&1.2;" +
            "26&1.8;50018720&1.2;50018708&1.2;50014479&1.2;50014482&1.2;50023950&1.2;" +
            "50020485&1.8;50008164&1.8;50010788&1.5;1801&1.5;35&0.6;50014812&1.2;" +
            "50006020&3.0;50013866&3.0;50022520&3.0;50018813&0.6;33&1.2;25&3.0;34&1.2;" +
            "50022517&3.0;50006000&1.2;50026457&1.2;50010392&0.6;50026460&1.2;50023717&1.8;" +
            "50026800&1.8;122952001&3.0;50026316&1.2;50604012&0.6;2813&1.8;29&3.0;" +
            "50015262&1.5;50023067&1.5;50023066&1.5;50015380&1.5;50016349&3.0;123690003&1.8;" +
            "50020275&1.8;50016348&3.0;122950001&3.0;50008141&1.2;21&3.0;50016422&1.2;" +
            "50009837&0.6;50050378&0.6;50002766&1.2;50023282&2.4;122928002&3.0;" +
            "50025705&1.5;50012473&0.6;50050359&0.0;50007216&0.0;50010404&3.0;30&3.0;" +
            "1625&3.0;28&1.8;50010368&3.0;16&3.0;50013864&3.0;50468001&3.0;122650005&3.0;" +
            "50011397&1.8;121422036&0.6;121470039&0.6;50013886&3.0;50011740&3.0;" +
            "50006843&3.0;50006842&3.0;50010728&3.0;50019782&1.2;50510002&3.0;50011699&3.0;" +
            "50012029&3.0;122684003&1.2;50008165&3;350201&1.2;50012131&0.6;50013697&1.8";

    static class Node{
        String brandId;
        String cateId;
        int ratio;
    }
    public static void main(String[] args) throws IOException {
        String[] brandId = TemplateFix.brand.split(",");
        String[] cateInfo = TemplateFix.cateAndMission.split(";");
        System.out.println(brandId.length);
        System.out.println(cateInfo.length);

        Map<String,Node> map = new HashMap<String, Node>();
        for(int i=0;i<brandId.length;i++){
            for(int j=0;j<cateInfo.length;j++){
                Node temp = new Node();
                temp.brandId = brandId[i];
                String [] c = cateInfo[j].split("&");
                temp.cateId = c[0];
                temp.ratio = (int)(Double.valueOf(c[1])*100);
                String code = temp.brandId+"&"+temp.cateId+"&"+temp.ratio;
                System.out.println(code);
                System.out.println(code.length());
                Node node = map.get(code);
                if(node != null){
                    System.out.println(code);
                    throw new RuntimeException("fail");
                }
                map.put(code,temp);
            }
        }

        System.out.println(map.size());
        System.out.println("==================================");
        try {
            File file = new File("D://exist.txt");
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader fr = new BufferedReader(read);

            String txt;

            int countE=0;
            while((txt = fr.readLine())!=null){
                if(map.get(txt) != null){
                    map.put(txt,null);
                    countE++;
                }
            }
            System.out.println(countE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int count  = 0;

        File file =new File("D://sql.txt");
        file.createNewFile();
        FileWriter fileWritter = new FileWriter(file,true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        StringBuilder sql = new StringBuilder();
        long num = 10014068;
        for(String ele : map.keySet()){
            Node val = map.get(ele);
            if(val != null){
                sql.append("insert into fee_comm_solution" +
                        "(id,object_id, object_type, category_id, shop_type, " +
                        "check_status, effective_time, ratio, off, creator_id, " +
                        "creator_nick, attributes, is_deleted, gmt_create, " +
                        "gmt_modified, target_fee, base_fee, trace_id, trace_user," +
                        " brand_id, fixed_fee, top_fee) " +

                        "values("+(num++)+",104001, 2, "+val.cateId+", 1, 1, " +
                        "'2015-04-30 20:21:04', "+val.ratio+", 1000, 0, 'system', '', 0, " +
                        "'2015-04-30 20:21:04', '2015-04-30 20:21:04', 0, 0," +
                        " null, null, "+val.brandId+", 0, 0);\n");
                sql.append("insert into fee_comm_solution" +
                        "(id,object_id, object_type, category_id, shop_type, " +
                        "check_status, effective_time, ratio, off, creator_id, " +
                        "creator_nick, attributes, is_deleted, gmt_create, " +
                        "gmt_modified, target_fee, base_fee, trace_id, trace_user," +
                        " brand_id, fixed_fee, top_fee) " +

                        "values("+(num++)+",104001, 2, "+val.cateId+", 2, 1, " +
                        "'2015-04-30 20:21:04', "+val.ratio+", 1000, 0, 'system', '', 0, " +
                        "'2015-04-30 20:21:04', '2015-04-30 20:21:04', 0, 0," +
                        " null, null, "+val.brandId+", 0, 0);\n");
                count++;
            }
        }
        System.out.println(num);
        String rs = sql.toString();
        bufferWritter.write(rs);
        bufferWritter.flush();
        bufferWritter.close();
        System.out.println(count);
        System.out.println("Done");
    }
}
