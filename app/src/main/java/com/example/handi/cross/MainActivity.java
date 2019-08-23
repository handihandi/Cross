package com.example.handi.cross;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.handi.cross.adapter.CustomGridViewActivity;
import com.example.handi.cross.adapter.MainAdapter;
import com.example.handi.cross.api.ApiRequest;
import com.example.handi.cross.api.RetrofitClientInstance;
import com.example.handi.cross.model.ItemsDTO;
import com.example.handi.cross.model.ResponseDTO;
import com.example.handi.cross.model.response.ResponseItemBlog;
import com.example.handi.cross.model.response.ResponseItems;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog pDialog;
    GridView grid;
    CustomGridViewActivity adapter;
    public static List<ResponseItems> listdata = new ArrayList<ResponseItems>();
    public static List<ResponseItemBlog> listdata1 = new ArrayList<ResponseItemBlog>();
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager  mLayoutManager;
    RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(this,R.style.MyAlertDialogStyle);

        adapter = new CustomGridViewActivity(this, (ArrayList<ResponseItems>) listdata);
        grid=(GridView)findViewById(R.id.grid_view_image_text);

        mRecyclerView = (RecyclerView) findViewById(R.id.card_view_recycler_list);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new MainAdapter(getApplicationContext(), (ArrayList<ResponseItemBlog>) listdata1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        LinearLayoutManager llm = new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };;
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        pDialog.setMessage("Loading ....");
        showDialog();
        Loadd();


    }

    private void Loadd(){


        ApiRequest service = RetrofitClientInstance.getRetrofitInstance().create(ApiRequest.class);

        Call<ResponseDTO> getKontak = service.getKontak();

        getKontak.enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                listdata.clear();
                listdata1.clear();
                for (int i = 0; i < response.body().getData().size(); i++) {
                    String aa = response.body().getData().get(i).getSection();
                    if (aa.equals( "products")){
                        for (int j = 0; j < response.body().getData().get(i).getItems().size(); j++) {
                            // insert model products
                            ResponseItems postValue = new ResponseItems();
                            postValue.setProductName(response.body().getData().get(i).getItems().get(j).getProductName());
                            postValue.setProductImage(response.body().getData().get(i).getItems().get(j).getProductImage());
                            postValue.setLinkProduct(response.body().getData().get(i).getItems().get(j).getLink());
                            listdata.add(postValue);
                        }
                    }else{
                        for (int k = 0; k < response.body().getData().get(i).getItems().size(); k++) {
                            // insert model articles
                            ResponseItemBlog postValue1 = new ResponseItemBlog();
                            postValue1.setArticleImage(response.body().getData().get(i).getItems().get(k).getArticleImage());
                            postValue1.setArticleTitle(response.body().getData().get(i).getItems().get(k).getArticleTitle());
                            postValue1.setLinkblog(response.body().getData().get(i).getItems().get(k).getLink());
                            listdata1.add(postValue1);
                        }

                    }


                }

                grid.setAdapter(adapter);
                mRecyclerView.setAdapter(mAdapter);
                hideDialog();
            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
                hideDialog();
                Toast.makeText(getApplicationContext(),
                        "Check your connection", Toast.LENGTH_LONG)
                        .show();

            }
        });

    }


    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
