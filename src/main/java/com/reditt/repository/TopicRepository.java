package com.reditt.repository;

import com.reditt.domain.Topic;
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
        topic.setId(id);
        topicDb.put(id++, topic);
        return id;
    }

    public Topic getTopic(Long id) {
        //TODO throw exception if topic does not exist
        return topicDb.get(id);
    }
}
