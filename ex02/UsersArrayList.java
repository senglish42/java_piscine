package ex02;

import java.util.ArrayList;

public class UsersArrayList implements UsersList
{
    ArrayList<User> arrayList;
    int size;
    int count;
    public UsersArrayList()
    {
        this.size = 10;
        this.count = 0;
        arrayList = new ArrayList<>(this.size);
    }
    public void addUser(User newUser)
    {
        try
        {
            retrieveById(newUser.getId());
            System.out.println("User " + newUser.getName() + " is already added to the UsersArrayList. Can not add twice.");
        }
        catch (UserNotFoundException e)
        {
            System.out.println("User " + newUser.getName() + " has been added to the UsersArrayList just now.");
            arrayList.add(newUser);
            ++count;
            if (count % 10 == 0)
            {
                this.size += this.size / 2;
                arrayList.ensureCapacity(this.size);
            }
        }
    }
    public User retrieveById(int id) throws UserNotFoundException
    {
        for (int count = 0; count < this.count; ++count)
        {
            if (id == arrayList.get(count).getId())
                return arrayList.get(count);
        }
        throw new UserNotFoundException();
    }
    public User retrieveByIndex(int index) throws ArrayIndexOutOfBoundsException
    {
        if (index < 0 || index > this.count)
            throw new ArrayIndexOutOfBoundsException();
        return arrayList.get(index);
    }
    public int retrieveNum()
    {
        return this.count;
    }
    public int retrieveArrSize()
    {
        return this.size;
    }
    public void getInfo()
    {
        for (int count = 0; count < this.count; ++count)
        {
            arrayList.get(count).getInfo();
            System.out.println("..................................");
        }
    }
}
