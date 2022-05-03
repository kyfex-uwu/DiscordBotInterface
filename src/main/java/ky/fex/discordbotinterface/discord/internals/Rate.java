package ky.fex.discordbotinterface.discord.internals;

import java.util.Timer;
import java.util.TimerTask;

public class Rate {
    public String key;
    public int remainingReqs=0;

    public Rate(String key){
        this.key=key;
    }

    public void updateRate(int remainingReqs, int limit, int resetAfterSecs){
        this.remainingReqs=remainingReqs;
        var thisPointer = this;
        if(remainingReqs==0){
            var resetTimer = new Timer();
            resetTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    thisPointer.remainingReqs=limit;
                    resetTimer.cancel();
                }
            }, resetAfterSecs*1000L);
        }
    }
}
