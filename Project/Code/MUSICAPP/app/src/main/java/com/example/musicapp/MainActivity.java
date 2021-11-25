package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtTitle, txtTimesong, txtTimeTotal;
    SeekBar skSong;
    ImageButton btnPrev, btnNext, btnPause, btnStop, btnPlay;
    ImageView ImgCD;

    ArrayList<Song> arraySong;
    int position = 0;
    MediaPlayer mediaPlayer;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        AddSong();
        KhoiTaoMediaPlayer();
        animation = AnimationUtils.loadAnimation(this,R.anim.rotate);

        btnStop.setOnClickListener(view -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer.release();
                btnPlay.setImageResource(R.drawable.play);
                KhoiTaoMediaPlayer();
            }
        });

        btnPlay.setOnClickListener(view -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
                btnPlay.setImageResource(R.drawable.play);
            }else{
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
            }
            SetTimeTotal();
            UpdateTimeSong();
            ImgCD.startAnimation(animation);
        });
  /*          btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= "https://khoapham.vn/download/vietnamoi.mp3";
                 MediaPlayer mediaPlay = new MediaPlayer();
                mediaPlay.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlay.setDataSource(url);
                    mediaPlay.prepareAsync();
                    mediaPlay.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            if(mp.isPlaying()){
                                mp.pause();
                                btnPlay.setImageResource(R.drawable.play);
                            }else{
                                mp.start();
                                btnPlay.setImageResource(R.drawable.pause);
                            }
//                            SetTimeTotal();
//                            UpdateTimeSong();
                            ImgCD.startAnimation(animation);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position++;
                if(position > arraySong.size()-1){
                    position=0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
                SetTimeTotal();
                UpdateTimeSong();
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position--;
                if(position<0){
                    position= arraySong.size()-1;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
                SetTimeTotal();
                UpdateTimeSong();
            }

        });
        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSong.getProgress());
            }
        });
    }

    private void AnhXa(){
        txtTitle = findViewById(R.id.tvTitle);
        txtTimesong = findViewById(R.id.tvTimeSong);
        txtTimeTotal= findViewById(R.id.tvTimeTotal);
        skSong = findViewById(R.id.seekbar);
        btnNext = findViewById(R.id.btn_next);
        btnPlay = findViewById(R.id.btn_play);
        btnPrev = findViewById(R.id.btn_prev);
        btnStop = findViewById(R.id.btn_stop);
        ImgCD = findViewById(R.id.image_cd);
    }
    private void AddSong() {
        arraySong = new ArrayList<>();
        arraySong.add(new Song("ThunDer", R.raw.thunder));
        arraySong.add(new Song("Best Of Me", R.raw.best_of_me));
        arraySong.add(new Song("Night Changes", R.raw.night_changes));

    }
    private void SetTimeTotal(){
        SimpleDateFormat formatTime = new SimpleDateFormat("mm:ss");
        txtTimeTotal.setText(formatTime.format(mediaPlayer.getDuration()));
        //Set maxTime = mediaPlayer.getDuration()
        skSong.setMax(mediaPlayer.getDuration());
    }
    private void UpdateTimeSong(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat forMat = new SimpleDateFormat("mm:ss");
                txtTimesong.setText(forMat.format(mediaPlayer.getCurrentPosition()));
                skSong.setProgress(mediaPlayer.getCurrentPosition());
                //Tu dong chuyen bai khi het thoi gian
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if(position > arraySong.size()-1){
                            position=0;
                        }
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        KhoiTaoMediaPlayer();
                        mediaPlayer.start();
                        btnPlay.setImageResource(R.drawable.pause);
                        SetTimeTotal();
                        UpdateTimeSong();
                    }
                });
                handler.postDelayed(this,500);
            }
        },100);

    }
    private void KhoiTaoMediaPlayer(){
        mediaPlayer = MediaPlayer.create(MainActivity.this, arraySong.get(position).getFile());
        txtTitle.setText(arraySong.get(position).getTitle());
    }
}