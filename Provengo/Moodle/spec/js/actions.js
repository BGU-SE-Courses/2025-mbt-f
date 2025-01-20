
// @provengo summon selenium 

/**
 * This is a good place to put specific actions that can be performed on the system under test. 
 * TODO - all actions are hardcoded and should be parametrized - ?
 */

/**
 * This thread is responsible for logging in to the system.
 */
bthread("login",function(){
  let event = sync({waitFor: any("login")});
  let session_log = event.data.session;
  let user = event.data.user;
  session_log.click(xpaths.login_from_main_page);
  session_log.writeText(xpaths.username_text_box, user.username);
  session_log.writeText(xpaths.password_text_box, user.password);
  session_log.click(xpaths.login_button);
  sync({request: Event("login done")});
});

/**
 * This thread is responsible for going to the course from the main page.
 */
bthread("goto course",function(){
  let event = sync({waitFor: any("goto course")});
  let session = event.data.session;
  let course = event.data.course;
  session.click(xpaths.press_on_myCourses);
  session.click(xpaths.press_on_course_in_my_coruses);
  sync({request: Event("goto course done")});
});

/**
 * this thread is responsible for going to a quiz from the course page.
 */
bthread("goto quiz",function(){
  let event = sync({waitFor: any("goto quiz")});
  let session = event.data.session;
  let quiz = event.data.quiz;
  session.click(xpaths.Quiz_1);
  sync({request: Event("goto quiz done")});
});

// TODO - ?
bthread("assert grade",function(){
  let event = sync({waitFor: any("assert grade")});
  let session = event.data.session;
  let quiz = event.data.quiz;
  //assert(grade).isNotNull();
});
