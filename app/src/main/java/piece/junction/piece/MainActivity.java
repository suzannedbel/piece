package piece.junction.piece;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

public class MainActivity extends FragmentActivity {

    private static String FRAGMENT_TAG = "fragment_tag";
    Fragment fragment;

    public enum State
    {
        Splash,
        ChooseItem,
        MoreInfo,
        Chat
    }

    private State currentState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        AddSplashFragment();
        Handler handler = new Handler();
        handler.postDelayed(removeSplashFragment, 2000);
    }

    private void AddSplashFragment() {
        currentState = State.Splash;
        FragmentManager fm = getSupportFragmentManager();
        fragment = fm.findFragmentByTag(FRAGMENT_TAG);
        if (fragment == null) {
            FragmentTransaction ft = fm.beginTransaction();
            fragment = new SplashFragment();
            ft.add(R.id.frameLayout, fragment, FRAGMENT_TAG);
            ft.commit();
        }
    }

    Runnable removeSplashFragment = new Runnable() {
        @Override
        public void run() {
            ReplaceFragment(new ChooseItemFragment(), State.ChooseItem);
        }
    };

    public void ReplaceFragment(Fragment newFragment, State currentState) {
        FragmentManager fm = getSupportFragmentManager();
        fragment = fm.findFragmentByTag(FRAGMENT_TAG);
        FragmentTransaction ft = fm.beginTransaction();
        fragment = newFragment;
        ft.replace(R.id.frameLayout, fragment, FRAGMENT_TAG);
        ft.commit();
        this.currentState = currentState;
    }


    @Override
    public void onBackPressed() {

        if(currentState == State.MoreInfo)
        {
            ReplaceFragment(new ChooseItemFragment(), State.ChooseItem);
        }else{
            super.onBackPressed();
        }

    }

}