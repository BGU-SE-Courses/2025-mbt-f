
// @provengo summon selenium 

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



























// bthread("login", function () {
//     let event = sync({ waitFor: any("login") });
//     let session_log = event.data.session;
//     let user = event.data.user;

//     // Emit an event for each action
//     sync({ request: Event("click login from main page", { session: session_log }) });
//     session_log.click(xpaths.login_from_main_page);

//     sync({ request: Event("write username", { session: session_log, username: user.username }) });
//     session_log.writeText(xpaths.username_text_box, user.username);

//     sync({ request: Event("write password", { session: session_log, password: user.password }) });
//     session_log.writeText(xpaths.password_text_box, user.password);

//     sync({ request: Event("click login button", { session: session_log }) });
//     session_log.click(xpaths.login_button);

//     // Signal that login is complete
//     sync({ request: Event("login done", { session: session_log }) });
// });