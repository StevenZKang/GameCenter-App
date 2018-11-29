package fall2018.csc207.game;

/*
Adapted from:
https://github.com/DaveNOTDavid/
sample-puzzle/blob/master/app/src/main/java/com/davenotdavid/samplepuzzle/GestureDetectGridView.java

This extension of GridView contains built in logic for handling swipes between buttons
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.GridView;
import android.widget.Toast;

import fall2018.csc207.minesweeper.MinesweeperController;
import fall2018.csc207.twentyfortyeight.TwentyFortyEightController;

public class GestureDetectGridView extends GridView {
    private static final int SWIPE_MIN_DISTANCE = 100;
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;
    private GestureDetector gDetector;
    private boolean mFlingConfirmed;
    private float mTouchX;
    private float mTouchY;
    private fall2018.csc207.game.BoardController boardController;

    public GestureDetectGridView(Context context) {
        super(context);
        init(context);
    }

    public GestureDetectGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GestureDetectGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP) // API 21
    public GestureDetectGridView(Context context, AttributeSet attrs, int defStyleAttr,
                                 int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(final Context context) {
        gDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapConfirmed(MotionEvent event) {
                int position = GestureDetectGridView.this.pointToPosition
                        (Math.round(event.getX()), Math.round(event.getY()));
                boardController.processTap(position);
                return true;
            }

            @Override
            public boolean onDown(MotionEvent event) {
                return true;
            }
            @Override
            public void onLongPress(MotionEvent e) {
                if (boardController instanceof MinesweeperController){
                    int position = GestureDetectGridView.this.pointToPosition
                            (Math.round(e.getX()), Math.round(e.getY()));
                    ((MinesweeperController) boardController).flagTile(position);
                }
            }
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                   float velocityY) {
                if(boardController instanceof TwentyFortyEightController) {
                    boolean result = false;
                    try {
                        float diffY = e2.getY() - e1.getY();
                        float diffX = e2.getX() - e1.getX();
                        if (Math.abs(diffX) > Math.abs(diffY)) {
                            if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) >
                                    SWIPE_VELOCITY_THRESHOLD) {
                                if (diffX > 0) {
                                    ((TwentyFortyEightController) boardController).moveRight();
                                    Toast.makeText(context, "Right", Toast.LENGTH_SHORT).show();
                                } else {
                                    ((TwentyFortyEightController)boardController).moveLeft();
                                    Toast.makeText(context, "Left", Toast.LENGTH_SHORT).show();
                                }
                                result = true;
                            }
                        } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) >
                                SWIPE_VELOCITY_THRESHOLD) {
                            if (diffY > 0) {
                                ((TwentyFortyEightController)boardController).moveDown();
                                Toast.makeText(context, "Down", Toast.LENGTH_SHORT).show();
                            } else {
                                ((TwentyFortyEightController)boardController).moveUp();
                                Toast.makeText(context, "Up", Toast.LENGTH_SHORT).show();
                            }
                            result = true;
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    return result;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        gDetector.onTouchEvent(ev);

        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mFlingConfirmed = false;
        } else if (action == MotionEvent.ACTION_DOWN) {
            mTouchX = ev.getX();
            mTouchY = ev.getY();
        } else {

            if (mFlingConfirmed) {
                return true;
            }

            float dX = (Math.abs(ev.getX() - mTouchX));
            float dY = (Math.abs(ev.getY() - mTouchY));
            if ((dX > SWIPE_MIN_DISTANCE) || (dY > SWIPE_MIN_DISTANCE)) {
                mFlingConfirmed = true;
                return true;
            }
        }

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            performClick();
        }
        return gDetector.onTouchEvent(ev);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    public void setBoardController(BoardController boardController) {
        this.boardController = boardController;
    }
}