package piece.junction.piece;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Suzie on 24.03.18.
 */

public class ChooseItemFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_choose_item, container, false);

        ImageView chooseItemOne = (ImageView)rootView.findViewById(R.id.chooseItem1);
        chooseItemOne.setOnClickListener(buttonClick);

        ImageView chatButton = (ImageView) rootView.findViewById(R.id.chat_icon);
        chatButton.setOnClickListener(chatButtonClick);

        ImageView profileButton = (ImageView) rootView.findViewById(R.id.profile_icon);
        profileButton.setOnClickListener(profileButtonClick);

        return rootView;
    }

    View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((MainActivity)getActivity()).ReplaceFragment(new MoreInfoFragment(), MainActivity.State.MoreInfo);
        }
    };

    View.OnClickListener chatButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((MainActivity)getActivity()).ReplaceFragment(new ChatListFragment(), MainActivity.State.ChatList);
        }
    };

    View.OnClickListener profileButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((MainActivity)getActivity()).ReplaceFragment(new ProfileFragment(), MainActivity.State.Profile);
        }
    };

}
