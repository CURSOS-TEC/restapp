package data;

import android.provider.BaseColumns;

public class VoteContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private VoteContract() {}

    /* Inner class that defines the table contents */
    public static class Vote implements BaseColumns {
        public static final String TABLE_NAME = "SoaVote";
        public static final String COLUMN_NAME_VOTE_ID = "id";
        public static final String COLUMN_NAME_VOTE_USER_ID = "userId";
        public static final String COLUMN_NAME_VOTE_RESTAURANT_ID = "restaurantId";
        public static final String COLUMN_NAME_VOTE_MENU_ID = "menuId";
        public static final String COLUMN_NAME_VOTE_MENU_ITEM = "menuItemId";
    }
}
