package app.quantun.langchanin.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
@Slf4j
public class FirebaseConfig {

    @Value("${firebase.service-account.path}")
    private String serviceAccountPath;

    @Autowired
    private ResourceLoader resourceLoader;

    private  InputStream getServiceAccount() throws IOException {
        Resource resource = resourceLoader.getResource(serviceAccountPath);
        return resource.getInputStream();
    }

    @Primary
    @Bean
    public FirebaseApp firebaseInit() throws IOException {


        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(this.getServiceAccount()))
                .build();

        return FirebaseApp.initializeApp(options);
    }

    @Bean
    public Firestore getDatabase() throws IOException {


        FirestoreOptions firestoreOptions = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(this.getServiceAccount())).build();
        return firestoreOptions.getService();
    }

}
