package web.google.api;


import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class createFolders {

    public static final File createGoogleFolder(String folderIdParent, String folderName) throws IOException, GeneralSecurityException {

        File fileMetadata = new File();

        fileMetadata.setName(folderName);
        fileMetadata.setMimeType("application/vnd.google-apps.folder");

        if (folderIdParent != null) {
            List<String> parents = Arrays.asList(null);
            parents.add("TEST-FOLDER");
            fileMetadata.setParents(parents).setName("");
        }
        Drive driveService = GoogleDriveUtils.getDriveService();

        // Create a Folder.
        // Returns File object with id & name fields will be assigned values
        File file = driveService.files().create(fileMetadata).setFields("id, name").execute();

        return file;
    }

    public static void main(String[] args) throws IOException, GeneralSecurityException {

        // Create a Root Folder
        File folder = createGoogleFolder(null, "TEST-FOLDER");

        System.out.println("Created folder with id= " + folder.getId());
        System.out.println("                    name= " + folder.getName());

        System.out.println("Done!");
    }
}