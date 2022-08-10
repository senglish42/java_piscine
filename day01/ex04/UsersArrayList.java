package ex04;

public class UsersArrayList implements UsersList
{
    User[] array;
    int size;
    int count;
    public UsersArrayList()
    {
        this.size = 10;
        this.count = 0;
        this.array = new User[this.size];
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
            array[count] = newUser;
            ++count;
            if (count % 10 == 0)
            {
                this.size += this.size / 2 + 1;
                User[] temp_array = this.array;
                this.array = new User[this.size];
                for (int count = 0; count < this.count; ++count)
                    this.array[count] = temp_array[count];
            }
        }
    }
    public User retrieveById(int id) throws UserNotFoundException
    {
        for (int count = 0; count < this.count; ++count)
        {
            if (id == this.array[count].getId())
                return this.array[count];
        }
        throw new UserNotFoundException();
    }
    public User retrieveByIndex(int index) throws ArrayIndexOutOfBoundsException
    {
        if (index < 0 || index > this.count)
            throw new ArrayIndexOutOfBoundsException();
        return this.array[index];
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
            this.array[count].getInfo();
            System.out.println("..................................");
        }
    }
}
