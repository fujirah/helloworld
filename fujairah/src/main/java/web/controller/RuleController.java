package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.common.exception.ManagerException;
import web.common.view.JsonBack;
import web.entity.Rule;
import web.manager.RuleManager;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by yuhao.zx on 14-9-20.
 */
@Controller
@RequestMapping("/rule")
public class RuleController {
    @Autowired
    private RuleManager ruleManager;

    @RequestMapping(value="/list" ,produces="application/json")
    @ResponseBody
    public void getList(@ModelAttribute Rule rule,HttpServletResponse response){
        try {
            List<Rule> list = ruleManager.getRuleList(rule);
            Integer count = ruleManager.getCount(rule);

            new JsonBack(response).
                    put("result", list).
                    put("count",count).
                    send();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping(value="/add" ,produces="application/json")
     @ResponseBody
     public void addRule(@ModelAttribute Rule rule,HttpServletResponse response){
        try {
            rule.setDeleted(0);
            ruleManager.insert(rule);
            new JsonBack(response).setIsSuccess(true).
                    send();
        } catch (ManagerException e) {
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @RequestMapping(value="/delete" ,produces="application/json")
    @ResponseBody
    public void addRule(@RequestParam Long ruleId,HttpServletResponse response){
        try {
            ruleManager.delete(ruleId);
            new JsonBack(response).setIsSuccess(true).
                    send();
        } catch (ManagerException e) {
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @RequestMapping(value="/listAll" ,produces="application/json")
    @ResponseBody
    public void getListAll(HttpServletResponse response){
        try {
            Rule rule = new Rule();
            rule.setPagging(false);
            List<Rule> list = ruleManager.getRuleList(rule);
            new JsonBack(response).
                    put("result", list).
                    send();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
 
}
