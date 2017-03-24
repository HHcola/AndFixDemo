package com.dexfileformat.dexfileformat;

import com.alipay.euler.andfix.annotation.MethodReplace;

/**
 * Created by hewei05 on 2017/3/23.
 */

public class ReplaceFile {

    @MethodReplace(clazz="com.dexfileformat.dexfileformat.DexFileFormat", method="getVersion")
    public String getVersion(String test) {
        String id = test + "123!!!!fix bug";
        return id;
    }
}
