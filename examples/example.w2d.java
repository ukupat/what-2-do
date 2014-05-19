// W2D code syntax example

// Users can import other files with directory
import ../fields/ExtraFields.w2d

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

// Select returns strings
#howMuchTime = new Select {
	label: "How much time do you have?", // Label is required, Exception is thrown on that
	options: { // Options are required, Exception is thrown on that
		30min: "30 minutes",
		60min: "60 minutes",
		5hr: "5 hours",
	},
	default: 30min
}

// Checkbox returns true or false - boolean types
#sleepy = new Checkbox {
	label: "Are you sleepy?", // Label is required, Exception is thrown on that
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
	true: #howMuchTime is 30min and #sleepy is true, // Basically it is -> return #howMuchTime == "30 minutes" && #sleepy == true;
	true: #howMuchTime is 60min and #sleepy is false,
	false: #howMuchTime is 5hr and #sleepy is true,
}

/*
 * Activities
 *
 * Activities are data objects that hold bunch of fields but also rules that must be true
 *
 * Activities are marked as at signs, ex. @cs60Min
 *
 * Activities are objects that have rules and data fields
 */

@cs = new Activity {
	rules: { // If there are no rules then it is always in option2
		$readyForGaming: true,
		$nextRule: false, // It says that this rule must return false
	}
	desc: "Play Counter Strike NOW",
	howToPlay: "With computer", // Keys must be one word
}

@sleep = new Activity {
	rules: { // If there are no rules then it is always in option
		$readyForGaming: false,
	}
	desc: "Go to sleep please"
}

// Return UI, if ui is not returned then nothing happens
return new UI {
	@sleep: "It's time to sleep", // Activitiy and its title
	@cs: "Counter Strike",
}