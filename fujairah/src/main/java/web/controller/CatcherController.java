package web.controller;

import com.woom.baseTool.catcher.Catcher;
import com.woom.baseTool.catcher.HtmlCatcher;
import com.woom.baseTool.catcher.PicCatcher;
import com.woom.baseTool.saver.Saver;
import com.woom.baseTool.util.UtilsCommon;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.common.view.JsonBack;
import web.entity.Rule;
import web.manager.RuleManager;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuhao.zx on 14-9-27.
 */
@Controller
@RequestMapping("/catcher")
public class CatcherController {
    @Autowired
    private RuleManager ruleManager;

    @RequestMapping(value="/catch" ,produces="application/json")
    @ResponseBody
    public void getList(@RequestParam Long ruleId,@RequestParam Integer deep,@RequestParam String link,
                        @RequestParam String location,HttpServletResponse response){
        try {
            Catcher<String> catcher = new HtmlCatcher();
            Rule rule = ruleManager.getRuleById(ruleId);
            if(null == rule){
                JsonBack.sendError("rule can't found",response);
            }

//            String rs = catcher.catchContent(link);
//            System.out.println(rs);
//            List<String> list = new ArrayList<String>();
//            Document doc = Jsoup.parse(rs);
//
//            UtilsCommon.getPic(doc, list,rule);
//            JsonBack jb = new JsonBack(response);
//
//            for(String ele:list){
//                try {
//                    Catcher picCatcher = new PicCatcher();
//                    Queue<byte[]> result= (Queue<byte[]>) picCatcher.catchContent(ele);
//                    Saver.savePic(location +"\\"+ Saver.getPicName(ele), result);
//                    jb.put("now", Saver.getPicName(ele)).sendSyn();
//                }catch (Exception e){
//                    System.out.println("go on");
//                }
//            }
//            jb.close();
            JsonBack jb = new JsonBack(response);
            for(int i=0;i<5;i++){
//                Thread.sleep(10000);
                jb.put("now", "hello"+i).sendSyn();
            }
            jb.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
