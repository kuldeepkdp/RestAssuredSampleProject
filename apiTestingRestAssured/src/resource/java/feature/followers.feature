@ActiveFeature
Feature: 002_Get Follower list
  This feature file cover scenarios related to Get Follower list

  @Active
  Scenario: Check that status code for Get GET followers/list request is 200
    Given I make Get request to "followers/list.json"
    Then Status code should be 200
    Then Response should contain follower list
 
  @Active
  Scenario: Verify follower list
    Given I make Get request to "followers/list.json"
    Then Status code should be 200
    Then Response should contain follower details
    