package com.dip.aap.controller;

import com.dip.aap.dao.PersonDAO;
import com.dip.aap.model.Person;
import com.dip.aap.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by andrz on 01/08/2017.
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String ShowLogin(){
        return "loginUser";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/confirm")
    public String AddNewArticle(@RequestParam String login_text,
                                @RequestParam String password_text,
                                Model model) {
        Person person = personDAO.findByLogin(login_text);
        if(person == null || !person.getPassword().equals(password_text)) {
            return "redirect:/login";
        }
        loginService.loggedPerson = person;
        return  "redirect:/articles/all";
    }
}
