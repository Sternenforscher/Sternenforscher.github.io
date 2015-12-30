package space.sternenforscher.nullrank.utils;

/**
 * Created by Sternenforscher on 30.12.15, 03:44.
 */
public class Onlinetime {
    //In milliseconds
    private long onlinetime;
    /*
     * 1 day
     * 24 hours
     * 1440 minutes
     * 86,400 seconds
     * 86,400,000 milliseconds
     *
     */


    /**
     * @param onlinetime
     */
    public Onlinetime(long onlinetime){
        this.onlinetime = onlinetime;
    }

    public Onlinetime(){
    }

    public void setOnlinetime(long onlinetime){
        this.onlinetime = onlinetime;
    }

    public long getOnlinetime() {
        return onlinetime;
    }

    public int asSeconds(){
        return (int) (onlinetime*0.001);
    }

    public double asMinutes(){
        return (onlinetime*0.0000167);
    }

    public double asHours(){
        return (onlinetime*0.00000030);
    }

    public double asDays(){
        return (asHours()/24);
    }
}
