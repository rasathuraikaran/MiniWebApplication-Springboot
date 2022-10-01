package com.example.bootjpa.Controller;
import com.example.bootjpa.dao.AlienRepo;
import com.example.bootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {
    @Autowired
    AlienRepo repo;
@GetMapping("/home")
    public String home()  {

    return "home.jsp";
    }



    @PostMapping("/alien")
    public Alien addAlien( @RequestBody Alien alien){
    repo.save(alien);
    return alien;
    }
    @RequestMapping ("/aliens")
    public List<Alien> getAlien(){
       return repo.findAll();
    }

    @GetMapping("/alien/{aid}")

    public Optional<Alien> getAliens(@PathVariable("aid") int aid){
        return repo.findById(aid);
    }

    @GetMapping("/deleteAlien")
    public ModelAndView deleteAlien(@RequestParam int aid){
        ModelAndView mv=new ModelAndView("deleteAlien.jsp");
        Alien alien1= repo.findById(aid).orElse(new Alien());
        repo.deleteById(aid);
        mv.addObject("alien1",alien1);
        return mv;
    }

    @DeleteMapping("/alien/{aid}")
    public String delesteAlien(@PathVariable int aid){
    Alien a=repo.getOne(aid);
    repo.delete(a);
    return "Deleted";

    }

    @GetMapping("/updateAlien")
    public ModelAndView updatesAlien(Alien alien){
        ModelAndView mv=new ModelAndView("updateAlien.jsp");
        Alien alien1= repo.findById(alien.getAid()).orElse(new Alien());
        repo.deleteById(alien.getAid());
        mv.addObject("alien1",alien1);
        return mv;
    }

    @PutMapping("/alien")
    public Alien updateAlien( @RequestBody Alien alien){
        repo.save(alien);
        return alien;
    }

}
