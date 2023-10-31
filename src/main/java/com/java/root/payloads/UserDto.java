package com.java.root.payloads;

public class UserDto {
    private String title;
    private String content;
    private String imageName;

    // All-args constructor
    public UserDto(String title, String content, String imageName) {
        this.title = title;
        this.content = content;
        this.imageName = imageName;
    }

    // Getter and setter methods for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter methods for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter and setter methods for imageName
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}