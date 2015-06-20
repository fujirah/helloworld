package web.controller;

import com.woom.tools.algorithm.SuduBL;
import com.woom.tools.algorithm.SuduDancingCut;
import com.woom.tools.algorithm.SuduJZ;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.common.view.JsonBack;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by yuhao.zx on 2015/3/30.
 */
@Controller
@RequestMapping("/code")
public class Code4Fun {
    @RequestMapping(value="/submit" ,produces="application/json")
    @ResponseBody
    public void computer(@RequestParam String tableI,HttpServletResponse response){
        try {
            JsonBack jb = new JsonBack(response);
            long now = System.currentTimeMillis();
            jb.put("data", SuduBL.computer(tableI));
            long after = System.currentTimeMillis();
            jb.put("time",after-now);
            jb.send();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping(value="/submitJZ" ,produces="application/json")
    @ResponseBody
    public void computerJZ(@RequestParam String tableI,HttpServletResponse response){
        try {
            JsonBack jb = new JsonBack(response);
            long now = System.currentTimeMillis();
            jb.put("data", SuduJZ.computer(tableI));
            long after = System.currentTimeMillis();
            jb.put("time",after-now);
            jb.send();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping(value="/submitDancing" ,produces="application/json")
    @ResponseBody
    public void submitDancing(@RequestParam String tableI,HttpServletResponse response){
        try {
            JsonBack jb = new JsonBack(response);
            long now = System.currentTimeMillis();
            SuduDancingCut sd = new SuduDancingCut();
            jb.put("data", sd.computer(tableI));
            long after = System.currentTimeMillis();
            jb.put("time",after-now);
            jb.send();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping(value="/submitDancingCut" ,produces="application/json")
    @ResponseBody
    public void submitDancingCut(@RequestParam String tableI,HttpServletResponse response){
        try {
            JsonBack jb = new JsonBack(response);
            long now = System.currentTimeMillis();
            SuduDancingCut sd = new SuduDancingCut();
            jb.put("data", sd.computer(tableI));
            long after = System.currentTimeMillis();
            jb.put("time",after-now);
            jb.send();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
