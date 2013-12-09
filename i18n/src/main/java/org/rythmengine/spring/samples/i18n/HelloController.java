package org.rythmengine.spring.samples.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HelloController {

    @ModelAttribute("who")
    public String who() {
        return "Rythm";
    }

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model, HttpServletRequest request) {
        return "hello";
	}

}