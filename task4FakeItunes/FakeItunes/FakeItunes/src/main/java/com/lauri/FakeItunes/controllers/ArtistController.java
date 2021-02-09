package com.lauri.FakeItunes.controllers;

import com.lauri.FakeItunes.dataaccess.ArtistRepository;
import com.lauri.FakeItunes.models.Artist;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

public class ArtistController {

    // Configure some endpoints to manage crud
    private ArtistRepository artistRepository = new ArtistRepository();

    // This returns 5 random artists in the database
    @RequestMapping(value="/api/artists", method = RequestMethod.GET)
    public ArrayList<Artist> getFiveRandomArtists(){
        return artistRepository.getFiveRandomArtists();
    }
}
