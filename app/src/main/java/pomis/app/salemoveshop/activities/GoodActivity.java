package pomis.app.salemoveshop.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pomis.app.salemoveshop.R;
import pomis.app.salemoveshop.fragments.OverviewFragment;
import pomis.app.salemoveshop.fragments.PurchaseFragment;
import pomis.app.salemoveshop.fragments.SearchFragment;
import pomis.app.salemoveshop.placeholders.GoodHolder;

public class GoodActivity extends AppCompatActivity {

    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private TextView mTextMessage;
    GoodHolder goodHolder;
    public Fragment currentFragment;


    public static void start(Context context, GoodHolder holder) {
        Intent starter = new Intent(context, GoodActivity.class);
        starter.putExtra("holder", holder);
        context.startActivity(starter);
    }

    void readIntent() {
        goodHolder = (GoodHolder) getIntent().getSerializableExtra("holder");

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            selectFragment(item.getItemId());
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);
        ButterKnife.bind(this);
        readIntent();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        selectFragment(R.id.navigation_home);
    }

    void selectFragment(int id) {
        clearViews();
        FragmentTransaction fTrans = getFragmentManager().beginTransaction();
        if (currentFragment != null)
            fTrans.detach(currentFragment);
        switch (id) {
            case R.id.navigation_home:
                currentFragment = new OverviewFragment(goodHolder);
                break;
            case R.id.nav_purchases:
                currentFragment = new PurchaseFragment();
                break;

        }
        fTrans.add(R.id.content, currentFragment, "current");
        fTrans.commit();

    }



    private void clearViews() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (getFragmentManager().findFragmentByTag("current") != null)
            transaction.detach(getFragmentManager().findFragmentByTag("current"));
        transaction.commit();
        content.removeAllViews();
        currentFragment = null;
    }
}
