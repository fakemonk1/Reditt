package com.reditt.domain;

/**
 * Created by Ashish Gupta on 01/06/17.
 */
public class VoteTopicRequest {
    private VoteType voteType;
    //Rest of the parameters will be added in future

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }
}
