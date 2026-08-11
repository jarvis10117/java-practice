package oop.streams_and_lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Song> listSong = new Songs().getSongs();
        List<Song> rockSong = listSong.stream()
                .filter(song-> song.getGenre().contains("Rock"))
                .collect(Collectors.toList());

        System.out.println(rockSong);


        List<Song> artistBeatles = listSong.stream()
                .filter(song -> song.getArtist().equals("The Beatles"))
                .filter(song -> song.getYear() > 1995)
                .collect(Collectors.toList());

        System.out.println(artistBeatles);

    }

}
