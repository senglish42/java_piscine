package ex03;

public interface UsersList
{
    void addUser(User newUser);
    User retrieveById(int id) throws UserNotFoundException;
    User retrieveByIndex(int index) throws ArrayIndexOutOfBoundsException;
    int retrieveNum();
    int retrieveArrSize();
    void getInfo();
}
