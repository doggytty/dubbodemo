package org.doggytty.utils.io;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.Arrays;


public final class CIOUtils {

    public CIOUtils() {
        throw new AssertionError("CIOUtils is final class!");
    }

    public static boolean deleteRecursive(File file) throws FileNotFoundException {
        boolean result = true;
        if (!file.exists()) {
            return true;
        } else {
            if (file.isDirectory()) {
                File[] fileList = file.listFiles();
                if (fileList != null) {
                    for (File subFile : fileList) {
                        result = result && deleteRecursive(subFile);
                    }
                }
            }
            return result && file.delete();
        }
    }

    public static void copyFromURL(URL url, File file) throws IOException {
        if (url == null) {
            throw new IOException("Missing input resource!");
        } else {
            if (file.exists()) {
                Files.delete(file.toPath());
            }

            InputStream io = url.openStream();
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[1024];

            int size;
            while ((size = io.read(buffer)) != -1) {
                fos.write(buffer, 0, size);
            }

            fos.close();
            io.close();
            file.setReadOnly();
            file.setReadable(true, false);

        }
    }

    public static void copyFile(File srcFile, File destFile) throws IOException {
        destFile.getParentFile().mkdirs();
        destFile.delete();
        destFile.createNewFile();
        FileChannel srcFileChannel = (new FileInputStream(srcFile)).getChannel();
        FileChannel destFileChannel = (new FileOutputStream(destFile)).getChannel();
        if (destFileChannel != null && srcFileChannel != null) {
            destFileChannel.transferFrom(srcFileChannel, 0L, srcFileChannel.size());
        }

        if (srcFileChannel != null) {
            srcFileChannel.close();
        }

        if (destFileChannel != null) {
            destFileChannel.close();
        }

        if (srcFile.canExecute()) {
            destFile.setExecutable(true, false);
        }

        if (!srcFile.canWrite()) {
            destFile.setReadOnly();
        }

        destFile.setReadable(true, false);
    }

    public static long getFolderSize(File file) {
        long var1 = 0L;
        File[] files = file.listFiles();
        if (files != null) {
            File[] subFiles = files;
            int fileLength = files.length;

            for (int i = 0; i < fileLength; ++i) {
                File subFile = subFiles[i];
                if (subFile.isDirectory()) {
                    var1 += getFolderSize(subFile);
                } else {
                    var1 += subFile.length();
                }
            }
        }

        return var1;
    }

    public static void run(String cmdString, File file, boolean var2) throws IOException {
        if (file != null && file.exists()) {
            ProcessBuilder var3 = new ProcessBuilder(new String[]{cmdString, file.getName()});
            var3 = var3.directory(file.getParentFile());
            exec(var3, var2);
        }

    }

    public static void exec(ProcessBuilder builder, boolean var1) throws IOException {
        exec(builder, var1, false);
    }

    public static void exec(ProcessBuilder builder, boolean var1, boolean var2) throws IOException {
        exec(builder, var1, var2, (PrintStream) null);
    }

    public static void exec(ProcessBuilder builder, boolean var1, boolean var2, PrintStream var3) throws IOException {
        builder.redirectErrorStream(true);
        Process var4 = builder.start();
        InputStreamReader var5 = new InputStreamReader(var4.getInputStream());
        BufferedReader var6 = new BufferedReader(var5);

        String var7;
        while ((var7 = var6.readLine()) != null) {
            if (var3 != null) {
                var3.print(var7);
            } else if (var1) {
            } else {
            }
        }

        try {
            int var8 = var4.waitFor();
            if (var8 != 0 && (!var2 || var8 == 127)) {
                throw new IOException("Exec failed with code " + var8 + " command [" + Arrays.toString(builder.command().toArray(new String[0])) + " in " + (builder.directory() != null ? builder.directory().getAbsolutePath() : "unspecified directory"));
            }
        } catch (InterruptedException var9) {
            ;
        }

    }

    public static boolean isNotSymbolicLink(File var0) {
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            return true;
        } else {
            try {
                if (var0 == null || var0.getParent() == null) {
                    return false;
                }

                File var1 = new File(var0.getParentFile().getCanonicalFile(), var0.getName());
                if (var1.getCanonicalFile().equals(var1.getAbsoluteFile())) {
                    return true;
                }
            } catch (IOException var2) {
                ;
            }

            return false;
        }
    }

    public static byte[] readFully(File var0) throws IOException {
        FileInputStream var1 = new FileInputStream(var0);
        ByteArrayOutputStream var2 = new ByteArrayOutputStream();
        byte[] var3 = new byte[1024];
        boolean var4 = false;

        int var5;
        while ((var5 = var1.read(var3)) != -1) {
            var2.write(var3, 0, var5);
        }

        var2.close();
        return var2.toByteArray();
    }
}
