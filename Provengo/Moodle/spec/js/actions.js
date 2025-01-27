
// @provengo summon selenium 
// @provengo summon ctrl

/**
 * This is a good place to put specific actions that can be performed on the system under test. 
 */

/**
 * This function is responsible for logging in to the system.
 * @param {session} session - the selenium session.
 * @param {user} user - the user to login with.
 */
function login(session, user){
  session.click(xpaths.login_from_main_page);
  session.writeText(xpaths.username_text_box, user.username);
  session.writeText(xpaths.password_text_box, user.password);
  session.click(xpaths.login_button);
}

/**
 * This function is responsible for going to the course from the main page.
 * Assumption - the user is already logged in and in the main page
 * @param {session} session - the selenium session.
 * @param {course} course - the course to go to.
 */
function goto_course_from_main_page(session){

  // Wait for the my courses button to be clickable
  session.waitForClickability(xpaths.press_on_myCourses, 1000)

  // Press on my courses
  session.click(xpaths.press_on_myCourses);
    
  // Wait for the course to be clickable
  session.waitForClickability(xpaths.OS_course, 1000)

  // Press on the course
  session.click(xpaths.OS_course);  
};

/**
 * this thread is responsible for going to a quiz from the course page.
 * @param {session} session - the selenium session.
 * @param {quiz} quiz - the quiz to go to.
 */
function goto_quiz_from_course_page(session){
  session.click(xpaths.Quiz_1);
};

/**
 * This function is responsible for toggling the edit mode.
 * @param {session} session - the selenium session.
 */
function toggle_edit_mode(session){
  session.click(xpaths.edit_mode_toggle);
}

/**
 * This function is responsible for deleting a quiz.
 * @param {session} session - the selenium session.
 * @param {quiz} quiz - the quiz to delete.
 */
function delete_quiz(session){

  // press on edit
  session.waitForClickability(xpaths.edit_quiz_1, 1000)
  session.click(xpaths.edit_quiz_1);

  // press on delete
  session.click(xpaths.delete_quiz_button);

  // wait for the popup to appear
  Ctrl.doSleep(500)

  // TODO remove the comment after checking 
  // Confirm delete
  session.click(xpaths.confirm_delete);
}

