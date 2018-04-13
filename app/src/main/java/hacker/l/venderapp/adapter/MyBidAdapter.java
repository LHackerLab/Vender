package hacker.l.venderapp.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.models.Result;

/**
 * Created by lalitsingh on 03/04/18.
 */

public class MyBidAdapter extends RecyclerView.Adapter<MyBidAdapter.MyViewHolder> {
    private Typeface materialdesignicons_font, ProximaNovaRegular, ProximaNovaLight;
    private Context mContext;
    private List<Result> userList;
    ProgressDialog pd;

    public MyBidAdapter(Context mContext, List<Result> userList) {
        this.mContext = mContext;
        this.userList = userList;
//        this.ProximaNovaRegular = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Regular.otf");
//        this.ProximaNovaLight = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Light.otf");
//        this.materialdesignicons_font = FontManager.getFontTypefaceMaterialDesignIcons(mContext, "fonts/materialdesignicons-webfont.otf");
    }

    @Override
    public MyBidAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_my_bid, parent, false);

        return new MyBidAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyBidAdapter.MyViewHolder holder, final int position) {
        if (position % 2 == 1) {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        holder.tv_tripType.setText(userList.get(position).getTripType());
        holder.tv_price.setText("\u20B9" + userList.get(position).getPrice());
        holder.tv_date.setText(userList.get(position).getDate());
        holder.tv_tripName.setText(userList.get(position).getTripName());
        holder.tv_cabtype.setText(userList.get(position).getCabtype());
        holder.tv_cabName.setText(userList.get(position).getCabName());
        holder.tv_time.setText(userList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tripType, tv_price, tv_date, tv_tax, tv_tripName, tv_cabtype, tv_cabName, tv_clear, tv_time;
        LinearLayout linearLayout;
        Switch switch_block;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_tripType = (TextView) itemView.findViewById(R.id.tv_tripType);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            tv_clear = (TextView) itemView.findViewById(R.id.tv_clear);
            tv_tax = (TextView) itemView.findViewById(R.id.tv_tax);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            tv_tripName = (TextView) itemView.findViewById(R.id.tv_tripName);
            tv_cabtype = (TextView) itemView.findViewById(R.id.tv_cabtype);
            tv_cabName = (TextView) itemView.findViewById(R.id.tv_cabName);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}
