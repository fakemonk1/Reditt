package com.reditt.service.impl;

import com.reditt.domain.SubmitTopicRequest;
import com.reditt.domain.Topic;
import com.reditt.repository.TopicRepository;
import com.reditt.service.TopicService;

import javax.annotation.Resource;

/**
 * Created by Ashish Gupta on 01/06/17.
 */

public class TopicServiceImpl implements TopicService {

    @Resource
    private TopicRepository repository;

    @Override
    public long submitTopic(SubmitTopicRequest request) {
        return repository.submitTopic(new Topic(request.getContent()));
    }

    @Override
    public Topic getTopic(Long id) {
        return repository.getTopic(id);
    }


}

