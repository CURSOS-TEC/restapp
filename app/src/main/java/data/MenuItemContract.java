package data;

import android.provider.BaseColumns;

public class MenuItemContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private MenuItemContract() {}

    /* Inner class that defines the table contents */
    public static class MenuItem implements BaseColumns {
        public static final String TABLE_NAME = "SoaMenuItem";
        public static final String COLUMN_NAME_MENU_ITEM_ID = "id";
        public static final String COLUMN_NAME_MENU_ITEM_MENU_ID= "menuId";
        public static final String COLUMN_NAME_MENU_ITEM_NAME = "name";
        public static final String COLUMN_NAME_MENU_ITEM_DESCRIPTION = "description";
        public static final String COLUMN_NAME_MENU_ITEM_PHOTO= "photoUri";
    }
}
