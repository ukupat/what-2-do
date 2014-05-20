grammar Grammar;

script
  : sentences
  ;

sentences
  : sentence (';' sentence)* ';'
  ;

sentence
  : question
  ;

/**
 * Questions
 */
question
  : questionVariable Assignment select  # QuestionSentence
  | questionVariable Assignment checkbox  # QuestionSentence
  ;

questionVariable
  : '#' Variable  # QuestionVariableName
  ;

select
  : 'new Select' '{' fields '}' # SelectQuestion
  ;

checkbox
  : 'new Checkbox' '{' label '}'  # CheckboxQuestion
  ;

fields
  : label
  | customField
  ;

label
  : 'label' KeyAndValueSeparator fieldValue  # LabelField
  ;

customField
  : Variable KeyAndValueSeparator String
  ;

fieldValue
  : String  # ObjectFieldValue
  ;

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
  :   '"' ~["\n\r]* '"'
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
