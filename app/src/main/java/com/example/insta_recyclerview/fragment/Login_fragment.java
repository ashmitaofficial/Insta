package com.example.insta_recyclerview.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.insta_recyclerview.R;
import com.example.insta_recyclerview.activity.AuthenticationActivity;
import com.example.insta_recyclerview.activity.HomeActivity;
import com.example.insta_recyclerview.utils.SharedPreferenceClass;

public class Login_fragment extends Fragment {

    private TextView signupTxt;
    private Button loginbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_login_fragment, container, false);

        signupTxt=view.findViewById(R.id.signupTxt);

        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, Signup_fragment.class,null)
                        .addToBackStack(null)
                        .commit();
            }
        });

        loginbtn = view.findViewById(R.id.login_btn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // store data in local storage
                SharedPreferenceClass.saveLogin(getContext());

                Intent intent = new Intent(getContext(), HomeActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view.getRootView();
    }


}