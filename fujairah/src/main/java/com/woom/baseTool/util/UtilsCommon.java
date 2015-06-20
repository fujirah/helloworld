package com.woom.baseTool.util;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import web.entity.Rule;

import java.util.List;

/**
 * Created by yuhao.zx on 14-9-27.
 */
public class UtilsCommon {
    public static List<String> getPic(Element element,List<String> list,Rule rule){
        Elements elements = element.children();
        for(Element pic : elements){
            if(pic.tagName().equals(rule.getLabel())){
                list.add(pic.attr(rule.getAttr()));
            }else{
                getPic(pic, list,rule);
            }
        }
        return list;
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
}
