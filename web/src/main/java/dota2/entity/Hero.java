package dota2.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hero {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("localized_name")
    private String localizeName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocalizeName() {
        return localizeName;
    }

    public void setLocalizeName(String localizeName) {
        this.localizeName = localizeName;
    }
}
