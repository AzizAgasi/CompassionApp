package com.techdot.CompassionApp.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techdot.project1.R;
import com.techdot.CompassionApp.model.ViewModel;

import java.util.List;


public class StaggeredGridViewAdapter extends RecyclerView.Adapter<StaggeredGridViewAdapter.ViewHolder> {

    List<ViewModel> viewModelList;
    public static Context mContext;

    public StaggeredGridViewAdapter(Context context) {
        mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.views_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewModel item = viewModelList.get(position);
        if (item.getTitle() != null) {
            holder.title.setText(item.getTitle());
        } else {
            holder.title.setVisibility(View.GONE);
        }
        if (item.getContent() != null) {
            holder.content.setText(item.getContent());
        } else {
            holder.content.setVisibility(View.GONE);
        }
        if (item.getImage() >= 0) {
            holder.image.setImageResource(item.getImage());
        } else {
            holder.image.setVisibility(View.GONE);
        }
        if (item.getLink() != null) {
            holder.link.setText(item.getLink());
        } else {
            holder.link.setVisibility(View.GONE);
        }
        if (item.getSideImage() >= 0) {
            holder.sideImage.setImageResource(item.getSideImage());
        } else {
            holder.sideImage.setVisibility(View.GONE);
        }
        if (item.getVideoLink() != null) {
            holder.video.setVisibility(View.VISIBLE);
            Uri videoUri = Uri.parse(item.getVideoLink());
            VideoView videoView = holder.video;
            MediaController mediaController = new MediaController(mContext);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(videoUri);

            videoView.requestFocus();
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    videoView.start();
                }
            });

        } else {
            holder.video.setVisibility(View.GONE);
        }
        holder.itemView.setBackgroundColor(item.getBackgroundColor());
    }

    @Override
    public int getItemCount() {
        return viewModelList.size();
    }

    public void setViewModelList(List<ViewModel> viewModelList) {
        this.viewModelList = viewModelList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView content;
        ImageView image;
        TextView link;
        ImageView sideImage;
        VideoView video;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleView);
            content = itemView.findViewById(R.id.contentView);
            image = itemView.findViewById(R.id.imageView);
            link = itemView.findViewById(R.id.clickableTextView);
            sideImage = itemView.findViewById(R.id.sideImage);
            video = itemView.findViewById(R.id.videoView);

            link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Link is clicked!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
