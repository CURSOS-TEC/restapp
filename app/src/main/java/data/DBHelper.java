package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {


    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SOADB.db";
    private static final String SQL_CREATE_USER_TABLE =
            "CREATE TABLE IF NOT EXISTS " + UserContract.User.TABLE_NAME + " (" +
                    UserContract.User.COLUMN_NAME_USER_ID + " INTEGER PRIMARY KEY," +
                    UserContract.User.COLUMN_NAME_USER_NAME + " TEXT," +
                    UserContract.User.COLUMN_NAME_USER_LAST + " TEXT, " +
                    UserContract.User.COLUMN_NAME_USER_EMAIL + " TEXT, " +
                    UserContract.User.COLUMN_NAME_USER_PASSWORD + " TEXT, "+
                    UserContract.User.COLUMN_NAME_USER_ROLE + " INTEGER) ";

    private static final String SQL_CREATE_STUDENT_TABLE =
            "CREATE TABLE IF NOT EXISTS " + StudentContract.Studnet.TABLE_NAME + " (" +
                    StudentContract.Studnet.COLUMN_NAME_STUDENT_ID + " INTEGER PRIMARY KEY," +
                    StudentContract.Studnet.COLUMN_NAME_STUDENT_COLLEGE_ID + " INTEGER," +
                    StudentContract.Studnet.COLUMN_NAME_STUDENT_CAREER + " TEXT) ";

    private static final String SQL_CREATE_RESTAURANT_TABLE =
            "CREATE TABLE IF NOT EXISTS " + RestaurantContract.Restaurant.TABLE_NAME + " (" +
                    RestaurantContract.Restaurant.COLUMN_NAME_RESTAURANT_ID + " INTEGER PRIMARY KEY," +
                    RestaurantContract.Restaurant.COLUMN_NAME_RESTAURANT_NAME + " TEXT," +
                    RestaurantContract.Restaurant.COLUMN_NAME_RESTAURANT_ADDRESS + " TEXT, " +
                    RestaurantContract.Restaurant.COLUMN_NAME_RESTAURANT_SCHEDULE + " TEXT, " +
                    RestaurantContract.Restaurant.COLUMN_NAME_RESTAURANT_PHONE + " TEXT, "+
                    RestaurantContract.Restaurant.COLUMN_NAME_RESTAURANT_PHOTO + " TEXT) ";

    private static final String SQL_CREATE_MENU_TABLE =
            "CREATE TABLE IF NOT EXISTS " + MenuContract.Menu.TABLE_NAME + " (" +
                    MenuContract.Menu.COLUMN_NAME_MENU_ID + " INTEGER PRIMARY KEY," +
                    MenuContract.Menu.COLUMN_NAME_MENU_RESTAURANT_ID + " INTEGER," +
                    MenuContract.Menu.COLUMN_NAME_MENU_SCHEDULE_TYPE + " INTEGER) ";

    private static final String SQL_CREATE_MENU_ITEM_TABLE =
            "CREATE TABLE IF NOT EXISTS " + MenuItemContract.MenuItem.TABLE_NAME + " (" +
                    MenuItemContract.MenuItem.COLUMN_NAME_MENU_ITEM_ID + " INTEGER PRIMARY KEY," +
                    MenuItemContract.MenuItem.COLUMN_NAME_MENU_ITEM_NAME + " TEXT," +
                    MenuItemContract.MenuItem.COLUMN_NAME_MENU_ITEM_DESCRIPTION + " TEXT," +
                    MenuItemContract.MenuItem.COLUMN_NAME_MENU_ITEM_PHOTO + " TEXT," +
                    MenuItemContract.MenuItem.COLUMN_NAME_MENU_ITEM_MENU_ID + " INTEGER) ";

    private static final String SQL_CREATE_VOTE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + VoteContract.Vote.TABLE_NAME + " (" +
                    VoteContract.Vote.COLUMN_NAME_VOTE_ID + " INTEGER PRIMARY KEY," +
                    VoteContract.Vote.COLUMN_NAME_VOTE_USER_ID + " INTEGER," +
                    VoteContract.Vote.COLUMN_NAME_VOTE_RESTAURANT_ID + " INTEGER," +
                    VoteContract.Vote.COLUMN_NAME_VOTE_MENU_ID + " INTEGER," +
                    VoteContract.Vote.COLUMN_NAME_VOTE_MENU_ITEM_ID + " INTEGER) ";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS" + UserContract.User.TABLE_NAME;

    /**
     * Constructor: only gets the context of the application.
     * @param context
     */
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_USER_TABLE);
        db.execSQL(SQL_CREATE_RESTAURANT_TABLE);
        db.execSQL(SQL_CREATE_STUDENT_TABLE);
        db.execSQL(SQL_CREATE_MENU_TABLE);
        db.execSQL(SQL_CREATE_MENU_ITEM_TABLE);
        db.execSQL(SQL_CREATE_VOTE_TABLE);

    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Called when the database needs to be downgraded. This is strictly similar to
     * {@link #onUpgrade} method, but is called whenever current version is newer than requested one.
     * However, this method is not abstract, so it is not mandatory for a customer to
     * implement it. If not overridden, default implementation will reject downgrade and
     * throws SQLiteException
     * <p>
     * <p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        onUpgrade(db, oldVersion, newVersion);
    }

    public void checkUserCredentials (){}
    public long addUserCredentials (String pName,String pLastName, String pEmail, String pPassword, int pId ){
        SQLiteDatabase db = this.getWritableDatabase();
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(UserContract.User.COLUMN_NAME_USER_NAME, pName);
        values.put(UserContract.User.COLUMN_NAME_USER_LAST, pLastName);
        values.put(UserContract.User.COLUMN_NAME_USER_EMAIL, pEmail);
        values.put(UserContract.User.COLUMN_NAME_USER_PASSWORD, pPassword);
        values.put(UserContract.User.COLUMN_NAME_USER_ROLE, pId);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(UserContract.User.TABLE_NAME, null, values);
        return newRowId;
        /**TODO: Validate unique email
         * TODO: Validate not null password
         * TODO: Check rol: 1 or 2 for types
         * **/
    }

    public void readMenuItem   () {} // works for best ranking
    public void createMenuItem () {}
    public void deleteMenuItem () {}
    public void updateMenuItem () {} // votes

    public void readMenu   () {}
    public void createMenu () {}
    public void deleteMenu () {}
    public void updateMenu () {}

    public void readRestaurant   () {}
    public void createRestaurant () {}
    public void deleteRestaurant () {}
    public void updateRestaurant () {}

}
