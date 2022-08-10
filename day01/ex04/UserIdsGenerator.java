package ex04;

public class UserIdsGenerator
{
    private int id;
    private static final UserIdsGenerator INSTANCE = new UserIdsGenerator();
    private UserIdsGenerator()
    {
        id = -1;
    }
    public static UserIdsGenerator getInstance()
    {
        return INSTANCE;
    }
    public int generateId()
    {
        return ++this.id;
    }
}
