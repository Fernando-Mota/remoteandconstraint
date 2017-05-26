package br.com.halphdem.hummingbirdsmdb.movie.data.remote;

import java.util.List;
import java.util.Map;

import br.com.halphdem.hummingbirdsmdb.BuildConfig;
import br.com.halphdem.hummingbirdsmdb.infra.MovieSearchPagination;
import br.com.halphdem.hummingbirdsmdb.movie.data.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MovieRemoteAPI {

    String apiKey = "3f5390735332d39e5016250f922e1421";

    @GET(BuildConfig.MOVIE_DISCOVER)
    Call<MovieSearchPagination> discover(@QueryMap Map<String, String> queryMap);

    @GET(BuildConfig.MOVIE_READ)
    Call<Movie> findById(@Path("id") int id, @QueryMap Map<String, String> queryMap);

    @GET(BuildConfig.MOVIE_SEARCH)
    Call<MovieSearchPagination> search(@Path("nextPage") int nextPage, @Path("apiKey") String apiKey, @Path("searchQuery") String searchQuery);

}