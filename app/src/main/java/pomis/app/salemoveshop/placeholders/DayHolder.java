package pomis.app.salemoveshop.placeholders;

import android.widget.TextView;

import com.mindorks.placeholderview.Animation;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.ArrayList;

import pomis.app.salemoveshop.R;

@Layout(R.layout.item_purchase_not_empty)
@Animate(Animation.SCALE_UP_ASC)
public class DayHolder {

    public int day;

    @View(R.id.tv_row_date)
    transient TextView tvDate;

    @View(R.id.phv_purhases)
    transient PlaceHolderView phvPurhases;

    ArrayList<GoodHolder> goodHolders;

    public DayHolder(int day, ArrayList<GoodHolder> goodHolders) {
        this.day = day;
        this.goodHolders = goodHolders;
    }

    @Resolve
    void onResolve() {
        tvDate.setText(day==0?"Today":String.valueOf(day));
        for (GoodHolder holder : goodHolders) {
            phvPurhases.addView(holder);
        }
    }



}
