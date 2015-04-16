parser grammar CutoutParser;

@header {
package cutout.java.util;
}

options {
    tokenVocab = CutoutLexer;
}

template		: (content | cut | cut_block)+ | ;

contentString : (CONTENT | ESCAPE_SEQUENCE)+ ;

content			: contentString ;

defaultValue : contentString;
cut			: CUT_START ID defaultValue? CUT_END ;

cut_block		: cut_block_open template cut_block_close ;
cut_block_open		: CUT_BLOCK_OPEN_START ID CUT_END ;
cut_block_close		: CUT_BLOCK_CLOSE_START ID CUT_END ;
