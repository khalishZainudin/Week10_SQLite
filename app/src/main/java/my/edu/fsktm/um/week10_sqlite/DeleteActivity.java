package my.edu.fsktm.um.week10_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    private EditText ETNameDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Button button = (Button)findViewById(R.id.BTNCancelDel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void deleteRecord(View v){
        ETNameDel = (EditText)findViewById(R.id.ETNameDel);

        String nameDel = ETNameDel.getText().toString();
        if(nameDel.isEmpty()){
            ETNameDel.setError(getString(R.string.error_name));
            return;
        }

        UserSQLHelper userSQLHelper = new UserSQLHelper(this);
        int flag = userSQLHelper.delete(nameDel);

        if(flag <= 0)
            Toast.makeText(this, "Username not found!", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, nameDel + " has been deleted.", Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }


}
