package piece.junction.piece;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Suzie on 24.03.18.
 */

public class ChooseItemFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_choose_item, container, false);

        LinearLayout scrollViewLayout = (LinearLayout)rootView.findViewById(R.id.choose_item_scrollview);

        for(int i = 0; i < 10; i++){
            ImageButton imageButton = new ImageButton(getActivity());
            imageButton.setImageResource(R.mipmap.ic_launcher);
            imageButton.setOnClickListener(buttonClick);
            scrollViewLayout.addView(imageButton);
        }

        return rootView;
    }

    View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((MainActivity)getActivity()).ReplaceFragment(new SplashFragment());
        }
    };

}
