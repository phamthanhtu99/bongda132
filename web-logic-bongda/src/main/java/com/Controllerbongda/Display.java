package com.Controllerbongda;

import com.google.api.services.drive.Drive;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import web.google.api.GoogleDriveUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller(value = "image")
public class Display {
    @GetMapping(value = "/repository/{id}")
    public @ResponseBody
    byte[] getImage(@PathVariable("id") String id) throws IOException {
        Drive driveService = GoogleDriveUtils.getDriveService();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        driveService.files().get(id)
                .executeMediaAndDownloadTo(outputStream);
        byte[] rs = outputStream.toByteArray();
        return rs;
    }
}
