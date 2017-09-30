package pomis.app.salemoveshop.placeholders;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.widget.TextView;

import com.mindorks.placeholderview.Animation;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.ArrayList;

import pomis.app.salemoveshop.R;

@Layout(R.layout.item_category)
@Animate(Animation.SCALE_UP_ASC)
public class CategoryHolder {

    public String name;

    public String descr;

    public Context context;

    public ArrayList<GoodHolder> goods;

    @View(R.id.tv_row_category_name)
    transient private TextView tvName;

    @View(R.id.tv_row_category_count)
    transient private TextView tvDescription;

    transient PlaceHolderView phv;

    public CategoryHolder(String name, String descr) {
        this.name = name;
        this.descr = descr;
    }

    public CategoryHolder(String name, String descr, Context context, ArrayList<GoodHolder> goods, PlaceHolderView phv) {
        this.name = name;
        this.descr = descr;
        this.context = context;
        this.goods = goods;
        this.phv = phv;
    }

    @Resolve
    void onResolve() {
        tvName.setText(name);

        tvDescription.setText(descr);
    }

    @Click(R.id.rl_category)
    void onClick() {
        phv.removeAllViews();
        phv.refresh();
        phv.getBuilder().setLayoutManager(new GridLayoutManager(context, 2));
        for (GoodHolder good : goods) {
            phv.addView(good);
        }
        phv.refresh();

    }

}
