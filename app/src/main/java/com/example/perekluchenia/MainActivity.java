package com.example.perekluchenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickBrowser(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        Toast toast = Toast.makeText(this, "Открыта ссылка " + "http://www.google.com",Toast.LENGTH_LONG);
        toast.show();
        startActivity(browserIntent);
    }

    public void OnClickPhone(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0123456789"));
        Toast toast = Toast.makeText(this, "Открыта телефон с номером " + "0123456789",Toast.LENGTH_LONG);
        toast.show();
        startActivity(intent);
    }

    public void OnClickMap(View view){
        double latitude = 55.044026; // любые данные
        double longitude = 82.917393; // любые данные

        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            String address = addresses.get(0).getAddressLine(0);

            Uri gmmIntentUri = Uri.parse("geo:" + latitude + ", " + latitude + "?q=" + Uri.encode(address));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            Toast toast = Toast.makeText(this, "Открыты координаты" + " 55.044026, 82.917393",Toast.LENGTH_LONG);
            toast.show();
            startActivity(mapIntent);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}