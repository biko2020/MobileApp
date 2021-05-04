package ma.enset.annuaireprofessionnal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class MyDatabase extends SQLiteOpenHelper {

    //************ creation de la base de donnees DbContact.db ***********

    private Context context;
    private static final String DATABASE_NAME = "DbContact.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "contact";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_FIRST_NAME = "contact_FIRSTName";
    private static final String COLUMN_LAST_NAME = "contact_LASTName";
    private static final String COLUMN_JOB = "contact_job";
    private static final String COLUMN_PHONE = "contact_phone";
    private static final String COLUMN_EMAIL = "contact_email";


    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //************ creation de la table conatct ***********
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_FIRST_NAME + "TEXT," +
                        COLUMN_LAST_NAME + "TEXT," +
                        COLUMN_JOB + "TEXT," +
                        COLUMN_PHONE + "TEXT," +
                        COLUMN_EMAIL + "TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF Exists contact" + TABLE_NAME);
        onCreate(db);
    }

    void addContact(String firstName,String lastName, String job, String phone, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COLUMN_FIRST_NAME, firstName );
        contentvalues.put(COLUMN_LAST_NAME, lastName);
        contentvalues.put(COLUMN_JOB, job);
        contentvalues.put(COLUMN_PHONE, phone);
        contentvalues.put(COLUMN_EMAIL, email);

        long result = db.insert(TABLE_NAME,null,contentvalues);

        // test si le resultat est null afficher un messages , courte duree avec le toast de base
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(context,"Save ok!",Toast.LENGTH_SHORT).show();
        }

    }
}