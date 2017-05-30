/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package picam.hannes.info.mydbapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import picam.hannes.info.mydbapplication.MyApp;
import picam.hannes.info.mydbapplication.fragment.AppMyPostsFragment;
import picam.hannes.info.mydbapplication.fragment.AppMyTopPostsFragment;
import picam.hannes.info.mydbapplication.fragment.AppRecentPostsFragment;

public class AppMainActivity extends AppBaseActivity {

    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager            mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.google.firebase.quickstart.database.R.layout.activity_main);

        // Create the adapter that will return a fragment for each section
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[]{
                    new AppRecentPostsFragment(),
                    new AppMyPostsFragment(),
                    new AppMyTopPostsFragment(),
            };
            private final String[] mFragmentNames = new String[]{
                    getString(com.google.firebase.quickstart.database.R.string.heading_recent),
                    getString(com.google.firebase.quickstart.database.R.string.heading_my_posts),
                    getString(com.google.firebase.quickstart.database.R.string.heading_my_top_posts)
            };

            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

            @Override
            public int getCount() {
                return mFragments.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentNames[position];
            }
        };
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(com.google.firebase.quickstart.database.R.id.container);
        mViewPager.setAdapter(mPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(com.google.firebase.quickstart.database.R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        // Button launches AppNewPostActivity
        findViewById(com.google.firebase.quickstart.database.R.id.fab_new_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AppMainActivity.this, AppNewPostActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.google.firebase.quickstart.database.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == com.google.firebase.quickstart.database.R.id.action_logout) {
            FirebaseAuth.getInstance(MyApp.fbApp).signOut();
            startActivity(new Intent(this, AppSignInActivity.class));
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}
