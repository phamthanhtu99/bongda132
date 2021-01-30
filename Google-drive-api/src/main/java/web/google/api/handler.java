package web.google.api;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.PhotosLibrarySettings;
import com.google.photos.library.v1.upload.UploadMediaItemRequest;
import com.google.photos.library.v1.upload.UploadMediaItemResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class handler {




    public static final void upload () throws IOException {
        Drive driveService =GoogleDriveUtils.getDriveService();
        File fileMetadata = new File();
        List<String> files=new ArrayList<String>();
        List<File> parents = GetSubFoldersByName.getGoogleRootFoldersByName("TEST-FOLDER");
        for(File item:parents){
            files.add(item.getId());
        }

        fileMetadata.setParents(files).setName("IMG_20200228_164222.jpg");
        java.io.File filePath = new java.io.File("D:\\bài tập\\pts\\IMG_20200228_164222.jpg");
        FileContent mediaContent = new FileContent("image/jpeg", filePath);
        File file = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();
        System.out.println("File ID: " + file.getId());
    }

    public static final String uploadImge(java.io.File file,String Folder,String name) throws IOException {
        String FolderID=GetSubFolders.FolderID(Folder);
        Drive driveService =GoogleDriveUtils.getDriveService();
        File fileMetadata = new File();
        fileMetadata.setParents(Collections.singletonList(FolderID));
        fileMetadata.setName(name);
        List<String> files=new ArrayList<String>();
        FileContent mediaContent = new FileContent("image/jpeg", file);
        File file2 = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();
        return file2.getId();
    }

    public  static  final Object[] file(MultipartFile multipartFile){
        CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) multipartFile;
        FileItem fileItem = commonsMultipartFile.getFileItem();
        DiskFileItem diskFileItem = (DiskFileItem) fileItem;
        String nameFile= diskFileItem.getName();
        String absPath = diskFileItem.getStoreLocation().getAbsolutePath();
        java.io.File file = new java.io.File(absPath);
        return new Object[]{file,nameFile};
    }
    public static final String uploadImgephoto(java.io.File filel,String Folder,String name) throws IOException, GeneralSecurityException {

        PhotosLibraryClient photosLibraryClient = googlephoto.connection();
        // Open the file and automatically close it after upload
        try (RandomAccessFile file = new RandomAccessFile("D:\\bài tập\\New folder\\Computer-printed-Photo-background-children-wedding-Photography-backdrops-for-Photographic-studio-emulational-wood-plank-D-7443.jpg", "rw")) {
            // Create a new upload request

            UploadMediaItemRequest uploadRequest =
                    UploadMediaItemRequest.newBuilder()
                            .setMimeType("image/jpg").setFileName("haha")
                            .setDataFile(file)
                            .build();
            photosLibraryClient.uploadMediaItem(uploadRequest);


        } catch (ApiException e) {
            // Handle error
        } catch (IOException e) {
            // Error accessing the local file
        }
        return "";
    }

    public static String handleImge(MultipartFile multipartFile,String Folder ) throws IOException {
        Object[] objects = file(multipartFile);
         java.io.File file = (java.io.File) objects[0];
        String name = (String) objects[1];
        return  uploadImge(file,Folder,name);
    }
    public static String handleImgephoto(MultipartFile multipartFile,String Folder ) throws IOException, GeneralSecurityException {
        Object[] objects = file(multipartFile);
        java.io.File file = (java.io.File) objects[0];
        String name = (String) objects[1];
        return  uploadImge(file,Folder,name);
    }
    public static void main(String[] args) throws IOException, GeneralSecurityException {

        // Create a Root Folder
        upload();
    }
}
