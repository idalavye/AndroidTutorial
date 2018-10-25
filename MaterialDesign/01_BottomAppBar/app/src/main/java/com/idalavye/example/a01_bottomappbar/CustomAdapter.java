package com.idalavye.example.a01_bottomappbar;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<ObjetoListView> {

    private Activity activity;
    private ArrayList<ObjetoListView> arrayList;
    private int lastPosition = -1;


    public CustomAdapter(Activity activity, ArrayList<ObjetoListView> arrayList) {
        super(activity, R.layout.custom_layout_listview, arrayList);
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_layout_listview, parent, false);
        }

        TextView txtName = convertView.findViewById(R.id.textName);
        TextView txtMessage = convertView.findViewById(R.id.textMessage);
        TextView txtDate = convertView.findViewById(R.id.textDate);
        TextView txtSmallIcon = convertView.findViewById(R.id.textSmallIcon);
        TextView txtBadgeNotification = convertView.findViewById(R.id.badge_notification);

        ImageView imgAudio = convertView.findViewById(R.id.imgAudio);
        ImageView imgVideo = convertView.findViewById(R.id.imgVideo);
        ImageView imgPhoto = convertView.findViewById(R.id.imgPhoto);
        ImageView imgP = convertView.findViewById(R.id.img_profile);
        imgP.setImageDrawable(activity.getResources().getDrawable(
                arrayList.get(position).getImg()
        ));


        txtName.setText(arrayList.get(position).getName());
        txtMessage.setText(arrayList.get(position).getMessage());
        txtDate.setText(arrayList.get(position).getDate());

        System.out.println("**************" + txtMessage.getText().toString());


        String lastMessage = arrayList.get(position).getLastMessges();
        switch (lastMessage) {
            case MainActivity.TEXT:
                txtMessage.setVisibility(View.VISIBLE);
                imgAudio.setVisibility(View.GONE);
                imgPhoto.setVisibility(View.GONE);
                imgVideo.setVisibility(View.GONE);
                txtSmallIcon.setVisibility(View.GONE);
                break;
            case MainActivity.AUDIO:
                txtMessage.setVisibility(View.VISIBLE);
                imgAudio.setVisibility(View.VISIBLE);
                txtSmallIcon.setVisibility(View.VISIBLE);
                txtSmallIcon.setText(arrayList.get(position).getTxtSmallIcon());
                break;
            case MainActivity.VIDEO:
                txtMessage.setVisibility(View.VISIBLE);
                imgVideo.setVisibility(View.VISIBLE);
                txtSmallIcon.setVisibility(View.VISIBLE);
                txtSmallIcon.setText(arrayList.get(position).getTxtSmallIcon());
                break;
            case MainActivity.IMAGE:
                txtMessage.setVisibility(View.VISIBLE);
                imgPhoto.setVisibility(View.VISIBLE);
                txtSmallIcon.setVisibility(View.VISIBLE);
                txtSmallIcon.setText(arrayList.get(position).getTxtSmallIcon());
                break;
        }

        if (!arrayList.get(position).isMsjPermission()) {
            txtDate.setTextColor(activity.getResources().getColor(R.color.color_notification));
            txtBadgeNotification.setVisibility(View.VISIBLE);
            txtBadgeNotification.setText(String.valueOf(arrayList.get(position).getCountMessage()));
        } else {
            txtDate.setTextColor(Color.GRAY);
            txtBadgeNotification.setVisibility(View.GONE);
        }

        //Animation
        Animation animation = AnimationUtils.loadAnimation(activity, android.R.anim.slide_in_left);
        convertView.startAnimation(animation);

        /*
        Animation animation = AnimationUtils.loadAnimation(activity,
                (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        convertView.startAnimation(animation);
        lastPosition = position;
    */

        return convertView;
    }
}

