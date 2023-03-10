package com.example.lostandfound.DatabaseAndTables;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "LostAndFound";

    private static final String TABLE_USER = "user";
    private static final String UID = "uid";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String PASS = "password";


    private static final String TABLE_ITEM = "item";
    private static final String IID = "item_id";
    private static final String TYPE = "type";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String CATEGORY = "category";
    private static final String DATE = "date";
    private static final String LOCATION = "location";
    private static final String IMAGE = "image";




    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTableUser = "CREATE TABLE " + TABLE_USER + "("+ UID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + NAME + " TEXT NOT NULL,"+ EMAIL + " TEXT NOT NULL," + PHONE + " TEXT NOT NULL," + PASS + " TEXT NOT NULL" + ")";
        String sqlTableItem = "CREATE TABLE " + TABLE_ITEM + "("+ IID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + TYPE + " TEXT NOT NULL," + TITLE + " TEXT NOT NULL," + DESCRIPTION + " TEXT NOT NULL," + CATEGORY + " TEXT NOT NULL," + DATE + " TEXT NOT NULL," + LOCATION + " TEXT NOT NULL," + IMAGE + " TEXT NOT NULL" +")";
        db.execSQL(sqlTableUser);
        db.execSQL(sqlTableItem);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM);

        // Create tables again
        onCreate(db);
    }


    // Add User
    void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(UID,user.getId());  // User ID
        cv.put(NAME, user.getName());
        cv.put(EMAIL, user.getEmail());
        cv.put(PHONE, user.getPhone());
        cv.put(PASS, user.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, cv);
        db.close();
    }

    // Update User
    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, user.getName());
        values.put(EMAIL, user.getEmail());
        values.put(PHONE, user.getPhone());
        values.put(PASS, user.getPassword());

        // Update
        return db.update(TABLE_USER, values, UID + " = ?",
                new String[]{String.valueOf(user.getId())});
    }

    // Delete User By ID
    public void deleteUserByID(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, UID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }

    // Get User By ID
    User getUserById(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, new String[]{UID, NAME, EMAIL, PHONE, PASS}, UID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        int uid = cursor.getInt(0);
        String name = cursor.getString(1);
        String email = cursor.getString(2);
        String phone = cursor.getString(3);
        String pass = cursor.getString(4);

        User user = new User(uid, name, email, phone, pass);
        cursor.close();
        db.close();

        return user;

    }

    // Add Item
    void addItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(IID,item.getId());  // Item ID
        cv.put(TYPE, item.getType());
        cv.put(TITLE, item.getTitle());
        cv.put(DESCRIPTION, item.getDescription());
        cv.put(CATEGORY, item.getCategory());
        cv.put(DATE, item.getDate());
        cv.put(LOCATION, item.getLocation());
        cv.put(IMAGE, item.getImage());

        // Inserting Row
        db.insert(TABLE_ITEM, null, cv);
        db.close();
    }

    // Update Item
    public int updateItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TYPE, item.getType());
        values.put(TITLE, item.getTitle());
        values.put(DESCRIPTION, item.getDescription());
        values.put(CATEGORY, item.getCategory());
        values.put(DATE, item.getDate());
        values.put(LOCATION, item.getLocation());
        values.put(IMAGE, item.getImage());

        // Update
        return db.update(TABLE_ITEM, values, IID + " = ?",
                new String[]{String.valueOf(item.getId())});
    }

    // Delete Item By ID
    public void deleteItemByID(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEM, IID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }

    // Get Item By ID
    Item getItemById(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ITEM, new String[]{IID, TYPE, TITLE, DESCRIPTION, CATEGORY, DATE, LOCATION, IMAGE}, IID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        int iid = cursor.getInt(0);
        String type = cursor.getString(1);
        String title = cursor.getString(2);
        String description = cursor.getString(3);
        String category = cursor.getString(4);
        String date = cursor.getString(5);
        String location = cursor.getString(6);
        String image = cursor.getString(7);

        Item item = new Item(iid, type, title, description, category, date, location, image);
        cursor.close();
        db.close();

        return item;

    }






}
