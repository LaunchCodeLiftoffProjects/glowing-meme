package org.launchcode.todo.controllers;


//import org.launchcode.todo.models.AddEvent;
import org.launchcode.todo.models.Event;
import org.launchcode.todo.models.User;
import org.launchcode.todo.models.data.AddEventDao;
import org.launchcode.todo.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;

//Defines the class
@Controller
//@RequestMapping(value ="addevent")
public class AddEventController {

    //Injecting a instance of AddEventDao here
    @Autowired
    private AddEventDao addEventDao;

    @Autowired
    private UserDao userDao;

    // Request path: /addevent
   /* @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("addevents", addEventDao.findAll());
        model.addAttribute("title", "Add Event");

        return "addevent";
    }*/

    @RequestMapping(value = "addevent", method = RequestMethod.GET)
    public String displayAddEventForm(Model model) {

        model.addAttribute("title", "Add Event");
        model.addAttribute(new Event());

        return "addevent";
    }

    @RequestMapping(value = "addevent", method = RequestMethod.POST)
    public String processAddEventForm(@ModelAttribute @Valid Event newAddEvent,
                                       HttpSession session,
                                       Errors errors, Model model) {

//        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
//
//        String yourDate=sdf.format(newAddEvent.getEventDate());
//        System.out.println(yourDate);

//        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm a");
//        System.out.println(sdf1.format(newAddEvent.getStart_Time()));

//
       System.out.println("new event" + newAddEvent);

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Event");
            return "addevent";
        }

//        try {
//            newAddEvent.setEventDate(sdf.parse(yourDate));
//            newAddEvent.setStart_Time(sdf1.parse(sdf1.format(newAddEvent.getStart_Time())));
//            newAddEvent.setFinish_Time(sdf1.parse(sdf1.format(newAddEvent.getFinish_Time())));
//        }
//        catch(Exception e){
//
//        }

        //User user = userDao.findOne(id);
        //newAddEvent.setUser(user);
        addEventDao.save(newAddEvent);
        return "dashboard";
    }
}
