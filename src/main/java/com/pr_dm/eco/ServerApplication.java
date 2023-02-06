package com.pr_dm.eco;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.ExportedUserRecord;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.ListUsersPage;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.auth.UserRecord.UpdateRequest;
import com.google.firebase.database.*;

@SpringBootApplication
public class ServerApplication {

    public static void getUserById(String uid) throws InterruptedException, ExecutionException {
        UserRecord userRecord = FirebaseAuth.getInstance().getUserAsync(uid).get();
        System.out.println("Successfully fetched user data: " + userRecord.getUid());
    }

    public static void getUserByEmail(String email) throws InterruptedException, ExecutionException {
        UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmailAsync(email).get();
        System.out.println("Successfully fetched user data: " + userRecord.getEmail());
    }

    public static void getUserByPhoneNumber(
            String phoneNumber) throws InterruptedException, ExecutionException {
        UserRecord userRecord = FirebaseAuth.getInstance().getUserByPhoneNumberAsync(phoneNumber).get();
        System.out.println("Successfully fetched user data: " + userRecord.getPhoneNumber());
    }

    public static void createUser() throws InterruptedException, ExecutionException {
        CreateRequest request = new CreateRequest()
                .setEmail("user@example.com")
                .setEmailVerified(false)
                .setPassword("secretPassword")
                .setPhoneNumber("+11234567890")
                .setDisplayName("John Doe")
                .setPhotoUrl("http://www.example.com/12345678/photo.png")
                .setDisabled(false);

        UserRecord userRecord = FirebaseAuth.getInstance().createUserAsync(request).get();
        System.out.println("Successfully created new user: " + userRecord.getUid());
    }

    public static void createUserWithUid() throws InterruptedException, ExecutionException {
        CreateRequest request = new CreateRequest()
                .setUid("some-uid")
                .setEmail("user@example.com")
                .setPhoneNumber("+11234567890");

        UserRecord userRecord = FirebaseAuth.getInstance().createUserAsync(request).get();
        System.out.println("Successfully created new user: " + userRecord.getUid());
    }

    public static void updateUser(String uid) throws InterruptedException, ExecutionException {
        UpdateRequest request = new UpdateRequest(uid)
                .setEmail("user@example.com")
                .setPhoneNumber("+11234567890")
                .setEmailVerified(true)
                .setPassword("newPassword")
                .setDisplayName("Jane Doe")
                .setPhotoUrl("http://www.example.com/12345678/photo.png")
                .setDisabled(true);

        UserRecord userRecord = FirebaseAuth.getInstance().updateUserAsync(request).get();
        System.out.println("Successfully updated user: " + userRecord.getUid());
    }

    public static void setCustomUserClaims(
            String uid) throws InterruptedException, ExecutionException {
        // Set admin privilege on the user corresponding to uid.
        Map<String, Object> claims = new HashMap<>();
        claims.put("admin", true);
        FirebaseAuth.getInstance().setCustomUserClaimsAsync(uid, claims).get();
        // The new custom claims will propagate to the user's ID token the
        // next time a new one is issued.

        String idToken = "id_token";
        // Verify the ID token first.
        FirebaseToken decoded = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get();
        if (Boolean.TRUE.equals(decoded.getClaims().get("admin"))) {
            // Allow access to requested admin resource.
        }

        // Lookup the user associated with the specified uid.
        UserRecord user = FirebaseAuth.getInstance().getUserAsync(uid).get();
        System.out.println(user.getCustomClaims().get("admin"));
    }

    public static void setCustomUserClaimsScript() throws InterruptedException, ExecutionException {
        UserRecord user = FirebaseAuth.getInstance()
                .getUserByEmailAsync("user@admin.example.com").get();
        // Confirm user is verified.
        if (user.isEmailVerified()) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("admin", true);
            FirebaseAuth.getInstance().setCustomUserClaimsAsync(user.getUid(), claims).get();
        }
    }

    public static void setCustomUserClaimsInc() throws InterruptedException, ExecutionException {
        UserRecord user = FirebaseAuth.getInstance()
                .getUserByEmailAsync("user@admin.example.com").get();
        // Add incremental custom claim without overwriting the existing claims.
        Map<String, Object> currentClaims = user.getCustomClaims();
        if (Boolean.TRUE.equals(currentClaims.get("admin"))) {
            // Add level.
            currentClaims.put("level", 10);
            // Add custom claims for additional privileges.
            FirebaseAuth.getInstance().setCustomUserClaimsAsync(user.getUid(), currentClaims).get();
        }
    }

    public static void listAllUsers() throws InterruptedException, ExecutionException {
        // Start listing users from the beginning, 1000 at a time.
        ListUsersPage page = FirebaseAuth.getInstance().listUsersAsync(null).get();
        while (page != null) {
            for (ExportedUserRecord user : page.getValues()) {
                System.out.println("User: " + user.getUid());
            }
            page = page.getNextPage();
        }

        // Iterate through all users. This will still retrieve users in batches,
        // buffering no more than 1000 users in memory at a time.
        page = FirebaseAuth.getInstance().listUsersAsync(null).get();
        for (ExportedUserRecord user : page.iterateAll()) {
            System.out.println("User: " + user.getUid());
        }
    }

    public static void deleteUser(String uid) throws InterruptedException, ExecutionException {
        FirebaseAuth.getInstance().deleteUserAsync(uid).get();
        System.out.println("Successfully deleted user.");
    }

    public static void createCustomToken() throws InterruptedException, ExecutionException {
        String uid = "some-uid";

        String customToken = FirebaseAuth.getInstance().createCustomTokenAsync(uid).get();
        // Send token back to client
        System.out.println("Created custom token: " + customToken);
    }

    public static void createCustomTokenWithClaims() throws InterruptedException, ExecutionException {
        String uid = "some-uid";
        Map<String, Object> additionalClaims = new HashMap<String, Object>();
        additionalClaims.put("premiumAccount", true);

        String customToken = FirebaseAuth.getInstance()
                .createCustomTokenAsync(uid, additionalClaims).get();
        // Send token back to client
        System.out.println("Created custom token: " + customToken);
    }

    public static void verifyIdToken(String idToken) throws InterruptedException, ExecutionException {
        // idToken comes from the client app (shown above)
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get();
        String uid = decodedToken.getUid();
        System.out.println("Decoded ID token from user: " + uid);
    }

    public static void verifyIdTokenCheckRevoked(String idToken) throws InterruptedException, ExecutionException {
        try {
            // Verify the ID token while checking if the token is revoked by passing
            // checkRevoked
            // as true.
            boolean checkRevoked = true;
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken, checkRevoked).get();
            // Token is valid and not revoked.
            String uid = decodedToken.getUid();
        } catch (ExecutionException e) {
            if (e.getCause() instanceof FirebaseAuthException) {
                FirebaseAuthException authError = (FirebaseAuthException) e.getCause();
                if (authError.getErrorCode().equals("id-token-revoked")) {
                    // Token has been revoked. Inform the user to reauthenticate or signOut() the
                    // user.
                } else {
                    // Token is invalid.
                }
            }
        }
    }

    public static void revokeIdTokens(String idToken) throws InterruptedException, ExecutionException {
        String uid = "someUid";
        FirebaseAuth.getInstance().revokeRefreshTokensAsync(uid).get();
        UserRecord user = FirebaseAuth.getInstance().getUserAsync(uid).get();
        // Convert to seconds as the auth_time in the token claims is in seconds too.
        long revocationSecond = user.getTokensValidAfterTimestamp() / 1000;
        System.out.println("Tokens revoked at: " + revocationSecond);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("metadata/" + uid);
        Map<String, Object> userData = new HashMap<>();
        userData.put("revokeTime", revocationSecond);
        ref.setValueAsync(userData).get();

    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        try {
            FileInputStream serviceAccount = new FileInputStream("firebase_service_account.secret.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            System.out.println("ERROR: invalid service account credentials. See README.");
            System.out.println(e.getMessage());

            System.exit(1);
        }
        System.out.println("[ServerApplication] Server successfully started.");
        try {
            // Smoke test
            createUserWithUid();
            getUserById("some-uid");
            getUserByEmail("user@example.com");
            getUserByPhoneNumber("+11234567890");
            updateUser("some-uid");
            // setCustomUserClaims("some-uid");
            listAllUsers();
            deleteUser("some-uid");
            createCustomToken();
            createCustomTokenWithClaims();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR: Test failed");
            System.out.println(e.getMessage());
    
            System.exit(1);
        }
        System.out.println("All tests passed!");
    }

}
