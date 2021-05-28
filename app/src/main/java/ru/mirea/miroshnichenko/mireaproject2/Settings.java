package ru.mirea.miroshnichenko.mireaproject2;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Settings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Settings extends Fragment {

    TextView themeView;
    TextView fileView;
    TextView fontsizeView;

    final String themeViewKey = "THEME";
    final String fileViewKey = "FILE";
    final String fontsizeViewKey = "FONTSIZE";

    private SharedPreferences preferences;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Settings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Settings.
     */
    // TODO: Rename and change types and number of parameters
    public static Settings newInstance(String param1, String param2) {
        Settings fragment = new Settings();
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
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        preferences = getActivity().getPreferences(MODE_PRIVATE);

        ((Button) view.findViewById(R.id.saveSettingsBtn)).setOnClickListener(saveSettingsListener);

        themeView = (TextView) view.findViewById(R.id.themeEditor);
        themeView.setText(preferences.getString(themeViewKey, "ligth"));

        fileView = (TextView) view.findViewById(R.id.fileEditor);
        fileView.setText(preferences.getString(fileViewKey, "txt"));

        fontsizeView = (TextView) view.findViewById(R.id.fontsizeEditor);
        fontsizeView.setText(preferences.getString(fontsizeViewKey, "14px"));
        
        return view;
    }

    private View.OnClickListener saveSettingsListener = new View.OnClickListener() {
        public void onClick(View v) {
            saveSettings(v);
        }
    };

    public void saveSettings(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(themeViewKey, themeView.getText().toString());
        editor.putString(fileViewKey, fileView.getText().toString());
        editor.putString(fontsizeViewKey, fontsizeView.getText().toString());
        editor.apply();
    }

}