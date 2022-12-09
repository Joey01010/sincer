package com.plane.sincer.utils;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@Log4j2
public class GzipUtil {
    /**
     * 压缩GZip
     *
     * @return String
     */
    public static String gZip(String input) {
        byte[] bytes = null;
        GZIPOutputStream gzip = null;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            gzip = new GZIPOutputStream(bos);
            gzip.write(input.getBytes(CharEncoding.UTF_8));
            gzip.finish();
            gzip.close();
            bytes = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            log.error("压缩出错：", e);
        } finally {
            try {
                if (gzip != null)
                    gzip.close();
                if (bos != null)
                    bos.close();
            } catch (final IOException ioe) {
                log.error("压缩出错：", ioe);
            }
        }
        return Base64.encodeBase64String(bytes);
    }

    /**
     * 解压GZip
     *
     * @return String
     */
    public static String unGZip(String input) {
        byte[] bytes;
        String out = input;
        GZIPInputStream gzip = null;
        ByteArrayInputStream bis;
        ByteArrayOutputStream bos = null;
        try {
            bis = new ByteArrayInputStream(Base64.decodeBase64(input));
            gzip = new GZIPInputStream(bis);
            byte[] buf = new byte[1024];
            int num;
            bos = new ByteArrayOutputStream();
            while ((num = gzip.read(buf, 0, buf.length)) != -1) {
                bos.write(buf, 0, num);
            }
            bytes = bos.toByteArray();
            out = new String(bytes, CharEncoding.UTF_8);
            gzip.close();
            bis.close();
            bos.flush();
            bos.close();
        } catch (Exception e) {
            log.error("解压出错：", e);
        } finally {
            try {
                if (gzip != null)
                    gzip.close();
                if (bos != null)
                    bos.close();
            } catch (final IOException ioe) {
                log.error("解压出错：", ioe);
            }
        }
        return out;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        //String json = "H4sIAAAAAAAAA+1cWXPbOBL+Lfugmt2HuHhTfJTkOEmVc1Ti3ezbFESCEtYQqSKh2MqvH/AAiIYk8zDjkbKOKioTR7MvfN0NkJr484ll/cBZTtKE/zWxZ/zbNK+MK6O4tBb8O19jzPK6t5wweetO5v5k5k7eOpP59SRYTN5OJzNzMpua6rgEbbCk2japvFeEY7Sj8G5hSt9jFOHsa/rwHpPVmlW9llHNyYrmon+R0u8kYuuq21G7lVnmlW1XPSEYbxrGxL+WcxbpLhFTLDl+t0mUDrPuQCEjPzBnT1BSmzlXNZmqla2x1Mqhlj7HMQmx1Ec5mFNIs64zlii8X2WcxwiYAtU8uG4toXa90q6XzbVQSkPZ6kLZNiFl24CU7UbdDD+yLtwagCKkB6l14dCbAnJTB9AzDU9SRGGIk04cBlBoU1enaWtEu6nSh1QtSNUJNKJ2B6KmBy0vr5fNNaTqDPAnM7BOWKmi6fa3k2lqhgp0Q3ldxBdrV1D1bUDVNyXR9X6LM0qS+w5kofRBoHHaWD9OKU0fcPS+B3HTCQB5XyPPFcPJS7Y5JpJkdZMKtOLf1zhZ/ZcgDvXGrYDEikQa7U+MtCTFCDGksllc36ElBWhmnrz4gehOCQfWzefZNWL4n47tBP6/+LXkJmd72oz888/ljlD2IflWNFsqR9YJ+mY7HbOmc5RUR75dyx2Xb8vuz7g9hHHXG5fxAXw7Q/iejsy3OcBT3AGMe+bYHt6BkM64N4RxZ2zGB7iKP4Rxfzoy405/xqcDGPeNYGTG3f6MB0MYt8dm3OvPuGmoxNpUEqfZZkeRpL0wjTcKRRn4qqqEy4k+pREIdypvZUORJSsJe7KjVN4LZPKWdccTVR6J+Q2Nptr6MaNkVddilpipBGbT2z7yCWp8bioFEMLnPKbL7mWa8QrpFsdM56vquUu3xzu+NqWT3jVPGUs3eh9Nw3scVa0sKzQukvIPSYQFf3Xy/sAJfc9Qfe8Y0RxrupfV3bWeffQwymnlwJvJUvMlbpZjinmFmCag2gX+m+klJSxMTck18Bd+DQaJG1LuM7LaVRUsGHDnwoyVZOSnyEvE8Itud4WV1yhjjcwn9iqC+WT+Vm5RVOu0VvBjNdAzp1deXZrthZ1qzHpoNhZcx7vyPJGUKzsRU+/KCpp/ogBlvCT4pHJjyRuXnH/bohA4XFmT42iRZgnOcnUpNZOAgxIGPTb9wWsQtD+YmW+/gH0HmqhXSXpDKFUWuvCokx3sEdIrqg7Ykm/DG5Ll7Bbl7AvKkA4jnFH2mX/FVK6MpgMii0SVegRKwrUAX9C0YNkRXreaf2iq4IDwVWP9Z027cYrlgUbJQcsOcJ2zjNxj0HSPs1rtZhknKsOEYAxFjADbbAkL1zdoQ+geDCx8IccQPgp/ixuXKnxtvkneUDZRYjRGI5OvCErgzUcmXxGUUJtSEjVOWRssLDfXKLAiTxIAebrbfEwj6Quea3AbCCDhnZ/jWHbaotO/1qAeJ1HhzcBjZB/lXCQqHlUUXEAB7Vh6V6zbaz6eifiq+NGWpmyWQTOVK/8dh4etjnZlzx1XXY1kIiJl2jjeQnDeDKwNQaJHcF2mA9CRh0HHAEM5mq5JUmDBh/gTXqFi//UQDxFAw2S3+YpjtUVcWNYfT21a//GPieXw8U41uPzTbBI5TneBOOeAMs83EVs0GYRlbTabN/sj2YGUbwwuFw2Xi0FcvsM8tFQcaUnMGgnfsNQYix4/NKsmMHzDdPwivnlu4NpF8S8GLlF2TSAsF5vMW5KsYCPaKpv1lhkINWX7Mqs+jHtVVKtx/A0vIgF7WF8S6JEojm7qYigylC6JqOSwDqJ8pSQMMXmS0qRYUblmDxhEj1/SHKyaDfpfmt2R8P4jyuodwbpc3pBE7xGJP2+8XVJJyuqyAGHwDIWWRJqx2UaAL0RFSSLzUJ5yKOt3XJQ1n0LZ6QHKviYdcjvol2UcrxnG75phVHJnaZ7PRF0jMLrpEmgpfJhnI/oqoUvKWW2UJzxniXJ8Rzb43wmBeuWh52YDQnFbeCynzThOlzkNMNwMoLc4ZjoC7LYO7FDasYHdVID9XUYiThwDT/w/wmnFXY8EOuuXBLrXIvU1XrzGi18bL2BqfCxelG1zzB4whvjUKQbA4qNzEAB7fhTt0x240QYlO0RvD9ofP8p712T3By2i+r0yXJPHD8/zXcd0XfEMwV52F4HFdV3LswPLtWsNPYjuaTC1HcO2+Zip49ST16LXmwa+NzVdO5gavgtOOUbEPAklNGX/IfnnRHh4g2cRybdzipL7fAbNmq/Th2sOyXmBdh/Rowod3Vj9reLb0JsbGgk9AvVE+fFW+TYjCfuGGYfyFYDDdXlIcpOmDANWUHF29Z2wNQ/eKyIONmDIQisMeusoK7zer4/mqGyoLa1dM31CxZNorRdTrLBYNKpccMEEftR6RVucfZOHBrVPxEWo/8LHf9ptlhjG5oPUUOS8FIX3syT6viZH0sMoQ+IYTg2zOb45ditlCM8DyM+U35Beb+s47YmAW+QWJDzWE6Zb0uCxGgmEZ5MkwnJDT62p0QZH5TGrvlminXIW2Fs+elUfZ/rl+XFtgU7HnuCMMyliAHcAQ/5hOlf+oHNPcKxTHK5xbzHe8P+z5pk+pVZ4Qi7rkuSyustlX5Jcdne5nEuSy+kul3tJcrnd5fIuSS6vu1wFv+55yuU8Fw8vRq6eeHgxcvXEw4uRqyceXoxcPfHwYuTqiYf2U3LN5Xsmf4903nNR8cKk64mNFyZdT4S8MOl64uSFSdcTLS9Mup6YaZyxcINg8vwF6omM5y9QTzA8f4F64t/5C9QT8s5foHaUm1h2HIe+8g7zoSx8TBAahuG9rAhzFHVi3yo+T7MfIz9qtcAypdFzmNff8qgf9tR58ePiI2cpbzA0jzZor4U8m5LyHsmzaakvnjyDGDD1AtFwR+VWfpvJkVt8xlx9L2R7Oy4+xxTj9bR9d0rttu9Oq4PtuxCDtl/j8J6rfIGpcsp8zPjNa06QQLrZoOfMNCbuvDppHEJjl2U4CffPnNyXh6Mwp6074OqEIUrC8VH67eOWogSxNCukqLZF2ldw6OG4LebwgGO+dNh8l6YtQafDO4V6fv0E4FjGWb5QeGxtn6iHlAXuHl/g76vfQpjUL3G9lGpN/8q+TOU6wSDtthRMI2t3rEj54tq1j2rXatNuS/V2Jto9wXx7pVbVAWHw1C5OHd39X18HvKbSg1PpD8l21xKCW7KITsXS+DZ+CSAovXxqKG8Tt+entyQpX6nvkKCKO+BlED69joKweHT0l+sYCPIJ7xh4kvMpEQow6Lscl1bxGWM5dqfUvhy70+rgPV2IQaWn1TNoY+xiaKXVmVayfW3dndJzKtkBtu5CDP4Y4I71wF4w9QvOwvrnOV6s9HA0/9B+lezQT+p8Ij8OL3fihw2eJcDfsVlzMvIMK4OecNvxa64TQesuZW1I35YFxIbx0hHqO8qSKmFt30fo7Utr5bd96geU237u54icv/0PAB0LYZXwr9Y4B2sc/wWu38Es1ctHzUsN6vunv5vdrNpu5fsefwHEztjVCVoAAA==";
        String json = "H4sIAAAAAAAAAytOLSrLTE41NTAAAOCUY68KAAAA";
        System.out.println(URLDecoder.decode(unGZip(json), "utf-8"));
    }
}

