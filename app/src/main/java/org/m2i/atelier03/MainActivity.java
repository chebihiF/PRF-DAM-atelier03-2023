package org.m2i.atelier03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button tel_btn, web_btn, geo_btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tel_btn = findViewById(R.id.tel_btn);
        web_btn = findViewById(R.id.web_btn);
        geo_btn = findViewById(R.id.geo_btn);

        geo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri geoLocation = Uri.parse("geo:48.860745416359656, 2.2948473712366013?z=14");
                //Uri telNumber = Uri.parse("geo:0,0?q=1 Quai de Grenelle");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLocation);
                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        web_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage = Uri.parse("www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        tel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri telNumber = Uri.parse("tel:08920182");
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(telNumber);
                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}