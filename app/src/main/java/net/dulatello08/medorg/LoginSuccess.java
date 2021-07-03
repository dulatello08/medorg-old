package net.dulatello08.medorg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import net.dulatello08.medorg.databinding.ActivityLoginSuccessBinding;

public class LoginSuccess extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityLoginSuccessBinding binding;
    private String Name;
    private String LastName;
    private String Email;
    private String Id;
    private String photoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarLoginSuccess.toolbar);
        binding.appBarLoginSuccess.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_login_success);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //data_handler
        Intent intent = getIntent();
        Name = intent.getStringExtra(Intent.EXTRA_TEXT);
        Email = intent.getStringExtra(Intent.EXTRA_EMAIL);
        photoUri = intent.getStringExtra(Intent.EXTRA_STREAM);

        /*StringBuilder sb = new StringBuilder(Name);
        sb.append(LastName);*/
        View hView = navigationView.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.textName);
        nav_user.setText(Name);

        TextView nav_email = (TextView)hView.findViewById(R.id.textEmail);
        nav_email.setText(Email);

        Uri photoUri1 = Uri.parse(photoUri);

        ImageView nav_img = (ImageView) hView.findViewById(R.id.imageView);
        nav_img.setImageURI(null);
        nav_img.setImageURI(photoUri1);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login_success, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_login_success);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
