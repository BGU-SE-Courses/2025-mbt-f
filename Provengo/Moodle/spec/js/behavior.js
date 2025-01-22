// Use Provengo-specific ways to handle selenium sessions or browsers
// @provengo summon ctrl

var deleted_quiz = false;

/**
 * This thread is responsible for the student watching his quiz grades.
 
bthread("student watches quiz grades", function() {

  // Open selenium session
  let session = new SeleniumSession("student", "chrome");
  session.start(URL);

  // Sleep to get the page loaded - TODO - remove
  Ctrl.doSleep(5000)

  // Login
  login(session, USERS.student);

  // choose course - do we need?
  let course = choose(COURSES);

  // go to course - do we need?
  goto_course_from_main_page(session, course);

  // choose quiz - do we need?
  let quiz = choose(course.quizes);

  // split behavior if the quiz is deleted or not synced with the teacher bthread
  if(deleted_quiz){

    // assert there is no quiz
    //assert_no_quiz_in_course_page(session, quiz);

  } else {

    // go to quiz
    goto_quiz_from_course_page(session, quiz);

    // assert there is a grade
    //assert_grade_in_quiz(session);

  }
});*/

/**
 * This thread is responsible for the teacher deleting a quiz.
 */
bthread("teacher deletes quiz", function() {

  // Open selenium session
  let session = new SeleniumSession("teacher", "chrome");
  session.start(URL);

  // Sleep to get the page loaded - TODO - remove
  //Ctrl.doSleep(5000)

  // Login
  login(session, USERS.teacher);

  // choose course - do we need?
  let course = choose(COURSES);

  // go to course - do we need?
  goto_course_from_main_page(session, course);

  // enable editing mode
  toggle_edit_mode(session);

  // choose quiz - do we need?
  let quiz = choose(course.quizes);

  // delete quiz
  delete_quiz(session, quiz);

  // indicator that the quiz has been deleted
  deleted_quiz = true;
}); 