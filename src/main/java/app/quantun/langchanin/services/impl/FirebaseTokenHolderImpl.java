package app.quantun.langchanin.services.impl;

import app.quantun.langchanin.services.FirebaseTokenHolder;
import com.google.firebase.auth.FirebaseToken;
import lombok.extern.slf4j.Slf4j;

//@Service
@Slf4j
public class FirebaseTokenHolderImpl implements FirebaseTokenHolder {

    private final FirebaseToken firebaseToken;

    public FirebaseTokenHolderImpl(FirebaseToken firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    @Override
    public String getUid() {
        return firebaseToken.getUid();
    }
}
