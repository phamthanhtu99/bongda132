package web.google.api;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.auth.Credentials;
import com.google.auth.oauth2.UserCredentials;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.PhotosLibrarySettings;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse;
import com.google.photos.library.v1.proto.NewMediaItem;
import com.google.photos.library.v1.upload.UploadMediaItemRequest;
import com.google.photos.library.v1.upload.UploadMediaItemResponse;
import com.google.photos.library.v1.util.NewMediaItemFactory;


import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class googlephoto {

    private static final java.io.File CREDENTIALS_FOLDER //
            = new java.io.File(System.getProperty("user.home"), "photos");
    private static final String CLIENT_SECRET_FILE_NAME = "credentials.json";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final List<String> SCOPES = Collections.singletonList("https://www.googleapis.com/auth/photoslibrary.appendonly");
    private static Credentials getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {

        java.io.File clientSecretFilePath = new java.io.File(CREDENTIALS_FOLDER, CLIENT_SECRET_FILE_NAME);

        if (!clientSecretFilePath.exists()) {
            throw new FileNotFoundException("Please copy " + CLIENT_SECRET_FILE_NAME //
                    + " to folder: " + CREDENTIALS_FOLDER.getAbsolutePath());
        }

        // Load client secrets.
        InputStream in = new FileInputStream(clientSecretFilePath);

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        String clientId = clientSecrets.getDetails().getClientId();
        String clientSecret = clientSecrets.getDetails().getClientSecret();
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
                clientSecrets, SCOPES).setDataStoreFactory(new FileDataStoreFactory(CREDENTIALS_FOLDER))
                .setAccessType("offline").build();

        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
       return  UserCredentials.newBuilder()
               .setClientId(clientId)
               .setClientSecret(clientSecret)
               .setRefreshToken(credential.getRefreshToken())
               .build();
    }
       public  static PhotosLibraryClient connection() throws GeneralSecurityException, IOException {
           NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
           PhotosLibrarySettings settings =
                   PhotosLibrarySettings.newBuilder()
                           .setCredentialsProvider(
                                   FixedCredentialsProvider.create(getCredentials(HTTP_TRANSPORT)))
                           .build();
           try (PhotosLibraryClient photosLibraryClient =
                        PhotosLibraryClient.initialize(settings)) {
               return  photosLibraryClient;

           } catch (ApiException e) {
               System.out.println("thất bai");
           }
           return null;
       }
 public static final void uploadImgephoto() throws IOException, GeneralSecurityException {
String pathToFile = "D:\\59f9a974a6727_thumb900.jpg"; String uploadToken="";
   PhotosLibraryClient photosLibraryClient = googlephoto.connection();
   // Open the file and automatically close it after upload
   try (RandomAccessFile file = new RandomAccessFile(pathToFile, "rws")) {
       // Create a new upload request
       UploadMediaItemRequest uploadRequest =
               UploadMediaItemRequest.newBuilder()
                       // The media type (e.g. "image/png")
                       .setMimeType("image/png")
                       // The file to upload
                       .setDataFile(file)
                       .build();
       // Upload and capture the response
       UploadMediaItemResponse uploadResponse = photosLibraryClient.uploadMediaItem(uploadRequest);
       if (uploadResponse.getError().isPresent()) {
           // If the upload results in an error, handle it
           UploadMediaItemResponse.Error error = uploadResponse.getError().get();
       } else {

        uploadToken = uploadResponse.getUploadToken().get();

       }
   } catch (ApiException e) {
       // Handle error
   } catch (IOException e) {
       // Error accessing the local file
   }
     try {
         NewMediaItem newMediaItem = NewMediaItemFactory
                 .createNewMediaItem(uploadToken, "Sd", "Sdsd");
         List<NewMediaItem> newItems = Arrays.asList(newMediaItem);
         // Create new media items in a specific album
         BatchCreateMediaItemsResponse response = photosLibraryClient
                 .batchCreateMediaItems("AJbffDZe1ZaIy7e6uJOvas-O0cYqX3FugiaDeJpuvIBnasqMmgU9PPY2zefM-IReQW_IqugWmfXO", newItems);
         // Check the response
     } catch (ApiException e) {
         // Handle error
     }
}
    public static void main(String[] args) throws IOException, GeneralSecurityException {uploadImgephoto();
       /* final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        PhotosLibrarySettings settings =
                PhotosLibrarySettings.newBuilder()
                        .setCredentialsProvider(
                                FixedCredentialsProvider.create( getCredentials(HTTP_TRANSPORT)))
                        .build();
        try (PhotosLibraryClient photosLibraryClient =
                     PhotosLibraryClient.initialize(settings)) {

            // Create a new Album  with at title
            Album createdAlbum = photosLibraryClient.createAlbum("My Album");

            // Get some properties from the album, such as its ID and product URL
            String id = createdAlbum.getId();
            String url = createdAlbum.getProductUrl();
            System.out.println(id);
        } catch (ApiException e) {
            System.out.println("thất bai");
        }*/

    }
}
