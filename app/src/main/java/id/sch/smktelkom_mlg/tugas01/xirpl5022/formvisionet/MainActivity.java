package id.sch.smktelkom_mlg.tugas01.xirpl5022.formvisionet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Name, Mail, Pass;
    Button bOk;
    RadioButton R1, R2;
    CheckBox Check1, Check2, Check3, Check4;
    TextView tvHasil;
    Spinner angkatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.editTextNama);
        Mail = (EditText) findViewById(R.id.editTextEmail);
        Pass = (EditText) findViewById(R.id.editTextPass);
        tvHasil = (TextView) findViewById(R.id.Hasilnya);
        angkatan = (Spinner) findViewById(R.id.Angkatan);
        Check1 = (CheckBox) findViewById(R.id.Java);
        Check2 = (CheckBox) findViewById(R.id.ASP);
        Check3 = (CheckBox) findViewById(R.id.Android);
        Check4 = (CheckBox) findViewById(R.id.Oracle);
        R1 = (RadioButton) findViewById(R.id.RPL);
        R2 = (RadioButton) findViewById(R.id.TKJ);
        bOk = (Button) findViewById(R.id.buttonOK);


        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()) ;


                String nama = Name.getText().toString();
                String hasil = "\n\nKelas Khusus yang Anda Pilih:";
                String level = null;
                int startlen = hasil.length();
                if (Check1.isChecked()) hasil += Check1.getText() + "\n";
                if (Check2.isChecked()) hasil += Check2.getText() + "\n";
                if (Check3.isChecked()) hasil += Check3.getText() + "\n";
                if (Check4.isChecked()) hasil += Check4.getText() + "\n";

                if (R2.isChecked()) {
                    level = R2.getText().toString();
                } else if (R1.isChecked())
                {
                    level = R1.getText().toString();
                }

                if (hasil.length() == startlen) hasil += "Tidak Memilih";

                tvHasil.setText(

                        "\nNama Anda :" + nama
                                + "\n\nKelas Anda :"
                                + angkatan.getSelectedItem().toString()
                                + hasil + "\n\nJurusan Anda:" + level);
            }


        });
    }

    private boolean isValid() {

        boolean valid = true;

        String email = Mail.getText().toString();
        String password = Pass.getText().toString();
        String nama = Name.getText().toString();


        if (nama.isEmpty()) {
            Name.setError("Nama Kosong");
            valid = false;
        } else if (nama.length() < 6) {
            Name.setError("Minimal 6 Karakter");
            valid = false;
        } else {
            Name.setError(null);
        }
        if (email.isEmpty()) {
            Mail.setError("e-Mail Belum Diisi");
            valid = false;
        } else if (email.length() < 4) {
            Mail.setError("Format Salah");
            valid = false;
        } else {
            Name.setError(null);
        }
        if (password.isEmpty()) {
            Pass.setError("Password harus diisi");
            valid = false;
        }


        return valid;
    }

}


