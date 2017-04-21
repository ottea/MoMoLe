package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.healthservices.mha.momole.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link content_lebensmittel_formular.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link content_lebensmittel_formular#newInstance} factory method to
 * create an instance of this fragment.
 */
public class content_lebensmittel_formular extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public content_lebensmittel_formular() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment content_lebensmittel_formular.
     */
    // TODO: Rename and change types and number of parameters
    public static content_lebensmittel_formular newInstance(String param1, String param2) {
        content_lebensmittel_formular fragment = new content_lebensmittel_formular();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_lebensmittel_formular, container, false);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_lebensmittel_bearbeiten);

        findViewById(R.id.button_lebensmittel_abbrechen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                finish();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //do nothing, stay on page
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(PaymentActivity.this);
                builder.setMessage(R.string.confirm_question);
                builder.setPositiveButton(R.string.yes, dialogClickListener);
                builder.setNegativeButton(R.string.no, dialogClickListener);
                builder.show();
            }
        });

        findViewById(R.id.button_lebensmittel_speichern).setOnClickListener(new View.OnClickListener() {
                                                                                @Override
                                                                                public void onClick(View v) {
                                                                                    String cat = ((TextView) findViewById(R.id.paymentInputCategory)).getText().toString();
                                                                                    String amount = ((TextView) findViewById(R.id.paymentInputAmount)).getText().toString();
                                                                                    double paid;
                                                                                    if (amount.length() > 0) {
                                                                                        try {
                                                                                            paid = Double.parseDouble(amount);
                                                                                            Payment payment = new Payment();
                                                                                            payment.setAmount(paid);
                                                                                            payment.setCategory(cat);
                                                                                            payment.setTime(System.currentTimeMillis());
                                                                                            PaymentDAO.getInstance(PaymentActivity.this).addPayment(payment);
                                                                                            Toast.makeText(PaymentActivity.this, R.string.save_payment_message, Toast.LENGTH_SHORT).show();
                                                                                            finish();
                                                                                        } catch (NumberFormatException e) {
                                                                                            Toast.makeText(PaymentActivity.this, R.string.amount_missing, Toast.LENGTH_LONG).show();
                                                                                        }
                                                                                    } else {
                                                                                        Toast.makeText(PaymentActivity.this,
                                                                                                R.string.amount_missing, Toast.LENGTH_LONG).show();
                                                                                    }
                                                                                }
                                                                            }
        );
    }
}
