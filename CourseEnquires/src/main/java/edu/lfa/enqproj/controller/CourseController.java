/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.enqproj.controller;

import edu.lfa.enqproj.dao.CourseDAO;
import edu.lfa.enqproj.dto.CourseDTO;
import edu.lfa.enqproj.entity.Course;
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
@RequestMapping(value="/admin/course")
public class CourseController {
    @Autowired
    private CourseDAO courseDAO;
   
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String index() {
        String data="";
        for(Course cour : courseDAO.getAll()){
        
            data += "<li>"+cour.getCourseCode()+"=>"+cour.getCourseName()+"</li>";
        
        }
        
        return data;
    } 
    
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return "admin/course/add";
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(CourseDTO couDTO){
        Course course= new Course();
        course.setCourseName(couDTO.getCname());
        course.setCourseCode(couDTO.getCcode());
        course.setCourseFees(couDTO.getCfees());
        
        courseDAO.insert(course);
        return "redirect:/admin/course/";
    }
    

}
