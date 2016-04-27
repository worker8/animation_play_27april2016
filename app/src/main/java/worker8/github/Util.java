package worker8.github;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;

import java.lang.ref.WeakReference;

/**
 * Created by tanjunrong on 4/27/16.
 */
public class Util {
    /**
     * Convenient method to obtain screen width in pixel
     *
     * @param activity
     * @return screen width in pixel
     */
    private static WeakReference<Integer> screenWidth = null;

    public static int getScreenWidth(Activity activity) {
        if (screenWidth == null || screenWidth.get() == null) {
            Display display = activity.getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = new WeakReference<Integer>(size.x);
        }
        return screenWidth.get();
    }

    /**
     * Convenient method to obtain screen height in pixel
     *
     * @param activity
     * @return screen width in pixel
     */
    private static WeakReference<Integer> screenHeight = null;

    public static int getScreenHeight(Activity activity) {
        if (screenHeight == null || screenHeight.get() == null) {
            Display display = activity.getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenHeight = new WeakReference<Integer>(size.y);
        }
        return screenHeight.get();
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px      A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return dp;
    }
}
