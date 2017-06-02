package com.reditt.service;

import com.reditt.domain.Topic;

import java.util.Comparator;

/**
 * Created by Ashish Gupta on 01/06/17.
 */
public class TopicUpvoteComparator implements Comparator<Topic> {

    @Override
    public int compare(Topic t1, Topic t2) {
        if (Long.compare(t2.getUpVotes(), t1.getUpVotes()) == 0) {
            return Long.compare(t2.getId(), t1.getId());
        } else {
            return Long.compare(t2.getUpVotes(), t1.getUpVotes());
        }
    }
}
