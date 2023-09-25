package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.testing.Sql.DBHelperItem;

public class AddMaterials extends AppCompatActivity {

    EditText MatCode,MatDesc,MatQuantity;

    DBHelperItem dbHelper1;
    Button MatAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materials);


        MatCode = findViewById(R.id.mat_code);
        MatDesc = findViewById(R.id.mat_des);
        MatQuantity = findViewById(R.id.mat_quan);
        dbHelper1 = new DBHelperItem(this);
        MatAdd = findViewById(R.id.addmat);

        MatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code1 = MatCode.getText().toString();
                String des1 = MatDesc.getText().toString();
                String qua1 = MatQuantity.getText().toString();

                boolean b =dbHelper1.insetItemData(code1,des1, qua1);
                if (b){
                    Toast.makeText(AddMaterials.this,"Data inserted",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(AddMaterials.this,Dashboard.class);
                    startActivity(i);
                }else {
                    Toast.makeText(AddMaterials.this,"Failed To insert Data",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}