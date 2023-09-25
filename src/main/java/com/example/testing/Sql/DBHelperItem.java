package com.example.testing.Sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelperItem extends SQLiteOpenHelper {

    private static DBHelperItem dbHelper;

    public static SQLiteDatabase db;

    public DBHelperItem(Context context ) {
        super(context,"ItemData",null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table ItemDetails(itemID Integer primary key autoincrement not null,code TEXT,des TEXT,quan TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists ItemDetails");
    }
    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }
    public Boolean insetItemData(String code, String des, String quan){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("code",code);
        contentValues.put("des",des);
        contentValues.put("quan",quan);
        long result= DB.insert("ItemDetails",null,contentValues);
        if (result == -1){
            return false;
        }else {
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Itemdetails ",null);
        return cursor;
    }

    public ArrayList<ItemModel> readItem() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursor = db.rawQuery("Select * from Itemdetails ", null);

        // on below line we are creating a new array list.
        ArrayList<ItemModel> itemModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                itemModalArrayList.add(new ItemModel(cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)));
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursor.close();
        return itemModalArrayList;
    }

    public void  updateItem(String itemID, String code, String des, String quan)
    {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("code", code);
        updatedValues.put("des", des);
        updatedValues.put("quan", quan);
        String where="itemID = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        db.update("Itemdetails",updatedValues, where, new String[]{itemID});
        db.close();

    }


}