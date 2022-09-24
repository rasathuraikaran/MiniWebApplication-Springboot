package com.example.bootjpa.Controller;
import com.example.bootjpa.dao.AlienRepo;
import com.example.bootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlienController {
    @Autowired
    AlienRepo repo;
@RequestMapping("/home")
    public String home(){
        return "home.jsp";
    }



    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){
    repo.save(alien);
    return "home.jsp";
    }
    @GetMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid){
        ModelAndView alien=new ModelAndView("showAlien.jsp");
        Alien alien1= repo.findById(aid).orElse(new Alien());
        alien.addObject("alien1",alien1);
        return alien;
    }

    @GetMapping("/deleteAlien")
    public ModelAndView deleteAlien(@RequestParam int aid){
        ModelAndView alien=new ModelAndView("deleteAlien.jsp");
        Alien alien1= repo.findById(aid).orElse(new Alien());
        repo.deleteById(aid);
        alien.addObject("alien1",alien1);
        return alien;
    }
}
