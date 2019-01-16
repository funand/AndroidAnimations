package com.example.prince.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.leakcanary.LeakCanary;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Animation fadeInAnime;
    RecyclerView rv;
    DataAdapter dataAdapter;
    CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this.getApplication());
        setContentView(R.layout.activity_main);
        fadeInAnime = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);

        mCompositeDisposable = new CompositeDisposable();
        initRecyclerView();
        loadJSON();
        rv.startAnimation(fadeInAnime);
    }

    private void initRecyclerView() {
        rv = (RecyclerView) findViewById(R.id.images_recycle);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
    }

    private void loadJSON() {
        JSONInterface jsonInterface = new Retrofit.Builder()
                .baseUrl(JSONInterface.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(JSONInterface.class);

        mCompositeDisposable.add(jsonInterface.getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));
    }

    private void handleResponse(DataClass dataClass) {
        dataAdapter = new DataAdapter(dataClass.getPhotos());
        rv.setAdapter(dataAdapter);
    }

    private void handleError(Throwable throwable) {
        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
    }


}
