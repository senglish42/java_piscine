package edu.school21.chat.app;

public class NotSavedSubEntityException extends RuntimeException{
    @Override
    public String toString() {
        return "The message is given can not be saved.";
    }
}
