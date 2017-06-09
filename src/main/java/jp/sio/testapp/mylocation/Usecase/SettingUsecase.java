package jp.sio.testapp.mylocation.Usecase;

import android.content.Context;

import jp.sio.testapp.mylocation.Repository.SettingPref;

/**
 * Created by NTT docomo on 2017/05/24.
 * Settingの値を設定したり取得する
 * 設定の保存方法はここで吸収する
 * 今回はSharedPreferenceを使用してる
 */

public class SettingUsecase {
    private SettingPref settingPref;
    private Context context;

    public SettingUsecase(Context context){
        this.context = context;
        settingPref = new SettingPref(context);
        settingPref.createPref();
    }


    /**
     * 設定を初期値にする
     * 初期値はまだ決めてないので空
     */
    public void setDefaultSetting(){

    }
    //とりあえずテスト用の仮数値
    public int getCount(){
        return 5;
    }

    public double getTimeout(){
        return 10.0;
    }

    public double getInterval(){
        return 10.0;
    }
}
