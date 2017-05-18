/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.enqproj.controller;

import edu.lfa.enqproj.dao.EnquiresDAO;
import edu.lfa.enqproj.dto.EnquiresDTO;
import edu.lfa.enqproj.entity.Course;
import edu.lfa.enqproj.entity.Enquires;
import edu.lfa.enqproj.entity.Faculty;
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
@RequestMapping(value="/admin/enquires")
public class EnquiresController {
    @Autowired
    private EnquiresDAO enquiresDAO;
   
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String index() {
        String data="";
        for(Enquires enq : enquiresDAO.getAll()){
        
            data += "<li>"+enq.getEnqFname()+"  "+enq.getEnqLname()+"=>"+enq.getEnqMessage()+"</li>";
        
        }
        
        return data;
    } 
    
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return "admin/enquires/add";
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(EnquiresDTO enqDTO){
        Enquires enq= new Enquires();
        enq.setEnqFname(enqDTO.getEfname());
        enq.setEnqLname(enqDTO.getElname());
        enq.setEnqEmail(enqDTO.getEemail());
        enq.setEnqGender(enqDTO.getEgender());
        enq.setEnqMessage(enqDTO.getEmessage());
        enq.setEnqFacultyId(new Faculty(enqDTO.getEfacultyid()));
        enq.setEnqCourseId(new Course(enqDTO.getEcourseid()));
        enquiresDAO.insert(enq);
        return "redirect:/admin/enquires/";
    }
    

}
