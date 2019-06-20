package id.tugas.grocissmark2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class GridBaseAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private Context ctx;
    private ArrayList<img_model_home> imageModelArrayList;
    private ImageView img_HomeGrid;
    private TextView txt_view_home;

    public GridBaseAdapter(Context ctx, ArrayList<img_model_home> imageModelArrayList) {

        this.ctx = ctx;
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public int getCount() {
        return imageModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.grid_item_home, parent, false);

        img_HomeGrid = (ImageView) itemView.findViewById(R.id.img_HomeGrid);
        txt_view_home = (TextView) itemView.findViewById(R.id.txt_view_home);

        img_HomeGrid.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        txt_view_home.setText(imageModelArrayList.get(position).getName());

        return itemView;
    }
}
