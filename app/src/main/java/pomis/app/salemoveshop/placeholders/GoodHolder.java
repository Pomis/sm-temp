package pomis.app.salemoveshop.placeholders;

import android.content.Context;
import android.support.annotation.IntegerRes;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.Animation;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.io.Serializable;
import java.util.ArrayList;

import pomis.app.salemoveshop.R;
import pomis.app.salemoveshop.activities.GoodActivity;

@Layout(R.layout.item_good)
@Animate(Animation.SCALE_UP_ASC)

public class GoodHolder implements Serializable {
    public String cost;

    public String name;

    public String descr;

    public String full_descr;

    public GoodHolder(String cost, String name, String descr, String full_descr, int backgroundImage, Context context) {
        this.cost = cost;
        this.name = name;
        this.descr = descr;
        this.full_descr = full_descr;
        this.backgroundImage = backgroundImage;
        this.context = context;
    }

    public int backgroundImage;

    transient Context context;

    @View(R.id.tv_row_category_name)
    transient private TextView tvName;

    @View(R.id.tv_row_descr)
    transient private TextView tvDescription;

    @View(R.id.iv_row_background)
    transient private ImageView ivBackground;

    public GoodHolder(String name, String descr, Context context) {
        this.name = name;
        this.descr = descr;
        this.context = context;

    }

    public GoodHolder(String name, String descr, int backgroundImage, Context context) {
        this.name = name;
        this.descr = descr;
        this.backgroundImage = backgroundImage;
        this.context = context;

    }

    @Resolve
    void onResolve() {
        tvName.setText(name);

        tvDescription.setText(descr);

        if (backgroundImage != 0)
            ivBackground.setImageDrawable(context.getResources().getDrawable(backgroundImage));
    }

    @Click(R.id.rl_good)
    void onClick() {
        GoodActivity.start(context, this);
    }
}
