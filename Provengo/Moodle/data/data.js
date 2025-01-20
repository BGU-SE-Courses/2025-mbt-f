
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
    press_on_myCourses: '/html[1]/body[1]/div[2]/nav[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]',
    press_on_course_in_my_coruses: '/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/aside[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[3]/span[2]',
    press_on_quiz_to_see_grade: '/html[1]/body[1]/div[2]/div[4]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]',
    
    delete_quiz_button: "//button[contains(@class,'delete-quiz')]",
    confirm_delete: "//button[contains(@class,'confirm-delete')]",
    grades_link: "//a[contains(@data-key,'grades')]",
    quiz_grades: "//div[contains(@class,'quiz-grades')]",
    OS_course: "//span[contains(text(),'OS')]",
    Quiz_1: "//span[@class='instancename' and text()='Quiz 1 ']",
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
      { title: 'Quiz 1', code: 'ISA01Q1' },
      { title: 'Quiz 2', code: 'ISA01Q2' }
    ]
  }
}