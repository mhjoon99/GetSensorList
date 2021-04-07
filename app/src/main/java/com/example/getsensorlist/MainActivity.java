package com.example.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mtxtSensors;
    SensorManager sensorManager;
    List<Sensor> sensorList;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtxtSensors = findViewById(R.id.txtSensors);
        mButton = findViewById(R.id.button);
//        mtxtSensors.setMovementMethod(new ScrollingMovementMethod());

        mButton.setOnClickListener(this);
    }



    @Override
    public void onClick (View v){
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        mtxtSensors.append("(# Sensors:" + sensorList.size() + ")\n\n");
        for (Sensor sensor : sensorList) {   //Enhanced for loop
            mtxtSensors.append("Sensor name: " + sensor.getName() + "\n");
            mtxtSensors.append("Sensor type: " + sensor.getType() + "\n\n");
        }
    }
}
