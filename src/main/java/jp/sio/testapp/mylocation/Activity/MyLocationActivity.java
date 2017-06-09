package jp.sio.testapp.mylocation.Activity;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.widget.Toast;

import jp.sio.testapp.mylocation.Presenter.MyLocationPresenter;
import jp.sio.testapp.mylocation.R;


public class MyLocationActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonStop;
    private Button buttonSetting;
    private TextView tvResult;
    private static ProgressDialog progressDialog;

    private Context context = this;
    private MyLocationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MyLocationPresenter(this);

        buttonStart = (Button)findViewById(R.id.buttonStart);
        buttonStop = (Button)findViewById(R.id.buttonStop);
        buttonSetting = (Button)findViewById(R.id.buttonSetting);
        tvResult = (TextView)findViewById(R.id.textViewResult);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offBtnStart();
                onBtnStop();
                offBtnSetting();
                pushBtnStart();
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnStart();
                offBtnStop();
                onBtnSetting();
                pushBtnStop();
            }
        });
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushBtnSetting();
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        presenter.checkPermission();
    }
    public void showTextView(String str){
        tvResult.setText(str);
    }

    public void pushBtnStart(){
        showTextView("start");
        presenter.locationStart();

    }
    public void pushBtnStop(){
        showTextView("stop");
        presenter.locationStop();
    }
    public void pushBtnSetting(){
        showTextView("setting");
        presenter.settingStart();
    }


    public void onBtnStart(){
        buttonStart.setEnabled(true);
    }
    public void offBtnStart(){
        buttonStart.setEnabled(false);
    }

    public void onBtnStop(){
        buttonStop.setEnabled(true);
    }
    public void offBtnStop(){
        buttonStop.setEnabled(false);
    }

    public void onBtnSetting(){
        buttonSetting.setEnabled(true);
    }
    public void offBtnSetting(){
        buttonSetting.setEnabled(false);
    }

    public void startProgressDialog(String message){
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    public void stopProgressDialog(){
        if(progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
    public void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}