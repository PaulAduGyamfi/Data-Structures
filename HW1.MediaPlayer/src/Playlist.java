/**
 * This class represents a playlist which has songRecord objects
 *
 * @author Paul Adu-Gyamfi
 */
public class Playlist implements Cloneable{
        private final SongRecord playlist[];
        private int max_songs;
        private int songs_currently_in_playlist;


    public Playlist() {
        playlist = new SongRecord[50];
        max_songs = playlist.length;
        songs_currently_in_playlist = 0;
    }


//    public Object clone(){
//        SongRecord playlist_copy = new SongRecord();
//    }

    /**
     *
     * @return
     */
    public int size(){

       return songs_currently_in_playlist;
    }


    /**
     *
     * @param song
     * song object to be added
     * @param position
     * position in playlist to add the song object
     * @throws IllegalArgumentException
     * when trying to add a song to a position that is not in the valid range
     * @throws FullPlaylistException
     * when trying to add a song to a playlist that is full
     */
    public void addSong(SongRecord song, int position) throws IllegalArgumentException,FullPlaylistException{
        if (position > songs_currently_in_playlist+1 || position < 1){
            throw new IllegalArgumentException();

        }
        if (songs_currently_in_playlist == max_songs){
            throw new FullPlaylistException();
        }
        if(position == songs_currently_in_playlist+1){
            playlist[position-1] = song;
            songs_currently_in_playlist++;
            return;
        }
        int i = songs_currently_in_playlist;
        while(i > position-1){
            playlist[i] = playlist[i-1];
            i--;
        }
        playlist[i] = song;
        songs_currently_in_playlist++;
    }


    /**
     *
     * @param position
     * position in the playlist of song to be removed
     * @throws IllegalArgumentException
     * when the position is not in the valid range
     */
    public void removeSong(int position) throws IllegalArgumentException{
        if(position > songs_currently_in_playlist || position < 1){
            System.out.println("That position is not within the valid range!");
            throw new IllegalArgumentException();
        }
        playlist[position-1] = null;
        int i = position-1;
        while(playlist[i+1] != null){
            playlist[i] = playlist[i+1];
            i++;
        }
        songs_currently_in_playlist--;


    }


    /**
     *
     * @param position
     * position of the song in the playlist
     * @return
     * the song at the specified position in the playlist
     * @throws IllegalArgumentException
     * when the position is not in the valid range
     *
     */
    public SongRecord getSong(int position) throws IllegalArgumentException{
        if(position > songs_currently_in_playlist || position < 1){
            System.out.println("That position is not within the valid range!");
            throw new IllegalArgumentException();
        }
        if(position == 1){
            return playlist[0];
        }
        int i = 0;
        while(i<position){
            i++;
        }
        return playlist[i];
    }


    /**
     *
     * @param originalList
     * playlist containg all the original songs by different artists
     * @param artist
     * artist to search by
     * @return
     * a playlist of songs by the specified artist
     * @throws FullPlaylistException
     * if the playlist is full
     */
    public static Playlist getSongsByArtist(Playlist originalList, String artist) throws FullPlaylistException {
        Playlist songs_by_artist = new Playlist();
        int song_position = 1;
        for(int i = 0; i < originalList.size(); i++){
            if(originalList.playlist[i].getArtist().equals(artist)){
                songs_by_artist.addSong(originalList.playlist[i],song_position++);
            }
        }
        if(songs_by_artist.size()>0){
            return songs_by_artist;
        }
        return null;
    }

//    public boolean equals(Object obj){
//
//        if(obj instanceof SongRecord){
//            SongRecord new_playlist = (SongRecord) obj;
//
//        }
//    }


    public void printAllSongs(){
        System.out.println(String.format("%-11s%-17s%10s%16s", "Song#", "Title", "Artist", "Length"));
        System.out.println("--------------------------------------------------------");
        for(int i = 0;i<size();i++){
            System.out.print(i+1);
            playlist[i].toString();
        }
    }


}
