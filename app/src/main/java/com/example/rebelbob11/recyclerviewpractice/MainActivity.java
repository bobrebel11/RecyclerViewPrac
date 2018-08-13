package com.example.rebelbob11.recyclerviewpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.rebelbob11.recyclerviewpractice.Adapter.MarvelAdapter;
import com.example.rebelbob11.recyclerviewpractice.POJO.Hero;
import com.example.rebelbob11.recyclerviewpractice.WebServices.ApiClient;
import com.example.rebelbob11.recyclerviewpractice.WebServices.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MarvelAdapter adapter;

    private List<Hero> heros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<Hero>> call = apiInterface.getHeros();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                heros = response.body();

                adapter = new MarvelAdapter(heros,getApplicationContext());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });










    }
}
