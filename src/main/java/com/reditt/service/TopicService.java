package com.reditt.service;

import com.reditt.domain.SubmitTopicRequest;
import com.reditt.domain.Topic;

/**
 * Created by Ashish Gupta on 01/06/17.
 */

public interface TopicService {


    long submitTopic(SubmitTopicRequest request);

    Topic getTopic(Long id);
}

