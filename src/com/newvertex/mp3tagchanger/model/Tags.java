package com.newvertex.mp3tagchanger.model;

import java.io.Serializable;

public class Tags implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String subTitle;
    private String comment;
    private String composer;
    private String album;
    private String albumArtist;
    private String artist;
    private String artists;

    public Tags() {
        this("", "", "", "", "", "", "", "");
    }

    public Tags(String tag) {
        this(tag, tag, tag, tag, tag, tag, tag, tag);
    }

    public Tags(String title, String subTitle, String comment, String composer, String album, String albumArtist, String artist, String artists) {
        this.title = title;
        this.subTitle = subTitle;
        this.comment = comment;
        this.composer = composer;
        this.album = album;
        this.albumArtist = albumArtist;
        this.artist = artist;
        this.artists = artists;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

}
