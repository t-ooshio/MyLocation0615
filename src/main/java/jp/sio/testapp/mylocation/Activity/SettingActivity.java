package jp.sio.testapp.mylocation.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import jp.sio.testapp.mylocation.Presenter.SettingPresenter;
import jp.sio.testapp.mylocation.R;

/**
 * Settingの画面
 * 処理はSettingUsecaseへ渡す
 */
public class SettingActivity extends AppCompatActivity {

    SettingPresenter settingPresenter;

    private Button buttonSet;
    private EditText editTextCount;
    private EditText editTextTimeout;
    private EditText editTextInterval;
    private EditText editTextSuplEndWaitTime;
    private EditText editTextDelAssistDataTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        settingPresenter = new SettingPresenter(this);

        buttonSet = (Button)findViewById(R.id.ButtunSet);
        editTextCount = (EditText)findViewById(R.id.editTextCount);
        editTextTimeout = (EditText)findViewById(R.id.editTextTimeout);
        editTextInterval = (EditText)findViewById(R.id.editTextInterval);
        editTextSuplEndWaitTime = (EditText)findViewById(R.id.editTextSuplEndWaitTime);
        editTextDelAssistDataTime = (EditText)findViewById(R.id.editTextDelAssistDataTime);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    public void onButtonSet(){

    }
}
