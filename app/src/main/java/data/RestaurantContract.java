package data;

import android.provider.BaseColumns;

public class RestaurantContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private RestaurantContract() {}

    /* Inner class that defines the table contents */
    public static class Restaurant implements BaseColumns {
        public static final String TABLE_NAME = "SoaRestaurant";
        public static final String COLUMN_NAME_RESTAURANT_ID = "id";
        public static final String COLUMN_NAME_RESTAURANT_NAME = "name";
        public static final String COLUMN_NAME_RESTAURANT_ADDRESS= "address";
        public static final String COLUMN_NAME_RESTAURANT_SCHEDULE= "schedule";
        public static final String COLUMN_NAME_RESTAURANT_PHONE= "phone";
        public static final String COLUMN_NAME_RESTAURANT_PHOTO= "photoUri";
    }
}
