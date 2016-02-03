package com.algonquincollege.benn0039.midtermapp;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener, SeekBar.OnSeekBarChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //
        //
        // TODO: Change Application name HSV Color Picker


        //////////////////////////////////////////////////
        //
        //  REFERENCES

        // Reference color buttons
         Button[] buttons = {
                (Button) findViewById(R.id.blackButton),
                (Button) findViewById(R.id.redButton),
                (Button) findViewById(R.id.grayButton),
                (Button) findViewById(R.id.limeButton),
                (Button) findViewById(R.id.cyanButton),
                (Button) findViewById(R.id.magentaButton),
                (Button) findViewById(R.id.maroonButton),
                (Button) findViewById(R.id.navyButton),
                (Button) findViewById(R.id.tealButton),
                (Button) findViewById(R.id.blueButton),
                (Button) findViewById(R.id.greenButton),
                (Button) findViewById(R.id.oliveButton),
                (Button) findViewById(R.id.purpleButton),
                (Button) findViewById(R.id.silverButton),
                (Button) findViewById(R.id.yellowButton)
        };

        // Reference SeekBars
        SeekBar hue = (SeekBar) findViewById(R.id.seekBar_hue);
        SeekBar sat = (SeekBar) findViewById(R.id.seekBar_sat);
        SeekBar val = (SeekBar) findViewById(R.id.seekBar_ligthness);

        // Reference swatch
        TextView swatch = (TextView) findViewById(R.id.swatchText);


        //////////////////////////////////////////////////
        //
        //  LISTENERS

        // Set seek bar listeners
        hue.setOnSeekBarChangeListener(this);
        val.setOnSeekBarChangeListener(this);
        sat.setOnSeekBarChangeListener(this);

        // Set button listeners
        int upperBound = buttons.length;

        for(int cnt = 0; cnt < upperBound; cnt++){
            buttons[cnt].setOnClickListener(this);
        }


        //Set swatch listener
        swatch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                // TODO: and make this a function?? getColor and convert???
                float[] hsv = new float[3];
                ColorDrawable swatchDrawable = (ColorDrawable) v.getBackground();
                int swatchColor = swatchDrawable.getColor();
                int hueValue, satValue, lightValue;
                Color.colorToHSV(swatchColor, hsv);
                hueValue = (int) hsv[0];
                satValue = (int) (hsv[1] * 100);
                lightValue = (int) (hsv[2] * 100);

                Toast.makeText(getApplicationContext(),"Hue: " + hueValue + "\u00B0 S: " + satValue + "% V: " + lightValue + "%", Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }


    //////////////////////////////////////////////////
    //
    // CANNED METHODS

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialog();
            newFragment.show( getFragmentManager(), "About Dialog");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //////////////////////////////////////////////////
    //
    //  LISTENER ACTIONS

    @Override
    public void onClick( View v ) {
        setSwatchColor(buttonColorChanger(v));
    }


    // Seek bar listeners
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(fromUser){
            setSwatchColor(calculateColorOnTheFly(seekBar));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        TextView hueLbl = (TextView) findViewById(R.id.txt_hue);
        TextView satLbl = (TextView) findViewById(R.id.txt_sat);
        TextView valLbl = (TextView) findViewById(R.id.txt_lightness);


        // Do I need logic here? what's the cost/benefit
        // is the overhead worth it?
        hueLbl.setText(R.string.hue_lbl);
        satLbl.setText(R.string.sat_lbl);
        valLbl.setText(R.string.lightness_lbl);
    }


    //////////////////////////////////////////////////////
    //
    // MY LOGIC/METHODS

    public int buttonColorChanger(View v) {

        // Reference UI Widgets
        SeekBar hue = (SeekBar) findViewById(R.id.seekBar_hue);
        SeekBar sat = (SeekBar) findViewById(R.id.seekBar_sat);
        SeekBar val = (SeekBar) findViewById(R.id.seekBar_ligthness);

        // TODO: Make a function for this
        // some handy variables for conversions
        float[] hsv = new float[3];
        int hueValue, satValue, lightValue, newColor;

        //get the background color of the current button
        ColorDrawable jj = (ColorDrawable) v.getBackground();
        newColor = jj.getColor();

        // convert to HSV
        Color.colorToHSV(newColor, hsv);

        // assign int values to h s v
        hueValue = (int) hsv[0];
        satValue = (int) (hsv[1] * 100);
        lightValue = (int) (hsv[2] * 100);

        // TODO: END possible function here

        //set the Hue seek bar
        hue.setProgress(hueValue);

        // set the Saturation bar
        sat.setProgress(satValue);

        //set the Value/Lightness bar
        val.setProgress(lightValue);

        Toast.makeText(getApplicationContext(),"Hue: " + hueValue + "\u00B0 S: " + satValue + "% V: " + lightValue + "%", Toast.LENGTH_SHORT).show();
        return newColor;
    }


    // get color values of the seek bars and return a int representation of the new color
    public int calculateColorOnTheFly(SeekBar bar) {

       // TextView swatch = (TextView) findViewById(R.id.swatchText);
        SeekBar hue = (SeekBar) findViewById(R.id.seekBar_hue);
        SeekBar sat = (SeekBar) findViewById(R.id.seekBar_sat);
        SeekBar val = (SeekBar) findViewById(R.id.seekBar_ligthness);

        TextView hueLbl = (TextView) findViewById(R.id.txt_hue);
        TextView satLbl = (TextView) findViewById(R.id.txt_sat);
        TextView valLbl = (TextView) findViewById(R.id.txt_lightness);

        float[] hsv = new float[3];
        int hueValue, satValue, lightValue;

        //get the values from each seek bar
        hueValue = hue.getProgress();
        satValue = sat.getProgress();
        lightValue = val.getProgress();

        // convert and assign values to hsv array.
        hsv[0] = (float) hueValue;
        hsv[1] = (float) satValue / 100;
        hsv[2] = (float) lightValue / 100;

        //Change text presentation for active seek bar
        if(bar.getId() == hue.getId()) {
            hueLbl.setText("HUE: " + hueValue + "\u00B0");
        }

        if(bar.getId() == sat.getId()) {
            satLbl.setText("SATURATION: " + satValue + "%");
        }

        if(bar.getId() == val.getId()) {
            valLbl.setText("LIGHTNESS: " + lightValue + "%");
        }

        return Color.HSVToColor(hsv);
    }

    // Sets the background color of the swatch
    public void setSwatchColor( int theNewColor) {
        TextView swatch = (TextView) findViewById(R.id.swatchText);
        swatch.setBackgroundColor(theNewColor);
    }
}
