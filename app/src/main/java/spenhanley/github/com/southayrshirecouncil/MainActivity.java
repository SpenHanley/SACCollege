package spenhanley.github.com.southayrshirecouncil;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_bin_collection)
    Button btnBinCollection;

    @BindView(R.id.btn_contact_us)
    Button btnContactUs;

    @BindView(R.id.btn_recycle_centers)
    Button btnRecycleCenters;

    @BindView(R.id.btn_school_holidays)
    Button btnSchoolHolidays;

    @BindView(R.id.flickr_link)
    ImageButton btnFlickr;

    @BindView(R.id.linkedin_link)
    ImageButton btnLinkedIn;

    @BindView(R.id.twitter_link)
    ImageButton btnTwitter;

    @BindView(R.id.youtube_link)
    ImageButton btnYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    public void init(View view) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent("http://twitter.com/southayrshire");
            }
        });

        btnLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent("http://linkedin.com/company/south-ayrshire-council");
            }
        });

        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent("http://youtube.com/user/southayrshire");
            }
        });

        btnFlickr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent("http://flickr.com/photos/southayrshire/sets");
            }
        });
    }

    public void openIntent(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void showHolidays(View view)
    {
        setContentView(R.layout.master_view_activity);
        View v = View.inflate(this, R.layout.school_holidays, null);
        ViewGroup parent = (ViewGroup) findViewById(R.id.master_view);
        parent.addView(v);
        List<String> holidayList = new ArrayList<>();
        String[] dates = this.getResources().getStringArray(R.array.holiday_info);
        Collections.addAll(holidayList, dates);
        ListView holidayRV = (ListView) findViewById(R.id.lst_holidays);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, holidayList);
        holidayRV.setAdapter(adapter);
    }

    public void showContact(View view)
    {
        setContentView(R.layout.master_view_activity);
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = View.inflate(this, R.layout.contact, null);
        ViewGroup parent = (ViewGroup) findViewById(R.id.master_view);
        parent.addView(v);
        TextView addressTv = (TextView) findViewById(R.id.address_tv);
        for (String s : getResources().getStringArray(R.array.address_array))
        {
            addressTv.append(s + "\n");
        }
        addressTv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }

    public void showTourism(View view)
    {
        setContentView(R.layout.master_view_activity);
        View v = View.inflate(this, R.layout.tourism, null);
        ViewGroup parent = (ViewGroup) findViewById(R.id.master_view);
        parent.addView(v);
    }

    public void showThings(View view)
    {
        setContentView(R.layout.master_view_activity);
        setContentView(R.layout.master_view_activity);
        View v = View.inflate(this, R.layout.things, null);
        ViewGroup parent = (ViewGroup) findViewById(R.id.master_view);
        parent.addView(v);
    }

    public void exit(View view)
    {
        finishAffinity();
    }
}