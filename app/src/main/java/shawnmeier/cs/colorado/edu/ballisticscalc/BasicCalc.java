package shawnmeier.cs.colorado.edu.ballisticscalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class BasicCalc extends Activity implements View.OnClickListener {

    List<View> toUpdate = new ArrayList<View>();
    String foo = "";
    protected void calculate() {
        EditText range = (EditText) this.findViewById(R.id.distance_input);
        EditText speed = (EditText) this.findViewById(R.id.speed_input);
        String range_t = range.getText().toString();
        String speed_t = speed.getText().toString();
        double range_v = Double.parseDouble(range_t);
        double speed_v = Double.parseDouble(speed_t);
        Update update = new Update(range_v, speed_v);
        for(View v : toUpdate){
            Updater u = (Updater) v.getTag(R.id.updater);
            u.update(update);
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calc);
        TextView angleLabel = (TextView) this.findViewById(R.id.angle_output);
        angleLabel.setTag(R.id.updater, new CalculateAngle(angleLabel));

        Button calculate = (Button) this.findViewById(R.id.calculate_button);
        calculate.setOnClickListener(this);
        toUpdate.add(angleLabel);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_basic_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        calculate();
        foo = "hello world";
    }
}
