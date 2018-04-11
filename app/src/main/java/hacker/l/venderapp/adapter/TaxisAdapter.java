package hacker.l.venderapp.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.fragments.CarDetailsFragment;
import hacker.l.venderapp.models.Result;
import hacker.l.venderapp.utilities.CircleImageView;

/**
 * Created by lalitsingh on 03/04/18.
 */

public class TaxisAdapter extends RecyclerView.Adapter<TaxisAdapter.MyViewHolder> {
    private Typeface materialdesignicons_font, ProximaNovaRegular, ProximaNovaLight;
    private Context mContext;
    private List<Result> userList;
    ProgressDialog pd;

    public TaxisAdapter(Context mContext, List<Result> userList) {
        this.mContext = mContext;
        this.userList = userList;
//        this.ProximaNovaRegular = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Regular.otf");
//        this.ProximaNovaLight = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Light.otf");
//        this.materialdesignicons_font = FontManager.getFontTypefaceMaterialDesignIcons(mContext, "fonts/materialdesignicons-webfont.otf");
    }

    @Override
    public TaxisAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_taxis, parent, false);

        return new TaxisAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaxisAdapter.MyViewHolder holder, final int position) {
        if (position % 2 == 1) {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        holder.tv_carYear.setText(userList.get(position).getCarModel());
        holder.tv_careName.setText(userList.get(position).getCabName());
        holder.tv_carType.setText(userList.get(position).getCabtype());
        holder.tv_rs.setText("Rs." + userList.get(position).getRs());
        holder.tv_carNumber.setText("Vehicle Number:" + userList.get(position).getCarNumber());
        holder.tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Delete Your Data", Toast.LENGTH_SHORT).show();
                userList.remove(position);
            }
        });
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarDetailsFragment fragment = CarDetailsFragment.newInstance("", "");
                moveFragment(fragment);
            }
        });
    }

    private void moveFragment(Fragment fragment) {
        FragmentManager fragmentManager = ((FragmentActivity) mContext).getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_carYear, tv_careName, tv_rs, tv_carType, tv_delete, tv_carNumber;
        LinearLayout linearLayout;
        CircleImageView image_car;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_car = (CircleImageView) itemView.findViewById(R.id.image_car);
            tv_careName = (TextView) itemView.findViewById(R.id.tv_careName);
            tv_carYear = (TextView) itemView.findViewById(R.id.tv_carYear);
            tv_carNumber = (TextView) itemView.findViewById(R.id.tv_carNumber);
            tv_delete = (TextView) itemView.findViewById(R.id.tv_delete);
            tv_rs = (TextView) itemView.findViewById(R.id.tv_rs);
            tv_carType = (TextView) itemView.findViewById(R.id.tv_carType);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}
