package com.pr_dm.eco.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Configuration
public class FirebaseConfig {

    public FirebaseConfig() {
        try {
            FileInputStream serviceAccount = new FileInputStream("firebase_service_account.secret.json");
            FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            System.out.println("ERROR: invalid service account credentials.");
            System.out.println(e.getMessage());

            System.exit(1);
        }
    }

}
