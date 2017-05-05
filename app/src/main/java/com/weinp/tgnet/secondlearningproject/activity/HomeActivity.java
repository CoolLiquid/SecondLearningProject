package com.weinp.tgnet.secondlearningproject.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weinp.tgnet.secondlearningproject.R;
import com.weinp.tgnet.secondlearningproject.activity.base.BaseActivity;
import com.weinp.tgnet.secondlearningproject.view.fragment.HomeFragment;
import com.weinp.tgnet.secondlearningproject.view.fragment.MessageFragment;
import com.weinp.tgnet.secondlearningproject.view.fragment.MimeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.content_layout)
    RelativeLayout contentLayout;
    @BindView(R.id.home_image_view)
    TextView homeImageView;
    @BindView(R.id.home_layout_view)
    RelativeLayout homeLayoutView;
    @BindView(R.id.fish_image_view)
    TextView fishImageView;
    @BindView(R.id.pond_layout_view)
    RelativeLayout pondLayoutView;
    @BindView(R.id.message_image_view)
    TextView messageImageView;
    @BindView(R.id.message_layout_view)
    RelativeLayout messageLayoutView;
    @BindView(R.id.mine_image_view)
    TextView mineImageView;
    @BindView(R.id.mine_layout_view)
    RelativeLayout mineLayoutView;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;

    FragmentManager manager;
    FragmentTransaction fragmentTransaction;
    HomeFragment homeFragment;
    MessageFragment messageFragment;
    MimeFragment mimeFragment;
    Fragment currentFragment;


    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_home_layout);
        ButterKnife.bind(this);
        manager = getFragmentManager();
        homeFragment = new HomeFragment();
        fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, homeFragment);
        fragmentTransaction.commit();
    }


    private void hideFragment(Fragment mimeFragment, FragmentTransaction fragmentTransaction) {
        if (mimeFragment != null) {
            fragmentTransaction.hide(mimeFragment);
        }
    }


    @OnClick({R.id.home_layout_view, R.id.message_layout_view, R.id.mine_layout_view})
    public void onClick(View view) {
        fragmentTransaction = manager.beginTransaction();
        switch (view.getId()) {
            case R.id.home_layout_view:
                homeImageView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                messageImageView.setBackgroundResource(R.drawable.comui_tab_message);
                mineImageView.setBackgroundResource(R.drawable.comui_tab_person);

                hideFragment(mimeFragment, fragmentTransaction);
                hideFragment(messageFragment, fragmentTransaction);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout, homeFragment);
                }
                currentFragment = homeFragment;
                break;
            case R.id.message_layout_view:
                messageImageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                homeImageView.setBackgroundResource(R.drawable.comui_tab_home);
                mineImageView.setBackgroundResource(R.drawable.comui_tab_person);

                hideFragment(mimeFragment, fragmentTransaction);
                hideFragment(homeFragment, fragmentTransaction);
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content_layout, messageFragment);
                }
                currentFragment = messageFragment;
                break;
            case R.id.mine_layout_view:
                mineImageView.setBackgroundResource(R.drawable.comui_tab_person_selected);
                homeImageView.setBackgroundResource(R.drawable.comui_tab_home);
                messageImageView.setBackgroundResource(R.drawable.comui_tab_message);

                hideFragment(messageFragment, fragmentTransaction);
                hideFragment(homeFragment, fragmentTransaction);
                if (mimeFragment == null) {
                    mimeFragment = new MimeFragment();
                    fragmentTransaction.add(R.id.content_layout, mimeFragment);
                }
                currentFragment = mimeFragment;
                break;
        }
        fragmentTransaction.show(currentFragment);
        fragmentTransaction.commit();
    }
}
