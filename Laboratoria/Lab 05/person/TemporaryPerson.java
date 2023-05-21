package com.company.person;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class TemporaryPerson extends Person{
    private String path;
    private List<String> parentNames;
    private List<String> childrenNames;

    public TemporaryPerson(String name, LocalDate birth, LocalDate death, String path, List<String> parentNames, List<String> childrenNames) {
        super(name, birth, death);
        this.path = path;
        this.parentNames = parentNames;
        this.childrenNames = childrenNames;
    }

    public String getPath() {
        return path;

    }

    public List<String> getParentNames() {
        return parentNames;
    }

//    Zadanie 7
//    public void convert(Map<String, TemporaryPerson> temporaryMap) {
//        for(String parentName : parentNames) {
//            Person parent = temporaryMap.get(parentName);
//            if(parent == null)
//                throw new UndefinedPersonReferenceException(path, getName());
//            this.parents.add(parent);
//        }
//    }
//
//    public void convertChildren(Map<String, TemporaryPerson> temporaryMap) {
//        for(String childName : childrenNames) {
//            Person child = temporaryMap.get(childName);
//            if(child == null)
//                throw new UndefinedPersonReferenceException(path, getName());
//            this.children.add(child);
//        }
//    }

    // Zadanie 8
    public void convert(Map<String, TemporaryPerson> temporaryMap) {
        for(String parentName : parentNames) {
            Person parent = temporaryMap.get(parentName);
            if(parent == null)
                throw new ParentNotReferencingChildException(path, getName());
            this.parents.add(parent);
        }
    }

    public void convertChildren(Map<String, TemporaryPerson> temporaryMap) {
        for(String childName : childrenNames) {
            Person child = temporaryMap.get(childName);
            if(child == null)
                throw new ChildNotReferencingParentException(path, getName());
            this.children.add(child);
        }
    }
}
