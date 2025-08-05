package org.miaoubich;

@FunctionalInterface
public interface StringOperator {
    String apply(String input);
    
    static StringOperator capitalize() {
        return str -> str == null || str.trim().isEmpty() 
            ? str 
            : str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    default StringOperator andThen(StringOperator after) {
        return str -> after.apply(this.apply(str));
    }
}
