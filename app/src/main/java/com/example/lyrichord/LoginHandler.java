package com.example.lyrichord;

import androidx.appcompat.app.AppCompatActivity;

abstract public class LoginHandler extends AppCompatActivity {
    protected Boolean validation;
    protected Boolean fbValidation = false;

    abstract public Boolean fieldValidation();
    abstract public void firebaseValidation();
    abstract public void toDashboard();

    public final void login(){
        if(fieldValidation()){
            firebaseValidation();
            if(fbValidation){
                toDashboard();
            }
        }
    }
}
