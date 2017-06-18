package com.miftakhudin.surface;

import android.media.Image;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class MainActivity extends AppCompatActivity {
    int[] images = {R.drawable.listviewexample, R.drawable.listviewexample};
    String[] title = {"Persiapan","Akad","Pemberian Mahar","Mahar","Sungkem","Dua Mempelai","Bapak (kiri) dan Lik Sam (kanan)","Bapak dan Teteh","Mempelai","Lik Sam","Bersama Fazrin","Bapak, Fazrin, Lik Sam","Mang Yayat dan Bapak","Bapak dan Abah","Bapak","Abah dan Emak","Mamah dan Bapak","Mamah dan Bapak","Mamah dan Bapak","Berpelukan","Mamah dan Bapak","Rini dan Bibi","Bibi, Rini, dan Amat","Bibi, Rini, dan Amat","Mamah, Bibi, Rini, dan Amat","Rini dan Amat","Rini dan Amat","Bibi dan Paman","Riyanto dan Fazrin","Keluarga baru","Kakak adik","Bersama Mamah","Bersama Kue","Bapak","Keluarga Kang Agus","Mbak Yulda dan lain-lain","Keluarga Kang Agus","Keluarga Mas Mamat","Anaknya Mas Mamat","Kang Agus","Mempelai berbaju merah","Mamah dan Fazrin","Mempelai berbaju merah","Berpandangan","Berpelukan","Menatap masa depan","Berdekatan","Bersama Dek Azka :)","Turut berbahagia"};
    //String[] description = {"Persiapan aqad nikah","Akad","resized_IMG_0708.jpg","resized_IMG_0714.jpg","resized_IMG_0716.jpg","resized_IMG_0717.jpg","resized_IMG_0718.jpg","resized_IMG_0722.jpg","resized_IMG_0723.jpg","resized_IMG_0724.jpg","resized_IMG_0725.jpg","resized_IMG_0726.jpg","resized_IMG_0727.jpg","resized_IMG_0731.jpg","resized_IMG_0734.jpg","resized_IMG_0735.jpg","resized_IMG_0738.jpg","resized_IMG_0740.jpg","resized_IMG_0741.jpg","resized_IMG_0742.jpg","resized_IMG_0743.jpg","resized_IMG_0744.jpg","resized_IMG_0745.jpg","resized_IMG_0746.jpg","resized_IMG_0747.jpg","resized_IMG_0748.jpg","resized_IMG_0749.jpg","resized_IMG_0753.jpg","resized_IMG_0756.jpg","resized_IMG_0757.jpg","resized_IMG_0759.jpg","resized_IMG_0760.jpg","resized_IMG_0761.jpg","resized_IMG_0762.jpg","resized_IMG_0775.jpg","resized_IMG_0776.jpg","resized_IMG_0779.jpg","resized_IMG_0780.jpg","resized_IMG_0782.jpg","resized_IMG_0784.jpg","resized_IMG_0786.jpg","resized_IMG_0789.jpg","resized_IMG_0790.jpg","resized_IMG_0791.jpg","resized_IMG_0792.jpg","resized_IMG_0793.jpg","resized_IMG_0796.jpg","resized_IMG_0803.jpg","resized_IMG_0812.jpg"};
    String[] pictures = {"resized_IMG_0689.jpg","resized_IMG_0690.jpg","resized_IMG_0708.jpg","resized_IMG_0714.jpg","resized_IMG_0716.jpg","resized_IMG_0717.jpg","resized_IMG_0718.jpg","resized_IMG_0722.jpg","resized_IMG_0723.jpg","resized_IMG_0724.jpg","resized_IMG_0725.jpg","resized_IMG_0726.jpg","resized_IMG_0727.jpg","resized_IMG_0731.jpg","resized_IMG_0734.jpg","resized_IMG_0735.jpg","resized_IMG_0738.jpg","resized_IMG_0740.jpg","resized_IMG_0741.jpg","resized_IMG_0742.jpg","resized_IMG_0743.jpg","resized_IMG_0744.jpg","resized_IMG_0745.jpg","resized_IMG_0746.jpg","resized_IMG_0747.jpg","resized_IMG_0748.jpg","resized_IMG_0749.jpg","resized_IMG_0753.jpg","resized_IMG_0756.jpg","resized_IMG_0757.jpg","resized_IMG_0759.jpg","resized_IMG_0760.jpg","resized_IMG_0761.jpg","resized_IMG_0762.jpg","resized_IMG_0775.jpg","resized_IMG_0776.jpg","resized_IMG_0779.jpg","resized_IMG_0780.jpg","resized_IMG_0782.jpg","resized_IMG_0784.jpg","resized_IMG_0786.jpg","resized_IMG_0789.jpg","resized_IMG_0790.jpg","resized_IMG_0791.jpg","resized_IMG_0792.jpg","resized_IMG_0793.jpg","resized_IMG_0796.jpg","resized_IMG_0803.jpg","resized_IMG_0812.jpg"};
    ListView listView;
    TextView titleView, descrView;
    Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mBarDrawerToggle;
    private ImageView imageView;
    private StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FirebaseApp.initializeApp(this);
        storageRef = FirebaseStorage.getInstance().getReference();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mBarDrawerToggle);
        mBarDrawerToggle.syncState();
        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        //setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class CustomAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_layout, null, true);
            titleView = (TextView) convertView.findViewById(R.id.article_title);
            imageView = (ImageView) convertView.findViewById(R.id.imageView1);
            String imageName = pictures[position];
            StorageReference pathReference = storageRef.child("nikahansabar/"+imageName);
            Glide.with(MainActivity.this)
                    .using(new FirebaseImageLoader())
                    .load(pathReference)
                    .into(imageView);

            String strTitle = title[position];
            //String strDescription = description[position];

            titleView.setText(strTitle);
            //descrView.setText(strDescription);

            return convertView;
        }
    }
}
