package com.reditt.repository;

import com.reditt.domain.Topic;
import com.reditt.domain.VoteTopicRequest;
import com.reditt.domain.VoteType;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by Ashish Gupta on 01/06/17.
 */

@Component
public class TopicRepository {

    static long id;
    private HashMap<Long, Topic> topicDb = new HashMap<>();

    public long submitTopic(Topic topic) {
        topic.setId(++id);
        topicDb.put(id, topic);
        return id;
    }

    public Topic getTopic(Long id) {
        //TODO throw exception if topic does not exist
        return topicDb.get(id);
    }

    public void voteTopic(Long topicId, VoteTopicRequest request) {
        if (topicDb.containsKey(topicId)) {
            if (request.getVoteType().equals(VoteType.DOWNVOTE)) {
                topicDb.get(topicId).downvote();
            } else if (request.getVoteType().equals(VoteType.UPVOTE)) {
                topicDb.get(topicId).upvote();
            }
        }
    }
}
