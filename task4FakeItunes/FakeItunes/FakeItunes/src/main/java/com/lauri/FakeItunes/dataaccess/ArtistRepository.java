package com.lauri.FakeItunes.dataaccess;

import com.lauri.FakeItunes.models.Customer;
import com.lauri.FakeItunes.models.Artist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArtistRepository {

    // Initialising connection object
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    // Methods for serving controller requests - i.e. what endpoints want

    public ArrayList<Artist> getFiveRandomArtists(){
        ArrayList<Artist> artists = new ArrayList<>();
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            int count=0;

            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT ArtistId,Name FROM artist");
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next() || count<=5) {
                count++;
                artists.add(
                        new Artist(
                                resultSet.getString("ArtistId"),
                                resultSet.getString("Name")
                        ));
            }
            System.out.println("All random artists obtained successfully");
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return artists;
    }


}
