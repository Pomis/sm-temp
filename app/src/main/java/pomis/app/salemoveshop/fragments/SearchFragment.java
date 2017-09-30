package pomis.app.salemoveshop.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxSearchView;
import com.mindorks.placeholderview.PlaceHolderView;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pomis.app.salemoveshop.R;
import pomis.app.salemoveshop.placeholders.CategoryHolder;
import pomis.app.salemoveshop.placeholders.GoodHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    @BindView(R.id.met_search)
    MaterialEditText metSearch;
    @BindView(R.id.phv_categories)
    PlaceHolderView phvCategories;
    Unbinder unbinder;
    ArrayList<GoodHolder> allGoods;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initCategoryList();
        initSearch();
    }

    private void initSearch() {
        metSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    phvCategories.removeAllViews();
                    phvCategories.refresh();
                    for (GoodHolder holder : allGoods) {
                        if (holder.name.toLowerCase().contains(charSequence.toString().toLowerCase()))
                            phvCategories.addView(holder);
                    }
                    phvCategories.refresh();

                } else {
                    initCategoryList();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    private void initCategoryList() {
        phvCategories.removeAllViews();
        phvCategories.refresh();
        phvCategories.getBuilder().setLayoutManager(new GridLayoutManager(getActivity(), 1));

        allGoods = new ArrayList<>();
        ArrayList<GoodHolder> foodList = new ArrayList<>();
        foodList.add(new GoodHolder("Carrot", "5 shops", R.drawable.morkva, getActivity()));
        foodList.add(new GoodHolder("Soda", "5 shops", R.drawable.soda, getActivity()));
        foodList.add(new GoodHolder("€1.3 - €2.6", "Eggs", "5 shops", "Eggs are laid by female animals of many different species, including birds, reptiles, amphibians ... Chickens and other egg-laying creatures are widely kept throughout the world, and mass production of chicken eggs is a global industry.", R.drawable.bg_eggs, getActivity()));
//        foodList.add(new GoodHolder("HP Elitebook G4", "3 shops", getActivity()));
//        foodList.add(new GoodHolder("Macbook Pro 2014 Retina 13''", "2 shops", getActivity()));
        foodList.add(new GoodHolder("Tuc Bakon", "5 shops", getActivity()));
        foodList.add(new GoodHolder("€1.4 - €2.5 ", "Tuc Onion", "3 shops", "Good cookies", R.drawable.bg_tuc, getActivity()));
        phvCategories.addView(new CategoryHolder("Food", "32 goods • 12 shops", getActivity(), foodList, phvCategories, R.drawable.foods));
        phvCategories.addView(new CategoryHolder("Computers", "19 goods • 4 shops", getActivity(), R.drawable.computers));

        ArrayList<GoodHolder> appliancesList = new ArrayList<>();
        appliancesList.add(new GoodHolder("€45 - €225", "Microwave oven", "3 shops", "A microwave oven is a kitchen appliance that heats and cooks food by exposing it to electromagnetic radiation in the microwave frequency range. ", R.drawable.bg_oven, getActivity()));
        appliancesList.add(new GoodHolder("Blender", "2 shops", R.drawable.blender, getActivity()));
        appliancesList.add(new GoodHolder("Coffee machine", "4 shops", R.drawable.coffee_blender, getActivity()));
        appliancesList.add(new GoodHolder("Pan", "4 shops", R.drawable.pan, getActivity()));
        appliancesList.add(new GoodHolder("Mixer", "4 shops", R.drawable.mixer, getActivity()));
        appliancesList.add(new GoodHolder("Dryer", "7 shops", R.drawable.dryer, getActivity()));
        appliancesList.add(new GoodHolder("Fan", "5 shops", R.drawable.fan, getActivity()));
        appliancesList.add(new GoodHolder("Cooker", "4 shops", R.drawable.cooker, getActivity()));
        appliancesList.add(new GoodHolder("Toaster", "6 shops", R.drawable.toaster, getActivity()));
        allGoods.addAll(appliancesList);
        phvCategories.addView(new CategoryHolder("Appliances", "10 goods • 5 shops", getActivity(), appliancesList, phvCategories, R.drawable.appliances));
        phvCategories.addView(new CategoryHolder("Medicine", "36 goods • 8 shops"));
        phvCategories.addView(new CategoryHolder("For garden", "21 goods • 6 shops"));
        phvCategories.addView(new CategoryHolder("Houseware", "15 goods • 7 shops"));
        phvCategories.addView(new CategoryHolder("Other", "17 goods • 9 shops"));

        allGoods.addAll(foodList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
