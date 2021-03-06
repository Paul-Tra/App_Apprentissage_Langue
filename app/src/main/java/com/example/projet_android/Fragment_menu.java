package com.example.projet_android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_menu.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_menu extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    static TextView nom ;
    static TextView score ;
    ProgressBar barre_progress ;
    ImageView drapeau ;
    View vue_du_frag ;


    NavigationView nav_view ;

    public TextView getNom() {
        return nom;
    }

    public void setNom(TextView nom) {
        this.nom = nom;
    }

    public TextView getScore() {
        return score;
    }

    public void setScore(TextView score) {
        this.score = score;
    }

    public ProgressBar getBarre_progress() {
        return barre_progress;
    }

    public void setBarre_progress(ProgressBar barre_progress) {
        this.barre_progress = barre_progress;
    }

    public ImageView getDrapeau() {
        return drapeau;
    }

    public void setDrapeau(ImageView drapeau) {
        this.drapeau = drapeau;
    }

    private OnFragmentInteractionListener mListener;

    public Fragment_menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_menu.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_menu newInstance(String param1, String param2) {
        Fragment_menu fragment = new Fragment_menu();
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
        nom = new TextView(getContext());
        score = new TextView(getContext());
        barre_progress = new ProgressBar(getContext());
        drapeau = new ImageView(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vue_du_frag = inflater.inflate(R.layout.fragment_fragment_menu, container, false);

        Log.d(Base_de_donnee.TAG, "onCreateView Menu: " + mParam1);
        if ( mParam1 != null ){
            nom = vue_du_frag.findViewById(R.id.Nom);
            score = vue_du_frag.findViewById(R.id.Score);
            barre_progress = vue_du_frag.findViewById(R.id.progressBar2);
            drapeau= vue_du_frag.findViewById(R.id.Drapeau);
            nom.setText("Joueur : "+MainActivity.bundle_de_la_session_en_cours.getString(MainActivity.BUNDLE_NOM));
            score.setText("Score : " + MainActivity.bundle_de_la_session_en_cours.getInt(MainActivity.BUNDLE_SCORE));



        }
        return vue_du_frag;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
