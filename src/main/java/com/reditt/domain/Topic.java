package com.reditt.domain;

/**
 * Created by Ashish Gupta on 01/06/17.
 */

public class Topic {

    private Long id;
    private String content;
    private long upVotes;
    private long downVotes;

    public Topic(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void upvote() {
        upVotes++;
    }

    public void downvote() {
        downVotes++;
    }

    public long getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(long upVotes) {
        this.upVotes = upVotes;
    }

    public long getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(long downVotes) {
        this.downVotes = downVotes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
