package pomis.app.salemoveshop.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.placeholderview.PlaceHolderView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pomis.app.salemoveshop.R;
import pomis.app.salemoveshop.placeholders.DayHolder;
import pomis.app.salemoveshop.placeholders.EmptyDayHolder;
import pomis.app.salemoveshop.placeholders.GoodHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PurchaseFragment extends Fragment {


    @BindView(R.id.phv_purchases)
    PlaceHolderView phvPurchases;
    Unbinder unbinder;

    public PurchaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_purchase, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList();
    }

    private void initList() {
        phvPurchases.getBuilder()
                .setHasFixedSize(false)
                .setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        phvPurchases.addView(new EmptyDayHolder(0));
        phvPurchases.addView(new EmptyDayHolder(31));
        phvPurchases.addView(new EmptyDayHolder(1));
        ArrayList<GoodHolder> goods1 = new ArrayList<>();
        goods1.add(new GoodHolder("Tuc Onion", "KONSUM Narva mnt", getActivity()));
        goods1.add(new GoodHolder("Eggs", "KONSUM Narva mnt", getActivity()));
        phvPurchases.addView(new DayHolder(2, goods1));
        phvPurchases.addView(new EmptyDayHolder(3));
        phvPurchases.addView(new EmptyDayHolder(4));
        phvPurchases.addView(new EmptyDayHolder(5));
        phvPurchases.addView(new EmptyDayHolder(6));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
