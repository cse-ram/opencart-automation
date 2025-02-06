package com.utility;

import com.constants.Env;
import com.google.gson.Gson;
import com.libs.pojos.Configs;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class EnvUtility {
    private static final Configs configs;
    static {
        try {
            configs = new Gson().fromJson(new FileReader("configs/config.json"), Configs.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getURL(Env env) {
        return configs.environments().get(env.name()).url();
    }

    public static int getMaxRetries(Env env){
        return configs.environments().get(env.name()).maxAttempt();
    }
}
