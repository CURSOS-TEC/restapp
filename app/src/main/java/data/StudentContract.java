package data;

import android.provider.BaseColumns;

public class StudentContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private StudentContract() {}

    /* Inner class that defines the table contents */
    public static class Studnet implements BaseColumns {
        public static final String TABLE_NAME = "SoaStudent";
        public static final String COLUMN_NAME_STUDENT_ID = "id";
        public static final String COLUMN_NAME_STUDENT_COLLEGE_ID = "license";
        public static final String COLUMN_NAME_STUDENT_CAREER = "career";
    }
}
