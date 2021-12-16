package com.example.appnhaconline.Service;

import com.example.appnhaconline.Model.Album;
import com.example.appnhaconline.Model.Baihat;
import com.example.appnhaconline.Model.Chude;
import com.example.appnhaconline.Model.Playlist;
import com.example.appnhaconline.Model.Quangcao;
import com.example.appnhaconline.Model.Theloai;
import com.example.appnhaconline.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

//send cac protocol va receive du lieu from server
public interface DataService {
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlist4now.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("theloai_chude.php")
    Call<Theloaitrongngay> GetCategoryMusic();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("baihatyeuthich.php")
    Call<List<Baihat>> GetBaiHatYeuThich();

    @GET("danhsachtatcaPlaylist.php")
    Call<List<Playlist>> GetAllPlaylist();

    @GET("tatcachude.php")
    Call<List<Chude >> GetAllChuDe();


    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDSBaiHatTheoQuangCao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDSBaiHatTheoPlaylist(@Field("idplaylist") String idplaylist);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDSBaiHatTheoTheLoai(@Field("idtheloai") String idtheloai);


    @FormUrlEncoded
    @POST("theloaitheochude.php")
    Call<List<Theloai>> GetTheloaitheoChude(@Field("idchude") String idchude);

}
