package edu.school21.chat.models;

import java.util.Date;
import java.util.Objects;

public class Message
{
    private final int id;
    private final User author;
    private final Chatroom room;
    private final String text;
    private final Date date;
    public Message(int id, User author, Chatroom room, String text, Date date)
    {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
    }
    public int getId()
    {
        return this.id;
    }
    public User getAuthor()
    {
        return this.author;
    }
    public Chatroom getRoom()
    {
        return this.room;
    }
    public String getText()
    {
        return this.text;
    }
    public Date getDate()
    {
        return this.date;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Message msg = (Message) obj;
        return Objects.equals(this.id, msg.getId()) &&
                Objects.equals(this.author, msg.getAuthor()) &&
                Objects.equals(this.room, msg.getRoom()) &&
                Objects.equals(this.text, msg.getText()) &&
                Objects.equals(this.date, msg.getDate());
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(this.id, this.author, this.room, this.text, this.date);
    }
    @Override
    public String toString()
    {
        return "edu.school21.chat.models.Message{id = " + this.id +
                ", author = " + this.author +
                ", room = " + this.room +
                ", text = '" + this.text + '\'' +
                ", date = " + this.date +
                '}';
    }
}
