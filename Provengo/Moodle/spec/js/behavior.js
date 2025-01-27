// Use Provengo-specific ways to handle selenium sessions or browsers
// @provengo summon ctrl

/**
 * This thread is responsible for the student watching his quiz grades.
 * It logs in as a student, goes to the course, and then to the quiz.
 */
bthread("student watches quiz grades", function() {

  // Open selenium session
  let session = new SeleniumSession("student", "chrome");
  session.start(URL);

  // Login
  login(session, USERS.student);

  sync({request: Ctrl.markEvent("Student Logged in")});

  // go to course
  goto_course_from_main_page(session);

  sync({request: Ctrl.markEvent("Student Goes to Course")});

  // go to quiz
  goto_quiz_from_course_page(session);

  // There is no way to actually check if the student is watching his grades

  sync({request: Ctrl.markEvent("Student Checks Grade")});
});

/**
 * This thread is responsible for the teacher deleting a quiz.
 * It logs in as a teacher, goes to the course, and deletes the quiz.
 */
bthread("teacher deletes quiz", function() {

  // Open selenium session
  let session = new SeleniumSession("teacher", "chrome");
  session.start(URL);

  // Login
  login(session, USERS.teacher);

  sync({request: Ctrl.markEvent("Teacher Logged in")});

  // go to course
  goto_course_from_main_page(session);

  sync({request: Ctrl.markEvent("Teacher goes to course")});

  // enable editing mode
  toggle_edit_mode(session);

  // delete quiz
  delete_quiz(session);

  sync({request: Ctrl.markEvent("Teacher Deletes Quiz")});
}); 


