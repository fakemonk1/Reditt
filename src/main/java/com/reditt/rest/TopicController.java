package com.reditt.rest;


import com.reditt.domain.SubmitTopicRequest;
import com.reditt.domain.Topic;
import com.reditt.domain.VoteTopicRequest;
import com.reditt.service.TopicService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Ashish Gupta on 01/06/17.
 */

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Resource
    private TopicService topicService;

    @RequestMapping(value = "/submit", method = RequestMethod.POST, produces = "application/json")
    public long submitTopic(@Valid SubmitTopicRequest request) {
        return topicService.submitTopic(request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Topic getTopicById(@PathVariable Long id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(value = "/{id}/vote", method = RequestMethod.POST)
    public void voteTopic(@PathVariable Long id, VoteTopicRequest request ) {
        topicService.voteTopic(id, request);
    }


    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public List<Topic> getTopTopics() {
        return topicService.getTopTopics();
    }

}
























    /*@Autowired
    private CustomerDAO customerDAO;


    @GetMapping("/customers")
    public List getCustomers() {
        return customerDAO.list();
    }*/
/*

    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id) {

        Customer customer = customerDAO.get(id);
        if (customer == null) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity createCustomer(@RequestBody Customer customer) {

        customerDAO.create(customer);

        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {

        if (null == customerDAO.delete(id)) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/customers/{id}")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

        customer = customerDAO.update(id, customer);

        if (null == customer) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }
*/

