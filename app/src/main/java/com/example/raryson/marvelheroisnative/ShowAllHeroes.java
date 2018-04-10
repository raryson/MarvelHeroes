package com.example.raryson.marvelheroisnative;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.raryson.marvelheroisnative.model.MarvelCharacter;
import com.example.raryson.marvelheroisnative.model.Result;
import com.example.raryson.marvelheroisnative.parameters.CharacterParameters;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import io.mikael.urlbuilder.UrlBuilder;


public class ShowAllHeroes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_heroes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        RestClient rest = new RestClient();
        try {
            Result<MarvelCharacter> characteres = rest.getCharactersAll();

            //LinearLayout layout = (LinearLayout)findViewById(R.id.layout);
            TextView wrapContent = (TextView) findViewById(R.id.large_text);

            List<String> Heroes = new ArrayList<>();

            for(MarvelCharacter character : characteres.getData().getResults())
            {
                String heroInfos = "Hero name: " + character.getName() + "\n" +
                        "Hero Description: " + character.getDescription() + "\n" + "\n";

                //String enchancedUrl = rest.getImagesUrl(character.getThumbnail().getPath() +"."+ character.getThumbnail().getExtension());
                //URL url = new URL(enchancedUrl);
                //Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());

                Heroes.add(heroInfos);

                //LinearLayout layout = (LinearLayout)findViewById(R.id.layout);
                //ImageView image = new ImageView(this);
                //image.setLayoutParams(new android.view.ViewGroup.LayoutParams(60,80));
                //image.setMaxHeight(20);
                //image.setMaxWidth(20);
                //image.setImageBitmap(bitmap);
                //layout.addView(image);

            }

            String concat = "";
            for(String foo : Heroes)
            {
                concat += "\n"+foo;
            }

            wrapContent.setText(concat);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_all_heroes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
