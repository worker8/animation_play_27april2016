package worker8.github;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.add_recipe_button)
    Button mRecipeButton;
    @BindView(R.id.search_button)
    Button mSearchButton;
    @BindView(R.id.background_image)
    ImageView mBackgroundImageView;
    @BindView(R.id.appear_group)
    LinearLayout mAppearGroup;

    final static int ANIM_DURATION = 1000;
    MainActivity mActivity;
    int mPadding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPadding = (int) Util.convertDpToPixel(10, mActivity);
    }

    public void onSearchClick(View view) {
        // Group 1
        ObjectAnimator animatorSearch = ObjectAnimator.ofFloat(mSearchButton, View.Y, 0 + mPadding);
        animatorSearch.setDuration(ANIM_DURATION);
//        animatorSearch.start();

        ObjectAnimator animatorRecipe = ObjectAnimator.ofFloat(mRecipeButton, View.Y, mBackgroundImageView.getHeight() / 2 - mSearchButton.getHeight() / 2);//Util.getScreenHeight(mActivity) / 2 - mSearchButton.getHeight() / 2);
        animatorRecipe.setDuration(ANIM_DURATION);
//        animatorRecipe.start();

        ObjectAnimator animatorBackground = ObjectAnimator.ofFloat(mBackgroundImageView, View.SCALE_Y, 0.5f);
        mBackgroundImageView.setPivotY(0);
        animatorBackground.setDuration(ANIM_DURATION);
//        animatorBackground.start();

        AnimatorSet set = new AnimatorSet();
        set.playTogether(animatorSearch, animatorRecipe, animatorBackground);
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                mAppearGroup.setVisibility(View.VISIBLE);
                ObjectAnimator animatorAppear = ObjectAnimator.ofFloat(mAppearGroup, View.ALPHA, 0, 1f);
                animatorAppear.setDuration(ANIM_DURATION);
                animatorAppear.start();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        set.start();

    }

}
