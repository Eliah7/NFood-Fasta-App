package com.eliahmbwilo.foodfasta;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private TextView mUsername;
    private TextView mEmail;
    private Button mButton;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mUsername = (TextView) view.findViewById(R.id.profile_username);
        mEmail = (TextView) view.findViewById(R.id.profile_email);
        mButton = (Button) view.findViewById(R.id.profile_button);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        String name = preferences.getString("name", "no username");
        String mail = preferences.getString("mail", "noemail@nodomain.com");

        mUsername.setText(name);
        mEmail.setText(mail);
        mButton.setText(name);

        return view;
    }

}
