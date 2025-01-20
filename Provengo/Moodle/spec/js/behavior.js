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
  let course = choose(COURSES);
  // go to course
  sync({ request: Event("goto course", { login: true, session: session, course: course }) });
  let quiz = choose(course.quizes);
  // go to quiz
  sync({ request: Event("goto quiz", { login: true, session: session, quiz: quiz }) });
  // assert there is a grade
  sync({ request: Event("assert grade", { login: true, session: session, quiz: quiz }) });
});

bthread("wait for login", function() {
  while (true) {
    let e = sync({ waitFor: any({ login: true }) });
    let sessionName = e.data.session.name;
    sync({
      waitFor: Event("login done", { session: sessionName }),
      block: any({ login: true })
    });
  }
});
