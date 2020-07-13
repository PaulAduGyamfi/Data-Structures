/**
 * This class represents a song object which has a song title, artist, song length of minutes, and song length of seconds
 *
 * @author Paul Adu-Gyamfi
 */

public class SongRecord {

    private String title;
    private String artist;
    private int minutes;
    private int seconds;

    public SongRecord(){
        this.title = null;
        this.artist = null;
        this.minutes = 0;
        this.seconds = 0;
    }

    /**
     *
     * @param title
     * title of the song
     * @param artist
     * creator of the song
     * @param minutes
     * the amount of minutes in the song
     * @param seconds
     * the amount of seconds in the song
     */
    public SongRecord(String title, String artist, int minutes, int seconds){
        this.title = title;
        this.artist = artist;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     *
     * @return
     * the song title
     */
    public String getTitle(){
        return title;
    }


    /**
     *
     * @param title
     * set the song title
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     *
     * @return
     * artist name
     */
    public String getArtist(){
        return artist;
    }


    /**
     *
     * @param artist
     * set the name of the song artist
     */
    public void setArtist(String artist){
        this.artist = artist;
    }


    /**
     *
     * @return
     * the number of minutes in the song
     */
    public int getMinutes(){
        return minutes;
    }

    /**
     *
     * @param minutes
     * set the minutes in the song
     * @throws IndexOutOfBoundsException
     * if the minutes provided is less than 0
     */
    public void setMinutes(int minutes) throws IndexOutOfBoundsException{
        if(!(minutes < 0)){
            this.minutes = minutes;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     *
     * @return
     * the number of seconds in the song
     */
    public int getSeconds(){
        return seconds;
    }


    /**
     *
     * @param seconds
     * set the amount of seconds in the song
     * @throws IndexOutOfBoundsException
     * if the seconds provided is less than 0 or greater than 59
     */
    public void setSeconds(int seconds) throws IndexOutOfBoundsException{
        if(!(seconds < 0 || seconds > 59)){
            this.seconds = seconds;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString(){
        System.out.println(String.format("%-10s%-21s%-13s%5d:%02d","", title, artist, minutes, seconds));
        return null;
    }

}
