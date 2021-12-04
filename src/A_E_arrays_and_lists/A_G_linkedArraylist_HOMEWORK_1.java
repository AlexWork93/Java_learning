package A_E_arrays_and_lists;

import java.util.*;

public class A_G_linkedArraylist_HOMEWORK_1 {

    // Create a program that implements a playlist for songs
    // Create a Song class having Title and Duration for a song.
    // The program will have an Album class containing a list of songs.
    // The albums will be stored in an ArrayList
    // Songs from different albums can be added to the playlist and will appear in the list in the order
    // they are added.
    // Once the songs have been added to the playlist, create a menu of options to:-
    // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
    // List the songs in the playlist
    // A song must exist in an album before it can be added to the playlist (so you can only play songs that
    // you own).
    // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
    // started tracking the direction we were going.
    // As an optional extra, provide an option to remove the current song from the playlist
    // (hint: listiterator.remove()
    public static MyAlbumsList myAlbumsList = new MyAlbumsList();
    public static MyPlayList myPlayList = new MyPlayList();

    public static void main(String[] args) {
        myPlayList.addSongToPlaylist(new MySong("1qwer", 123));
        myPlayList.addSongToPlaylist(new MySong("2qwer", 123));
        myPlayList.addSongToPlaylist(new MySong("3qwer", 123));
        myPlayList.addSongToPlaylist(new MySong("4qwer", 123));
        myPlayList.addSongToPlaylist(new MySong("5qwer", 123));
        myPlayList.addSongToPlaylist(new MySong("6qwer", 123));
        myPlayList.addSongToPlaylist(new MySong("7qwer", 123));
        myPlayList.addSongToPlaylist(new MySong("8qwer", 123));
        myPlayList.addSongToPlaylist(new MySong("9qwer", 123));
        myPlayList.addSongToPlaylist(new MySong("10qwer", 123));
        myPlayList.addSongToPlaylist(new MySong("11qwer", 123));

        mainMenu();
    }

    public static void mainMenu(){
        boolean mainMenu = true;
        while (mainMenu){
            printMainMenu();
            switch (getSolution()){
                case 1:
                    addSongMenu();
                    break;
                case 2:
                    customizePlaylistMenu();
                    break;
                case 3:
                    MyPlayer myPlayer = new MyPlayer(myPlayList);
                    myPlayer.playerMenu();
                    break;
                case 0:
                    mainMenu = false;
                    break;
                default:
                    System.out.println("Incorrect value");
            }
        }
    }

    public static void addSongMenu(){
        boolean addSong = true;
        while (addSong){
            printAddSongMenu();
            switch (getSolution()){
                case 1:
                    System.out.println(myAlbumsList);
                    break;
                case 2:
                    System.out.println("Enter name of album");
                    String temp = getStringValue();
                    if (myAlbumsList.addAlbum(temp)){
                        myAlbumsList.addAlbum(temp);
                    }else System.out.println("Album with name " + temp + "is already exist");
                    break;
                case 3:
                    System.out.println("Enter name of album");
                    addSongSubMenu(myAlbumsList.getAlbum((getStringValue())));
                    break;
                case 0:
                    addSong = false;
                    break;
                default:
                    System.out.println("Incorrect value");
            }
        }
    }

    public static void addSongSubMenu(MyAlbum selectedAlbum){
        boolean addSongSub = true;
        while (addSongSub){
            printAddSongSubMenu();
            switch (getSolution()){
                case 1:
                    System.out.println(selectedAlbum);
                    break;
                case 2:
                    System.out.println("Enter name of song");
                    String name = getStringValue();
                    System.out.println("Enter duration of song");
                    double duration = getDoubleValue();
                    selectedAlbum.addSong(name, duration);
                    break;
                case 0:
                    addSongSub = false;
                    break;
                default:
                    System.out.println("Incorrect value");
            }
        }
    }

    public static void customizePlaylistMenu(){
        boolean customizePlaylist = true;
        while (customizePlaylist){
            printCustomizePlaylistMenu();
            switch (getSolution()){
                case 1:
                    System.out.println(myPlayList);
                    break;
                case 2:
                    addSongToPlaylistMenu();
                    break;
                case 3:
                    System.out.println("Print name of song to remove");
                    myPlayList.removeSongFromPlaylist(getStringValue());
                    break;
                case 0:
                    customizePlaylist = false;
                    break;
                default:
                    System.out.println("Incorrect value");
            }
        }
    }

    public static void addSongToPlaylistMenu(){
        boolean addSong = true;
        while (addSong){
            printAddSongToPlaylistMenu();
            switch (getSolution()){
                case 1:
                    System.out.println(myAlbumsList);
                    break;
                case 2:
                    System.out.println("Enter name of album");
                    addSongToPlayListSubMenu(myAlbumsList.getAlbum((getStringValue())));
                    break;
                case 0:
                    addSong = false;
                    break;
                default:
                    System.out.println("Incorrect value");
            }
        }
    }

    public static void addSongToPlayListSubMenu(MyAlbum selectedAlbum){
        boolean addSongSub = true;
        while (addSongSub){
            printAddSongToPlayListSubMenu();
            switch (getSolution()){
                case 1:
                    System.out.println(selectedAlbum);
                    break;
                case 2:
                    System.out.println("Enter name of song");
                    String name = getStringValue();
                    myPlayList.addSongToPlaylist(selectedAlbum.getSong(name));
                    break;
                case 0:
                    addSongSub = false;
                    break;
                default:
                    System.out.println("Incorrect value");
            }
        }
    }

    public static void printMainMenu(){ System.out.println("1. Add Song. \n2. Customize playlist. \n3. Player \n0. Quit."); }
    public static void printAddSongMenu(){ System.out.println("1. Show list of albums. \n2. Add album. \n3. Select album. \n0. Quit."); }
    public static void printAddSongSubMenu(){ System.out.println("1. Show list of songs in album. \n2. Add song to the album. \n0. Quit."); }
    public static void printAddSongToPlaylistMenu(){ System.out.println("1. Show list of albums. \n2. Select album. \n0. Quit."); }
    public static void printAddSongToPlayListSubMenu(){ System.out.println("1. Show list of songs in album. \n2. Add song to the album. \n0. Quit."); }
    public static void printCustomizePlaylistMenu(){ System.out.println("1. Show playlist. \n2. Add song to playlist. \n3. Remove song from playlist \n0. Quit."); }

    public static int getSolution(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Your choose");
        if (sc.hasNextInt()) {
            int res = sc.nextInt();
            sc.nextLine();
            return res;
        }
        System.out.println("Incorrect value");
        return getSolution();
    }

    public static double getDoubleValue(){
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextDouble()) {
            double res = sc.nextDouble();
            sc.nextLine();
            return res;
        }
        System.out.println("Incorrect value. Input should be a number.");
        return getSolution();
    }

    public static String getStringValue(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}

class MySong {
    private String nameOfSong;
    private double durationOfSong;

    public MySong(String nameOfSong, double durationOfSong) {
        this.nameOfSong = nameOfSong;
        this.durationOfSong = durationOfSong;
    }

    public String getNameOfSong() {
        return nameOfSong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySong mySong = (MySong) o;
        return nameOfSong.equals(mySong.nameOfSong);
    }

    @Override
    public String toString() {
        return  "Song = " + nameOfSong +
                ", duration " + durationOfSong;
    }
}

class MyAlbum {
    private String nameOfAlbum;
    private ArrayList<MySong> mySongs;

    public MyAlbum(String nameOfAlbum) {
        this.nameOfAlbum = nameOfAlbum;
        this.mySongs = new ArrayList<>();
    }

    public String getNameOfAlbum() {
        return nameOfAlbum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyAlbum album = (MyAlbum) o;
        return Objects.equals(nameOfAlbum, album.nameOfAlbum);
    }


    private MySong findSong (MySong songForTest){
        for (MySong song: mySongs) {
            if(song.equals(songForTest)) return songForTest;
        }
        return null;
    }

    private MySong findSong (String nameOfSongForTest){
        for(MySong song: mySongs){
            if(nameOfSongForTest.equals(song.getNameOfSong())) return song;
        }
        return null;
    }

    public boolean addSong (String nameOfSongToAdd, double durationOfSongToAdd){
        MySong song = new MySong(nameOfSongToAdd, durationOfSongToAdd);
        if(findSong(song) == null){
            mySongs.add(song);
            return true;
        }
        return false;
    }

    public MySong getSong (String nameOfSong){
        return findSong(nameOfSong);
    }

    @Override
    public String toString() {
        String res = "";
        if (mySongs.isEmpty()){
            return "You do not have any songs";
        }else {
            for (MySong song: mySongs){
                res += song + "\n";
            }
        }
        return  res;
    }
}

class MyAlbumsList {
    private String name = "Album list";
    private ArrayList<MyAlbum> myAlbums;

    public MyAlbumsList() {
        this.myAlbums = new ArrayList<>();
    }

    private MyAlbum findAlbum (String nameOfAlbumForTest){
        for(MyAlbum album: myAlbums){
            if(nameOfAlbumForTest.equals(album.getNameOfAlbum())) return album;
        }
        return null;
    }

    private MyAlbum findAlbum (MyAlbum albumForTest){
        for (MyAlbum album: myAlbums) {
            if(album.equals(albumForTest)) return albumForTest;
        }
        return null;
    }

    public boolean addAlbum (String nameOfAlbumToAdd){
        MyAlbum album = new MyAlbum(nameOfAlbumToAdd);
        if(findAlbum(album) == null){
            myAlbums.add(album);
            return true;
        }
        return false;
    }

    public MyAlbum getAlbum (String nameOfAlbum){
        return findAlbum(nameOfAlbum);
    }

    @Override
    public String toString() {
        String res = "";
        if (myAlbums.isEmpty()){
            return "You do not have any albums";
        }else {
            for (MyAlbum album: myAlbums){
                res += album.getNameOfAlbum() + "\n";
            }
        }
        return  res;
    }
}

class MyPlayList {
    private String nameOfPlaylist;
    private LinkedList<MySong> mySongs;

    public MyPlayList() {
        this.nameOfPlaylist = "Playlist";
        this.mySongs = new LinkedList<>();
    }

    public LinkedList<MySong> getMySongs() {
        return mySongs;
    }

    @Override
    public String toString() {
        String res = "";
        if (mySongs.isEmpty()){
            return "You do not have any songs";
        }else {
            for (MySong song: mySongs){
                res += song + "\n";
            }
        }
        return  res;
    }

    public boolean addSongToPlaylist(MySong song){
        if (findSong(song.getNameOfSong()) == null){
            mySongs.add(song);
            return true;
        }else return false;
    }

    public boolean removeSongFromPlaylist(String nameOfSong){
        MySong song = findSong(nameOfSong);
        if (song != null){
            mySongs.remove(song);
            return true;
        }else return false;
    }

    public MySong findSong(String nameOfSong){
        Iterator<MySong> iterator = mySongs.listIterator();
        while (iterator.hasNext()){
            MySong songInPlaylist = iterator.next();
            if (songInPlaylist.getNameOfSong().equals(nameOfSong)){
                return songInPlaylist;
            }
        }return null;
    }

}

class MyPlayer{
    MyPlayList playList;
    private LinkedList<MySong> songs;
    private boolean goForward;
    private boolean play = false;
    private MySong currentSong;

    public MyPlayer(MyPlayList playList) {
        this.playList = playList;

        if (!playList.getMySongs().isEmpty()){
            this.songs = playList.getMySongs();
            this.currentSong = songs.get(0);
            goForward = true;
        }
    }

    public  void playerMenu(){
        boolean player = true;
        ListIterator<MySong> listIterator = songs.listIterator(0);
        while (player){
            printPlayerMenu();
            switch (getSolution()){
                case 1:
                    play(listIterator);
                    break;
                case 2:
                    replay(listIterator);
                    break;
                case 3:
                    next(listIterator);
                    break;
                case 4:
                    previous(listIterator);
                    break;
                case 0:
                    player = false;
                    break;
                default:
                    System.out.println("Incorrect value");
            }
        }
    }

    public static void printPlayerMenu(){ System.out.println("1. Play. \n2. Replay. \n3. Next \n4. Previous. \n0. Quit."); }

    public static int getSolution(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Your choose");
        if (sc.hasNextInt()) {
            int res = sc.nextInt();
            sc.nextLine();
            return res;
        }
        System.out.println("Incorrect value");
        return getSolution();
    }

    public void play(ListIterator<MySong> listIterator){
        if (songs.isEmpty()){
            System.out.println("You should add some songs before");
        }else {
            System.out.println("Song " + songs.get(listIterator.nextIndex()).getNameOfSong() + " is played");
            play = true;
        }
    }

    public void replay(ListIterator<MySong> listIterator){
        if (!play){
            System.out.println("You should start playing");
        }else System.out.println("Song " + songs.get(listIterator.nextIndex()).getNameOfSong() + " is played from the beginning");
    }

    public void next(ListIterator<MySong> listIterator){
        if (songs.isEmpty()){
            System.out.println("You should add some songs before");
        }else{
            changeDirectionForward(listIterator);
            if (listIterator.hasNext()){
                currentSong = listIterator.next();
                System.out.println("You are on song: " + currentSong.getNameOfSong());
            }else System.out.println( currentSong.getNameOfSong() + " is the last song");
        }
    }

    public void previous(ListIterator<MySong> listIterator){
        if (songs.isEmpty()){
            System.out.println("You should add some songs before");
        }else{
            changeDirectionBackwards(listIterator);
            if (listIterator.hasPrevious()){
                currentSong = listIterator.previous();
                System.out.println("You are on song: " + currentSong.getNameOfSong());
            }else System.out.println( currentSong.getNameOfSong() + "is the fist song");
        }
    }

    private void changeDirectionForward(ListIterator<MySong> listIterator){
        if (listIterator.hasNext()) {
            if (!goForward){
                listIterator.next();
                goForward = true;
            }
        }
    }

    private void changeDirectionBackwards(ListIterator<MySong> listIterator){
        if (listIterator.hasPrevious()) {
            if (goForward) {
                listIterator.previous();
                goForward = false;
            }
        }
    }
}





























