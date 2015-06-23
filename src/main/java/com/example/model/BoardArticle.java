package com.example.model;

import javax.persistence.*;

/**
 * Created by arahansa on 2015-06-16.
 */
@Entity
public class BoardArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nick;
    private String content;

    @Column(name = "addressfile")
    private String addressFile;
    @Column(name="addressthumbnail")
    private String addressThumbnail;

    public BoardArticle() {       }

    public BoardArticle(String nick, String content) {
        this.nick = nick;
        this.content = content;
    }

    public Long getId() {        return id;    }
    public void setId(Long id) {        this.id = id;    }
    public String getNick() {        return nick;    }
    public void setNick(String nick) {        this.nick = nick;    }
    public String getContent() {        return content;    }
    public void setContent(String content) {        this.content = content;    }

    @Override
    public String toString() {
        return "BoardArticle{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", content='" + content + '\'' +
                ", addressFile='" + addressFile + '\'' +
                ", addressThumbnail='" + addressThumbnail + '\'' +
                '}';
    }
}
