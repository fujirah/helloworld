package com.woom.baseTool.deal;

import com.meterware.httpunit.*;
import com.woom.baseTool.catcher.Catcher;
import com.woom.baseTool.catcher.HtmlCatcher;
import com.woom.baseTool.catcher.PicCatcher;
import com.woom.baseTool.saver.Saver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 * Created by yuhao.zx on 14-9-14.
 */
public class Main {
    public static void main(String[] args) {
        /*Catcher<String> catcher = new HtmlCatcher();
        String rs = catcher.catchContent("http://image.baidu.com/");
        System.out.println(rs);
        List<String> list = new ArrayList<String>();
        Document doc = Jsoup.parse(rs);
        
        getPic(doc, list);
        System.out.println(list.size());
        for(String ele:list){
            System.out.println(ele);
            Catcher picCatcher = new PicCatcher();

            Queue<byte[]> result= (Queue<byte[]>) picCatcher.catchContent(ele);
            Saver.savePic("D:/test/" + Saver.getPicName(ele), result);
        }
        System.out.println("finish");
//        System.out.println(getAllLinks(doc.getElementsByTag("body").first()));
        Context context = Context.enter();
        Scriptable scriptable = context.initStandardObjects();*/

        WebConversation wc = new WebConversation();
        WebRequest req = new GetMethodWebRequest( "http://www.baidu.com");
        try {
            WebResponse resp = wc.getResponse( req );
            WebImage[] rs = resp.getImages();
            System.out.println("hehe");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


    private static String getAllLinks(Element element){
        String result="";
        Elements elements = element.children();
        for(Element link : elements){
            if(link.hasAttr("href")){
                result += link.attr("href")+",";
            }else{
                result += getAllLinks(link);
            }
        }
        return result;
    }

    private static List<String> getPic(Element element,List<String> list){
        Elements elements = element.children();
        for(Element pic : elements){
            if(pic.tagName().equals("img")){
                list.add(pic.attr("src"));
            }else if(pic.tagName().equals("script")){
//                list.add();
            }else{
                getPic(pic, list);
            }
        }
        return list;
    }

//    private static String getScriptPic(String org){
//
//    }
}
