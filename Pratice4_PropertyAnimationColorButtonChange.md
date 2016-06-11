# ColorButtonChange 
- Use property animation on android to run color button from green to red
- Demo: https://www.youtube.com/watch?v=TP-VjqaF6d8
- Reference:
    final ValueAnimator groundAnimator = ObjectAnimator.ofInt
                (btn, "backgroundColor",
                        Color.GREEN, Color.RED);
        //set same duration and animation properties as others
        groundAnimator.setDuration(3000);
        groundAnimator.setEvaluator(new ArgbEvaluator());
        groundAnimator.setRepeatCount(ValueAnimator.INFINITE);
        groundAnimator.setRepeatMode(ValueAnimator.REVERSE);

        groundAnimator.start();
