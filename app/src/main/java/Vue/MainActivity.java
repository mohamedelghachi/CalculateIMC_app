package Vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.myimg.R;

import Controller.Controle;
import Model.Profil;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText_poids;
    private EditText mEditText_taille;
    private EditText mEditText_age;
    private RadioButton mRadioButton_Homme;
    private RadioButton mRadioButton_Femme;
    private Button mButton_calculer;
    private RadioGroup mRadioGroup_homme_femme;
    private ImageView mImageView_imoj;
    private TextView mtextView_result;
    private int mSexe = 1;

    private Controle controle = Controle.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText_poids = findViewById(R.id.editTextNumber_poids);
        mEditText_taille = findViewById(R.id.editTextNumber_taille);
        mEditText_age = findViewById(R.id.editTextNumber_age);
        mRadioButton_Homme = findViewById(R.id.radioButton_homme);
        mRadioButton_Femme = findViewById(R.id.radioButton_femme);
        mButton_calculer = findViewById(R.id.button_calculer);
        mRadioGroup_homme_femme = findViewById(R.id.radiogroupe_homme_femme);
        mImageView_imoj = findViewById(R.id.imageView_imoj);
        mtextView_result = findViewById(R.id.textView_result);


        //mButton_calculer.setEnabled(false);

        mButton_calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controle.creerProfil(Integer.parseInt(mEditText_poids.getText().toString()),
                        Integer.parseInt(mEditText_taille.getText().toString()),
                        Integer.parseInt(mEditText_age.getText().toString()),
                        mSexe);
                float img = controle.getIMG();
                String message = controle.getMessage();
                if(message == "normal" ){
                    mImageView_imoj.setImageResource(R.drawable.normal);

                }
                if(message == "trop graisse" ){
                    mImageView_imoj.setImageResource(R.drawable.graisse);
                }
                if(message == "trop maigre" ){
                    mImageView_imoj.setImageResource(R.drawable.maigre);
                }

                mtextView_result.setText(String.format("",img)+" : IMG => "+message);
            }
        });

        mRadioGroup_homme_femme.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.radioButton_homme){
                mSexe = 1;
            }
            if(checkedId == R.id.radioButton_femme){
                mSexe = 0;
            }
        });
    }
}