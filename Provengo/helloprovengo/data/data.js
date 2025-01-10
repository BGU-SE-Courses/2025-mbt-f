/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */
const URL = 'http://localhost';

const xpaths = {

    login_from_main_page : '//div[@id="usernavigation"]//a',
    username_text_box : '//input[@id="username"]',
    password_text_box : '//input[@id="password"]',
    login_button : '//button[@id="loginbtn"]',
    
}

const seleniumSession = new SeleniumSession("user") 

const USERS ={
    teacher:{
      username: 'teacher',
      password: 'teacher'
    },
    student:{
      username: 'student',
      password: 'student'
    }
}

const COURSES=[
  {
      title: 'OS',
      code: 'ISA',
      quizes:[
        {
          title: 'Quiz 1',
          code: 'ISA01Q1',
          questions:[
            {
              title: 'Q1',
              code: 'ISA01Q1Q1'
            },
            {
              title: 'Q2',
              code: 'ISA01Q1Q2'
            }
          ]
        },
        {
          title: 'Quiz 2',
          code: 'ISA01Q2',
          questions:[
            {
              title: 'Q1',
              code: 'ISA01Q2Q1'
            },
            {
              title: 'Q2',
              code: 'ISA01Q2Q2'
            }
          ]
        }
      ]
  }


]