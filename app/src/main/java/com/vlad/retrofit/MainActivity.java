package com.vlad.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
 TextView cout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cout=(TextView)findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://rihard.ms-idi.eu")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MessageApi messagesApi = retrofit.create(MessageApi.class);

    //-----------------------------------------------POST test---------------------------------
        /*
        RegistrationBody body = new RegistrationBody();
        body.name = "myName";
        body.email = "myEmail@email.com";
        body.home_page="http://myPage.com";
        body.message="myMessage";
        body.file=null;
        //messagesApi.registerUser(body);

        Call<RegistrationResponse> call = messagesApi.registerUser(body);
        call.enqueue(new Callback <RegistrationResponse() {
            @Override
            public void onResponse(Response<RegistrationResponse> response) {
                if (response.isSuccess()) {
                    // tasks available
                } else {
                    // error response, no access to resource?
                }
            }
        } )
        */
      //----------------------------------------------------------------------------------------


/*
        Call<List<Message>> messages = messagesApi.messages();
        messages.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                // log("response " + response.body().size());
                for (int x = 0; x < response.body().size(); x++) {
                    cout.setText(cout.getText() +
                            //response.body().get(2).getId()+ " "+
                            response.body().get(x).getName() + " " +
                            response.body().get(x).getEmail() + " " +
                            response.body().get(x).getHomePage() + " " +
                            response.body().get(x).getIpAddress() + " " +
                            response.body().get(x).getBrowser() + " " +
                            response.body().get(x).getMessage() + " " +
                            response.body().get(x).getFile() + " " +
                            response.body().get(x).getCreatedAt() + "\n\n "
                    );
                    // Log.d(TAG, "Response.body().size()=" + response.body().size());
                }
            }
            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {

            }
        });

*/

//-------------------------------RXJava-------------------------------------
        messagesApi.messages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Message>>() {
                    @Override
                    public void onSuccess(@NonNull List<Message> messages) {
                        for (int x = 0; x < messages.size(); x++) {
                            cout.setText(cout.getText() +
                                    messages.get(x).getName() + " " +
                                    messages.get(x).getEmail() + " " +
                                    messages.get(x).getHomePage() + " " +
                                    messages.get(x).getIpAddress() + " " +
                                    messages.get(x).getBrowser() + " " +
                                    messages.get(x).getMessage() + " " +
                                    messages.get(x).getFile() + " " +
                                    messages.get(x).getCreatedAt() + "\n\n ");
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        cout.setText("onError " + e);
                    }
                });
//------------------------------------------------------------------------------
    }





}
