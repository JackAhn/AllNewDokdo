package kr.hs.dgsw.allnewdokdo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

public class DokdoDBHelper extends SQLiteOpenHelper {
    public DokdoDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table dokdo ( sequenceNumber integer primary key autoincrement, kind text, imgno integer, content text )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table dokdo";
        db.execSQL(sql);
        onCreate(db);
    }

    public long insert(DokdoBean dokdo){
        if(checkData(dokdo)){
            SQLiteDatabase db = getWritableDatabase();
            ContentValues value = new ContentValues();
            Log.i("dokdoabc", dokdo.getImgNo()+"");
            value.put("kind", dokdo.getKind());
            value.put("imgno", dokdo.getImgNo());
            value.put("content", dokdo.getContent());
            return db.insert("dokdo", null, value);
        }
        return 0;
    }

    public ArrayList<DokdoBean> getData(String kind){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from dokdo where kind='"+kind+"'";
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<DokdoBean> result = new ArrayList<>();
        while(cursor.moveToNext()){
            DokdoBean dokdoBean = new DokdoBean();
            dokdoBean.setSequenceNumber(cursor.getInt(cursor.getColumnIndex("sequenceNumber")));
            dokdoBean.setKind(cursor.getString(cursor.getColumnIndex("kind")));
            dokdoBean.setImgNo(cursor.getInt(cursor.getColumnIndex("imgno")));
            dokdoBean.setContent(cursor.getString(cursor.getColumnIndex("content")));
            result.add(dokdoBean);
        }
        return result;
    }

    public String natureContent(int imgno){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from dokdo where imgno='"+imgno+"'";
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToNext()){
            return cursor.getString(cursor.getColumnIndex("content"));
        }
        return null;
    }



    private boolean checkData(DokdoBean dokdo){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from dokdo where content='"+dokdo.getContent()+"'";
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToNext()){
            return false;
        }
        return true;
    }
}
