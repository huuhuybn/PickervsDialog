package vn.e.pickervsdialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnShowToast;
    private Button btnShowAlert;
    private Button btnShowProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // tham chieu cac doi tuong tu file layout
        btnShowToast = findViewById(R.id.btnShowToast);
        btnShowAlert = findViewById(R.id.btnShowAlert);
        btnShowProgress = findViewById(R.id.btnShowProgress);


        // set su kien click vao cac button
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast

                Toast.makeText(MainActivity.this,
                        "Noi dung muon hien thi!!!", Toast.LENGTH_SHORT).show();


            }
        });

        btnShowProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

                progressDialog.setMessage("Loading...");


                if (progressDialog.isShowing())
                    progressDialog.dismiss();
                else progressDialog.show();


            }
        });


        btnShowAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAlert();

            }
        });


        // bat su kien click de hien thi date picker
        findViewById(R.id.btnShowToast2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // lay thoi gian hien tai
                final Calendar calendar = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        Toast.makeText(MainActivity.this,
                                year + " : " + month + " : " + dayOfMonth, Toast.LENGTH_SHORT).show();
                    }
                }, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();


            }
        });
    }


    public void showAlert() {
        AlertDialog.Builder builder
                = new AlertDialog.Builder(MainActivity.this);


        builder.setTitle("Demo");
        //builder.setMessage("Hello SEO410??");

        LayoutInflater layoutInflater = MainActivity.this.getLayoutInflater();

        View view = layoutInflater.inflate(R.layout.my_dialog, null);
        builder.setView(view);


        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,
                        "ban vua bam ok!", Toast.LENGTH_SHORT).show();


            }
        });

        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,
                        "ban vua bam cancel!", Toast.LENGTH_SHORT).show();

            }
        });
        builder.show();

    }
}


