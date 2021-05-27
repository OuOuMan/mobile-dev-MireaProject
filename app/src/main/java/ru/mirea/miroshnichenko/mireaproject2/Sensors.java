package ru.mirea.miroshnichenko.mireaproject2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Sensors#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sensors extends Fragment implements SensorEventListener {

    private TextView accelerometer1;
    private TextView accelerometer2;
    private TextView accelerometer3;

    private TextView gyroscope1;
    private TextView gyroscope2;
    private TextView gyroscope3;

    private TextView magnetometer1;
    private TextView magnetometer2;
    private TextView magnetometer3;

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private Sensor gyroscopeSensor;
    private Sensor magnetometerSensor;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Sensors() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Sensors.
     */
    // TODO: Rename and change types and number of parameters
    public static Sensors newInstance(String param1, String param2) {
        Sensors fragment = new Sensors();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sensors, container, false);

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        magnetometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        accelerometer1 = (TextView) view.findViewById(R.id.accelerometer1);
        accelerometer2 = (TextView) view.findViewById(R.id.accelerometer2);
        accelerometer3 = (TextView) view.findViewById(R.id.accelerometer3);

        gyroscope1 = (TextView) view.findViewById(R.id.gyroscope1);
        gyroscope2 = (TextView) view.findViewById(R.id.gyroscope2);
        gyroscope3 = (TextView) view.findViewById(R.id.gyroscope3);

        magnetometer1 = (TextView) view.findViewById(R.id.magnetometer1);
        magnetometer2 = (TextView) view.findViewById(R.id.magnetometer2);
        magnetometer3 = (TextView) view.findViewById(R.id.magnetometer3);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometerSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gyroscopeSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, magnetometerSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float valueAzimuth = event.values[0];
            float valuePitch = event.values[1];
            float valueRoll = event.values[2];
            accelerometer1.setText(valueAzimuth + "");
            accelerometer2.setText(valuePitch + "");
            accelerometer3.setText(valueRoll + "");

        } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            float valueAzimuth = event.values[0];
            float valuePitch = event.values[1];
            float valueRoll = event.values[2];
            gyroscope1.setText(valueAzimuth + "");
            gyroscope2.setText(valuePitch + "");
            gyroscope3.setText(valueRoll + "");
        } else if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            float valueAzimuth = event.values[0];
            float valuePitch = event.values[1];
            float valueRoll = event.values[2];
            magnetometer1.setText(valueAzimuth + "");
            magnetometer2.setText(valuePitch + "");
            magnetometer3.setText(valueRoll + "");
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

}