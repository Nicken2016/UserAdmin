package net.nicken.useradmin.controller;

import net.nicken.useradmin.model.User;
import net.nicken.useradmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Nicken on 13.11.2016.
 */
@Controller
public class UserController {
    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(@RequestParam(value = "page", required = false) Integer page,
                            Model model){
        page = page == null ? 1 : page;
        int endpage = (int) Math.ceil((float)this.userService.size()/3);
        model.addAttribute("page", page);
        model.addAttribute("endpage",endpage);
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUser(page));

        return "users";
    }

    @RequestMapping(value = "/users/search", method = RequestMethod.POST)
    public String searchUsers(@RequestParam(value = "uname", required = false) String uname,
                            Model model){
    if(uname.isEmpty())
        {
        int page = 1;
        int endpage = (int) Math.ceil((float)this.userService.size()/3);
        model.addAttribute("page", page);
        model.addAttribute("endpage",endpage);
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUser(page));
        }
    else
        {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.searchUser(uname));
        }
    return "users";
    }


    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        user.setCreateddate(new Date());
        if(user.getId() == 0){
            this.userService.addUser(user);
        }else {
            this.userService.updateUser(user);
        }
        return "redirect:/users";
    }


    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);

        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editUser(@RequestParam(value = "page", required = false) Integer page,
                           @PathVariable("id") int id,
                           Model model){
        page = page == null ? 1 : page;
        int endpage = (int) Math.ceil((float)this.userService.size()/3);
        model.addAttribute("page", page);
        model.addAttribute("endpage",endpage);
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUser(page));
        return "users";
    }

    @RequestMapping("usersdata/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));

        return "usersdata";
    }

}
