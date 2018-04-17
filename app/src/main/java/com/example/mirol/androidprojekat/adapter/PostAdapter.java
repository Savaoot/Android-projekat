package com.example.mirol.androidprojekat.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mirol.androidprojekat.R;
import com.example.mirol.androidprojekat.model.Comment;

public class PostAdapter extends ArrayAdapter<Comment>{
    private final Context context;
    private final Comment[] comments;


    public PostAdapter(@NonNull Context context, @NonNull Comment[] objects) {
        super(context, -1, objects);
        this.comments = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.comment_item, parent, false);
        TextView title = rowView.findViewById(R.id.tv_title);
        TextView descp = rowView.findViewById(R.id.tv_description);

        title.setText(comments[position].getTitle());
        descp.setText(comments[position].getDescription());

        return rowView;
    }
}
