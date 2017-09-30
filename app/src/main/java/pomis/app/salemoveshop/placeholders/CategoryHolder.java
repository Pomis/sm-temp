package pomis.app.salemoveshop.placeholders;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.widget.ImageView;
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

    public int bg;

    @View(R.id.tv_row_category_name)
    transient private TextView tvName;

    @View(R.id.tv_row_category_count)
    transient private TextView tvDescription;

    @View(R.id.iv_row_background)
    transient private ImageView ivBg;


    transient PlaceHolderView phv;

    public CategoryHolder(String name, String descr) {
        this.name = name;
        this.descr = descr;
    }

    public CategoryHolder(String name, String descr, Context context, ArrayList<GoodHolder> goods,
                          PlaceHolderView phv, int background) {
        this.name = name;
        this.descr = descr;
        this.context = context;
        this.goods = goods;
        this.phv = phv;
        this.bg = background;
    }

    public CategoryHolder(String name, String descr, Context context, int bg) {
        this.name = name;
        this.descr = descr;
        this.context = context;
        this.bg = bg;
    }

    @Resolve
    void onResolve() {
        tvName.setText(name);
        if (bg!=0) ivBg.setImageDrawable(context.getResources().getDrawable(bg));
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
