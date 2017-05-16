package com.weinp.tgnet.practicallibrary.animation;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by weinp on 2017/5/16.
 */

public abstract class ABaseTransForm implements ViewPager.PageTransformer {

    protected abstract void onTransForm(View pager, float position);

    @Override
    public void transformPage(View page, float position) {
        onPreTransForm(page, position);
        onPostTransform(page, position);
        onPostTransform(page, position);

    }

    protected void onPreTransForm(View pager, float position) {
        final float width = pager.getWidth();
        pager.setRotationX(0);
        pager.setRotationY(0);
        pager.setRotation(0);
        pager.setScaleX(1);
        pager.setScaleY(1);
        pager.setPivotX(0);
        pager.setPivotY(0);
        pager.setTranslationY(0);
        pager.setTranslationX(isPaddingEnable() ? 0f : -width * position);

        if (hideOffscreePages()) {
            pager.setAlpha(position < -1f || position > 1f ? 0f : 1f);
            pager.setEnabled(false);
        }else{
            pager.setAlpha(1);
            pager.setEnabled(true);
        }
    }

    protected boolean isPaddingEnable() {
        return false;
    }

    protected boolean hideOffscreePages() {
        return true;
    }


    protected void onPostTransform(View pager, float position) {

    }


}
