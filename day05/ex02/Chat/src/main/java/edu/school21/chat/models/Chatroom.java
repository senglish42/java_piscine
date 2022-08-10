package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class Chatroom
{
    private final long id;
    private final String name;
    private final User owner;
    private ArrayList<Message> msg;
    public Chatroom(long id, String name, User owner, ArrayList<Message> msg)
    {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.msg = msg;
    }
    public long getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }
    public User getOwner()
    {
        return this.owner;
    }
    public ArrayList<Message> getMsg()
    {
        return this.msg;
    }
    public void setMsg(ArrayList<Message> msg)
    {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", msg=" + msg +
                '}';
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Chatroom chatroom = (Chatroom)obj;
        return Objects.equals(this.id, chatroom.getId()) &&
                Objects.equals(this.msg, chatroom.getMsg()) &&
                Objects.equals(this.name, chatroom.getName()) &&
                Objects.equals(this.owner, chatroom.getOwner());
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(this.id, this.name, this.owner, this.msg);
    }
}
