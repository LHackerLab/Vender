package hacker.l.venderapp.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.models.Result;

/**
 * Created by lalitsingh on 03/04/18.
 */

public class AvailabilityAdapter extends RecyclerView.Adapter<AvailabilityAdapter.MyViewHolder> {
    private Typeface materialdesignicons_font, ProximaNovaRegular, ProximaNovaLight;
    private Context mContext;
    private List<Result> userList;
    ProgressDialog pd;

    public AvailabilityAdapter(Context mContext, List<Result> userList) {
        this.mContext = mContext;
        this.userList = userList;
//        this.ProximaNovaRegular = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Regular.otf");
//        this.ProximaNovaLight = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Light.otf");
//        this.materialdesignicons_font = FontManager.getFontTypefaceMaterialDesignIcons(mContext, "fonts/materialdesignicons-webfont.otf");
    }

    @Override
    public AvailabilityAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_availlability, parent, false);

        return new AvailabilityAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AvailabilityAdapter.MyViewHolder holder, final int position) {
        if (position % 2 == 1) {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#C7C7CC"));
        } else {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#44d8d27e"));
        }
        holder.tv_carYear.setText(userList.get(position).getCarModel());
        holder.tv_careName.setText(userList.get(position).getCabName());
        holder.tv_carNumber.setText("Vehicle Number:"+userList.get(position).getCarNumber());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_carYear, tv_careName, tv_carNumber, tv_avality;
        LinearLayout linearLayout;
        ImageView image_car;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_car = (ImageView) itemView.findViewById(R.id.image_car);
            tv_careName = (TextView) itemView.findViewById(R.id.tv_careName);
            tv_carYear = (TextView) itemView.findViewById(R.id.tv_carYear);
            tv_carNumber = (TextView) itemView.findViewById(R.id.tv_carNumber);
            tv_avality = (TextView) itemView.findViewById(R.id.tv_avality);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}
