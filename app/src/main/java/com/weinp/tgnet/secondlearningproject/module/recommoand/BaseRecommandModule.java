package com.weinp.tgnet.secondlearningproject.module.recommoand;

import com.weinp.tgnet.secondlearningproject.module.BaseModule;

/**
 * Created by weinp on 2017/5/5.
 */

public class BaseRecommandModule extends BaseModule {
    //一定要保证我们的变量与我们的json的key保持一致
    public String code;
    public String emsg;
    public RecommandModule data;
}
