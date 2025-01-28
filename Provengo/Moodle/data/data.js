
// @provengo summon selenium 



/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */
const URL = "http://localhost";

const xpaths = {
    login_from_main_page : '/html[1]/body[1]/div[2]/nav[1]/div[1]/div[2]/div[1]/div[1]/span[1]/a[1]',
    username_text_box : '//input[@id="username"]',
    password_text_box : '//input[@id="password"]',
    login_button : '//button[@id="loginbtn"]',
    press_on_myCourses: '/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]',

    press_on_course_in_my_coruses: '/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/aside[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[3]/span[2]',
    press_on_quiz_to_see_grade: '/html[1]/body[1]/div[2]/div[4]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]',
    
    delete_quiz_button: "//button[contains(@class,'delete-quiz')]",
    confirm_delete: "//button[contains(@class,'confirm-delete')]",
    grades_link: "//a[contains(@data-key,'grades')]",
    quiz_grades: "//div[contains(@class,'quiz-grades')]",
    OS_course: "//span[@aria-hidden='true' and normalize-space(text())='OS']",
    edit_mode_toggle: "//label[contains(text(),'Edit mode')]",
    Quiz_1: "//a[contains(text(),'Quiz 1')]",
    edit_quiz_1: "/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/ul/li[2]/div[2]/div[2]/div[4]/div/div/div/div/a/i",
    delete_quiz_button: "//*[@id='action-menu-3-menu']/a[8]",
    confirm_delete: "//button[contains(@class,'btn btn-danger')]",

    quiz_grades: "//body/div[2]/div[4]/div[1]/div[2]/div[1]/section[1]/div[2]/ul[1]/li[1]/div[1]/table[1]/tbody[1]/tr[6]/td[1]/b[2]"
  }

const USERS ={
    teacher:{
      username: 'admin',
      password: '12345678Dd-'
    },
    student:{
      username: 'student',
      password: '12345678Dd-'
    }
}

const COURSES = {
  OS:{
    title: 'OS',
    code: 'ISA',
    quizes: [
      { title: 'Quiz 1', code: 'ISA01Q1' }
    ]
  }
}