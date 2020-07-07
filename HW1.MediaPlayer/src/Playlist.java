public class Playlist {
        private final SongRecord playlist[];
        private int max_songs;
        private int songs_currently_in_playlist;

    public Playlist() {
        playlist = new SongRecord[50];
        max_songs = playlist.length;
        songs_currently_in_playlist = 0;
    }

    //    @Override
//    public Object clone(){
//        SongRecord[] newList = new SongRecord[playlist.length];
//        for(int i = 0; i < playlist.length; i++){
//            newList[i] = playlist[i];
//        }
//        return newList;
//    }
    public int size(){
       int size = 0;
       while(size < songs_currently_in_playlist){
           size++;
       }
       return size;
    }
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

//    @Override
//    public boolean equals(Object obj){
//
//        if(obj.equals(null)){
//            return false;
//        }
//        int i = 0;
//        while( i != 0){
//            if(obj){
//                return false;
//            }
//        }
//    }


    public void printAllSongs(){
        for(int i = 0;i<size();i++){
            System.out.print(i+1+". ");
            playlist[i].toString();
        }
    }


}
