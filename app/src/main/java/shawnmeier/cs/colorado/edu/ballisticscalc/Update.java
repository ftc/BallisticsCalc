package shawnmeier.cs.colorado.edu.ballisticscalc;

/**
 * Created by s on 5/15/15.
 */
public class Update {
    double range;
    double speed;
    Update(double range, double speed){
        this.range = range;
        this.speed = speed;
    }
    double getRange(){
        return range;
    }
    double getSpeed(){
        return speed;
    }
}
