package proj.mokrab.mediaparkassignment.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import proj.mokrab.mediaparkassignment.Model.Car;
import proj.mokrab.mediaparkassignment.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private List<Car> carList;
    private Context mContext;


    public RecyclerViewAdapter(Context mContext, List<Car> carList) {
        this.carList = carList;
        this.mContext = mContext;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView imageName;
        RelativeLayout relativeLayoutListItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.ImageView_photo);
            imageName = itemView.findViewById(R.id.TextView_photo_name);
            relativeLayoutListItem = itemView.findViewById(R.id.relative_layout_listitem);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        //Image placement suing Uri, if not showing, check here
        Glide.with(mContext)
                .asBitmap()
                .load(carList.get(position).getModel().getPhotoUrl())
                .into(holder.image);

        holder.imageName.setText(carList.get(position).getPlateNumber());

        holder.relativeLayoutListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on. ");
                Toast.makeText(mContext, carList.get(position).getModel().getTitle(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return carList.size();

    }

    public void updateList(List<Car> list){
        carList = list;
        notifyDataSetChanged();
    }



}
