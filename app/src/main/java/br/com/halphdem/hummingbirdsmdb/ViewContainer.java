package br.com.halphdem.hummingbirdsmdb;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.halphdem.hummingbirdsmdb.di.movierepository.DaggerMovieRepositoryComponent;
import br.com.halphdem.hummingbirdsmdb.di.movierepository.MovieRepositoryComponent;
import br.com.halphdem.hummingbirdsmdb.di.movierepository.MovieRepositoryModule;
import br.com.halphdem.hummingbirdsmdb.movielist.MovieListFragment;

public class ViewContainer extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    private static MovieRepositoryComponent movieRepositoryComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_container);

        movieRepositoryComponent = DaggerMovieRepositoryComponent.builder()
                .movieRepositoryModule(new MovieRepositoryModule())
                .retrofitComponent(HummingBirdsMdbApplication.getRetrofitComponent()).build();

        if(getSupportFragmentManager().findFragmentByTag("movie_list") == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.view_container, new MovieListFragment(), "movie_list")
                    .commit();
        }
    }

    public static MovieRepositoryComponent getMovieRepositoryComponent() {
        return movieRepositoryComponent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_search);



        SearchManager searchManager = (SearchManager) this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(this.getComponentName()));

        searchView.setOnCloseListener(this);

        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Toast.makeText(this, "Cricou no search", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Toast.makeText(this, "Texto mudou para: " + newText, Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public boolean onClose() {
        Toast.makeText(ViewContainer.this, "Fechou!", Toast.LENGTH_LONG).show();
        return false;
    }
}
