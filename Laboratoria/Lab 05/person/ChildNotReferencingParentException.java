package com.company.person;

public class ChildNotReferencingParentException extends ParentChildInconsistencyException{
    public ChildNotReferencingParentException(String path, String name) {
        super(path, name);
    }
}
