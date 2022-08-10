package ex04;

public class UserNotFoundException extends RuntimeException
{
    public String what() {
        return "\033[31mCan not retrieve user by ID is given.\033[0m";
    }
    public String toString() { return this.what(); }
}
