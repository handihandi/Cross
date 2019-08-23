package com.example.handi.cross;

import com.example.handi.cross.api.ApiRequest;
import com.example.handi.cross.api.RetrofitClientInstance;
import com.example.handi.cross.model.ResponseDTO;
import com.example.handi.cross.model.response.ResponseItemBlog;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

/**
 * Created by handi.imsi on 22/08/2019.
 */
public class MainActivityTest {
    public MainActivityTest( ) {
    }

    @Mock
    ApiRequest apiRequest;
    Gson gson;
    private RetrofitClientInstance retrofitClientInstance;


    @Test
    public void onCreate() throws Exception {

        ApiRequest mockedApiInterface = Mockito.mock(ApiRequest.class);
        final Call<ResponseDTO> mockedCall = Mockito.mock(Call.class);

        Mockito.when(mockedApiInterface.getKontak()).thenReturn(mockedCall);

        Mockito.doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Callback<ResponseDTO> callback = invocation.getArgument(1);
                //Callback<ResponseDTO> callback = invocation.getArgumentAt(0, Callback.class);
                callback.onResponse(mockedCall, Response.success(new ResponseDTO()));
                // or callback.onResponse(mockedCall, Response.error(404. ...);
                // or callback.onFailure(mockedCall, new IOException());

                return null;
            }
        }).when(mockedCall).enqueue(any(Callback.class));


    }



    }
