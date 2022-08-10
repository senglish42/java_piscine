package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class User
{
    private final long id;
    private final String login;
    private final String password;
    private final ArrayList<Chatroom> rooms;
    private final ArrayList<Chatroom> u_rooms;
    public User(long id, String login, String password, ArrayList<Chatroom> rooms, ArrayList<Chatroom> u_rooms)
    {
        this.id = id;
        this.login = login;
        this.password = password;
        this.rooms = rooms;
        this.u_rooms = u_rooms;
    }

    public long getId() {
        return this.id;
    }
    public String getLogin()
    {
        return this.login;
    }
    public String getPassword()
    {
        return this.password;
    }
    public ArrayList<Chatroom> getRooms()
    {
        return this.rooms;
    }
    public ArrayList<Chatroom> getU_rooms()
    {
        return this.u_rooms;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        User msg = (User) obj;
        return Objects.equals(this.id, msg.getId()) &&
                Objects.equals(this.login, msg.getLogin()) &&
                Objects.equals(this.password, msg.getPassword()) &&
                Objects.equals(this.rooms, msg.getRooms()) &&
                Objects.equals(this.u_rooms, msg.getU_rooms());
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", login='" + login + '\'' +
//                ", password='" + password + '\'' +
//                ", rooms=" + rooms +
//                ", u_rooms=" + u_rooms +
//                '}';
//    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.id, this.login, this.password, this.rooms, this.u_rooms);
    }
}
