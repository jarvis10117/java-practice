package oop.collections;

import java.util.*;

public class Jukebox2 {

    public static void main(String[] args) {
        new Jukebox2().go();
    }

    public void go() {
        // Load mock song data
        List<SongV2> songList = MockSongs.getSongsV2();
        Set<SongV3> songSet = new HashSet<>(MockSongs.getSongsV3());

//        System.out.println("Before sorting:");
//        System.out.println(songList);

//        System.out.println("\nAfter sorting by artist using collections.sort::");
//        Collections.sort(MockSongs.getSongsV2());
//        System.out.println();
//
//        System.out.println("\nAfter sorting by artist using collections.sort using comparator:");
//        Collections.sort(songList, new TitleCompare());
//        System.out.println(songList);

        System.out.println(songSet);


    }
}
//class TitleCompare implements Comparator<SongV2> {
//    @Override
//    public int compare(SongV2 o1, SongV2 o2) {
//        return o1.getTitle().compareTo(o2.getTitle());
//    }
//}

// Implements Comparable so Collections.sort() knows how to order SongV2 objects
class SongV2 implements Comparable<SongV2> {
    private final String title;
    private final String artist;
    private final int bpm;

    SongV2(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public int getBpm() {
        return bpm;
    }


    @Override
    public int compareTo(SongV2 s) {

        if (title.compareTo(s.getTitle()) != 0){
            return title.compareTo(s.getTitle());
        }
        else if (artist.compareTo(s.getArtist()) != 0){
            return artist.compareTo(s.getArtist());
        }
        return Integer.compare(bpm, s.getBpm());
    }

    @Override
    public String toString() {
        return title + " - " + artist + " (" + bpm + ")";
    }
}
class SongV3 implements Comparable<SongV2> {
    private final String title;
    private final String artist;
    private final int bpm;

    SongV3(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public int getBpm() {
        return bpm;
    }


    @Override
    public int compareTo(SongV2 s) {

        if (title.compareTo(s.getTitle()) != 0){
            return title.compareTo(s.getTitle());
        }
        else if (artist.compareTo(s.getArtist()) != 0){
            return artist.compareTo(s.getArtist());
        }
        return Integer.compare(bpm, s.getBpm());
    }

    @Override
    public String toString() {
        return title + " - " + artist + " (" + bpm + ")";
    }

    @Override
    public boolean equals(Object obj) {
        SongV3 other = (SongV3) obj;
        return this.getTitle().equals(other.getTitle());
    }

    @Override
    public int hashCode() {
        System.out.println(this.getTitle().hashCode());
        return this.getTitle().hashCode();
    }
}







class MockSongs {

    public static List<SongV2> getSongsV2() {
        List<SongV2> songs = new ArrayList<>();
        songs.add(new SongV2("somersault", "zero 7", 147));
        songs.add(new SongV2("cassidy", "grateful dead", 150));
        songs.add(new SongV2("$10", "hitchhiker", 140));
        songs.add(new SongV2("havana", "cabello", 105));
        songs.add(new SongV2("Cassidy", "grateful dead", 150));
        songs.add(new SongV2("50 ways", "simon", 102));
        songs.add(new SongV2("havana", "cabello", 105));

        return songs;
    }
    public static List<SongV3> getSongsV3() {
        List<SongV3> songs = new ArrayList<>();
        songs.add(new SongV3("somersault", "zero 7", 147));
        songs.add(new SongV3("Cassidy", "grateful", 158));
        songs.add(new SongV3("$10", "hitchhiker", 140));
        songs.add(new SongV3("havana", "cabello", 105));
        songs.add(new SongV3("Cassidy", "grateful dead", 150));
        songs.add(new SongV3("50 ways", "simon", 102));
        songs.add(new SongV3("havana", "c", 105));

        return songs;
    }


}