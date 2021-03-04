package controller;

import model.Login;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.jws.soap.SOAPBinding;

@Controller
@RequestMapping("/home")
public class UserController {
    @Autowired
    private UserService productService;

    @GetMapping("")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("home", "login", new Login());
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView login(@ModelAttribute Login login) {
        User user = UserService.checkLogin(login);
        if(user==null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
        ModelAndView modelAndView =new ModelAndView("user");
        modelAndView.addObject("u", user);
        return modelAndView;
    }
}
