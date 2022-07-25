package id.undika.pertemuan10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import id.undika.pertemuan10.pojo.pojo_movies;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_MOVIE = "extra_movie";

    ImageView detailPoster;
    TextView detailJudul, detailDate, detailDesc, detailReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailPoster=findViewById(R.id.detail_poster);
        detailJudul=findViewById(R.id.detail_judul);
        detailDate=findViewById(R.id.detail_release_date);
        detailDesc=findViewById(R.id.detail_deskripsi);
        detailReview=findViewById(R.id.detail_review);

        //ambil paket EXTRA_MOVIE dari adapter
        pojo_movies Movies = getIntent().getParcelableExtra(EXTRA_MOVIE);

        detailJudul.setText(Movies.getTitle());
        detailDate.setText(Movies.getRealease_date());
        detailDesc.setText(Movies.getDesc());
        detailReview.setText(Movies.getReview());

        //set gambar
        Glide.with(DetailActivity.this).load(Movies.getPoster())
                .apply(new RequestOptions().override(350,550)).into(detailPoster);
    }
}