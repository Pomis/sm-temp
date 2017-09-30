package pomis.app.salemoveshop.placeholders;

import android.widget.TextView;

import com.mindorks.placeholderview.Animation;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import pomis.app.salemoveshop.R;

@Layout(R.layout.item_purchase)
@Animate(Animation.SCALE_UP_ASC)
public class EmptyDayHolder {

    public int day;

    @View(R.id.tv_row_date)
    transient TextView tvDate;


    public EmptyDayHolder(int day) {
        this.day = day;
    }

    @Resolve
    void onResolve() {
        tvDate.setText(day==0?"Today":String.valueOf(day));

    }

}
