package com.example.doctor25;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListItemAdapter extends ArrayAdapter<ListItem> {
    public ListItemAdapter(@NonNull Context context, ArrayList<ListItem> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {

        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        ListItem currentListItemPosition = getItem(position);

        ImageView profile_pic = currentItemView.findViewById(R.id.profile_pic);
        assert currentListItemPosition!= null;

        if(currentListItemPosition.Img==-1)
            profile_pic.setBackgroundResource(R.drawable.ic_menu_report_image);
        else
            profile_pic.setBackgroundResource(currentListItemPosition.Img);

        TextView txt = currentItemView.findViewById(R.id.txt);
        if(currentListItemPosition.Name.equals("Null") || currentListItemPosition.Qualification.equals("Null"))
            txt.setText(Html.fromHtml("<b>Name:</b> Not Found<br>"+"<b>Qualification:</b> Not Found"));
        else
            txt.setText(Html.fromHtml("<b>Name:</b> "+ currentListItemPosition.Name+"<br>"+"<b>Qualification:</b> "+ currentListItemPosition.Category));

        return currentItemView;
    }

};