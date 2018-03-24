package piece.junction.piece;

import android.app.ActionBar;
import android.os.Debug;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Window;

import piece.junction.piece.dummy.DummyContent;

public class MainActivity extends FragmentActivity implements ChatFragment.OnListFragmentInteractionListener {

    private static String FRAGMENT_TAG = "fragment_tag";
    public static String JOIN_GROUP = "join_group";
    Fragment fragment;

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
    }

    public enum State
    {
        Splash,
        ChooseItem,
        MoreInfo,
        ChatList,
        Chat,
        WantItem,
        Profile,
        Location,
        Ticket,
        Join
    }

    private State currentState;
    private State previousState;

    boolean hasAddedMember = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        AddSplashFragment();
        Handler handler = new Handler();
        handler.postDelayed(removeSplashFragment, 5000);
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

    public void ReplaceFragment(Fragment newFragment, State state) {

        if(currentState == State.ChooseItem || currentState == State.MoreInfo)
        {
            previousState = currentState;
        }
        FragmentManager fm = getSupportFragmentManager();
        fragment = fm.findFragmentByTag(FRAGMENT_TAG);
        FragmentTransaction ft = fm.beginTransaction();
        fragment = newFragment;
        ft.replace(R.id.frameLayout, fragment, FRAGMENT_TAG);
        ft.commit();
        this.currentState = state;
    }

    @Override
    public void onBackPressed() {
        if(currentState == State.MoreInfo)
        {
            ReplaceFragment(new ChooseItemFragment(), State.ChooseItem);
        }else if(currentState == State.Profile)
        {
            ReplaceFragment(new ChooseItemFragment(), State.ChooseItem);
        }else if(currentState == State.ChatList)
        {
            ReplacePreviousState();
        }else if(currentState == State.Chat)
        {
            ReplaceFragment(new ChatListFragment(), State.ChatList);
        }else if(currentState == State.WantItem)
        {
            ReplaceFragment(new MoreInfoFragment(), State.MoreInfo);
        }else if(currentState == State.Location)
        {
            ReplaceFragment(new MoreInfoFragment(), State.MoreInfo);
        }
        else if(currentState == State.Ticket)
        {
            ReplaceFragment(new ProfileFragment(), State.Profile);
        }
        else{
            super.onBackPressed();
        }
    }

    private void ReplacePreviousState()
    {
        if(previousState == State.ChooseItem)
        {
            ReplaceFragment(new ChooseItemFragment(), State.ChooseItem);
        }else if(previousState == State.MoreInfo)
        {
            ReplaceFragment(new MoreInfoFragment(), State.MoreInfo);
        }
    }

}
