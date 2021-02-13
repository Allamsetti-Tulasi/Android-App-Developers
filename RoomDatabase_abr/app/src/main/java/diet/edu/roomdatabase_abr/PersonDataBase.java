package diet.edu.roomdatabase_abr;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Person.class},version = 1,exportSchema = false)
public  abstract class PersonDataBase  extends RoomDatabase {


    public abstract PersonDao personDao();

}
