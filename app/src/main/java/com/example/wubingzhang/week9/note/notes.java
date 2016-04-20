package com.example.wubingzhang.week9.note;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wubingzhang.week9.R;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class notes extends AppCompatActivity {
    private ListView notesList;
    ArrayList<noteClass> list = new ArrayList<noteClass>();
    Button addNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        addNotes = (Button)findViewById(R.id.addNotes);
        addNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notes.this, com.example.wubingzhang.week9.note.addNotes.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });


        notesList = (ListView)findViewById(R.id.notesList);

        getData();

        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        for(int i=0;i<list.size();i++)
        {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", list.get(i).getTitle());
            map.put("ItemText", list.get(i).getContent());
            mylist.add(map);
        }

        SimpleAdapter mSchedule = new SimpleAdapter(this, //没什么解释
                mylist,//数据来源
                R.layout.notes_cell,//ListItem的XML实现

                //动态数组与ListItem对应的子项
                new String[] {"ItemTitle", "ItemText"},

                //ListItem的XML文件里面的两个TextView ID
                new int[] {R.id.noteLabel,R.id.noteContent});
        //添加并且显示
        notesList.setAdapter(mSchedule);
    }

    static class ViewHolder{
        public TextView title;
        public TextView content;
    }

    public void getData(){
        Serializable extra = getIntent().getSerializableExtra("note");
        if(extra!=null){
            noteClass note = (noteClass)extra;
            list.add(note);
        }
    }

//    public class notesAdapter extends ArrayAdapter<noteClass>{
//        View[] itemViews;
//        public notesAdapter(ArrayList<noteClass> notes){
//            super(notes.this,0, notes);
//
//            itemViews = new View[notes.size()];
//
//            for(int i=0;i<itemViews.length;i++){
//                itemViews[i]=makeItemView(notes.get(i));
//            }
//        }
//
//        private View makeItemView(noteClass note){
//            LayoutInflater inflater = (LayoutInflater)notes.
//                    this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View itemView = inflater.inflate(R.layout.notes_cell,null);
//            TextView title = (TextView)itemView.findViewById(R.id.noteLabel);
//            TextView content = (TextView)itemView.findViewById(R.id.noteContent);
//            title.setText(note.getTitle());
//            content.setText(note.getContent());
//            return itemView;
//        }
//
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null)
//                return itemViews[position];
//            return convertView;
//        }
//    }
}

