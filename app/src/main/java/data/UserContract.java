package data;

import android.provider.BaseColumns;

/**
 *This contract is used to abstracts the user table on the data base*/
public class UserContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private UserContract() {}

    /* Inner class that defines the table contents */
    public static class User implements BaseColumns {
        public static final String TABLE_NAME = "SoaUser";
        public static final String COLUMN_NAME_USER_NAME = "username";
        public static final String COLUMN_NAME_USER_LAST = "lastname";
        public static final String COLUMN_NAME_USER_EMAIL = "email";
        public static final String COLUMN_NAME_USER_PASSWORD = "password";
        public static final String COLUMN_NAME_USER_ROLE = "role";
    }

}
