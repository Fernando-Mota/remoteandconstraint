package br.com.halphdem.hummingbirdsmdb.movieoverview;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import br.com.halphdem.hummingbirdsmdb.R;
import br.com.halphdem.hummingbirdsmdb.ViewContainer;
import br.com.halphdem.hummingbirdsmdb.di.movieoverview.DaggerMovieOverviewContponent;
import br.com.halphdem.hummingbirdsmdb.di.movieoverview.MovieOverviewModule;
import br.com.halphdem.hummingbirdsmdb.movie.data.Movie;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteListenersContract;

public class MovieOverviewFragment extends Fragment implements MovieRemoteListenersContract.MovieFindByIdListener, MovieOverviewContract.View {

    @Inject
    MovieOverviewContract.Presenter presenter;

    private Movie movie;

    private ImageView backgroundTop;

    private ImageView movieDetailPoster;

    private TextView movieDetailTitle;

    private TextView movieDetailYear;

    private TextView movieDetailOverview;

    private TextView movieDetailPercentualRating;

    private TextView movieDetailProductionCompanies;

    private TextView movieDetailOriginalTitle;

    private TextView movieDetailGenres;

    private TextView movieDetailReleaseDate;

    private TextView movieDetailRevenue;

    private TextView movieDetailBudget;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_overview, container, false);

        DaggerMovieOverviewContponent.builder().movieOverviewModule(new MovieOverviewModule())
                .movieRepositoryComponent(ViewContainer.getMovieRepositoryComponent()).build().inject(this);

        backgroundTop = (ImageView) view.findViewById(R.id.background_top);
        backgroundTop.setColorFilter(Color.DKGRAY, PorterDuff.Mode.MULTIPLY);
        movieDetailPoster = (ImageView) view.findViewById(R.id.movie_detail_poster);
        movieDetailTitle = (TextView) view.findViewById(R.id.movie_detail_title);
        movieDetailYear = (TextView) view.findViewById(R.id.movie_detail_year);
        movieDetailOverview = (TextView) view.findViewById(R.id.movie_detail_overview);
        movieDetailPercentualRating = (TextView) view.findViewById(R.id.movie_detail_percentual_rating);
        movieDetailProductionCompanies = (TextView) view.findViewById(R.id.movie_detail_production_companies);
        movieDetailOriginalTitle = (TextView) view.findViewById(R.id.movie_detail_original_title);
        movieDetailGenres = (TextView) view.findViewById(R.id.movie_detail_genres);
        movieDetailReleaseDate = (TextView) view.findViewById(R.id.movie_detail_release_date);
        movieDetailRevenue = (TextView) view.findViewById(R.id.movie_detail_revenue);
        movieDetailBudget = (TextView) view.findViewById(R.id.movie_detail_budget);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        presenter.findById(bundle.getString("id"), this);
    }

    @Override
    public void onFindById(Movie movie) {
        this.movie = movie;

        if (movie == null) {
            Toast.makeText(getContext(), getString(R.string.erro_overview_sem_sinopse), Toast.LENGTH_SHORT).show();
            return;
        }

        movieDetailTitle.setText(movie.getTitle());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(movie.getReleaseDate());
        movieDetailYear.setText(String.valueOf(calendar.get(Calendar.YEAR)));
        movieDetailOverview.setText(movie.getOverview());

        double rating = movie.getVoteAverage()*10;
        if (rating >= 70) {
            movieDetailPercentualRating.setTextColor(Color.GREEN);
        } else if (rating >= 51 && rating <= 69) {
            movieDetailPercentualRating.setTextColor(Color.YELLOW);
        } else if (rating <= 50) {
            movieDetailPercentualRating.setTextColor(Color.RED);
        }
        movieDetailPercentualRating.setText(String.valueOf(rating));
        movieDetailProductionCompanies.setText("No companies available yet");
        movieDetailOriginalTitle.setText(movie.getOriginalTitle());
        movieDetailGenres.setText("No genres available yet");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        movieDetailReleaseDate.setText(simpleDateFormat.format(movie.getReleaseDate()));
        movieDetailRevenue.setText(String.valueOf(movie.getRevenue()));
        movieDetailBudget.setText(String.valueOf(movie.getBudget()));

        presenter.loadImage(getContext(), movie.getBackdropPath(), backgroundTop);
        presenter.loadImage(getContext(), movie.getPosterPath(), movieDetailPoster);
    }

    @Override
    public void onFindByIdError(Throwable throwable) {
        Toast.makeText(getContext(), getString(R.string.erro_overview_carregar_filme), Toast.LENGTH_LONG).show();
    }
}
