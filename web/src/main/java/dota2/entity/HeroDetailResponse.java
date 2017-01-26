package dota2.entity;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HeroDetailResponse {

    @SerializedName("heroes")
    private List<Hero> heroes;

    @SerializedName("status")
    private String status;

    @SerializedName("count")
    private Integer count;

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
