package main.task3;

public class Whale extends Being {
    private SelfIdentity selfIdentity;
    private EmotionalState emotionalState;
    private TimeToGetUsed timeToGetUsed;

    public Whale(Position position, EmotionalState emotionalState, SelfIdentity selfIdentity) {
        super(position);
        this.emotionalState = emotionalState;
        this.selfIdentity = selfIdentity;
    }

    public String changeSelfIdentity(SelfIdentity selfIdentity) {
        if (this.selfIdentity == selfIdentity)
            return "I already know who I am";
        else {
            getUsed(selfIdentity);
            return "Now I for sure know who I am";
        }
    }

    private void getUsed(SelfIdentity selfIdentity) {
        this.selfIdentity = selfIdentity;

        switch (getBodyPosition()) {
            case NATURAL:
                timeToGetUsed = TimeToGetUsed.LITTLE;
                break;

            case UNNATURAL:
                timeToGetUsed = TimeToGetUsed.MUCH;
                break;
        }
    }

    public boolean changeEmotionalState(EmotionalState emotionalState) {
        if ((emotionalState == EmotionalState.HAPPY || emotionalState == EmotionalState.USUAL)
                && getBodyPosition() == Position.UNNATURAL) {
            return false;
        } else {
            this.emotionalState = emotionalState;
            return true;
        }
    }

    public EmotionalState getEmotionalState() {
        return emotionalState;
    }

    public SelfIdentity getSelfIdentity() {
        return selfIdentity;
    }

    public TimeToGetUsed getTimeToGetUsed() {
        return timeToGetUsed;
    }
}
