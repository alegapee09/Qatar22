package com.dam.evaluaciont1_agp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultadoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultadoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_FASE = "fase";
    private static final String ARG_FECHA = "fecha";
    private static final String ARG_PRIMEQ = "primeq";
    private static final String ARG_SEGEQ = "segeq";
    private static final String ARG_GOLESPRIM = "golesprim";
    private static final String ARG_GOLESSEG = "golesseg";


    // TODO: Rename and change types of parameters
    private String fase;
    private String fecha;
    private String primeq;
    private String segeq;
    private String golesprim;
    private String golsesseg;

    public ResultadoFragment() {
        // Required empty public constructor
    }

    public static ResultadoFragment newInstance(String Fase, String Fecha, String PrimEq, String SeqEq, String Golesprim, String Golesseg) {
        ResultadoFragment fragment = new ResultadoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_FASE, Fase);
        args.putString(ARG_FECHA, Fecha);
        args.putString(ARG_PRIMEQ, PrimEq);
        args.putString(ARG_SEGEQ, SeqEq);
        args.putString(ARG_GOLESPRIM, Golesprim);
        args.putString(ARG_GOLESSEG, Golesseg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fase = getArguments().getString(ARG_FASE);
            fecha = getArguments().getString(ARG_FECHA);
            primeq = getArguments().getString(ARG_PRIMEQ);
            segeq = getArguments().getString(ARG_SEGEQ);
            golesprim = getArguments().getString(ARG_GOLESPRIM);
            golsesseg = getArguments().getString(ARG_GOLESSEG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resultado, container, false);
    }
}
