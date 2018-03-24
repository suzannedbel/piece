package piece.junction.piece;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ChatListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_chat_list, container, false);

        ImageView chatImage = (ImageView)rootView.findViewById(R.id.chatImage);
        chatImage.setOnClickListener(onClickChat);

        return rootView;
    }

    View.OnClickListener onClickChat = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((MainActivity)getActivity()).ReplaceFragment(new ChatFragment(), MainActivity.State.Chat);
        }
    };



}
