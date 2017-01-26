package dota2.hero.controller;

import dota2.hero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dota2/hero")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @RequestMapping("/all")
    @ResponseBody
    public List<String> getAllHeroName() {
        return heroService.getAllHeroName();
    }

}
