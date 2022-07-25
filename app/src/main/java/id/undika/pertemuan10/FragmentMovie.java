package id.undika.pertemuan10;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.undika.pertemuan10.adapter.movieAdapter;
import id.undika.pertemuan10.pojo.pojo_movies;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMovie#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMovie extends Fragment {

    private RecyclerView rvMovies;
    private ArrayList<pojo_movies> listMovies = new ArrayList<>();

    public FragmentMovie() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_movie_rv, container, false);
        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);

        listMovies.addAll(getListDataMovies());
        showRecyclerViewMovie();
        return view;
    }

    private void showRecyclerViewMovie() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this.getContext()));
        movieAdapter adapter = new movieAdapter(this.getContext());
        adapter.setListMovie(listMovies);
        rvMovies.setAdapter(adapter);
    }

    private ArrayList<pojo_movies> getListDataMovies() {
        String[] movieTitle = getResources().getStringArray(R.array.mv_titles);
        String[] movieReleased = getResources().getStringArray(R.array.mv_released);
        String[] movieDesc = getResources().getStringArray(R.array.mv_description);
        String[] movieReview = getResources().getStringArray(R.array.mv_reviews);
        TypedArray moviePoster = getResources().obtainTypedArray(R.array.mv_poster);

        ArrayList<pojo_movies> listMovies = new ArrayList<>();
        for (int i = 0; i<movieTitle.length; i++) {
            pojo_movies movies = new pojo_movies();
            movies.setTitle(movieTitle[i]);
            movies.setRealease_date(movieReleased[i]);
            movies.setDesc(movieDesc[i]);
            movies.setReview(movieReview[i]);
            movies.setPoster(moviePoster.getResourceId(i, -1));
            listMovies.add(movies);
        }

        return listMovies;
    }
}