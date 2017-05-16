package com.weinp.tgnet.practicallibrary.dialogfragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;

/**
 * 1.以后需要往这个类中添加权限工具类（权限的处理）
 * <p>
 * 2.添加对键盘的处理
 */

public class BaseDialogFragment extends DialogFragment {
    /**
     * 所有继承BaseDialogFragment的DialogFrament，点击返回建统一
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int keyCode, KeyEvent keyEvent) {
                if (keyCode == keyEvent.KEYCODE_BACK
                        && keyEvent.getRepeatCount() == 0) {
                    return onBeforBackPressed();
                }

                return false;
            }
        });
    }

    protected boolean onBeforBackPressed() {
        return false;
    }


    public void singleShow(FragmentManager manager) {
        show(manager, this.getClass().getName());
    }

}
