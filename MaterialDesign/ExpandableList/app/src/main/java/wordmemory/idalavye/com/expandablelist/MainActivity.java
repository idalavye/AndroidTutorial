package wordmemory.idalavye.com.expandablelist;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandleList;
    private HashMap<String,Contacto> listContactos;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();

        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }

                lastExpandedPosition = groupPosition;
            }
        });
    }

    private void init() {
        this.expandableListView = findViewById(R.id.expandablelistview);
        this.listContactos = getContacts();
        this.expandleList = new ArrayList<>(listContactos.keySet());
        this.expandableListAdapter = new CustomExpandableListAdapter(this,expandleList,listContactos);
    }

    private HashMap<String,Contacto> getContacts(){
        HashMap<String,Contacto> list = new HashMap<>();

        list.put("İbrahim",new Contacto("44444","idalavye@sfasdf","asdfasdfadf",R.drawable.ic_android_black_24dp));
        list.put("Ali  ",new Contacto("4444sfdg4","idalagfdsgvye@sfasdf","asdfasdfasdfadf",R.drawable.ic_android_black_24dp));
        list.put("Veli",new Contacto("4sdf4444","idalfff4444avye@fsdg","asdfasdfadf",R.drawable.ic_android_black_24dp));

        return list;
    }
}
