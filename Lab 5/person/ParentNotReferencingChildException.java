package com.company.person;

public class ParentNotReferencingChildException extends ParentChildInconsistencyException{
    public ParentNotReferencingChildException(String path, String name) {
        super(path, name);
    }
}
