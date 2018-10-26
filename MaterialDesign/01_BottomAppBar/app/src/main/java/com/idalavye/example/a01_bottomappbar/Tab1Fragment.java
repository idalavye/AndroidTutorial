package com.idalavye.example.a01_bottomappbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Tab1Fragment extends Fragment {

    public static ListView listView;
    public static CustomAdapter customAdapter;


    public static final String TEXT = "TEXT";
    public static final String AUDIO = "AUDIO";
    public static final String IMAGE = "IMAGE";
    public static final String VIDEO = "VIDEO";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1layout, container, false);
        listView = view.findViewById(R.id.listView);

        customAdapter = new CustomAdapter(getActivity(), getArrayList());

        listView.setNestedScrollingEnabled(true);
        listView.setAdapter(customAdapter);


        return view;
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

    private String getEmoji(int unicode) {
        return new String(Character.toChars(unicode));
    }


}
