@ActiveFeature
Feature: 001_Get Tweet timelines
  This feature file cover scenarios related to Get Tweet timelines

  @Active
  Scenario: Check that status code for Get statuses/home_timeline request is 200
    Given I make Get request to "statuses/home_timeline.json"
    Then Status code should be 200
  @Active
  Scenario: Check count parameter for Get statuses/home_timeline request
    Given I make Get request to "statuses/home_timeline.json" having parameter "count" is equal to "5"
    Then response should retun 5 tweets

    
