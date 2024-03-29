package id.tugas.grocissmark2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gvGallery;
    private GridBaseAdapter gridBaseAdapter;
    private ArrayList<img_model_home> imageModelArrayList;

    private int[] myImageList = new int[]{R.drawable.ai, R.drawable.an,
            R.drawable.au,R.drawable.dw
            ,R.drawable.id,R.drawable.lr,
            R.drawable.pr,R.drawable.ps,R.drawable.xd};
    private String[] myImageNameList = new String[]{"Illustrator", "Animate",
            "Audition","DreamWeaver"
            ,"InDesign","Lightroom",
            "Premiere Pro","Photoshop","XD"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gvGallery = findViewById(R.id.gv);

        imageModelArrayList = populateList();

        gridBaseAdapter = new GridBaseAdapter(getApplicationContext(),imageModelArrayList);
        gvGallery.setAdapter(gridBaseAdapter);

        gvGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, myImageNameList[position]+" Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private ArrayList<img_model_home> populateList(){

        ArrayList<img_model_home> list = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            img_model_home imageModel = new img_model_home();
            imageModel.setName(myImageNameList[i]);
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;
    }
}
