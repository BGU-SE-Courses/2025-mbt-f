
// /* @provengo summon selenium */


/* Use-case teacher delete quiz from course */
    
bthread("delete quiz from course",function(){
    let session = new SeleniumSession("teacher");
    session.start(URL);
    sync({request: Event("login",{login: true, session: session, user: USERS.teacher})});
    let course = choose(COURSES);
    sync({request: Event("goto course", {login: true, session:session, course:course})});
    let quiz = choose(course.quizes);
    sync({request: Event("delete quiz", {login: true, session:session, quiz:quiz})});

});



bthread("wait for login", function() {
    while (true) {
        let e = sync({ waitFor: any({login: true})});
        let sessionName = e.data.session.name;
        sync({
            waitFor: Event("login done", { session: sessionName }),
            block: any({login: true})
        });
    }
});










// bthread("student check deleted quiz grade", function(){
//     let session = new SeleniumSession("student").start(URL);
//     sync({request: Event("login",{login: true, session: session, user: USERS.student})});
//     let course = choose(COURSES);
//     sync({request: Event("goto course", {login: true, session:session, course:course})});
//     sync({request: Event("view grades", {login: true, session:session, course:course})});
// });


// // Student trying to view deleted quiz grades
// bthread("student check deleted quiz grade", function(){
//     let session = new SeleniumSession("student").start(URL);
//     sync({request: Event("login",{login: true, session: session, user: USERS.student})});
//     let course = choose(COURSES);
//     sync({request: Event("goto course", {login: true, session:session, course:course})});
//     sync({request: Event("view grades", {login: true, session:session, course:course})});
// });

// // Handler for navigating to course
// bthread("goto course handler", function() {
//     while(true) {
//         let e = sync({waitFor: any("goto course")});
//         let session = e.data.session;
//         let course = e.data.course;
//         session.click(//h3[contains(text(),'${course.title}')]);
//         sync({request: Event("course opened", {session: session})});
//     }
// });

// // Handler for viewing grades
// bthread("view grades handler", function() {
//     while(true) {
//         let e = sync({waitFor: any("view grades")});
//         let session = e.data.session;
//         // Click on grades section
//         session.click("//a[contains(@data-key,'grades')]");
//         sync({request: Event("grades viewed", {session: session})});
//     }
// });



// // Update the delete quiz handler
// bthread("delete quiz handler", function() {
//     while(true) {
//         let e = sync({waitFor: any("delete quiz")});
//         let session = e.data.session;
//         let quiz = e.data.quiz;
        
//         // Navigate to quiz settings
//         session.click(//a[contains(text(),'${quiz.title}')]//following::a[contains(@class,'editing')]);
        
//         // Click delete button
//         session.click(xpaths.delete_quiz_button);
        
//         // Confirm deletion
//         session.click(xpaths.confirm_delete);
        
//         sync({request: Event("quiz deleted", {session: session})});
//     }
// });

// // Add verification for deleted quiz
// bthread("verify deleted quiz", function() {
//     while(true) {
//         let e = sync({waitFor: Event("quiz deleted")});
//         let session = e.data.session;
//         let quiz = e.data.quiz;
        
//         // Verify quiz is no longer visible
//         try {
//             session.waitForInvisibility(//a[contains(text(),'${quiz.title}')]);
//             sync({request: Event("quiz delete verified", {session: session})});
//         } catch(error) {
//             sync({request: Event("verification failed", {
//                 session: session, 
//                 error: "Quiz still visible after deletion"
//             })});
//         }
//     }
// });

// // Add verification for student grade view
// bthread("verify student grade view", function() {
//     while(true) {
//         let e = sync({waitFor: Event("grades viewed")});
//         let session = e.data.session;
        
//         // Verify appropriate message is shown
//         try {
//             session.waitForVisibility("//div[contains(@class,'alert-warning')]");
//             sync({request: Event("grade view verified", {session: session})});
//         } catch(error) {
//             sync({request: Event("verification failed", {
//                 session: session,
//                 error: "No warning message shown for deleted quiz"
//             })});
//         }
//     }
// });