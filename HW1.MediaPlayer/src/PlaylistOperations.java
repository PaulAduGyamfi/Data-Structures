import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Paul Adu-Gyamfi
 * #111607347
 * paul.adu-gyamfi@stonybrook.edu
 *
 * CSE 214.R30
 * Juan Tarquino
 */
public class PlaylistOperations {
    public static void main(String[] args) throws FullPlaylistException {

        Scanner menu_input = new Scanner(System.in);

        Playlist my_playlist = new Playlist();

        System.out.println(("A) Add Song"));
        System.out.println(("B) Print Songs by Artist"));
        System.out.println(("G) Get Song"));
        System.out.println(("R) Remove Song"));
        System.out.println(("P) Print All Songs"));
        System.out.println(("S) Size"));
        System.out.println(("Q) Quit\n"));



        System.out.print("Select a menu option:");
        char menu_option = menu_input.next().charAt(0);
        
        while (menu_option != 'Q'){

           switch (Character.toUpperCase(menu_option)){
               case 'A':
                   System.out.print("Enter the song title: ");
                   menu_input.nextLine();
                   String Title = menu_input.nextLine();

                   System.out.print("Enter the song artist: ");
                   String Artist = menu_input.nextLine();

                   System.out.print("Enter the song length (minutes): ");
                   int Minutes = menu_input.nextInt();

                   System.out.print("Enter the song length (seconds): ");
                   int Seconds = menu_input.nextInt();

                   System.out.print("Enter the position: ");
                   int Position = menu_input.nextInt();

                   try {
                       SongRecord new_song = new SongRecord(Title,Artist,Minutes,Seconds);
                       my_playlist.addSong(new_song,Position);
                       System.out.println("Song Added: "+new_song.getTitle()+" By "+new_song.getArtist());

                   }catch (IllegalArgumentException e){
                       System.out.println("Invalid position for adding the new song.");
                   }catch (FullPlaylistException f){
                       System.out.println("There is no more room inside the Playlist to store this song!");
                   }catch (IndexOutOfBoundsException o){
                       System.out.println("Invalid song length.");
                   }
                   break;
               case 'B':
                   System.out.print("Enter the artist: ");
                   menu_input.nextLine();
                   String get_songs_by_artist = menu_input.nextLine();

                   if(Playlist.getSongsByArtist(my_playlist,get_songs_by_artist) != null){
                       Playlist artist_playlist =  Playlist.getSongsByArtist(my_playlist,get_songs_by_artist);
                       artist_playlist.printAllSongs();
                   }else {
                       System.out.println("There are no songs by that Artist");
                   }
                   break;

               case 'G':
                   System.out.print("Enter the position: ");
                   int get_song_by_position = menu_input.nextInt();
                   try {
                       System.out.println(String.format("%-11s%-17s%10s%16s", "Song#", "Title", "Artist", "Length"));
                       System.out.println("--------------------------------------------------------");
                       System.out.print("1");
                       my_playlist.getSong(get_song_by_position).toString();
                   }catch (IllegalArgumentException e){
                       System.out.println("No song was found");
                   }
                   break;
               case 'R':
                   System.out.print("Enter the position: ");
                   int remove_song_at_position = menu_input.nextInt();
                   try {
                       my_playlist.removeSong(remove_song_at_position);
                       System.out.println("Song Removed at position "+ remove_song_at_position);
                   }catch (IllegalArgumentException e){
                       System.out.println("No song at position "+remove_song_at_position +" to remove");
                   }
                   break;
               case 'P':
                   my_playlist.printAllSongs();
                   break;
               case 'S':
                   System.out.println("There are "+ my_playlist.size()+" song(s) in the current playlist");
                   break;
               default:
                   break;
           }
            System.out.println(("\nA) Add Song"));
            System.out.println(("B) Print Songs by Artist"));
            System.out.println(("G) Get Song"));
            System.out.println(("R) Remove Song"));
            System.out.println(("P) Print All Songs"));
            System.out.println(("S) Size"));
            System.out.println(("Q) Quit\n"));



            System.out.print("Select a menu option:");
            menu_option = menu_input.next().charAt(0);

       }

        System.out.println("Program terminating normally...");

    }
}
