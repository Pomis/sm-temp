package pomis.app.salemoveshop.fragments;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pomis.app.salemoveshop.App;
import pomis.app.salemoveshop.R;
import pomis.app.salemoveshop.activities.CallActivity;
import pomis.app.salemoveshop.placeholders.GoodHolder;

import static android.view.View.GONE;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {
    GoodHolder goodHolder;
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.tv_cost)
    TextView tvCost;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    Unbinder unbinder;
    @BindView(R.id.b_order)
    Button bOrder;
    @BindView(R.id.tv_selected)
    TextView tvSelected;
    @BindView(R.id.ll_days)
    LinearLayout llDays;

    public OverviewFragment(GoodHolder goodHolder) {
        this.goodHolder = goodHolder;
    }

    public OverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        readModel();
    }

    private void readModel() {
        if (goodHolder.backgroundImage != 0)
            ivPhoto.setImageDrawable(getActivity().getResources().getDrawable(goodHolder.backgroundImage));
        if (goodHolder.cost != null) tvCost.setText(goodHolder.cost);
        if (goodHolder.full_descr != null) tvDescription.setText(goodHolder.full_descr);
        bOrder.setOnClickListener((v) -> {
            new Thread(() -> {
                final Context context = getActivity().getApplication().getApplicationContext();
                try {
                    Thread.sleep(3500);
                    CallActivity.start(context);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });
        if (!goodHolder.name.equals("Eggs"))
            llDays.setVisibility(GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.ll_days)
    void onClick() {
        tvSelected.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        tvSelected.setTextColor(getResources().getColor(R.color.colorWhite));
    }
}
