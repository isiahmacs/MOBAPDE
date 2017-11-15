package projects.mp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by isiah on 13/11/2017.
 */

public class AccountHelper extends SQLiteOpenHelper {

    public static final String SCHEMA = "MOBAPDE_MP";
    public static int VERSION = 3;

    public AccountHelper(Context context) {
        super(context, SCHEMA, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // called once when SCHEMA has not been created.
        String accountTable = "CREATE TABLE " + Account.TABLE_NAME + " ( "
                + Account.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Account.COLUMN_USERNAME+ " STRING, "
                + Account.COLUMN_PASSWORD + " STRING );";
        db.execSQL(accountTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method will be called when the version is incremented

        db.execSQL("DROP TABLE IF EXISTS " + Account.TABLE_NAME);

        onCreate(db);
    }

    public void insertAccount(Account a){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Account.COLUMN_USERNAME, a.getUsername());
        contentValues.put(Account.COLUMN_PASSWORD, a.getPassword());
        db.insert(Account.TABLE_NAME, null, contentValues);
        db.close();
    }

    public Account queryAccount(int id){
        SQLiteDatabase db = getReadableDatabase();
        Account account = new Account();
        Cursor cursor = db.query(Account.TABLE_NAME, null,
                Account.COLUMN_ID + " =? ", new String[]{String.valueOf(id)},
                null, null, null);
        if(cursor.moveToFirst()){
            account.setAccountID(cursor.getInt(cursor.getColumnIndex(Account.COLUMN_ID)));
            account.setUsername(cursor.getString(cursor.getColumnIndex(Account.COLUMN_USERNAME)));
            account.setPassword(cursor.getString(cursor.getColumnIndex(Account.COLUMN_PASSWORD)));
        }
        cursor.close();
        db.close();
        return account;
    }

    public void updateUsername(Account account){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Account.COLUMN_USERNAME, account.getUsername());
        db.update(Account.TABLE_NAME, contentValues,
                Account.COLUMN_ID + " =? ", new String[]{String.valueOf(account.getAccountID())});
        db.close();
    }

    public void updatePassword(Account account){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Account.COLUMN_PASSWORD, account.getPassword());
        db.update(Account.TABLE_NAME, contentValues,
                Account.COLUMN_ID + " =? ", new String[]{String.valueOf(account.getAccountID())});
        db.close();
    }

    public ArrayList<Account> queryAllAccounts(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(Account.TABLE_NAME, null,
                null, null, null, null, null, null);

        ArrayList<Account> accountArrayList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Account account = new Account();
                account.setAccountID(cursor.getInt(cursor.getColumnIndex(Account.COLUMN_ID)));
                account.setUsername(cursor.getString(cursor.getColumnIndex(Account.COLUMN_USERNAME)));
                account.setPassword(cursor.getString(cursor.getColumnIndex(Account.COLUMN_PASSWORD)));
                accountArrayList.add(account);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return accountArrayList;
    }

    public Cursor queryAllAccountsAsCursor(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(Account.TABLE_NAME, null,
                null, null, null, null, null, null);

        return cursor;
    }

    public boolean checkUser(String username) {
        String[] columns = {
                Account.COLUMN_ID
        };
        SQLiteDatabase db = getReadableDatabase();
        String selection = Account.COLUMN_USERNAME + " = ?";
        String[] selectionArgs = { username };
        Cursor cursor = db.query(Account.TABLE_NAME,
                columns, selection, selectionArgs,null,null,null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if(cursorCount > 0)
            return true;

        return false;
    }

    public boolean checkUser(String username,String password) {
        String[] columns = {
                Account.COLUMN_ID
        };
        SQLiteDatabase db = getReadableDatabase();
        String selection =  Account.COLUMN_USERNAME + " = ?"+" AND "+Account.COLUMN_PASSWORD+" = ?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(Account.TABLE_NAME,
                columns, selection,selectionArgs,null,null,null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if(cursorCount > 0)
            return true;

        return false;
    }


}
