package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuhao.zx on 14-9-14.
 */
@Controller
@RequestMapping("/demon")
public class demon {

    @RequestMapping(value = "/helloWorld",method = RequestMethod.GET)
    //此配置直接返回字符串内容
    @ResponseBody
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        System.out.println("helloworld");
        return "helloWorld";
    }
}
