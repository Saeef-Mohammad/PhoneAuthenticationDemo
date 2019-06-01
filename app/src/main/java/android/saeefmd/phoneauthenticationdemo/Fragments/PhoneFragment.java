package android.saeefmd.phoneauthenticationdemo.Fragments;


import android.os.Bundle;
import android.saeefmd.phoneauthenticationdemo.MainActivity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.saeefmd.phoneauthenticationdemo.R;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneFragment extends Fragment {


    public PhoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phone, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText mobileEt = view.findViewById(R.id.mobile_et);
        Button continueBt = view.findViewById(R.id.continue_bt);

        continueBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = mobileEt.getText().toString().trim();

                if (number.isEmpty() || number.length() < 11) {

                    mobileEt.setError(getString(R.string.number_error_message));
                    mobileEt.requestFocus();
                    return;
                }

                String phoneNumber = "+88" + number;

                Bundle bundle = new Bundle();
                bundle.putString("PHONE", phoneNumber);
                ((MainActivity) getActivity()).switchToOtpHelperFragment(bundle);
            }
        });
    }
}
