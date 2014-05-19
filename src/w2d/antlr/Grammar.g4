grammar Grammar;

question
	: Question '= new Select {' select '}'	
    | Question '= new Checkbox {' checkbox '}'
    ;

select
	: 'label: ' Text
	| 'options: {' option '},'
	| 'default: ' Key
	;
	
option
	:
	;
	  
Key
	:	[aA-zZ0-9]+
	;

Text
	:	.*?
	;
	
Import
	:	'import ' .*? '.w2d'
	;
	
Question
	: '#' .*? ' '
	;
 
Documentation
    :   '/*' .*? '*/' -> skip
    ;

Comment
	:	'//' .*? '/n' -> skip
	;
