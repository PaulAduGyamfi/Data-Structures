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

    public SongRecord(String title, String artist, int minutes, int seconds){
        this.title = title;
        this.artist = artist;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Accessor and Mutator methods for each variable
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getArtist(){
        return artist;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }

    public int getMinutes(){
        return minutes;
    }
    public void setMinutes(int minutes) throws IndexOutOfBoundsException{
        if(!(minutes < 0)){
            this.minutes = minutes;
        }
        else{
            throw new IndexOutOfBoundsException("TO small");
        }
    }

    public int getSeconds(){
        return seconds;
    }

    public void setSeconds(int seconds) throws IndexOutOfBoundsException{
        if(!(seconds < 0 || seconds > 59)){
            this.seconds = seconds;
        }
        else{
            throw new IndexOutOfBoundsException("dsdfsdfs");
        }
    }
    @Override
    public String toString(){
        System.out.println(String.format("%-10s%-21s%-13s%5d:%02d","", title, artist, minutes, seconds));
        return null;
    }

}
