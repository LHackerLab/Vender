package hacker.l.venderapp.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hacker.l.venderapp.R;
import hacker.l.venderapp.models.Result;

/**
 * Created by lalitsingh on 03/04/18.
 */

public class OpenBookingAdapter extends RecyclerView.Adapter<OpenBookingAdapter.MyViewHolder> {
    private Typeface materialdesignicons_font, ProximaNovaRegular, ProximaNovaLight;
    private Context mContext;
    private List<Result> userList;
    ProgressDialog pd;

    public OpenBookingAdapter(Context mContext, List<Result> userList) {
        this.mContext = mContext;
        this.userList = userList;
//        this.ProximaNovaRegular = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Regular.otf");
//        this.ProximaNovaLight = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Light.otf");
//        this.materialdesignicons_font = FontManager.getFontTypefaceMaterialDesignIcons(mContext, "fonts/materialdesignicons-webfont.otf");
    }

    @Override
    public OpenBookingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_opne_booking, parent, false);

        return new OpenBookingAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OpenBookingAdapter.MyViewHolder holder, final int position) {
        if (position % 2 == 1) {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        holder.tv_tripType.setText(userList.get(position).getTripType());
        holder.tv_distance.setText(userList.get(position).getDistance() + "KMs");
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
        TextView tv_tripType, tv_distance, tv_date, tv_tripName, tv_cabtype, tv_cabName, tv_time;
        LinearLayout linearLayout;
        Switch switch_block;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_tripType = (TextView) itemView.findViewById(R.id.tv_tripType);
            tv_distance = (TextView) itemView.findViewById(R.id.tv_distance);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            tv_tripName = (TextView) itemView.findViewById(R.id.tv_tripName);
            tv_cabtype = (TextView) itemView.findViewById(R.id.tv_cabtype);
            tv_cabName = (TextView) itemView.findViewById(R.id.tv_cabName);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}
