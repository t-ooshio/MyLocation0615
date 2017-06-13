package jp.sio.testapp.mylocation.Presenter;

import android.app.Activity;

import jp.sio.testapp.mylocation.Activity.SettingActivity;
import jp.sio.testapp.mylocation.Usecase.SettingUsecase;

/**
 * Created by NTT docomo on 2017/05/24.
 * SettingActivityとSettingUsecaseの橋渡し
 */

public class SettingPresenter {
    SettingActivity activity;
    SettingUsecase settingusecase;

    public SettingPresenter(SettingActivity activity){
        this.activity = activity;
        settingusecase = new SettingUsecase(activity);
    }
    public void commitSetting(){
        //TODO :SettingActivityから値取得する処理書く settingusecase.setLocationType(activity.getLocationType());
        settingusecase.setCount(activity.getCount());
        settingusecase.setInterval(activity.getInterval());
        settingusecase.setTimeout(activity.getTimeout());
        //TODO :SettingActivityから値取得する処理書くsettingusecase.setIsCold(activity.getIsCold);
        settingusecase.setDelAssistDataTime(activity.getDelAssistDataTime());
        settingusecase.setSuplEndWaitTIme(activity.getSuplEndWaitTime());
        settingusecase.commitSetting();
    }
}
