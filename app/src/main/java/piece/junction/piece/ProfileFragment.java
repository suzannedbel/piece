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

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        ImageView ticketImage = (ImageView)rootView.findViewById(R.id.ticket_button);
        ticketImage.setOnClickListener(ticketButtonClick);

        return rootView;
    }

    View.OnClickListener ticketButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((MainActivity)getActivity()).ReplaceFragment(new TicketFragment(), MainActivity.State.Ticket);
        }
    };

}
