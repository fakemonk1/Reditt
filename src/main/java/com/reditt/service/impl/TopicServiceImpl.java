package com.reditt.service.impl;

import com.reditt.domain.SubmitTopicRequest;
import com.reditt.domain.Topic;
import com.reditt.domain.VoteTopicRequest;
import com.reditt.repository.TopicCacheRepository;
import com.reditt.repository.TopicRepository;
import com.reditt.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Ashish Gupta on 01/06/17.
 */

@Service
public class TopicServiceImpl implements TopicService {

    @Resource
    private TopicRepository repository;

    @Resource
    private TopicCacheRepository cache;

    /**
     * Submit a Topic
     */
    @Override
    public long submitTopic(SubmitTopicRequest request) {
        return repository.submitTopic(new Topic(request.getContent()));
    }

    /**
     * Upvote/Downvote a topic
     */
    @Override
    public void voteTopic(Long topicId, VoteTopicRequest request) {
        repository.voteTopic(topicId, request);
    }


    /**
     * @return Topic
     */
    @Override
    public Topic getTopic(Long id) {
        return repository.getTopic(id);
    }

    /**
     * @return List of all the topics sorted by upvotes, descending
     */
    @Override
    public List<Topic> getTopTopics() {
        return cache.getTopTopics();
    }
}

