package com.accenture.propostaBackEnd.utils;

public enum SearchOperation {
	EQUALITY, NEGATION, GREATER_THAN, LESS_THAN, LIKE, STARTS_WITH, ENDS_WITH, CONTAINS;
	 
    public static final String[] SIMPLE_OPERATION_SET = { ":", "!", ">", "<", "~" };
    public static final String OR_PREDICATE_FLAG = "'";
    public static final String ZERO_OR_MORE_REGEX = "*";
    
    public static SearchOperation getSimpleOperation(char input) {
        switch (input) {
        case ':':
            return EQUALITY;
        case '!':
            return NEGATION;
        case '>':
            return GREATER_THAN;
        case '<':
            return LESS_THAN;
        case '~':
            return LIKE;
        default:
            return null;
        }
    }
}