package test.jvm.classload.myClassLoader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 自定义类加载器
 *
 * 执行时出了乌龙，导错了
 *
 * @Author chenxiangge
 * @Date 1/22/21
 */
public class MyClassLoader extends ClassLoader {
    private String byteCodePath;

    public MyClassLoader(String byteCodePath) {
        this.byteCodePath = byteCodePath;
    }


    public MyClassLoader(ClassLoader parent, String byteCodePath) {
        super(parent);
        this.byteCodePath = byteCodePath;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        //获取字节码文件完整路径
        String fileName = byteCodePath + className + ".class";
        //打印文件名 方便调试
        System.out.println(fileName);
        BufferedInputStream bufferedInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //输入流
            bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));
            //输出流
            byteArrayOutputStream = new ByteArrayOutputStream();

            //具体数据获取并写出的过程
            int len;
            byte[] bytes = new byte[1024];
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            //获取内存中完整的字节数据的数据
            byte[] byteCodes = byteArrayOutputStream.toByteArray();

            //字节数据的数组转换为class实例
            Class<?> aClass = defineClass(null, byteCodes, 0, byteCodes.length);

            return aClass;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (null != bufferedInputStream) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != byteArrayOutputStream) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return null;

    }
}
