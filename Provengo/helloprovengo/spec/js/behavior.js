
// @provengo summon selenium 




/* Use-case teacher delete quiz from course */
    
bthread("delete quiz from course",function(){
    let session = new SeleniumSession("teacher").start(URL);
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

