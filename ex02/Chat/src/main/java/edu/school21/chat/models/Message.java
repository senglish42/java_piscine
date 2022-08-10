package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message
{
    private Long id;
    private String formatDate = null;
    private final User author;
    private final Chatroom room;
    private final String text;
    private final LocalDateTime date;

    public void setId(long id) {
        this.id = id;
    }

    public Message(Long id, User author, Chatroom room, String text, LocalDateTime date)
    {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
        if (date != null) {
            this.formatDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")); }
    }
    public long getId()
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
    public LocalDateTime getDate()
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
    public String toString() {
        return "Message:{\n" +
                "id=" + this.id +
                ",\nauthor={id=" + this.author.getId() +
                ",login=" + this.author.getLogin() +
                ",password=" + this.author.getPassword() +
                ",createdRooms=" + this.author.getU_rooms() +
                ",rooms=" + this.author.getRooms() +
                "},\nroom={id=" + this.room.getId() +
                ",name=" + this.room.getName() +
                ",creator=" + this.room.getOwner() +
                ",messages=" + this.room.getMsg() +
                "},\ntext='" + this.text + '\'' +
                ",\ndateTime=" + this.formatDate +
                '}';
    }
}
