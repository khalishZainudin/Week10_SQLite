package my.edu.fsktm.um.week10_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Button button = (Button)findViewById(R.id.BTNCancelUpdate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    EditText EToldName, ETnewName;

    public void updateName(View v){
        EToldName = (EditText)findViewById(R.id.ETNameUpd);
        ETnewName = (EditText)findViewById(R.id.ETNameNew);



        String oldName = EToldName.getText().toString();
        if(oldName.isEmpty()){
            EToldName.setError(getString(R.string.error_name));
            return;
        }

        String newName = ETnewName.getText().toString();
        if(newName.isEmpty()){
            ETnewName.setError(getString(R.string.error_name));
            return;
        }

        UserSQLHelper userSQLHelper = new UserSQLHelper(this);
        int flag = userSQLHelper.updateName(oldName, newName);

        if(flag <= 0)
            Toast.makeText(this, "Name not found!", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, oldName + " successfully updated to " + newName, Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }
}
