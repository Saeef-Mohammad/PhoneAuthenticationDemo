package android.saeefmd.phoneauthenticationdemo;

import android.os.Bundle;
import android.saeefmd.phoneauthenticationdemo.Fragments.OTPFragment;
import android.saeefmd.phoneauthenticationdemo.Fragments.PhoneFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchToPhoneFragment();
    }

    private void switchToPhoneFragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PhoneFragment()).commit();
    }

    private void switchToOtpFragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new OTPFragment()).addToBackStack(null).commit();
    }

    public void switchToOtpHelperFragment(Bundle bundle) {
        if (bundle == null) {
            switchToOtpFragment();
        } else {
            OTPFragment otpHelperFragment = new OTPFragment();
            otpHelperFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, otpHelperFragment).addToBackStack(null).commit();
        }
    }
}
