package fr.perrze.aguilleurdepaires;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SwitchmanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SwitchmanFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ClientSide clientSide;
    private ImageView view;

    public SwitchmanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SwitchmanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SwitchmanFragment newInstance(String param1, String param2) {
        SwitchmanFragment fragment = new SwitchmanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Context context = getActivity().getApplicationContext();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String serverIp= prefs.getString("ip","10.0.0.5");
        int serverPort = Integer.parseInt(prefs.getString("port","5000"));


        clientSide = new ClientSide(serverPort,serverIp);

        view = (ImageView) getView().findViewById(R.id.clmain);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_switchman, container, false);

    }


    public static Boolean decisionTree(String dataType, Object content){
        switch (dataType){
            case "MessageToUser":
                ArrayList<String> contentArray= (ArrayList<String>) content;
                String peerIp=contentArray.get(0);
                String peerId=contentArray.get(1);
                String message=contentArray.get(2);

                Snackbar.make(view.findViewById(R.id.), "Message From "+peerId+"("+peerIp+") : "+message,
                                Snackbar.LENGTH_SHORT)
                        .show();
                break;
        }
        return null;
    }
}