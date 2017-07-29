package com.example.ravinderreddy.viewpager26;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.ravinderreddy.viewpager26.R.id.frame_one_lv;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FliperFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FliperFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FliperFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private String[] params = new String[]{"One","Two","Three","Four","Five","Six","Service"};
    private String[] eyeColors= new String[]{"White","Black","Orange","yellow","Green","Blue","Cyan"};
    Context context;
    private List<String> buttonsList = new ArrayList<>();
    public FliperFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1
     * @return A new instance of fragment FliperFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FliperFragment newInstance(String param1) {
        FliperFragment fragment = new FliperFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mParam1.equals("1")) {
            View view  = inflater.inflate(R.layout.frame_one, container, false);
            Button btOne  = view.findViewById(R.id.fragment_one_bt_one);
            ListView listView = view.findViewById(frame_one_lv);
            final FrameOneAdapter   frameOneAdapter = new FrameOneAdapter(getContext(),buttonsList);
            listView.setAdapter(frameOneAdapter);
            btOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                    alertDialog.setItems(params, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (!buttonsList.contains(params[i])) {
                                buttonsList.add(params[i]);
                                frameOneAdapter.notifyDataSetChanged();
                            }
                        }
                    });
                    alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    alertDialog.show();
                }
            });
            return view;
        }
        else if (mParam1.equals("2")) {
            View view  = inflater.inflate(R.layout.frame_two, container, false);
            Button btOne  = view.findViewById(R.id.fragment_one_bt_one);
            ListView listView = view.findViewById(frame_one_lv);
            final FrameOneAdapter   frameOneAdapter = new FrameOneAdapter(getContext(),buttonsList);
            listView.setAdapter(frameOneAdapter);
            btOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                    alertDialog.setItems(eyeColors, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (!buttonsList.contains(eyeColors[i])) {
                                buttonsList.add(eyeColors[i]);
                                frameOneAdapter.notifyDataSetChanged();
                            }
                        }
                    });
                    alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    alertDialog.show();
                }
            });
            return view;
        } else if (mParam1.equals("3")) {
            View view  = inflater.inflate(R.layout.frame_three, container, false);
            final Button button  = view.findViewById(R.id.frame_three_one);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(((ColorDrawable)button.getBackground()).getColor() == getActivity().getColor(R.color.hash)){
                            button.setBackgroundColor(Color.BLUE);
                    }else{
                        button.setBackgroundColor(getActivity().getColor(R.color.hash));
                    }
                }
            });
                    final Button button2  = view.findViewById(R.id.frame_three_two);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(((ColorDrawable)button2.getBackground()).getColor() == getActivity().getColor(R.color.hash)){
                        button2.setBackgroundColor(Color.BLUE);
                    }else{
                        button2.setBackgroundColor(getActivity().getColor(R.color.hash));
                    }
                }
            });
           final Button button3  = view.findViewById( R.id.frame_three_three);
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(((ColorDrawable)button3.getBackground()).getColor() == getActivity().getColor(R.color.hash)){
                        button3.setBackgroundColor(Color.BLUE);
                    }else{
                        button3.setBackgroundColor(getActivity().getColor(R.color.hash));
                    }                }
            });
            return view;
        }else {
            View view  = inflater.inflate(R.layout.frame_four, container, false);
            return view;
        }
    }

    private void showToast(String one) {
        Toast.makeText(getActivity(), one, Toast.LENGTH_SHORT).show();
    }

    private void fragment_one_ll_click(View view) {
        Toast.makeText(getActivity(), "Hello one fragment!", Toast.LENGTH_SHORT).show();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
