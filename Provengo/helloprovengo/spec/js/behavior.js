/* @provengo summon selenium */

/* Use-case teacher delete quiz from course */
    
bthread("delete quiz",function(){
    let session = new SeleniumSession("teacher").start(URL);
    sync({request: Event("login",{session:session,user: USERS.teachr})});
    let course = choose(COURSES);
    sync({request: Event("goto course", {session:session,course:course})});
    let quiz = choose(course.quizes);
    sync({request: Event("delete quiz", {session:session,quiz:quiz})});

})


