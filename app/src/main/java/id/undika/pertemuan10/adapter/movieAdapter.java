package id.undika.pertemuan10.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.undika.pertemuan10.DetailActivity;
import id.undika.pertemuan10.Movie_Detail_Activity;
import id.undika.pertemuan10.R;
import id.undika.pertemuan10.pojo.pojo_movies;

public class movieAdapter extends RecyclerView.Adapter<movieAdapter.ViewHolder> {
    private Context context;
    private static ArrayList<pojo_movies> listMovie;

    //cons
    public movieAdapter(Context context) {
        this.context = context;
    }

    //setter
    public static ArrayList<pojo_movies> getListMovie() {
        return listMovie;
    }

    public static void setListMovie(ArrayList<pojo_movies> listMovie) {
        movieAdapter.listMovie = listMovie;
    }


    @NonNull
    @Override //inflate layout item_list
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_movie,
                parent, false);
        return new ViewHolder(v);
    }

    //penempatan data pojo ke item_list
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        pojo_movies pm = getListMovie().get(position);

        holder.titleMovie.setText(pm.getTitle());
        holder.releaseMovie.setText(pm.getRealease_date());
        holder.descMovie.setText(pm.getDesc());
        Glide.with(holder.itemView.getContext()).load(pm.getPoster())
                .into(holder.posterMovies);
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    //hubungkan dengan layout xml item_list
    public class ViewHolder extends RecyclerView.ViewHolder {

        //deklarasi
        public ImageView posterMovies;
        public TextView releaseMovie, descMovie, titleMovie;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            posterMovies = itemView.findViewById(R.id.posterMovies);
            releaseMovie = itemView.findViewById(R.id.releaseMovies);
            descMovie = itemView.findViewById(R.id.descMovies);
            titleMovie = itemView.findViewById(R.id.titleMovies);

            //event onClick utk list (req: buat 1 activity baru --> halaman detail)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //isi yg ditampilkan di halaman 2 sesuai dengan gambar/data yg dipilih
                    int i = getBindingAdapterPosition();
                    pojo_movies m = getListMovie().get(i);

                    m.setTitle(m.getTitle());
                    m.setDesc(m.getDesc());
                    m.setRealease_date(m.getRealease_date());

                    Intent detailIntent = new Intent(itemView.getContext(), Movie_Detail_Activity.class);
                    detailIntent.putExtra(DetailActivity.EXTRA_MOVIE, m);

                    context.startActivity(detailIntent);
                    //itemView.getContext().startActivity(detailIntent);

                }
            });
        }
    }
}
