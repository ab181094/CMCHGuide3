package com.example.amrit.cmchguide.Map;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.amrit.cmchguide.R;
import com.qozix.tileview.TileView;

public class MapActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TileView tileView;
    ImageView marker;
    String building = null;
    int x = 0, y = 0;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        this.context = this;

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            building = bundle.getString("name");
            x = Integer.parseInt(bundle.getString("x"));
            y = Integer.parseInt(bundle.getString("y"));
            //toastIt(buiding + ": " + x + ", " + y);
        }

        linearLayout = (LinearLayout) findViewById(R.id.tileLayout);

        tileView = new TileView(this);

        //create tileview -- Amrit
        tileView.setSize(3000, 2000);

        //Setting the minimum parameters from the documentation -- Amrit
        tileView.addDetailLevel(1f, "tiles/map/1000/%d_%d.gif", "samples/map.jpg");
        tileView.addDetailLevel(0.5f, "tiles/map/500/%d_%d.gif", "samples/map.jpg");
        tileView.addDetailLevel(0.25f, "tiles/map/250/%d_%d.gif", "samples/map.jpg");
        tileView.addDetailLevel(0.125f, "tiles/map/125/%d_%d.gif", "samples/map.jpg");

        tileView.moveToAndCenter(3000, 2000);
        tileView.slideToAndCenter(3000, 2000);
        tileView.setScale(0.25);

        if (building != null) {
            marker = new ImageView(this);
            marker.setImageResource(R.drawable.marker);
            marker.setTag(building);

            tileView.addMarker(marker, x, y, -0.5f, -1.0f);
            tileView.setScale(1f);
            tileView.slideToAndCenter(x - 200, y - 200);

            marker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setCancelable(true);
                    builder.setTitle("পরিচিতি");
                    builder.setMessage("ভবনের নামঃ " + building);
                    builder.show();
                }
            });
        }

        linearLayout.addView(tileView);

        /*tileView.addTileViewEventListener(new TileView.TileViewEventListenerImplementation(){
            @Override
            public void onTap(int x, int y) {
                toastIt("The co-ordinate of this place is: " + x + ", " +y);
            }
        });*/
    }

    private void toastIt(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }
}
