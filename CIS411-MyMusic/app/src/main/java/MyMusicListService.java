/**
 * Created by Simon Kay on 10/16/2014.
 */


import com.wesleyreisz.mymusic.model.Song;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyMusicListService {
    private List<Song> songs;

    {
        songs = new ArrayList<Song>();
        songs.add(new Song("Gangnam Style", "Psy", "Psy 6 (Six Rules) Part 1", getDate(2012,8,15)));
        songs.add(new Song("Barbie Girl", "Aqua", "Aquarium", getDate(1997,03,15)));
        songs.add(new Song("I'm Blue (Da Ba Dee)", "Eiffel 65","Europop", getDate(1999,06,15)));
        songs.add(new Song("I Love You", "Barney", "Barney's Favorites Volume 1", getDate(1993,01,01)));
        songs.add(new Song("Friday", "Rebecca Black", "Friday", getDate(2011,03,14)));
        songs.add(new Song("Ice Ice Baby", "Vanilla Ice","To The Extreme", getDate(1990,07,02)));
        songs.add(new Song("My Humps", "Black Eyed Peas", "Monkey Business", getDate(2005,9,20)));
        songs.add(new Song("Macarena", "Los del Rio", "A mi me gusta", getDate(1995,8,15)));
        songs.add(new Song("Who Let The Dogs Out", "Baha Men", "Who Let the Dogs Out", getDate(2000,07,25)));
        songs.add(new Song("Jump", "Kris Kross", "Totally Krossed Out", getDate(1992,02,06)));

    }

    public List<Song>findALl(){
        return songs;
    }

    public Song findOne(String name){
        for (Song song:songs){
            if (song.equals(name)){
                return song;
            }
        }
        return new Song();
    }


}
