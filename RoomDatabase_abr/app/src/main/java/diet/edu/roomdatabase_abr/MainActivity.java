package diet.edu.roomdatabase_abr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name,age;
    TextView result;
    PersonDataBase personDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name1);
        age = findViewById(R.id.age1);
        result = findViewById(R.id.text1);
        personDataBase = Room.databaseBuilder(this,
                PersonDataBase.class,"mydb")
                .allowMainThreadQueries().build();

    }

    public void save(View view) {
        String name1 = name.getText().toString();
        int age1 = Integer.parseInt(age.getText().toString());
        Person person = new Person(name1,age1);
        personDataBase.personDao().insert(person);
        getData();
    }

    private void getData() {
        List<Person> p = personDataBase.personDao().getAll();
        result.setText("");
        for(int i=0;i<p.size();i++){
            result.append(p.get(i).getId()+"\n");
            result.append(p.get(i).getName()+"\n");
            result.append(p.get(i).getAge()+"\n\n\n");

        }

    }
}