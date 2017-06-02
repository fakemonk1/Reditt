package com.reditt.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Ashish Gupta on 01/06/17.
 */
public class SubmitTopicRequest {

    @NotNull
    @Size(max = 255)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

