package com.reditt.repository;

import com.reditt.domain.Topic;
import com.reditt.service.TopicUpvoteComparator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Ashish Gupta on 02/06/17.
 */

@Service
public class TopicCacheRepository {
    @Value("${top.votes.count}")
    private int topVotesCount;

    private SortedSet<Topic> topTopicsCache = new TreeSet<>(new TopicUpvoteComparator());

    public void add(Topic topic) {
        //to maintain a fixed size
        if (topTopicsCache.isEmpty() || topTopicsCache.size() < topVotesCount) {
            topTopicsCache.add(topic);
            //new entry is bigger and the new topic upvotes are greater, then EVICT the last entry
        } else if (topic.getUpVotes() >= topTopicsCache.last().getUpVotes()) {
            topTopicsCache.remove(topTopicsCache.last());
            topTopicsCache.add(topic);
        }
    }

    public void remove(Topic topic) {
        topTopicsCache.remove(topic);
    }

    public List<Topic> getTopTopics() {
        return new ArrayList<>(topTopicsCache);
    }

}
