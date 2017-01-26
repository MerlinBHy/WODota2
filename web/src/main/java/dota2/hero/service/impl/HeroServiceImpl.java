package dota2.hero.service.impl;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import dota2.entity.Hero;
import dota2.entity.HeroDetailResponse;
import dota2.hero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class HeroServiceImpl implements HeroService {

    @Value("${hero-http-url}")
    private String allHeroUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<String> getAllHeroName() {
        HeroDetailResponse heroDetailResponse = getHeroDetails();
        List<String> allHeroNames = Lists.newArrayList();
        if (heroDetailResponse != null) {
            for (Hero hero : heroDetailResponse.getHeroes()) {
                allHeroNames.add(hero.getLocalizeName());
            }
        }
        return allHeroNames;
    }

    private HeroDetailResponse getHeroDetails() {
        Map response = restTemplate.getForEntity(allHeroUrl, Map.class).getBody();
        return response == null || response.get("result") == null ? null :
                new Gson().fromJson(response.get("result").toString(), HeroDetailResponse.class);
    }
}
