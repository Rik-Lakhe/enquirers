/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.enqproj.controller;

import edu.lfa.enqproj.dao.EnquiresDAO;
import edu.lfa.enqproj.dao.FollowupDAO;
import edu.lfa.enqproj.dto.FollowupDTO;
import edu.lfa.enqproj.entity.Enquires;
import edu.lfa.enqproj.entity.Followup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author LAKHE
 */
@Controller
@RequestMapping(value="/admin/followup")
public class FollowupController {
    @Autowired
    private FollowupDAO followupDAO;
    @Autowired
    private EnquiresDAO enquiresDAO;
   
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String index() {
        String data="";
        for(Followup fol : followupDAO.getAll()){
        
            data += "<li>"+fol.getFollowId()+"  "+fol.getFollowEnqId()+"  "+fol.getFollowEnqMessage()+"</li>";
        
        }
        
        return data;
    } 
    
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return "admin/followup/add";
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(FollowupDTO folDTO){
        Followup fol= new Followup();
        fol.setFollowEnqId(new Enquires(folDTO.getFenquiresid()));
        fol.setFollowEnqMessage(folDTO.getFenquiresmessage());
//        fol.setFollowEnqMessage(new Enquires(folDTO.getFenquiresmessage()));
        followupDAO.insert(fol);
        return "redirect:/admin/followup/";
    }
    
}
