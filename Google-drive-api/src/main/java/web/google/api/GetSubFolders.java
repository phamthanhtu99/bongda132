package web.google.api;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetSubFolders {

    // com.google.api.services.drive.model.File
    public static final List<File> getGoogleSubFolders(String googleFolderIdParent) throws IOException {

        Drive driveService = GoogleDriveUtils.getDriveService();

        String pageToken = null;
        List<File> list = new ArrayList<File>();

        String query = null;
        if (googleFolderIdParent == null) {
            query = " mimeType = 'application/vnd.google-apps.folder' " //
                    + " and 'root' in parents";
        } else {
            query = " mimeType = 'application/vnd.google-apps.folder' " //
                    + " and '" + googleFolderIdParent + "' in parents";
        }

        do {
            FileList result = driveService.files().list().setQ(query).setSpaces("drive") //
                    // Fields will be assigned values: id, name, createdTime
                    .setFields("nextPageToken, files(id, name, createdTime)")//
                    .setPageToken(pageToken).execute();
            for (File file : result.getFiles()) {
                list.add(file);
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        //
        return list;
    }
    public  static  final List<File> Folder(String name) throws IOException {
        String pageToken = null;
        Drive drive = GoogleDriveUtils.getDriveService();
        List<File> lists =new ArrayList<>();
        String query=  " name = '" + name + "' " //
                + " and mimeType = 'application/vnd.google-apps.folder' " //
                + " and 'root' in parents";

        do {
            FileList result = drive.files().list()
                    .setQ(query)
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id, name)")
                    .setPageToken(pageToken)
                    .execute();
            pageToken=result.getNextPageToken();
            for (File item: result.getFiles()){
               lists.add(item);
            }
        }
        while (pageToken!=null);

      return lists;
    }
    // com.google.api.services.drive.model.File
    public static final List<File> getGoogleRootFolders() throws IOException {
        return getGoogleSubFolders(null);
    }

    public static final String FolderID(String name) throws IOException {
        String ID=null ;
        List<File> googleRootFolders = Folder(name);
        for (File file: googleRootFolders){
            ID =file.getId();
        }
        return  ID;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(FolderID("java"));

    }

}