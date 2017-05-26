package br.com.halphdem.hummingbirdsmdb.infra;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.com.halphdem.hummingbirdsmdb.movie.data.Movie;

/**
 * Created by fernando on 14/05/17.
 */

public class MovieSearchPagination {

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("total_results")
    private int totalResults;

    private int page;

    private List<Movie> results;

    public MovieSearchPagination() {
    }

    public MovieSearchPagination(int totalPages, int totalResults, int page) {
        this.totalPages = totalPages;
        this.totalResults = totalResults;
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
