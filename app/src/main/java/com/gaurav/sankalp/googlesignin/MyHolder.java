package com.gaurav.sankalp.googlesignin;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by gourav on 4/24/2018.
 */

public class MyHolder {

    TextView nametxt;
    TextView presenttxt;
    TextView totaltext;
    TextView percenttxt;
    public MyHolder(View itemView) {


        nametxt= (TextView) itemView.findViewById(R.id.rolltext);
        presenttxt=itemView.findViewById(R.id.presenttext);
        totaltext= (TextView) itemView.findViewById(R.id.totaltext);
        percenttxt=itemView.findViewById(R.id.percenttext);
    }
}
