package br.com.halphdem.hummingbirdsmdb.movielist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import br.com.halphdem.hummingbirdsmdb.R;
import br.com.halphdem.hummingbirdsmdb.movie.data.Genres;
import br.com.halphdem.hummingbirdsmdb.movie.data.Movie;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {

    private List<Movie> movies;

    private MovieListContract.Presenter presenter;

    private Context context;

    private ItemClickCallback itemClickCallback;

    public MovieListAdapter(List<Movie> movies, MovieListContract.Presenter presenter, Context context, ItemClickCallback itemClickCallback) {
        this.movies = movies;
        this.presenter = presenter;
        this.context = context;
        this.itemClickCallback = itemClickCallback;
    }

    @Override
    public MovieListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);

        MovieListViewHolder listaContatoViewHolder = new MovieListViewHolder(view);

        return listaContatoViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieListViewHolder holder, int position) {

        Movie movie = movies.get(position);
        final Integer id = movie.getId();

        holder.movieListTitle.setText(movie.getTitle());
        holder.movieListRating.setText(String.valueOf(movie.getVoteAverage()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(movie.getReleaseDate());
        holder.movieListReleaseYear.setText(String.valueOf(calendar.get(Calendar.YEAR)));
        String generos = getGeneros(movie);
        holder.movieListGeneros.setText(generos);
        holder.movieListOverview.setText(movie.getOverview());
        holder.movieListMaisInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickCallback.onItemClick(id.toString());
            }
        });


        presenter.loadImage(context, movie.getPosterPath(), holder.movieListPoster);


    }

    private String getGeneros(Movie movie) {
        if (movie.getGenres() != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Genres genre : movie.getGenres()) {
                stringBuilder.append(genre.getName() + " ");
            }
            return stringBuilder.toString();
        }
        return "";
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieListViewHolder extends RecyclerView.ViewHolder {

        private ImageView movieListPoster;

        private TextView movieListTitle;

        private TextView movieListRating;

        private TextView movieListReleaseYear;

        private TextView movieListGeneros;

        private TextView movieListOverview;

        private TextView movieListMaisInformacoes;

        public MovieListViewHolder(View itemView) {
            super(itemView);

            movieListPoster = (ImageView) itemView.findViewById(R.id.movie_list_poster);
            movieListTitle = (TextView) itemView.findViewById(R.id.movie_list_title);
            movieListRating = (TextView) itemView.findViewById(R.id.movie_list_rating);
            movieListReleaseYear = (TextView) itemView.findViewById(R.id.movie_list_release_year);
            movieListGeneros = (TextView) itemView.findViewById(R.id.movie_list_generos);
            movieListOverview = (TextView) itemView.findViewById(R.id.movie_list_overview);
            movieListMaisInformacoes = (TextView) itemView.findViewById(R.id.movie_list_mais_informacoes);
        }
    }
}
