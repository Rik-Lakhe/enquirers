/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.enqproj.controller;

import edu.lfa.enqproj.dao.FacultyDAO;
import edu.lfa.enqproj.dto.FacultyDTO;
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
@RequestMapping(value="/admin/faculty")
public class FacultyController {
    @Autowired
    private FacultyDAO facultyDAO;
   
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String index() {
        String data="";
        for(Faculty fac : facultyDAO.getAll()){
        
            data += "<li>"+fac.getFacultyName()+"</li>";
        
        }
        
        return data;
    } 
    
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return "admin/faculty/add";
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(FacultyDTO facDTO){
        Faculty fac= new Faculty();
        fac.setFacultyName(facDTO.getFname());
        fac.setFacultyStatus(facDTO.isFstatus());
        facultyDAO.insert(fac);
        return "redirect:/admin/faculty/";
    }
    

}
