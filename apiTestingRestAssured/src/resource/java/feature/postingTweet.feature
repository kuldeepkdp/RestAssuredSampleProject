@ActiveFeature
Feature: 003_Post tweets
  This feature file cover scenarios related to Posting tweets

  @Active
  Scenario: Check that status code for Post statuses/update.json request is 200
    Given I make Post request to "statuses/update.json"
    Then Status code should be 200
    
  @Active
  Scenario: Check that user can delete tweet
    Given I make Post request to "statuses/update.json" to add new tweet "I am posting this tweet using Rest assured API for testing purpose 2"
    And I make Delete request to "statuses/destroy/"
    Then Status code should be 200
