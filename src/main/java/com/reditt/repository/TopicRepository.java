package com.reditt.repository;

import com.reditt.domain.Topic;
import com.reditt.domain.VoteTopicRequest;
import com.reditt.domain.VoteType;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ashish Gupta on 01/06/17.
 */

@Component
public class TopicRepository {


    private AtomicLong id = new AtomicLong(1);
    private HashMap<Long, Topic> topicDb = new HashMap<>();

    /**
     * To interact with the cache repository, which at any point of time is able to return the max topics by upvotes
     */
    @Resource
    private TopicCacheRepository cacheRepository;

    public long submitTopic(Topic topic) {
        long ids = id.getAndIncrement();
        topic.setId(ids);
        topicDb.put(ids, topic);
        cacheRepository.add(topic);
        return ids;
    }

    public Topic getTopic(Long id) {
        return topicDb.get(id);
    }

    public void voteTopic(Long topicId, VoteTopicRequest request) {
        if (topicDb.containsKey(topicId)) {
            final Topic topic = topicDb.get(topicId);
            cacheRepository.remove(topic);
            if (request.getVoteType().equals(VoteType.DOWNVOTE)) {
                topic.downvote();
            } else if (request.getVoteType().equals(VoteType.UPVOTE)) {
                topic.upvote();
            }
            cacheRepository.add(topic);
        }
    }
}