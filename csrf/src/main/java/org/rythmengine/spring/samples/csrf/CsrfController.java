package org.rythmengine.spring.samples.csrf;

import org.rythmengine.spring.web.util.ControllerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CsrfController extends ControllerUtil {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String form() {
        return "home";
    }

    @RequestMapping(value = "/csrf", method = RequestMethod.POST)
    public String onPost(String msg, ModelMap modelMap) {
        modelMap.put("msg", msg);
        return "echo";
    }

}