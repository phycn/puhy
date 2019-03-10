package cn.puhy.common;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipUtil {

    /**
     * 解压文件
     *
     * @param zipFile
     * @return
     * @throws IOException
     */
    public static String unzip(String zipFile) throws IOException {
        String unzipPath = zipFile.split("\\.")[0];
        OutputStream os = null;
        try (ZipArchiveInputStream is = new ZipArchiveInputStream(new BufferedInputStream
                (new FileInputStream(zipFile), 1024))) {
            ZipArchiveEntry entry;
            while ((entry = is.getNextZipEntry()) != null) {
                if (entry.isDirectory()) {
                    File directory = new File(unzipPath, entry.getName());
                    directory.mkdirs();
                } else {
                    Path entryPath = Paths.get(unzipPath, entry.getName());
                    if (Files.notExists(entryPath.getParent())) {
                        Files.createDirectories(entryPath.getParent());
                    }
                    os = new BufferedOutputStream(new FileOutputStream(entryPath.toFile()), 1024);
                    IOUtils.copy(is, os);
                    os.close();
                }
            }
        } finally {
            if (os != null) {
                os.close();
            }
        }
        return unzipPath;
    }
}
