package data;

import android.provider.BaseColumns;

public class MenuContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private MenuContract() {}

    /* Inner class that defines the table contents */
    public static class Menu implements BaseColumns {
        public static final String TABLE_NAME = "SoaMenu";
        public static final String COLUMN_NAME_MENU_ID = "id";
        public static final String COLUMN_NAME_MENU_RESTAURANT= "restaurantId";
        public static final String COLUMN_NAME_MENU_SCHEDULE_TYPE= "scheduleType";
    }
}
