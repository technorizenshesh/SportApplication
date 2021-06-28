package com.sport.sportapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.RelativeLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sport.sportapplication.Activity.CreateTeamsActivity;
import com.sport.sportapplication.Activity.FixturesActivity;
import com.sport.sportapplication.Activity.HomeActivity;
import com.sport.sportapplication.Activity.LoginActivity;
import com.sport.sportapplication.Activity.PlayersProfileActivity;
import com.sport.sportapplication.Adapter.Temas_RecyclerViewAdapter;
import com.sport.sportapplication.Model.TeamsModel;
import com.sport.sportapplication.R;

import java.util.ArrayList;

public class HomeFragmentOne extends Fragment {

   private View view;
   CardView card_news;
   CardView card_teams;
   CardView card_chat;
   CardView cardStanding;
   RelativeLayout RR_back;
   CardView card_events;
   CardView card_playerProfile;
    Fragment fragment;
    public HomeFragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // view = inflater.inflate(R.layout.fragment_main, container, false);
        view = inflater.inflate(R.layout.fragment_home, container, false);

        findView();

        RR_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        card_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), CalendarView.class));

            }
        });

        card_playerProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), PlayersProfileActivity.class));

            }
        });


        return view;
    }

    private void findView() {
        card_news=view.findViewById(R.id.card_news);
        card_teams=view.findViewById(R.id.card_teams);
        card_chat=view.findViewById(R.id.card_chat);
        cardStanding=view.findViewById(R.id.cardStanding);
        card_events=view.findViewById(R.id.card_events);
        card_playerProfile=view.findViewById(R.id.card_playerProfile);
        RR_back=view.findViewById(R.id.RR_back);

        card_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment = new NewsFragment();
                loadFragment(fragment);

            }
        });

        cardStanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), FixturesActivity.class));

               /* fragment = new FixtureMatchFragment();
                loadFragment(fragment);*/

            }
        });

        card_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new ChatFragment();
                loadFragment(fragment);

            }
        });

        card_teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), CreateTeamsActivity.class));

               /* fragment = new HomeFragment();
                loadFragment(fragment);*/

            }
        });
    }


    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_homeContainer, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }


}
