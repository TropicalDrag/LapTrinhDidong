package com.example.appnhaconline.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appnhaconline.Model.Playlist;
import com.example.appnhaconline.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView TVplaylistname;
        ImageView IVplaylistback, IVplaylist;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewholder = null;
        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_playlist,null);
            viewholder = new ViewHolder();
            viewholder.TVplaylistname = convertView.findViewById(R.id.textviewtenplaylist);
            viewholder.IVplaylist= convertView.findViewById(R.id.imageviewplaylist);
            viewholder.IVplaylistback= convertView.findViewById(R.id.imageviewbackgroudplaylist);
            convertView.setTag(viewholder);
        }
        else {
            viewholder= (ViewHolder) convertView.getTag();
        }
        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhNen()).into(viewholder.IVplaylistback);
        Picasso.with(getContext()).load(playlist.getHinhIcon()).into(viewholder.IVplaylist);
        viewholder.TVplaylistname.setText(playlist.getTen());
        return convertView;
    }
}
