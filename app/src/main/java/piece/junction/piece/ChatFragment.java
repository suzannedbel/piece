package piece.junction.piece;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Suzie on 25.03.18.
 */

public class ChatFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);

        ImageView dashBoardImage = (ImageView)rootView.findViewById(R.id.dashboard_icon);
        dashBoardImage.setOnClickListener(onClickDashboard);

        return rootView;
    }

    View.OnClickListener onClickDashboard = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((MainActivity)getActivity()).ReplaceFragment(new MoreInfoFragment(), MainActivity.State.MoreInfo);
        }
    };


}
