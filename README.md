# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called [Moodle](https://address-of-the-project.com).

Moodle is an open-source learning platform that makes it easy for educators to create and manage online courses. It’s flexible, user-friendly, and widely used in schools, universities, and organizations around the world. One of its standout features is the ability to create interactive lessons, where teachers can easily integrate multimedia content like videos, quizzes, and assignments. Moodle also offers powerful tools for communication, including forums and messaging, so students and teachers can stay connected. Another key feature is its grading system, which allows educators to track student progress and provide feedback. Plus, because it’s open-source, it’s highly customizable to fit the unique needs of any educational institution.

## Installation
we followed the instraction here:
https://docs.moodle.org/405/en/Complete_install_packages_for_Windows?_gl=1*65l900*_ga*MTA1Njg2MDk3Ni4xNzM2NTAyNTM0*_ga_QWYJYEY9P5*MTczNjUwODY0MS4yLjEuMTczNjUwOTQyOC4wLjAuMA..

we download it from here:
https://download.moodle.org/windows/?_gl=1*1x9n0gr*_ga*MTA1Njg2MDk3Ni4xNzM2NTAyNTM0*_ga_QWYJYEY9P5*MTczNjUwODY0MS4yLjEuMTczNjUxMDI0My4wLjAuMA..

we chose 4.5.1+ version

install the server in the Moodle folder and chages paths in the reset files

## What we tested
We tested the quiz module that allows teachers to manage quizzes and students to check their grades. We chose to test the following user stories:
1. Use case: A teacher deletes an existing quiz from an existing course
Preconditions: There is a course with an existing quiz, and the teacher has the necessary permissions to delete quizzes.
Expected outcome: The quiz is successfully deleted from the course and is no longer available to students.

2. Use case: A student tries to check their grade for a quiz
Preconditions: There is a course with an existing quiz, and the student has already attempted the quiz. The quiz grades have been calculated and are available for viewing.
Expected outcome: The student is able to view their grade for the quiz.

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

## Results
Update all README.md files (except for d-e, see Section 1). Specifically, replace all $$*TODO*…$$ according to the instructions inside the $$.

## Detected Bugs
We detected the following bugs:

1. Bug 1: 
   1. General description: Student manages to check grade after deletion
   2. Steps to reproduce: Student goes to the course page -> teacher deletes the quiz -> student clicks on the quiz 
   3. Expected result: Student not able to check grades\ some kind of message
   4. Actual result: Student was able to access quiz grade after the quiz was deleted.
   5. Link to the bug report: None



