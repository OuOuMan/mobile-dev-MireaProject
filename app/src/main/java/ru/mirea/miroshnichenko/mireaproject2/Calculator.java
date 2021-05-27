package ru.mirea.miroshnichenko.mireaproject2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Calculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calculator extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Calculator() {
        // Required empty public constructor
    }

    private View view;
    private TextView result;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment calc.
     */
    // TODO: Rename and change types and number of parameters
    public static Calculator newInstance(String param1, String param2) {
        Calculator fragment = new Calculator();
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
        view =  inflater.inflate(R.layout.fragment_calculator, container, false);
        result = (TextView) view.findViewById(R.id.resultValue);


        ((Button) view.findViewById(R.id.buttonPlus)).setOnClickListener(nButtonClickListenerPlus);
        ((Button) view.findViewById(R.id.buttonMinus)).setOnClickListener(nButtonClickListenerMinus);
        ((Button) view.findViewById(R.id.buttonMultiple)).setOnClickListener(nButtonClickListenerMultiple);
        ((Button) view.findViewById(R.id.buttonDiv)).setOnClickListener(nButtonClickListenerDiv);


        return view;
    }


    private View.OnClickListener nButtonClickListenerPlus = new View.OnClickListener() {
        public void onClick(View v) {
            plusHandler(v);
        }
    };

    private View.OnClickListener nButtonClickListenerMinus = new View.OnClickListener() {
        public void onClick(View v) {
            minusHandler(v);
        }
    };

    private View.OnClickListener nButtonClickListenerMultiple = new View.OnClickListener() {
        public void onClick(View v) {
            multipleHandler(v);
        }
    };

    private View.OnClickListener nButtonClickListenerDiv = new View.OnClickListener() {
        public void onClick(View v) {
            divHandler(v);
        }
    };


    public void plusHandler(View view1) {
        EditText textArg1 = (EditText) view.findViewById(R.id.editTextTextPersonName);
        EditText textArg2 = (EditText) view.findViewById(R.id.editTextTextPersonName2);
        int num1 = Integer.parseInt(textArg1.getText().toString());
        int num2 = Integer.parseInt(textArg2.getText().toString());
        int res = num1 + num2;

        result.setText(Integer.toString(res));
    }

    public void minusHandler(View view1) {
        EditText textArg1 = (EditText) view.findViewById(R.id.editTextTextPersonName);
        EditText textArg2 = (EditText) view.findViewById(R.id.editTextTextPersonName2);
        int num1 = Integer.parseInt(textArg1.getText().toString());
        int num2 = Integer.parseInt(textArg2.getText().toString());
        int res = num1 - num2;

        result.setText(Integer.toString(res));
    }

    public void multipleHandler(View view1) {
        EditText textArg1 = (EditText) view.findViewById(R.id.editTextTextPersonName);
        EditText textArg2 = (EditText) view.findViewById(R.id.editTextTextPersonName2);
        int num1 = Integer.parseInt(textArg1.getText().toString());
        int num2 = Integer.parseInt(textArg2.getText().toString());
        int res = num1 * num2;

        result.setText(Integer.toString(res));
    }

    public void divHandler(View view1) {
        EditText textArg1 = (EditText) view.findViewById(R.id.editTextTextPersonName);
        EditText textArg2 = (EditText) view.findViewById(R.id.editTextTextPersonName2);
        int num1 = Integer.parseInt(textArg1.getText().toString());
        int num2 = Integer.parseInt(textArg2.getText().toString());
        int res = num1 / num2;

        result.setText(Integer.toString(res));
    }
}