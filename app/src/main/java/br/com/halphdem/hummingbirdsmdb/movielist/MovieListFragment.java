package br.com.halphdem.hummingbirdsmdb.movielist;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import br.com.halphdem.hummingbirdsmdb.R;
import br.com.halphdem.hummingbirdsmdb.ViewContainer;
import br.com.halphdem.hummingbirdsmdb.di.movielist.DaggerMovieListComponent;
import br.com.halphdem.hummingbirdsmdb.di.movielist.MovieListModule;
import br.com.halphdem.hummingbirdsmdb.infra.MovieSearchPagination;
import br.com.halphdem.hummingbirdsmdb.movie.data.Movie;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteListenersContract;
import br.com.halphdem.hummingbirdsmdb.movieoverview.MovieOverviewFragment;

public class MovieListFragment extends Fragment implements MovieListContract.View, SwipeRefreshLayout.OnRefreshListener, MovieRemoteListenersContract.MovieDiscoverListener, ItemClickCallback {

    @Inject
    MovieListContract.Presenter presenter;

    private List<Movie> movies;

    private RecyclerView movieList;

    private Context context;

    private SwipeRefreshLayout swipeRefreshMovieList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_list, container, false);

        DaggerMovieListComponent.builder()
                .movieListModule(new MovieListModule())
                .movieRepositoryComponent(ViewContainer.getMovieRepositoryComponent()).build().inject(this);

        movieList = (RecyclerView) view.findViewById(R.id.movie_list);

        swipeRefreshMovieList = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_list_movies);
        swipeRefreshMovieList.setOnRefreshListener(this);

        return view;
    }

    @Override
    public void openMovieOverView(String id) {
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        Fragment newFragment = new MovieOverviewFragment();
        newFragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.frag_fade_in, R.anim.frag_fade_out, R.anim.frag_fade_in, R.anim.frag_fade_out);
        transaction.replace(R.id.view_container, newFragment);
        transaction.addToBackStack(getString(R.string.list_to_overview_fragment));
        transaction.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        movies = new ArrayList<>();
        presenter.listMovies(this);
    }

    @Override
    public void onDiscover(MovieSearchPagination pagination) {
        movieList.setLayoutManager(new LinearLayoutManager(getContext()));
        Collections.reverse(movies);
        movies.addAll(pagination.getResults());
        Collections.reverse(movies);
        movieList.setAdapter(new MovieListAdapter(movies, presenter, context, this));
        movieList.getAdapter().notifyDataSetChanged();
        swipeRefreshMovieList.setRefreshing(false);
        presenter.setPagination(pagination);

    }

    @Override
    public void onDiscoverError(Throwable throwable) {
        Toast.makeText(getActivity(), getString(R.string.erro_lista_retorno_lista), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(String id) {
        openMovieOverView(id);
    }

    @Override
    public void onRefresh() {
        presenter.listMovies(this);
        swipeRefreshMovieList.setRefreshing(true);
    }
}
