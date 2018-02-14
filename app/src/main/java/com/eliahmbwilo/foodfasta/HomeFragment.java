package com.eliahmbwilo.foodfasta;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("Home");

        image1 = (ImageView) view.findViewById(R.id.food_image_1);
        image2 = (ImageView) view.findViewById(R.id.food_image_2);
        image3 = (ImageView) view.findViewById(R.id.food_image_3);
        image4 = (ImageView) view.findViewById(R.id.food_image_4);
        image5 = (ImageView) view.findViewById(R.id.food_image_5);
        image6 = (ImageView) view.findViewById(R.id.food_image_6);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodOrderIntent1 = new Intent(getContext(), Order1Activity.class);
                startActivity(foodOrderIntent1);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodOrderIntent2 = new Intent(getContext(), Order2Activity.class);
                startActivity(foodOrderIntent2);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodOrderIntent3 = new Intent(getContext(), Order3Activity.class);
                startActivity(foodOrderIntent3);
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodOrderIntent4 = new Intent(getContext(), Order4Activity.class);
                startActivity(foodOrderIntent4);
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodOrderIntent5 = new Intent(getContext(), Order5Activity.class);
                startActivity(foodOrderIntent5);
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodOrderIntent6 = new Intent(getContext(), Order6Activity.class);
                startActivity(foodOrderIntent6);
            }
        });

        return view;
    }

}
