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

public class WantItemFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_want_item, container, false);

        ImageView joinImage = (ImageView)rootView.findViewById(R.id.join_button);
        joinImage.setOnClickListener(joiOnClick);

        return rootView;
    }

    View.OnClickListener joiOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((MainActivity)getActivity()).ReplaceFragment(new JoinFragmentDialog(), MainActivity.State.Join);
        }
    };

}
