package cn.puhy.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileUtil {

    public static void main(String[] args) throws IOException {
        System.out.println(getFileSuffix("1212"));
    }

    /**
     * 获取文件后缀名
     *
     * @param fileName
     * @return
     */
    public static String getFileSuffix(String fileName) {
        String[] arrays = fileName.split("\\.");
        return arrays.length == 1 ? "" : arrays[1];
    }

    /**
     * 获取文件后缀名
     *
     * @param file
     * @return
     */
    public static String getFileSuffix(File file) {
        String fileName = file.getName();
        return getFileSuffix(fileName);
    }

    /**
     * 获取绝对路径中的文件名
     *
     * @param absolutePath
     * @return
     */
    public static String getFileName(String absolutePath) {
        Path source = Paths.get(absolutePath);
        return source.getFileName().toString();
    }

    /**
     * 拷贝文件到指定目录，文件名不变
     *
     * @param sourceAbsolutePath
     * @param targetDir
     * @throws IOException
     */
    public static void copyFile(String sourceAbsolutePath, String targetDir) throws IOException {
        Path source = Paths.get(sourceAbsolutePath);
        Files.copy(source, Paths.get(targetDir, getFileName(sourceAbsolutePath)));
    }

    /**
     * 拷贝文件到指定目录，指定文件名
     *
     * @param sourceAbsolutePath
     * @param targetDir
     * @param targetFileName
     * @throws IOException
     */
    public static void copyFile(String sourceAbsolutePath, String targetDir, String targetFileName) throws IOException {
        String targetFileSuffix = FileUtil.getFileSuffix(targetFileName);
        String sourceFileSuffix = FileUtil.getFileSuffix(sourceAbsolutePath);
        if (StringUtil.isBlank(targetFileSuffix)) {
            targetFileName = targetFileName + "." + sourceFileSuffix;
        }
        Path source = Paths.get(sourceAbsolutePath);
        Files.copy(source, Paths.get(targetDir, targetFileName));
    }

    /**
     * 移动文件
     *
     * @param sourceAbsolutePath
     * @param targetDir
     * @throws IOException
     */
    public static void moveFile(String sourceAbsolutePath, String targetDir) throws IOException {
        String fileName = getFileName(sourceAbsolutePath);
        Files.move(Paths.get(sourceAbsolutePath), Paths.get(targetDir, fileName));
    }

    /**
     * 获取目录下所有指定文件类型的文件
     *
     * @param dir
     * @param fileType
     * @return
     * @throws IOException
     */
    public static List<String> getAllFileByType(String dir, String fileType) {
        File[] files = new File(dir).listFiles();
        return Arrays.stream(Objects.requireNonNull(files))
                .filter(file -> !file.isDirectory() && fileType.equals(getFileSuffix(file)))
                .map(File::getAbsolutePath)
                .collect(Collectors.toList());
    }

    /**
     * 获取目录下所有指定文件类型的文件,包括子目录
     *
     * @param dir
     * @param fileType
     * @return
     */
    public static List<String> getAllFileByTypeRecursion(String dir, String fileType) throws IOException {
        final List<String> imageList = new ArrayList<>();
        //遍历目录
        Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                String fileAbsoluteName = file.toString();
                if (fileType.equals(getFileSuffix(fileAbsoluteName))) {
                    imageList.add(fileAbsoluteName);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return imageList;
    }
}
