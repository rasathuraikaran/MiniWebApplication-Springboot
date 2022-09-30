package com.example.bootjpa.Controller;
import com.example.bootjpa.dao.AlienRepo;
import com.example.bootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlienController {
    @Autowired
    AlienRepo repo;
@GetMapping("/home")
    public String home()  {

    return "home.jsp";
    }



    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){
    repo.save(alien);
    return "home.jsp";
    }
    @GetMapping("/aliens")
            @ResponseBody
    public String getAlien(@RequestParam int aid){
       return repo.findAll().toString();
    }

    @GetMapping("/deleteAlien")
    public ModelAndView deleteAlien(@RequestParam int aid){
        ModelAndView mv=new ModelAndView("deleteAlien.jsp");
        Alien alien1= repo.findById(aid).orElse(new Alien());
        repo.deleteById(aid);
        mv.addObject("alien1",alien1);
        return mv;
    }

    @GetMapping("/updateAlien")
    public ModelAndView updateAlien(Alien alien){
        ModelAndView mv=new ModelAndView("updateAlien.jsp");
        Alien alien1= repo.findById(alien.getAid()).orElse(new Alien());
        repo.deleteById(alien.getAid());
        mv.addObject("alien1",alien1);
        return mv;
    }



}
