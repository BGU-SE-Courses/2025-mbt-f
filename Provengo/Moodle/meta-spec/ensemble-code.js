// @provengo summon ctrl

// Domain Specific

// We defined the domain specific goals in this specific order 
// As we thought that the moodle may not work properly if the student is in 
// the course page and the teacher deletes the quiz as the student can still press on the quiz button 
// even if the quiz was deleted

/**
 * The goals in our test suite is to make sure that the teacher can delete a quiz and the student can check his grade.
 
const GOALS = [
    Ctrl.markEvent("Student Goes to Course"),
    Ctrl.markEvent("Teacher Deletes Quiz"),
    Ctrl.markEvent("Student Checks Grade")
];*/

/**
 * count how many tests in the ensemble have the goals met in order.
 *
 * @param {Event[][]} ensemble The test suite to be ranked.
 * @returns Number of events from GOALS that have been met.
 
function rankByDomainSpecific(ensemble) {

    let sum = 0;

    // for each test
    for (let index = 0; index < ensemble.length; index++) {

        // get the test
        let test = ensemble[index];

        // find the goals that were met in the test
        let goals_met_indicies = [];

        // for each goal
        for (let goal of GOALS) {
            let index = test.findIndex(e => e.name == goal.name)
            if (index != -1) {
                goals_met_indicies.push(index);
            }
        }

        // if all goals were not met, skip this test
        if (goals_met_indicies.length != GOALS.length) 
            continue;

        // make sure the goals were met in order
        let last_index = -1;
        let goals_met = true;
        for (let index of goals_met_indicies) {
            if (index < last_index) {
                goals_met = false;
                break;
            }
            last_index = index;
        }

        if (!goals_met)
            continue;

        // all events in the goal list were met
        sum++;
    }

    return sum;
}*/

/**
 * Ranks potential test suites based on the percentage of goals they cover.
 * Goal events are defined in the GOALS array above. An ensemble with rank
 * 100 covers all the goal events.
 *
 * Multiple ranking functions are supported - to change ranking function,
 * use the `ensemble.ranking-function` configuration key, or the 
 * --ranking-function <functionName> command-line parameter.
 *
 * @param {Event[][]} ensemble the test suite/ensemble to be ranked
 * @returns the percentage of goals covered by `ensemble`.
 * 
 function rankingFunction(ensemble) {
    
    // How many goals did `ensemble` hit?
    const metGoalsCount = rankByDomainSpecific(ensemble);
    // What percentage of the ensemble had the specific order of goals met
    const metGoalsPercent = metGoalsCount/ensemble.length;

    return metGoalsPercent * 100; // convert to human-readable percentage
} */



// Two way

// @provengo summon ctrl

const STUDENT_GOALS = [
    Ctrl.markEvent("Student Logged in"),
    Ctrl.markEvent("Student Goes to Course"),
    Ctrl.markEvent("Student Checks Grade")
];

const TEACHER_GOALS = [
    Ctrl.markEvent("Teacher Logged in"),
    Ctrl.markEvent("Teacher goes to course"),
    Ctrl.markEvent("Teacher Deletes Quiz")
];

const GOALS = [
    [Ctrl.markEvent("Student Logged in"), Ctrl.markEvent("Student Goes to Course"), Ctrl.markEvent("Student Checks Grade"), Ctrl.markEvent("Teacher Logged in"), Ctrl.markEvent("Teacher goes to course"), Ctrl.markEvent("Teacher Deletes Quiz")],
    [Ctrl.markEvent("Student Logged in"), Ctrl.markEvent("Student Goes to Course"), Ctrl.markEvent("Teacher Logged in"), Ctrl.markEvent("Student Checks Grade"), Ctrl.markEvent("Teacher goes to course"), Ctrl.markEvent("Teacher Deletes Quiz")],
    [Ctrl.markEvent("Student Logged in"), Ctrl.markEvent("Teacher Logged in"), Ctrl.markEvent("Student Goes to Course"), Ctrl.markEvent("Student Checks Grade"), Ctrl.markEvent("Teacher goes to course"), Ctrl.markEvent("Teacher Deletes Quiz")],
    [Ctrl.markEvent("Teacher Logged in"), Ctrl.markEvent("Student Logged in"), Ctrl.markEvent("Student Goes to Course"), Ctrl.markEvent("Student Checks Grade"), Ctrl.markEvent("Teacher goes to course"), Ctrl.markEvent("Teacher Deletes Quiz")],
    [Ctrl.markEvent("Student Logged in"), Ctrl.markEvent("Student Goes to Course"), Ctrl.markEvent("Teacher Logged in"), Ctrl.markEvent("Teacher goes to course"), Ctrl.markEvent("Student Checks Grade"), Ctrl.markEvent("Teacher Deletes Quiz")],
    [Ctrl.markEvent("Student Logged in"), Ctrl.markEvent("Teacher Logged in"), Ctrl.markEvent("Student Goes to Course"), Ctrl.markEvent("Teacher goes to course"), Ctrl.markEvent("Student Checks Grade"), Ctrl.markEvent("Teacher Deletes Quiz")],
    [Ctrl.markEvent("Teacher Logged in"), Ctrl.markEvent("Student Logged in"), Ctrl.markEvent("Student Goes to Course"), Ctrl.markEvent("Teacher goes to course"), Ctrl.markEvent("Student Checks Grade"), Ctrl.markEvent("Teacher Deletes Quiz")],
    [Ctrl.markEvent("Student Logged in"), Ctrl.markEvent("Teacher Logged in"), Ctrl.markEvent("Teacher goes to course"), Ctrl.markEvent("Student Goes to Course"), Ctrl.markEvent("Student Checks Grade"), Ctrl.markEvent("Teacher Deletes Quiz")],
    [Ctrl.markEvent("Teacher Logged in"), Ctrl.markEvent("Student Logged in"), Ctrl.markEvent("Teacher goes to course"), Ctrl.markEvent("Student Goes to Course"), Ctrl.markEvent("Student Checks Grade"), Ctrl.markEvent("Teacher Deletes Quiz")],
    [Ctrl.markEvent("Teacher Logged in"), Ctrl.markEvent("Teacher goes to course"), Ctrl.markEvent("Student Logged in"), Ctrl.markEvent("Student Goes to Course"), Ctrl.markEvent("Student Checks Grade"), Ctrl.markEvent("Teacher Deletes Quiz")]
];

/**
 * checks out of all the possible paths
 * 
 * @param {Event[][]} ensemble 
 * @returns the fraction of paths met
 */
function rankByTwoWay(ensemble) {
    // List of all possible goal permutations
    let permutations = GOALS;

    // Save the total number of valid permutations
    const totalPermutations = permutations.length;

    // Remove permutations that are fully matched in the tests
    for (let test of ensemble) {
        permutations = permutations.filter(perm => {
            let testIndex = 0; // Start from the beginning of the test
            return !perm.every(event => {
                const foundIndex = test.findIndex((t, i) => i >= testIndex && t.name === event.name);
                if (foundIndex === -1) {
                    return false; // Event not found, stop checking this permutation
                }
                testIndex = foundIndex + 1; // Move to the next position for order checking
                return true; // Continue checking the next event in the permutation
            });
        });
    }

    // Calculate the fraction of permutations matched
    return (totalPermutations - permutations.length) / totalPermutations;
}

/**
 * We defined all the orders possible for the system
 * We will check how many of these orders are met in the tests
 * and maximize the number of orders met
 * 
 * @param {Event[][]} ensemble 
 * @returns 
 */
 function rankingFunction(ensemble) {
    
    // How many possible paths did the ensemble meet
    const metGoalsPercent = rankByTwoWay(ensemble);

    return metGoalsPercent * 100 ; // convert to human-readable percentage
}

