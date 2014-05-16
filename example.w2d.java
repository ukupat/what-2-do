// W2D code syntax example

/*
 * W2D has 3 main points
 */

/*
 * Questions
 *
 * Fields where use can give input, ex. "Are you sleepy?" checkbox
 *
 * Questions are marked as hashtags, ex. #sleepyCheck
 *
 * Question can be checkbox and hardcoded select
 */

#howMuchTime = new Select {
	label: "How much time to you have?",
	30: "30 minutes",
	60: "60 minutes",
	5: "5 hours"
}

#sleepy = new Checkbox {
	label: "Are you sleepy?"
}

/*
 * Rules
 *
 * Statements that take given input from user via questions
 * and return true or false based on precept
 *
 * Rules are marked as dollar signs, ex. $readyForGaming
 *
 * Rules are objects that return true or false and are used in declaring activities
 */

$readyForGaming = new Rule {
	true: #howMuchTime is 30 and #sleepy is true,
	true: #howMuchTime is 60 and #sleepy is false,
	false: #howMuchTime is 5 and #sleepy is true,
}

/*
 * Activities
 *
 * Activities are data objects that hold bunch of fields but also rules that must be true
 *
 * Activities are marked as at signs, ex. @cs60Min
 *
 * TODO
 */

@cs = new Game {
	name: "Play Counter Strike",
	how: "With computer",
	rules: $readyForGaming,
}

// Adds object field after creating it
@cs.location("Where computer is")

