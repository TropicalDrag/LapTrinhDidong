package com.example.appmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtTitle, txtTimeSong, txtTimeTotal;
    SeekBar skSong;
    ImageButton btnPrev, btnStop, btnPlay, btnNext;

    ArrayList<Song> arraySong;
    int position = 0;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            App();
            AddSong();

            mediaPlayer = MediaPlayer.create(MainActivity.this, arraySong.get(position).getFile());
            txtTitle.setText(arraySong.get(position).getTitle());

            btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.pause();
                        btnPlay.setImageResource(R.drawable.pause);
                    }else{
                        mediaPlayer.start();
                        btnPlay.setImageResource(R.drawable.play);
                    }

                }
            });
    }
    private void AddSong(){
        arraySong = new ArrayList<>();
        arraySong.add(new Song("Có hẹn với thanh xuân", R.raw.co_hen_voi_thanh_xuan));
        arraySong.add(new Song("Răng khôn", R.raw.rang_khon));
        arraySong.add(new Song("Có hẹn với thanh xuân", R.raw.nam_ngu_emru));

    }

    private void App(){
        txtTimeSong = (TextView) findViewById(R.id.txtTimeSong);
        txtTimeTotal = (TextView) findViewById(R.id.txtTimeTotal);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        skSong = (SeekBar) findViewById(R.id.skSong);
        btnNext = (ImageButton) findViewById(R.id.btnNext);
        btnPrev = (ImageButton) findViewById(R.id.btnPrev);
        btnStop = (ImageButton) findViewById(R.id.btnStop);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
    }
}