// Use Provengo-specific ways to handle selenium sessions or browsers

bthread("student watches quiz grades", function() {
  let session = new SeleniumSession("student", "chrome");
  session.start(URL);

  // Login
  login(session, USERS.student);

  // choose course - do we need?
  let course = choose(COURSES);

  // go to course - do we need?
  goto_course_from_main_page(session, course);

  // choose quiz - do we need?
  let quiz = choose(course.quizes);

  // go to quiz
  goto_quiz_from_course_page(session, quiz);

  // assert there is a grade
  assert_grade_in_quiz(session);
});


bthread("teacher deletes quiz", function() {
  let session = new SeleniumSession("teacher", "chrome");
  session.start(URL);

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

});