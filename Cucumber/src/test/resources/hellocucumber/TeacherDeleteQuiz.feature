# Feature: A set of scenarios for testing the "example" module

#   Scenario: Testing how a case where a user adds a product to the cart
#     Given an example scenario
#     When all step definitions are implemented
#     Then the scenario passes


Feature: Moodle Quiz Management
  As a teacher
  I want to manage quizzes in my course
  So that I can maintain my course content effectively

  Scenario: Teacher deletes a quiz from course
    Given Teacher is on Home Page
    When Teacher is logged in with <username> and <password>
    And Teacher navigates to course number <"1">
    And Teacher deletes quiz number <"1">
    Then the quiz should be successfully deleted


