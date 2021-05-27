package ru.mirea.miroshnichenko.mireaproject2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicPlayer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicPlayer extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MusicPlayer() {
        // Required empty public constructor
    }

    private WebView webView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WebViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebViewFragment newInstance(String param1, String param2) {
        WebViewFragment fragment = new WebViewFragment();
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
        View view = inflater.inflate(R.layout.fragment_music_player, container, false);
        ((Button) view.findViewById(R.id.startBtn)).setOnClickListener(playMusicListener);
        ((Button) view.findViewById(R.id.stopBtn)).setOnClickListener(stopMusicListener);
        return view;
    }

    private View.OnClickListener playMusicListener = new View.OnClickListener() {
        public void onClick(View v) {
            onClickPlayMusic(v);
        }
    };

    private View.OnClickListener stopMusicListener = new View.OnClickListener() {
        public void onClick(View v) {
            onClickStopMusic(v);
        }
    };

    public void onClickPlayMusic(View view) {
        getActivity().startService(
                new Intent(getActivity(), PlayerService.class));
    }
    public void onClickStopMusic(View view) {
        getActivity().stopService(
                new Intent(getActivity(), PlayerService.class));
    }
}