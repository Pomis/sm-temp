package pomis.app.salemoveshop.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import pomis.app.salemoveshop.R;

public class CallActivity extends AppCompatActivity {
    @BindView(R.id.v_bg)
    View vBg;

    public static void start(Context context) {
        Intent starter = new Intent(context, CallActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        vBg.animate().alpha(0.9f).setDuration(800).setStartDelay(200).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        vBg.setAlpha(0f);
    }
}
