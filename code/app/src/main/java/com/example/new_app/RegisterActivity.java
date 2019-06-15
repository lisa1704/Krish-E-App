package com.example.new_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextPhone,editTextCode;
FirebaseAuth mAuth;
String codeSent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
mAuth=FirebaseAuth.getInstance();

        editTextCode=findViewById(R.id.editTextCode);
        editTextPhone=findViewById(R.id.editTextPhone);

        findViewById(R.id.buttonVerifyCode).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                sendVerificationCode();

            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                verifySignInCode();
            }}
        );

        }


private void verifySignInCode()
{
    String code =editTextCode.getText().toString();
    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
    signInWithPhoneAuthCredential(credential);
}

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                                  Toast.makeText(getApplicationContext(),
                                          "Login Successful",Toast.LENGTH_LONG).show();


                        } else {
                            if(task.getException() instanceof FirebaseAuthInvalidCredentialsException)
                            {
                                Toast.makeText(getApplicationContext(),
                                        "Incorrect Verification Code",Toast.LENGTH_LONG).show();
                            }

                            }
                        }
                    });
                }

private void sendVerificationCode()
{
    String phone=editTextPhone.getText().toString();
    if(phone.isEmpty())
    {
        editTextPhone.setError("Phone number is required");
        editTextPhone.requestFocus();
        return;
    }
    if(phone.length()<10)
    {
        editTextPhone.setError("Enter a valid ph");
        editTextPhone.requestFocus();
        return;
    }
    PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phone,        // Phone number to verify
            60,                 // Timeout duration
            TimeUnit.SECONDS,   // Unit of timeout
            this,               // Activity (for callback binding)
            mCallbacks);        // OnVerificationStateChangedCallbacks
}

PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
    @Override
    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

    }

    @Override
    public void onVerificationFailed(FirebaseException e) {

    }

    @Override
    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        super.onCodeSent(s, forceResendingToken);
        codeSent =s;
    }
};












}
