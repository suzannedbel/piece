package piece.junction.piece;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Suzie on 24.03.18.
 */

public class MoreInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_moreinfo, container, false);

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        boolean joinGroup = sharedPref.getBoolean(MainActivity.JOIN_GROUP, false);

        if(joinGroup)
        {
            ImageView memberCountImage = (ImageView)rootView.findViewById(R.id.member_count_image);
            memberCountImage.setVisibility(View.VISIBLE);

            LinearLayout justusLayout = (LinearLayout)rootView.findViewById(R.id.justus_profile_image);
            justusLayout.setVisibility(View.VISIBLE);
        }

        ImageView wantItemImage= (ImageView)rootView.findViewById(R.id.want_item_button);
        wantItemImage.setOnClickListener(wantItemClick);

        ImageView locationImage = (ImageView)rootView.findViewById(R.id.location_button);
        locationImage.setOnClickListener(locationClick);

        ImageView chatImage = (ImageView)rootView.findViewById(R.id.chat_icon);
        chatImage.setOnClickListener(chatButtonClick);

        return rootView;
    }

    View.OnClickListener wantItemClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((MainActivity)getActivity()).ReplaceFragment(new WantItemFragment(), MainActivity.State.WantItem);
        }
    };

    View.OnClickListener locationClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((MainActivity)getActivity()).ReplaceFragment(new LocationFragment(), MainActivity.State.Location);
        }
    };

    View.OnClickListener chatButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((MainActivity)getActivity()).ReplaceFragment(new ChatListFragment(), MainActivity.State.ChatList);
        }
    };



}
