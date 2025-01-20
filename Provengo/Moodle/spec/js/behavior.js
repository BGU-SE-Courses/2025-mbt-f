// Use Provengo-specific ways to handle selenium sessions or browsers

// bthread("delete quiz from course", function() {
//   let session = new SeleniumSession("teacher", "chrome");
//   session.start(URL);
//   sync({ request: Event("login", { login: true, session: session, user: USERS.student }) });
//   let course = choose(COURSES);
//   sync({ request: Event("goto course", { login: true, session: session, course: course }) });
//   let quiz = choose(course.quizes);
//   sync({ request: Event("delete quiz", { login: true, session: session, quiz: quiz }) });
// });

bthread("student watches quiz grades", function() {
  let session = new SeleniumSession("student", "chrome");
  session.start(URL);

  // login
  sync({ request: Event("login", { login: true, session: session, user: USERS.student }) });
  sync({ waitFor: Event("login done")});

  // choose course - do we need?
  let course = choose(COURSES);

  // go to course - do we need?
  sync({ request: Event("goto course", { login: true, session: session, course: course }) });
  sync({ waitFor: Event("goto course done")});

  // choose quiz - do we need?
  let quiz = choose(course.quizes);

  // go to quiz
  sync({ request: Event("goto quiz", { login: true, session: session, quiz: quiz }) });
  sync({ waitFor: Event("goto quiz done")});

  // assert there is a grade
  sync({ request: Event("assert grade", { login: true, session: session, quiz: quiz }) });
});


