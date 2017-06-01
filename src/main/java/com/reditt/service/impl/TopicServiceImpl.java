package com.reditt.service.impl;

import com.reditt.domain.SubmitTopicRequest;
import com.reditt.domain.Topic;
import com.reditt.domain.VoteTopicRequest;
import com.reditt.domain.VoteType;
import com.reditt.repository.TopicRepository;
import com.reditt.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish Gupta on 01/06/17.
 */

@Service
public class TopicServiceImpl implements TopicService {

    @Resource
    private TopicRepository repository;

    @Override
    public long submitTopic(SubmitTopicRequest request) {
        //TODO check topic size for 255 characters
        return repository.submitTopic(new Topic(request.getContent()));
    }

    @Override
    public void voteTopic(Long topicId, VoteTopicRequest request) {
        repository.voteTopic(topicId, request);
    }

    @Override
    public Topic getTopic(Long id) {
        return repository.getTopic(id);
    }

    @Override
    public List<Topic> getTopTopics() {
        //TODO implement me
        return new ArrayList<Topic>();
    }


}

