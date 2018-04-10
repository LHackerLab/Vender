package hacker.l.venderapp.adapter;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.models.Result;

/**
 * Created by lalitsingh on 03/04/18.
 */

public class TripManagerAdapter extends RecyclerView.Adapter<TripManagerAdapter.MyViewHolder> {
    private Typeface materialdesignicons_font, ProximaNovaRegular, ProximaNovaLight;
    private Context mContext;
    private List<Result> userList;
    ProgressDialog pd;

    public TripManagerAdapter(Context mContext, List<Result> userList) {
        this.mContext = mContext;
        this.userList = userList;
//        this.ProximaNovaRegular = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Regular.otf");
//        this.ProximaNovaLight = FontManager.getFontTypeface(mContext, "fonts/ProximaNova-Light.otf");
//        this.materialdesignicons_font = FontManager.getFontTypefaceMaterialDesignIcons(mContext, "fonts/materialdesignicons-webfont.otf");
    }

    @Override
    public TripManagerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tripmanager, parent, false);

        return new TripManagerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TripManagerAdapter.MyViewHolder holder, final int position) {
        if (position % 2 == 1) {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        holder.tv_name.setText("Name:" + userList.get(position).getName());
        holder.tv_phone.setText(userList.get(position).getPhone());
        holder.tv_phoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String phone = userList.get(position).getPhone();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone));//change the number
                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                mContext.startActivity(callIntent);

            }
        });
        holder.image_whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                mContext.startActivity(launchIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_phone, tv_phoneIcon, tv_avality;
        LinearLayout linearLayout;
        ImageView image_whatsapp;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_whatsapp = (ImageView) itemView.findViewById(R.id.image_whatsapp);
            tv_phone = (TextView) itemView.findViewById(R.id.tv_phone);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_phoneIcon = (TextView) itemView.findViewById(R.id.tv_phoneIcon);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}
