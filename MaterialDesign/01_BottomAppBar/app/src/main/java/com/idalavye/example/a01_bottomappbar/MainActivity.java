package com.idalavye.example.a01_bottomappbar;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter customAdapter;


    private BottomAppBar bar;
    private TextView tw_newWord;
    private Switch aSwitch;
    private boolean fbModeCenter = true;
    private FloatingActionButton fab;


    public static final String TEXT = "TEXT";
    public static final String AUDIO = "AUDIO";
    public static final String IMAGE = "IMAGE";
    public static final String VIDEO = "VIDEO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fab.hide();
                } else {
                    fab.show();
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fbModeCenter) {
                    bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
                    fab.setImageResource(R.drawable.ic_arrow);
                    fbModeCenter = false;
                    listView.setVisibility(View.GONE);

//                    Intent intent = new Intent(getApplicationContext(), CreateNewActivity.class);
//                    startActivity(intent);
                } else {
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
                    listView.startAnimation(animation);
                    listView.setVisibility(View.VISIBLE);
                    bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                    fab.setImageResource(R.drawable.ic_add_black_24dp);
                    fbModeCenter = true;
                }
            }
        });

        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMessage("NavigationMenu");
            }
        });

        this.listView.setNestedScrollingEnabled(true);
        this.listView.setAdapter(customAdapter);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Position : " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public boolean addPhoto(MenuItem menuItem) {
        getMessage("AddPhoto");
        return true;
    }

    public boolean search(MenuItem menuItem) {
        getMessage("Search");
        return true;
    }

    private void getMessage(String message) {
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void init() {
        this.tw_newWord = findViewById(R.id.tw_newWord);
        this.bar = findViewById(R.id.bar);
        setSupportActionBar(bar);
        this.aSwitch = findViewById(R.id.switch1);
        this.fab = findViewById(R.id.fab);
        this.listView = findViewById(R.id.listView);
        this.customAdapter = new CustomAdapter(this, getArrayList());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bbar, menu);

        return true;
    }

    private String getEmoji(int unicode) {
        return new String(Character.toChars(unicode));
    }

    private ArrayList<ObjetoListView> getArrayList() {

        ArrayList<ObjetoListView> arrayList = new ArrayList<>();

        //MENSAJE NO LEIDO
        arrayList.add(new ObjetoListView("Familia" + getEmoji(0x1F601), "Juan: " + getEmoji(0x1F64C),
                "10/8/18", TEXT, false, 3, "", R.drawable.foto));
        //AUDIO
        arrayList.add(new ObjetoListView("Alicia", "",
                "4/8/18", AUDIO, false, 1, "0:34", R.drawable.foto));
        //PHOTO
        arrayList.add(new ObjetoListView("Juan", "",
                "AYER", IMAGE, true, 1, "Foto", R.drawable.foto));
        //VIDEO
        arrayList.add(new ObjetoListView("Amaya", "",
                "JUEVES", VIDEO, true, 1, "Video", R.drawable.foto));
        //TXT
        arrayList.add(new ObjetoListView("Comida",
                "tú: ¡Me parece genial!" + getEmoji(0x1F60A),
                "2/8/18", TEXT, true, 1, "", R.drawable.foto));

        //TXT
        arrayList.add(new ObjetoListView("Diana",
                "Nos vemos el viernes " + getEmoji(0x1F60A),
                "2/8/18", TEXT, true, 1, "", R.drawable.foto));


        //MENSAJE NO LEIDO
        arrayList.add(new ObjetoListView("Familia" + getEmoji(0x1F601), "Juan: " + getEmoji(0x1F64C),
                "10/8/18", TEXT, false, 3, "", R.drawable.foto));
        //AUDIO
        arrayList.add(new ObjetoListView("Alicia", "",
                "4/8/18", AUDIO, false, 1, "0:34", R.drawable.foto));
        //PHOTO
        arrayList.add(new ObjetoListView("Juan", "",
                "AYER", IMAGE, true, 1, "Foto", R.drawable.foto));
        //VIDEO
        arrayList.add(new ObjetoListView("Amaya", "",
                "JUEVES", VIDEO, true, 1, "Video", R.drawable.foto));
        //TXT
        arrayList.add(new ObjetoListView("Comida",
                "tú: ¡Me parece genial!" + getEmoji(0x1F60A),
                "2/8/18", TEXT, true, 1, "", R.drawable.foto));

        //TXT
        arrayList.add(new ObjetoListView("Diana",
                "Nos vemos el viernes " + getEmoji(0x1F60A),
                "2/8/18", TEXT, true, 1, "", R.drawable.foto));


        //MENSAJE NO LEIDO
        arrayList.add(new ObjetoListView("Familia" + getEmoji(0x1F601), "Juan: " + getEmoji(0x1F64C),
                "10/8/18", TEXT, false, 3, "", R.drawable.foto));
        //AUDIO
        arrayList.add(new ObjetoListView("Alicia", "",
                "4/8/18", AUDIO, false, 1, "0:34", R.drawable.foto));
        //PHOTO
        arrayList.add(new ObjetoListView("Juan", "",
                "AYER", IMAGE, true, 1, "Foto", R.drawable.foto));
        //VIDEO
        arrayList.add(new ObjetoListView("Amaya", "",
                "JUEVES", VIDEO, true, 1, "Video", R.drawable.foto));
        //TXT
        arrayList.add(new ObjetoListView("Comida",
                "tú: ¡Me parece genial!" + getEmoji(0x1F60A),
                "2/8/18", TEXT, true, 1, "", R.drawable.foto));

        //TXT
        arrayList.add(new ObjetoListView("Diana",
                "Nos vemos el viernes " + getEmoji(0x1F60A),
                "2/8/18", TEXT, true, 1, "", R.drawable.foto));


        return arrayList;
    }
}
