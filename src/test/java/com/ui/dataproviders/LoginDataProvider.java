package com.ui.dataproviders;

import com.google.gson.Gson;
import com.libs.pojos.LoginData;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.Stream;

public final class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() {
        var emptyIterator = Stream.<Object[]>empty().iterator();

        Path filePath = Path.of("test-data/login-data.json");
        if (!Files.exists(filePath)) {
            System.err.println("File not found: " + filePath);
            return emptyIterator;
        }

        try (FileReader fileReader = new FileReader(filePath.toFile())) {
            LoginData loginData = new Gson().fromJson(fileReader, LoginData.class);
            return loginData != null ? loginData.data().stream().map(user -> new Object[]{user}).iterator() : emptyIterator;
        } catch (IOException e) {
            System.err.println("Error reading login data: " + e.getMessage());
            return emptyIterator;
        }
    }
}
