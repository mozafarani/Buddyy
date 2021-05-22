package com.example.buddyy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.telephony.mbms.StreamingServiceInfo;

import androidx.annotation.Nullable;

public class DatabaseOperations extends SQLiteOpenHelper {

    public static final String USERS_TABLE = "USERS_TABLE";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";

    public DatabaseOperations(@Nullable Context context) {
        super(context, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + USERS_TABLE + " (" + COLUMN_NAME + " TEXT PRIMARY KEY, " + COLUMN_EMAIL + " TEXT, " + COLUMN_PASSWORD + " TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUser(UserModel userModel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME, userModel.getName());
        contentValues.put(COLUMN_EMAIL, userModel.getEmail());
        contentValues.put(COLUMN_PASSWORD, userModel.getPassword());

        long insert = db.insert(USERS_TABLE, null, contentValues);

        return insert != -1;
    }

    public boolean userExists(UserModel model){
        String s = "SELECT "+COLUMN_EMAIL+", "+COLUMN_PASSWORD+" FROM " + USERS_TABLE+";";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(s, null);

        int pos1 = cursor.getColumnIndex("email");
        int pos2 = cursor.getColumnIndex("password");

            while(cursor.moveToNext()) {

                System.out.println(model.getEmail().equals(cursor.getString(pos1)) +" " +model.getEmail() + " " + cursor.getString(pos1) + " PASSWORDS " + model.getPassword().equals(cursor.getColumnName(pos2)) + " " + model.getPassword() + " " + cursor.getString(pos2));


                if(model.getEmail().equals(cursor.getString(pos1)) && model.getPassword().equals(cursor.getString(pos2))){
                    System.out.println("Hey");
                    cursor.close();
                    System.out.println("Hey");
                    return true;
                }

            }
            cursor.close();
            return false;
    }
}
