package com.as3.reddit.representations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dropwizard.validation.ValidationMethod;
import org.hibernate.validator.constraints.*;

public class Posts {

    private final int id;

    @NotBlank
    @Length(min = 2, max = 255)
    private final String url;

    @NotBlank
    @Length(min = 2, max = 255)
    private final String title;

    private final int vote;

    public Posts() {
        this.id = 0;
        this.url = null;
        this.title = null;
        this.vote = 0;
    }

    public Posts(int id,String url, String title, int vote) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.vote = 0;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public int getVote() {
        return vote;
    }

}
