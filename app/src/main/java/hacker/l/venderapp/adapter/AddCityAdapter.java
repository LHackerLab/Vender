package hacker.l.venderapp.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.models.Result;

/**
 * Created by lalitsingh on 03/04/18.
 */

public class AddCityAdapter extends RecyclerView.Adapter<AddCityAdapter.MyViewHolder> implements Filterable {
    private Typeface materialdesignicons_font, ProximaNovaRegular, ProximaNovaLight;
    private Context mContext;
    private List<Result> dataList, FilteruserList;
    ProgressDialog pd;

    public AddCityAdapter(Context mContext, List<Result> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
        this.FilteruserList = dataList;
//        this.ProximaNovaRegular = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Regular.otf");
//        this.ProximaNovaLight = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Light.otf");
//        this.materialdesignicons_font = FontManager.getFontTypefaceMaterialDesignIcons(mContext, "fonts/materialdesignicons-webfont.otf");
    }

    @Override
    public AddCityAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_add_city, parent, false);

        return new AddCityAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AddCityAdapter.MyViewHolder holder, final int position) {
        if (position % 2 == 1) {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        holder.tv_cityName.setText(FilteruserList.get(position).getCityName());
    }

    @Override
    public int getItemCount() {
        return FilteruserList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString().trim();
                // name match condition. this might differ depending on your requirement
                // here we are looking for name or phone number match
                if (charString.isEmpty()) {
                    FilteruserList = dataList;
                } else {
                    List<Result> filteredList = new ArrayList<>();
                    for (Result row : dataList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getCityName().toLowerCase().trim().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }


                    FilteruserList = filteredList;
                }


                FilterResults filterResults = new FilterResults();
                filterResults.values = FilteruserList;
                return filterResults;
            }


            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                FilteruserList = (ArrayList<Result>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_cityName;
        LinearLayout linearLayout;
        ImageView image_car;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_cityName = (TextView) itemView.findViewById(R.id.tv_cityName);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}
