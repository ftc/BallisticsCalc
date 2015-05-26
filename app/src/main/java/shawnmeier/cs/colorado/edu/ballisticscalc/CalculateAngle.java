package shawnmeier.cs.colorado.edu.ballisticscalc;

import android.widget.TextView;

import static java.lang.Double.isNaN;
import static java.lang.StrictMath.asin;

/**
 * Created by s on 5/15/15.
 */
public class CalculateAngle implements Updater {
    double g = 9.8;
    private final TextView v;
    CalculateAngle(TextView v){
        this.v = v;
    }
    private double calculateAngle(double range, double speed){
        return asin(range * g/ (speed*speed));
    }
    public void update(Update u){
        double out = calculateAngle(u.getRange(), u.getSpeed());
        if(isNaN(out)){
            v.setText("Bad");
        }else{
            v.setText((new Double(out)).toString());
        }
    }
}
