package pomis.app.salemoveshop.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    }

    private void initCategoryList() {
        ArrayList<GoodHolder> foodList = new ArrayList<>();
        foodList.add(new GoodHolder("Carrot", "5 shops", getActivity()));
        foodList.add(new GoodHolder("Soda", "5 shops", getActivity()));
        foodList.add(new GoodHolder("€1.3 - €2.6", "Eggs", "5 shops", "Eggs are laid by female animals of many different species, including birds, reptiles, amphibians ... Chickens and other egg-laying creatures are widely kept throughout the world, and mass production of chicken eggs is a global industry." ,R.drawable.bg_eggs, getActivity()));
        foodList.add(new GoodHolder("HP Elitebook G4", "3 shops", getActivity()));
        foodList.add(new GoodHolder("Macbook Pro 2014 Retina 13''", "2 shops", getActivity()));
        foodList.add(new GoodHolder("Tuc Bakon", "5 shops", getActivity()));
        foodList.add(new GoodHolder("€1.4 - €2.5 ", "Tuc Onion", "3 shops", "Good cookies" ,R.drawable.bg_tuc, getActivity()));

        phvCategories.addView(new CategoryHolder("Food", "12 shops", getActivity(), foodList, phvCategories));
        phvCategories.addView(new CategoryHolder("Computers", "4 shops"));
        phvCategories.addView(new CategoryHolder("Appliances", "5 shops"));
        phvCategories.addView(new CategoryHolder("Medicine", "8 shops"));
        phvCategories.addView(new CategoryHolder("For garden", "6 shops"));
        phvCategories.addView(new CategoryHolder("Houseware", "7 shops"));
        phvCategories.addView(new CategoryHolder("Other", "9 shops"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
