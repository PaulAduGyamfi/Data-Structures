/**
 * This class represents a playlist which has songRecord objects
 *
 * @author Paul Adu-Gyamfi
 */
public class Playlist implements Cloneable{
        private final SongRecord[] playlist;
        private final int max_songs;
        private int songs_currently_in_playlist;


    public Playlist() {
        playlist = new SongRecord[50];
        max_songs = playlist.length;
        songs_currently_in_playlist = 0;
    }


//    public Object clone() throws CloneNotSupportedException {
//        Playlist playlist_copy = new Playlist();
//            for(int i=0; i< size(); i++){
//                playlist_copy.getSong(i).setArtist(playlist[i].getArtist());
//                playlist_copy.getSong(i).setTitle(playlist[i].getTitle());
//                playlist_copy.getSong(i).setMinutes(playlist[i].getMinutes());
//                playlist_copy.getSong(i).setSeconds(playlist[i].getSeconds());
//
//                playlist_copy.getSong(i).toString();
//            }
//
//        return playlist_copy;
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
            throw new IllegalArgumentException();
        }

        return playlist[position-1];
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


    /**
     *
     * @param obj
     * new playlist to compare to the original playlist
     * @return
     * a boolean value of true if the playlist have same songs or false otherwise
     */
    public boolean equals(Object obj){
        if(obj instanceof Playlist){
            Playlist new_playlist = (Playlist) obj;
            if(new_playlist.songs_currently_in_playlist != songs_currently_in_playlist){
                return false;
            }
            for(int i = 0; i<songs_currently_in_playlist; i++){
                if(!playlist[i].getArtist().equals(new_playlist.getSong(i+1).getArtist())){
                    return false;
                }
                if(!playlist[i].getTitle().equals(new_playlist.getSong(i+1).getTitle())){
                    return false;
                }
                if(playlist[i].getMinutes() != new_playlist.getSong(i+1).getMinutes()){
                    return false;
                }
                if(playlist[i].getSeconds() != new_playlist.getSong(i+1).getSeconds()){
                    return false;
                }
            }
            return true;

        }
        return false;
    }


    public void printAllSongs(){
        System.out.println(String.format("%-11s%-17s%10s%16s", "Song#", "Title", "Artist", "Length"));
        System.out.println("--------------------------------------------------------");
        for(int i = 0;i<size();i++){
            System.out.print(i+1);
            playlist[i].toString();
        }
    }


}
