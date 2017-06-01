package com.reditt.service;

import com.reditt.domain.SubmitTopicRequest;
import com.reditt.domain.Topic;
import com.reditt.domain.VoteTopicRequest;
import com.reditt.domain.VoteType;

import java.util.List;

/**
 * Created by Ashish Gupta on 01/06/17.
 */

public interface TopicService {

    long submitTopic(SubmitTopicRequest request);
    void voteTopic(Long topicId, VoteTopicRequest request);
    Topic getTopic(Long id);
    List<Topic> getTopTopics();
}

