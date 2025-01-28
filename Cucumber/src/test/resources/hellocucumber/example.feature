Feature: A set of scenarios for testing the "example" module

  Scenario Outline: Student checks quiz grade
    Given Student is on Home Page
    When Student is logged in with "<username>" and "<password>"
    And Student navigates to my courses and course
    And Student check grade to the quiz
    Then the student can see the grade

    Examples:
      | username | password |
      | yakinaf | Yn318969177# |


  Scenario Outline: Teacher deletes a quiz from course
    Given Teacher is on Home Page
    When Teacher is logged in with "<username>" and "<password>"
    And Teacher navigates to course name
    And Teacher deletes quiz number
    Then the quiz should be successfully deleted

  Examples:
    | username | password |
    | noapatch | Noa319123048# |




