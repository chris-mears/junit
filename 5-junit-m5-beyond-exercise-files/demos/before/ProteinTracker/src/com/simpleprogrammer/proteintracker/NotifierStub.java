package com.simpleprogrammer.proteintracker;

//This overrides the dependency so it will always return true
//This is helpful trying to get around a dependency when you need to test
public class NotifierStub implements Notifier {

    @Override
    public boolean send(String message) {
        return true;
    }
}
