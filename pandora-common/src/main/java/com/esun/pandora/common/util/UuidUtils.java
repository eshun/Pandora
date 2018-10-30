package com.esun.pandora.common.util;

import java.util.UUID;

/**
 * Created by esun on 2018/10/22.
 */
public class UuidUtils {
    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
