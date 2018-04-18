package com.daimokenya.tic_tac_toe;

import android.os.IBinder;
import android.support.test.espresso.Root;
import android.view.WindowManager;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by hitch_sex on 3/30/18.
 */

public class ToastMatcher extends TypeSafeMatcher<Root> {

    @Override    public void describeTo(Description description) {
        description.appendText("is toast");
    }

    @Override    public boolean matchesSafely(Root root) {
        int type = root.getWindowLayoutParams().get().type;
        if ((type == WindowManager.LayoutParams.TYPE_TOAST)) {
            IBinder windowToken = root.getDecorView().getWindowToken();
            IBinder appToken = root.getDecorView().getApplicationWindowToken();
            if (windowToken == appToken) {
                //means this window isn't contained by any other windows.
            }
        }
        return false;
    }
}