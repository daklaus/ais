package at.game.tictactoe;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: at.game.tictactoe.c */
class C0002c implements OnTouchListener {
    final /* synthetic */ MainActivity f25a;

    C0002c(MainActivity mainActivity) {
        this.f25a = mainActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f25a.f0a.m7a(motionEvent.getX(), motionEvent.getY());
                break;
            case 1:
                view.performClick();
                break;
        }
        return true;
    }
}
