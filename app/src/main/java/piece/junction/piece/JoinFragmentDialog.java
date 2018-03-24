package piece.junction.piece;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Suzie on 25.03.18.
 */

public class JoinFragmentDialog extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dialog_join, container, false);

        ImageView okImage = (ImageView)rootView.findViewById(R.id.ok_button);
        okImage.setOnClickListener(okOnClick);

        return rootView;
    }

    View.OnClickListener okOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean(MainActivity.JOIN_GROUP, true);
            editor.commit();
            ((MainActivity)getActivity()).ReplaceFragment(new MoreInfoFragment(), MainActivity.State.MoreInfo);
        }
    };

}
