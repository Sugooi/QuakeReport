package com.adil.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * Created by adil on 2/21/2017.
 */

 public class QuakeAdapter extends ArrayAdapter<QuakeList> {
    private Context context;

    public QuakeAdapter(Activity context, ArrayList<QuakeList> quakes)
    {super(context,0,quakes);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        View listItemView =convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.quake_activity, parent, false);
        }
        final QuakeList currentQuake= getItem(position);
        TextView magView = (TextView) listItemView.findViewById(R.id.mag);
        DecimalFormat Decformat = new DecimalFormat("0.0");
        String formatted = Decformat.format(currentQuake.getMagnitude());
        magView.setText(formatted);
        TextView placeView = (TextView) listItemView.findViewById(R.id.city);
        TextView subplaceView = (TextView) listItemView.findViewById(R.id.subcity);




        final String root = currentQuake.getCityName();

        if(root.contains("of"))
        {String[] sub = root.split("of");
            String ploc= sub[0] + "of";
            String loc =sub[1];
            placeView.setText(ploc);
            subplaceView.setText(loc);
        }
       else
        {String ploc ="Near ";
            placeView.setText(ploc);
            subplaceView.setText(root);
        }


      GradientDrawable magnitudeCircle = (GradientDrawable) magView.getBackground();
       int magnitudeColor = getMagnitudeColor(currentQuake.getMagnitude());

        //Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(currentQuake.getDate());
         TextView subDateView = (TextView) listItemView.findViewById(R.id.subDate);
      String hell = currentQuake.getSubDate();
       subDateView.setText(hell);

        LinearLayout click = (LinearLayout) listItemView.findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = currentQuake.getUrl();
                Intent intent = new Intent(getContext(),WebActivity.class);
                intent.putExtra("url",url);
                intent.putExtra("place",root);
                context.startActivity(intent);
            }
        });

        return  listItemView;
    }


    public int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor( getContext() , magnitudeColorResourceId);

    }
}

