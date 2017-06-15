package jp.sio.testapp.mylocation.Repository;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jp.sio.testapp.mylocation.L;

/**
 * Logファイルに関するクラス
 * Created by NTT docomo on 2017/05/22.
 */

public class LocationLog {
    //-------Logの項目------------
    private int settingCount;
    private long settingInterval;
    private long settingTimeout;
    private boolean settingIsCold;
    private int settingSuplEndWaitTime;
    private int settingDelAssistdatatime;

    private Calendar calendar = Calendar.getInstance();
    private long createLogTime;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_hhmmss");

    private File file;
    private String fileName;
    private String filePath;

    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    InputStreamReader inputStreamReader;
    OutputStreamWriter outputStreamWriter;
    BufferedReader reader;
    BufferedWriter writer;

    /**
     * Logファイルを作成
     */
    public void makeLogFile(String settingHeader){
        //TODO: ログファイルの生成、csv形式
        if(isExternalStrageWriteable()){
            createLogTime = System.currentTimeMillis();
            fileName = simpleDateFormat.format(createLogTime) + ".txt";
            filePath = Environment.getExternalStorageDirectory().getPath() + "/"+ "MyLocation/" + fileName;
            L.d("LogFilePath:" + filePath);

            file = new File(filePath);
            file.getParentFile().mkdir();
        }else{
            L.d("ExternalStrage書き込み不可");
        }
        //TODO: headerに設定の項目を出力
        try{
            fileOutputStream = new FileOutputStream(file,true);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
            writer = new BufferedWriter(outputStreamWriter);
            writer.write(settingHeader);
            writer.newLine();
        } catch (FileNotFoundException e) {
            L.d(e.getMessage());
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            L.d("UTF-8使えない");
            e.printStackTrace();
        } catch (IOException e) {
            L.d("write失敗");
            e.printStackTrace();
        }
    }

    /**
     * Logファイルを閉じる(Readerとかを閉じる処理を想定)
     */
    public void endLogFile(){
        try {
            fileOutputStream.close();
            outputStreamWriter.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Logファイルへの書き込み
     */
    public void writeLog(String log){
        //TODO:日付、時間、測位結果を出力
        try {
            writer.append(log);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //externalStrageのReadとWriteが可能かチェック
    private boolean isExternalStrageWriteable(){
        boolean result = false;
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            result = true;
        }
        return result;
    }
}
