package id.muhammadfaisal.kring.helper;

import com.google.common.annotations.Beta;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Encrypter {

    public static String encrypt(String s) {
        return String.valueOf(Hashing.sha256().hashString(s, StandardCharsets.UTF_8));
    }
}
