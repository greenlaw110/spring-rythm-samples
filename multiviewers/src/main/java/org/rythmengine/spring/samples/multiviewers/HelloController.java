package org.rythmengine.spring.samples.multiviewers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    @ModelAttribute("who")
    public String who() {
        return "Rythm";
    }

	@RequestMapping(method = RequestMethod.GET)
	public String hello(ModelMap model) {
        return "hello";
	}

    @RequestMapping(value="/bye", method = RequestMethod.GET)
	public String bye(ModelMap model) {
	    return "bye";
	}

    @RequestMapping(value="/hi", method = RequestMethod.GET)
	public String hi(ModelMap model) {
	    return "hi";
	}

}