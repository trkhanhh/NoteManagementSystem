package com.example.notemanagementsystem_01.ui.changepassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.notemanagementsystem_01.R;

public class ChangePasswordFragment extends Fragment {

    private ChangePasswordViewModel changePasswordViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        changePasswordViewModel =
                new ViewModelProvider(this).get(ChangePasswordViewModel.class);
        View root = inflater.inflate(R.layout.fragment_changepassword, container, false);
        final TextView textView1 = root.findViewById(R.id.TextView1);
        final EditText edtCurrentPassword = root.findViewById(R.id.EditTextCurrentPassword);
        final EditText edtNewPassword = root.findViewById(R.id.EditTextNewPassword);
        final EditText edtConfirmPassword = root.findViewById(R.id.EditTextConfirmPasswordcp);
        changePasswordViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }
}