package wordmemory.idalavye.com.expandablelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static wordmemory.idalavye.com.expandablelist.R.drawable.ic_android_black_24dp;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> list;
    private HashMap<String, Contacto> expandableListDetailes;

    public CustomExpandableListAdapter(Context context, List<String> list, HashMap<String, Contacto> expandableListDetailes) {
        this.context = context;
        this.list = list;
        this.expandableListDetailes = expandableListDetailes;
    }

    @Override
    public int getGroupCount() {
        return this.list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.expandableListDetailes.get(this.list.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String nombre = (String) getGroup(groupPosition);
        Contacto contacto = (Contacto) getChild(groupPosition, 0);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }

        TextView txtNombre = convertView.findViewById(R.id.tw1);
        TextView txtNumero = convertView.findViewById(R.id.tw2);

        txtNombre.setText(nombre);
        txtNumero.setText(contacto.getNumero());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Contacto contacto = (Contacto) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        System.out.println(contacto.getImg());
        CircleImageView circleImageView = convertView.findViewById(R.id.circleimage);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), contacto.getImg());
        circleImageView.setImageResource(contacto.getImg());

        LinearLayout l1 = convertView.findViewById(R.id.linearLayout1);
        LinearLayout l2 = convertView.findViewById(R.id.linearLayout2);
        LinearLayout l3 = convertView.findViewById(R.id.linearLayout3);
        LinearLayout l4 = convertView.findViewById(R.id.linearLayout4);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "asdfasf", Toast.LENGTH_SHORT).show();
            }
        });

        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        convertView.startAnimation(animation);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
