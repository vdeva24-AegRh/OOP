package Seminars;

import Seminars.Interfaces.Electronic;

public class ParentChildTest {
    public static void invoke(Parent parent) {
        parent.go();
    }
    public static void invoke(Electronic.Child child) {
        child.go();
    }
    public static void main (String [] args) {
        Parent currParent = new Parent();
        invoke(currParent);

        Electronic.Child currChild = new Electronic.Child();
        invoke(currChild);

        Parent currParent1 = new Electronic.Child();
        invoke(currParent1);

    }
}
