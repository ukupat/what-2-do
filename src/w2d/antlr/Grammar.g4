grammar Grammar;

script
  : sentences
  ;

sentences
  : sentence (';' sentence)* ';'
  ;

sentence
  : question
  | ruleObject // Couldn't use rule name
  | activity
  ;

/**
 * Questions
 */
question
  : questionVariable Assignment select    # QuestionSentence
  | questionVariable Assignment checkbox  # QuestionSentence
  ;

questionVariable
  : '#' Variable  # QuestionVariableName
  ;

select
  : 'new Select' ObjectStart fields ObjectEnd # SelectQuestion
  ;

checkbox
  : 'new Checkbox' ObjectStart label ObjectEnd  # CheckboxQuestion
  ;

fields
  : label
  ;

label
  : 'label' KeyAndValueSeparator fieldValue  # LabelField
  ;

fieldValue
  : String  # ObjectFieldValue
  ;

/**
 * Rules
 */
ruleObject
  : ruleVariable Assignment 'new Rule' ObjectStart statements ObjectEnd  # RuleSentence
  ;

ruleVariable
  : '$' Variable  # RuleVariableName
  ;

statements
  : statement (',' statement)*
  ;

statement
  : booleanType KeyAndValueSeparator expressions
  ;

expressions
  : expression ((andOperator|orOperator) expression)*
  ;

expression
  : questionVariable expressionType booleanType
  | questionVariable expressionType String
  ;

booleanType // TODO should be BooleanType
  : 'true'
  | 'false'
  ;

expressionType // TODO should be ExpressionType
  : 'is'
  | 'is not'
  ;

andOperator // TODO should be AndOperator
  : 'and'
  ;

orOperator // TODO should be OrOperator
  : 'or'
  ;

/**
 * Activities
 */
activity
  : activityVariable Assignment 'new Activity' ObjectStart activityFields ObjectEnd # ActivitySentence
  ;

activityVariable
  : '@' Variable  # ActivityVariableName
  ;

activityFields
  : (customField ',')* (rulesField ',')? (customField ',')* titleField (',' customField)*
  | (customField ',')* titleField (',' customField)* (',' rulesField)? (',' customField)*
  ;

customField
  : Variable KeyAndValueSeparator String # ActivityCustomField
  ;

titleField
  : 'title' KeyAndValueSeparator String # ActivityTitleField
  ;

rulesField
  : 'rules' KeyAndValueSeparator ObjectStart ruleField (',' ruleField)* ObjectEnd # ActivityRulesField
  ;

ruleField
  : ruleVariable KeyAndValueSeparator booleanType # ActivityRule
  |                                               # ActivityRule
  ;

/**
 * Stuff
 */
Assignment
  : '='
  ;

KeyAndValueSeparator
  : ':'
  ;

Variable
  : [a-zA-Z][a-zA-Z0-9_]*
  ;

String
  : '"' ~["\n\r]* '"'
  ;

ObjectStart
  : '{'
  ;

ObjectEnd
  : '}'
  ;

/**
 * Different whitespaces for skipping
*/
Whitespaces
  : [ \t\r\n]+ -> skip
  ;

/**
 * Comments and doc
 */
Documentation
  : '/*' .*? '*/' -> skip
  ;

Comment
  : '//' .*? '/n' -> skip
  ;
