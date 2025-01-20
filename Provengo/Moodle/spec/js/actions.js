
// @provengo summon selenium 

bthread("start chrome as student", function() {
  let session = new SeleniumSession("student", "chrome");
  session.start(URL);  // Start the session at the given URL
  sync({
    request: Event("login", { login: true, session: session, user: USERS.teacher })  // Perform login
  });
});

bthread("login",function(){
  let event = sync({waitFor: any("login")});
  let session_log = event.data.session;
  let user = event.data.user;
  session_log.click(xpaths.login_from_main_page);
  session_log.writeText(xpaths.username_text_box, user.username);
  session_log.writeText(xpaths.password_text_box, user.password);
  session_log.click(xpaths.login_button);
  sync({request: Event("login done",{session: session_log.name})});
});

bthread("goto course",function(){
  let event = sync({waitFor: any("goto course")});
  let session = event.data.session;
  let course = event.data.course;
  session.click(xpaths.press_on_myCourses);
  session.click(xpaths.press_on_course_in_my_coruses);
  sync({request: Event("goto course done",{session: session.name})});
});

bthread("goto quiz",function(){
  let event = sync({waitFor: any("goto quiz")});
  let session = event.data.session;
  let quiz = event.data.quiz;
  session.click(xpaths.Quiz_1);
  sync({request: Event("goto quiz done",{session: session.name})});
});

bthread("assert grade",function(){
  let event = sync({waitFor: any("assert grade")});
  let session = event.data.session;
  let quiz = event.data.quiz;
  session.click(xpaths.grades_link);
  session.assertExists(xpaths.quiz_grades);
});
