package com.lauri.FakeItunes.models;

public class Artist {

    private String artistID;
    private String name;

    public Artist() {
    }

    public Artist(String artistID, String name) {
        this.artistID = artistID;
        this.name = name;
    }

    public String getArtistID() {
        return artistID;
    }

    public void setArtistID(String artistID) {
        this.artistID = artistID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
