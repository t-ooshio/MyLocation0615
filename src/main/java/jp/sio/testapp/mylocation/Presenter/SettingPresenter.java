package jp.sio.testapp.mylocation.Presenter;

import jp.sio.testapp.mylocation.Activity.SettingActivity;
import jp.sio.testapp.mylocation.Usecase.SettingUsecase;

/**
 * Created by NTT docomo on 2017/05/24.
 * SettingActivityとSettingUsecaseの橋渡し
 */

public class SettingPresenter {
    SettingActivity activity;
    SettingUsecase usecase;

    public SettingPresenter(SettingActivity activity){
        this.activity = activity;
        usecase = new SettingUsecase(this.activity.getApplicationContext());
    }

    public void setSetting(){

    }
}
