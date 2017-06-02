**Reditt**

Demo Application to imitate following Reditt behaviour

Access: 

This has been deplyed on Heroku and can be accessed through swagger on:

https://reditt.herokuapp.com/swagger-ui.html

Functionality that must be present:
1. Maintain a list of topics and its upvotes/downvotes
2. Allow the user to submit topics. For this challenge, a “topic” is simply a string that does not exceed 255 characters.
3. Allow the user to upvote or downvote a topic. For this challenge, the user may upvote or downvote the same topic multiple times.
4 .Always return a list of top 20 topics (sorted by upvotes, descending) on the homepage 
5. In-memory: Design an in-memory data structure (shared by the same process as your application) that will allow you to keep the topics in memory without using data persistence. It is okay for the topics to disappear after the application restarts. You may use data structures provided by your language’s standard library to build your data structure. Please note that in-memory data structure stores such as Redis and relational databases are not allowed.

