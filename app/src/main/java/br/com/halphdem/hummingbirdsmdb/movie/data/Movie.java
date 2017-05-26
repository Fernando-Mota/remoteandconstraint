package br.com.halphdem.hummingbirdsmdb.movie.data;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by fernando on 13/05/17.
 */

public class Movie {


    /**
     * adult : false
     * backdrop_path : /6aUWe0GSl69wMTSWWexsorMIvwU.jpg
     * belongs_to_collection : null
     * budget : 160000000
     * genres : [{"id":14,"name":"Fantasy"},{"id":10749,"name":"Romance"}]
     * homepage : http://movies.disney.com/beauty-and-the-beast-2017
     * id : 321612
     * imdb_id : tt2771200
     * original_language : en
     * original_title : Beauty and the Beast
     * overview : A live-action adaptation of Disney's version of the classic 'Beauty and the Beast' tale of a cursed prince and a beautiful young woman who helps him break the spell.
     * popularity : 94.010954
     * poster_path : /tnmL0g604PDRJwGJ5fsUSYKFo9.jpg
     * production_companies : [{"name":"Walt Disney Pictures","id":2},{"name":"Mandeville Films","id":10227}]
     * production_countries : [{"iso_3166_1":"GB","name":"United Kingdom"},{"iso_3166_1":"US","name":"United States of America"}]
     * release_date : 2017-03-16
     * revenue : 1186864733
     * runtime : 129
     * spoken_languages : [{"iso_639_1":"en","name":"English"}]
     * status : Released
     * tagline : Be our guest.
     * title : Beauty and the Beast
     * video : false
     * vote_average : 6.8
     * vote_count : 2377
     */

    private boolean adult;

    @SerializedName("backdrop_path")
    private String backdropPath;

    private int budget;

    private String homepage;

    private int id;

    private String name;

    @SerializedName("imdb_id")
    private String imdbId;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    private String overview;

    private double popularity;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("release_date")
    private Date releaseDate;

    private int revenue;

    private int runtime;

    private String status;

    private String tagline;

    private String title;

    private boolean video;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("vote_count")
    private int vote_count;

    private List<Genres> genres;

    private List<ProductionCompanies> production_companies;

    private List<ProductionCountries> production_countries;

    private List<SpokenLanguages> spoken_languages;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public List<ProductionCompanies> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<ProductionCompanies> production_companies) {
        this.production_companies = production_companies;
    }

    public List<ProductionCountries> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<ProductionCountries> production_countries) {
        this.production_countries = production_countries;
    }

    public List<SpokenLanguages> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<SpokenLanguages> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
