/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.enqproj.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author LAKHE
 */
@Controller
@RequestMapping(value="/")
public class DefaultController {
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    
    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest req){
        req.getSession().invalidate();
        return "redirect:/";
    }

}
