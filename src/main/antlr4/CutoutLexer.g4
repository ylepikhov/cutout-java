lexer grammar CutoutLexer;

@header {
package cutout.java.util;
}

CUT_BLOCK_OPEN_START	: '{?' -> mode(CUT_MODE) ;
CUT_BLOCK_CLOSE_START	: '{/' -> mode(CUT_MODE) ;
CUT_START		: '{' -> mode(CUT_MODE) ;

CONTENT			: ~[\\{}]+ ;
fragment
ESCAPE          : '\\' ;
ESCAPE_SEQUENCE		: ESCAPE .
{
     String s = getText();
     setText(s.substring(1));
} ;

mode CUT_MODE ;

fragment
UPPERCASE_LETTER	: [A-Z] ;
fragment
LOWERCASE_LETTER	: [a-z] ;
fragment
DIGIT			: [0-9] ;
fragment
UNDERSCORE		: '_' ;

CUT_END			: '}' -> mode(DEFAULT_MODE) ;

ID			: (UPPERCASE_LETTER | LOWERCASE_LETTER) (UPPERCASE_LETTER | LOWERCASE_LETTER | DIGIT | UNDERSCORE)* ;

WS_SKIP			: [ \t\r\n]+ -> skip ;

VALUE_START		: '=' -> mode(VALUE_MODE), skip ;

mode VALUE_MODE	;

VALUE_CONTENT		: ~[\\{}]+ -> type(CONTENT) ;
VALUE_ESCAPE_SEQUENCE	: ESCAPE .
{
     String s = getText();
     setText(s.substring(1));
}
-> type(ESCAPE_SEQUENCE) ;
VALUE_CUT_END		: '}' -> type(CUT_END), mode(DEFAULT_MODE) ;
