package com.model;

public class MessageWithBLOBs extends Message {
    private String title;

    private String message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }


    @Override
    public String toString() {
        return "MessageWithBLOBs{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}