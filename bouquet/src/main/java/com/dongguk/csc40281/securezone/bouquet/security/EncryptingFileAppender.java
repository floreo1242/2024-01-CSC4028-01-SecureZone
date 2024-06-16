package com.dongguk.csc40281.securezone.bouquet.security;

import ch.qos.logback.core.FileAppender;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;

public class EncryptingFileAppender<E> extends FileAppender<E> {

    private Cipher cipher;

    public EncryptingFileAppender() {
        try {
            cipher = Cipher.getInstance("AES");
            SecretKeySpec key = new SecretKeySpec("MySecretKey12345".getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing cipher", e);
        }
    }

    @Override
    protected void subAppend(E event) {
        try {
            byte[] bytes = this.encoder.encode(event);
            byte[] encryptedBytes = cipher.doFinal(bytes);
            super.subAppend((E) new String(encryptedBytes, Charset.defaultCharset()));
        } catch (Exception e) {
            addError("Error encrypting log message", e);
        }
    }

}

