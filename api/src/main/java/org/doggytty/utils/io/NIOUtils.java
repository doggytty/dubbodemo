package org.doggytty.utils.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by doggytty on 17-6-13.
 */
public class NIOUtils {

    public void copy(String fromPath, String toPath) throws IOException{
        // channel 注册selector file channel没有异步模式
        FileInputStream fis = new FileInputStream(fromPath);
        FileOutputStream fos = new FileOutputStream(toPath);
        FileChannel inc = fis.getChannel();
        FileChannel out = fos.getChannel();
        // 创建缓冲区
        ByteBuffer bb = ByteBuffer.allocate(4096);
        while(true){
            //判断是否读完文件
            int eof =inc.read(bb);
            if(eof == -1){
                break;
            }
            // 重设一下buffer的position=0，limit=position
            bb.flip();
            // 开始写
            out.write(bb);
            // 写完要重置buffer，重设position=0,limit=capacity
            bb.clear();
        }
        inc.close();
        out.close();
        fis.close();
        fos.close();
    }
}
