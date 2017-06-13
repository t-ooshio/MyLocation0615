package jp.sio.testapp.mylocation.Repository;

import android.content.Context;
import android.content.SharedPreferences;

import jp.sio.testapp.mylocation.L;
import jp.sio.testapp.mylocation.R;

import static android.content.Context.*;

/**
 * Created by NTT docomo on 2017/05/23.
 */

public class SettingPref {
    private SharedPreferences settingPref;
    private SharedPreferences.Editor editor;
    private Context context;

    //Default設定
    private final int defCount = 0;
    private final long defInterval = 75;
    private final long defTimeout = 60;
    private final boolean defIsCold = true;
    private final int defSuplEndWaitTime = 1;
    private final int defDelAssistDataTime = 3;
    private final String defLocationType = "LocationUeb";
    //SharedPreference名
    private String PREFNAME = "MyLocationSetting";

    /**
     * SettingをShearedPreferencesに保存・読み込みを行う
     */
    public SettingPref(Context context){
        this.context = context;
    }
    public void createPref(){
        settingPref = context.getSharedPreferences(PREFNAME, MODE_PRIVATE);
        editor = settingPref.edit();
    }

    public void setLocationType(String location){
        editor.putString(context.getString(R.string.settingLocationType),location);
        commitSetting();
    }
    public void setCount(int count){
        editor.putInt(context.getString(R.string.settingCount),count);
        commitSetting();
    }
    public void setInterval(long interval){
        editor.putLong(context.getString(R.string.settingInterval),interval);
        commitSetting();
    }
    public void setTimeout(long timeout){
        editor.putLong(context.getString(R.string.settingTimeout),timeout);
        commitSetting();
    }
    public void setIsCold(boolean isCold){
        editor.putBoolean(context.getString(R.string.settingIsCold),isCold);
        commitSetting();
    }
    public void setSuplEndWaitTime(int suplendwaittime){
        editor.putInt(context.getString(R.string.settingSuplEndWaitTime),suplendwaittime);
        commitSetting();
    }
    public void setDelAssistDataTime(int delAssistDataTime){
        editor.putInt(context.getString(R.string.settingDelAssistdataTime),delAssistDataTime);
        commitSetting();
    }
    public String getLocationType(){
        return settingPref.getString(context.getString(R.string.settingLocationType),defLocationType);
    }
    public int getCount(){
        return settingPref.getInt(context.getString(R.string.settingCount),defCount);
    }
    public long getInterval(){
        return settingPref.getLong(context.getString(R.string.settingInterval),defInterval);
    }
    public long getTimeout(){
        return settingPref.getLong(context.getString(R.string.settingTimeout),defTimeout);
    }
    public boolean getIsCold(){
        return settingPref.getBoolean(context.getString(R.string.settingIsCold),defIsCold);
    }
    public int getSuplEndWaitTime(){
        return settingPref.getInt(context.getString(R.string.settingSuplEndWaitTime),defSuplEndWaitTime);
    }
    public int getDelAssistDataTime(){
        return settingPref.getInt(context.getString(R.string.settingDelAssistdataTime),defDelAssistDataTime);
    }

    public void setDefaultSetting(){
        setLocationType(defLocationType);
        setCount(defCount);
        setInterval(defInterval);
        setTimeout(defTimeout);
        setIsCold(defIsCold);
        setSuplEndWaitTime(defSuplEndWaitTime);
        setDelAssistDataTime(defDelAssistDataTime);
        commitSetting();
    }

    public void commitSetting(){
        editor.apply();
        editor.commit();
        L.d("commitSetting");
    }
}