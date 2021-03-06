package com.russellitneng.rite;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity  { //has to add "implements EmaiDialog.Comunicator" to communicate between fragments

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                EmaiDialog emaiDialog = new EmaiDialog();
                emaiDialog.show(manager, "email_confirm");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {

            startActivity(new Intent(this, About.class));
            return true;
        }
        else if(id == R.id.action_web){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.russellitbd.com"));
            startActivity(intent);
        }

        return true;
    }

    public void serviceListMenu(View view) {
        Intent intent = new Intent(this, ServiceList.class);
        startActivity(intent);
    }

    /*TODO applies when a custom dialog fragment is used and for using button communication events*/
//    @Override
//    public void onClickEvent(String massage) {
//        if(massage.equals("yes")) {
//            String uri = "mailto:a15shaafi.209@gmail.com";
//            Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
//            sendIntent.setType("message/plain");
//            sendIntent.setData(Uri.parse(uri));
//            startActivity(sendIntent);
//        }
//        else
//            Toast.makeText(this,massage,Toast.LENGTH_SHORT).show();
//    }

    /**/
}
