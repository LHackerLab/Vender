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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.fragments.CarDetailsFragment;
import hacker.l.venderapp.fragments.DriversDetailsFragment;
import hacker.l.venderapp.models.Result;
import hacker.l.venderapp.utilities.CircleImageView;

/**
 * Created by lalitsingh on 03/04/18.
 */

public class DriversAdapter extends RecyclerView.Adapter<DriversAdapter.MyViewHolder> {
    private Typeface materialdesignicons_font, ProximaNovaRegular, ProximaNovaLight;
    private Context mContext;
    private List<Result> userList;
    ProgressDialog pd;

    public DriversAdapter(Context mContext, List<Result> userList) {
        this.mContext = mContext;
        this.userList = userList;
//        this.ProximaNovaRegular = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Regular.otf");
//        this.ProximaNovaLight = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Light.otf");
//        this.materialdesignicons_font = FontManager.getFontTypefaceMaterialDesignIcons(mContext, "fonts/materialdesignicons-webfont.otf");
    }

    @Override
    public DriversAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_drivers, parent, false);

        return new DriversAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DriversAdapter.MyViewHolder holder, final int position) {
        if (position % 2 == 1) {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        holder.tv_careName.setText(userList.get(position).getName());
        holder.tv_phone.setText(userList.get(position).getPhone());
        holder.tv_status.setText(userList.get(position).getStatus());
        holder.tv_carNumber.setText("Dl Number:" + userList.get(position).getDlNumber());
        holder.tv_carexpir.setText("Dl Expiry Date:" + userList.get(position).getDlExpirDate());
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
                DriversDetailsFragment fragment = DriversDetailsFragment.newInstance("", "");
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
        TextView tv_carYear, tv_careName, tv_phone, tv_carexpir, tv_delete, tv_status, tv_carNumber;
        LinearLayout linearLayout;
        CircleImageView image_car;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_car = (CircleImageView) itemView.findViewById(R.id.image_car);
            tv_careName = (TextView) itemView.findViewById(R.id.tv_careName);
            tv_carYear = (TextView) itemView.findViewById(R.id.tv_carYear);
            tv_carNumber = (TextView) itemView.findViewById(R.id.tv_carNumber);
            tv_delete = (TextView) itemView.findViewById(R.id.tv_delete);
            tv_phone = (TextView) itemView.findViewById(R.id.tv_phone);
            tv_carexpir = (TextView) itemView.findViewById(R.id.tv_carexpir);
            tv_status = (TextView) itemView.findViewById(R.id.tv_status);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}
