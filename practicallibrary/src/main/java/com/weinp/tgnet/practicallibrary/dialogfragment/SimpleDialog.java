package com.weinp.tgnet.practicallibrary.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.io.Serializable;


/**
 * Created by weinp on 2017/5/9.
 */

public abstract class SimpleDialog extends BaseDialogFragment {


    public final static String key = "_value";
    private Bundle bundle;

    public abstract class Builder<T extends SimpleDialog, E extends Builder> implements Serializable {
        public Bundle bundle;
        public boolean isCancle;

        public boolean isCancle() {
            return isCancle;
        }

        public E setCancle(boolean isCancle) {
            this.isCancle = isCancle;
            return (E) this;
        }
        public Bundle buildArguments() {
            bundle.putSerializable(key, this);
            return bundle;
        }

        public abstract SimpleDialog build();
    }

    final protected <T extends Builder> void setBuilder(T builder) {
        this.setArguments(builder.buildArguments());
    }

    final protected <T extends Builder> T getBuilder() {
        Bundle bundle = getArguments();
        if (bundle == null)
            return null;
        else
            return (T) bundle.getSerializable(key);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Builder builder = getBuilder();
        if (builder != null) {
            setCancelable(builder.isCancle());
        }
    }
}
