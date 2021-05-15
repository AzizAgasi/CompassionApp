package com.techdot.CompassionApp.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.techdot.CompassionApp.adapter.SpacesItemDecoration;
import com.techdot.CompassionApp.adapter.StaggeredGridViewAdapter;
import com.techdot.CompassionApp.model.ViewModel;
import com.techdot.project1.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    List<ViewModel> viewModelList;
    StaggeredGridViewAdapter adapter;
    RecyclerView recyclerView;
    StaggeredGridLayoutManager staggeredGridLayoutManager;

    MediaController mediaController;

    TextView mainText;
    ImageView mainImage;
    TextView mainLink;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        viewModelList = new ArrayList<>();
        adapter = new StaggeredGridViewAdapter(getContext());

        recyclerView = root.findViewById(R.id.staggeredRecyclerView);
        mainText = root.findViewById(R.id.mainText);
        mainImage = root.findViewById(R.id.mainImage);
        mainLink = root.findViewById(R.id.mainLink);

        mediaController = new MediaController(getContext());

        recyclerView.addItemDecoration(new SpacesItemDecoration(20));
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeViewModelList();
        adapter.setViewModelList(viewModelList);

        mainImage.setImageResource(R.drawable.m);
        mainText.setText("Learn more about how we're responding with Covid-19");
        mainLink.setText("Tell me more ->");

        mainLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "The links can be clicked", Toast.LENGTH_SHORT).show();
            }
        });



        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }

    public void initializeViewModelList() {
        ViewModel item1 = new ViewModel();
        item1.setTitle("New Sponsorship");
        item1.setImage(R.drawable.a);
        item1.setLink("Reagle ->");
        item1.setBackgroundColor(Color.CYAN);

        ViewModel item2 = new ViewModel();
        item2.setTitle("Johanna");
        item2.setContent("Birthday in 2 months");
        item2.setLink("Give a gift ->");
        item2.setBackgroundColor(Color.CYAN);

        ViewModel item3 = new ViewModel();
        item3.setTitle("Weather ->");
        item3.setImage(R.drawable.b);
        item3.setLink("My community ->");
        item3.setBackgroundColor(Color.CYAN);

        ViewModel item4 = new ViewModel();
        item4.setImage(R.drawable.c);
        item4.setContent("How to use Amazon Smile and give as you use");
        item4.setBackgroundColor(Color.CYAN);

        ViewModel item5 = new ViewModel();
        item5.setTitle("Sergio");
        item5.setContent("3 years of \nsponsorship\nThank you");
        item5.setSideImage(R.drawable.d);
        item5.setBackgroundColor(Color.CYAN);

        ViewModel item6 = new ViewModel();
        item6.setTitle("New Photo");
        item6.setImage(R.drawable.e);
        item6.setBackgroundColor(Color.CYAN);

        ViewModel item7 = new ViewModel();
        item7.setTitle("Thank you");
        item7.setContent("Given this year");
        item7.setLink("My Children ->");
        item7.setBackgroundColor(Color.CYAN);

        ViewModel item8 = new ViewModel();
        item8.setTitle("Sergio");
        item8.setContent("Give thanks that Sergio receives regular home visits from caring project staff");
        item8.setLink("Pray now ->");
        item8.setBackgroundColor(Color.CYAN);

        ViewModel item9 = new ViewModel();
        item9.setVideoLink("https://www.youtube.com/watch?v=vDHtypVwbHQ");

        viewModelList.add(item1);
        viewModelList.add(item2);
        viewModelList.add(item3);
        viewModelList.add(item4);
        viewModelList.add(item6);
        viewModelList.add(item5);
        viewModelList.add(item7);
        viewModelList.add(item8);
        viewModelList.add(item9);
    }


}