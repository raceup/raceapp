package it.raceup.raceapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.raceup.raceapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChallengePlayerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChallengePlayerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChallengePlayerFragment extends Fragment {
    public static final String ARG_PARAM_NAME = "name";
    public static final String ARG_PARAM_INDUSTRY = "industry";
    public static final String ARG_PARAM_AGE = "age";
    public static final String ARG_PARAM_EMAIL = "email";
    public static final String ARG_PARAM_RECORD_0 = "record_0";
    public static final String ARG_PARAM_RECORD_1 = "record_1";
    private String name, industry, age, email, record_0, record_1;

    private OnFragmentInteractionListener mListener;

    public ChallengePlayerFragment() {
        // Required empty public constructor
    }

    public static ChallengePlayerFragment newInstance(String name, String industry, String age, String email, String record_0, String record_1) {
        ChallengePlayerFragment fragment = new ChallengePlayerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_NAME, name);
        args.putString(ARG_PARAM_INDUSTRY, industry);
        args.putString(ARG_PARAM_AGE, age);
        args.putString(ARG_PARAM_EMAIL, email);
        args.putString(ARG_PARAM_RECORD_0, record_0);
        args.putString(ARG_PARAM_RECORD_1, record_1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM_NAME);
            industry = getArguments().getString(ARG_PARAM_INDUSTRY);
            age = getArguments().getString(ARG_PARAM_AGE);
            email = getArguments().getString(ARG_PARAM_EMAIL);
            record_0 = getArguments().getString(ARG_PARAM_RECORD_0);
            record_1 = getArguments().getString(ARG_PARAM_RECORD_1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_challenge_player, container, false);
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
