# DrawableAnimation on Android
1. cut image png from array image animation. Then, 
+ indentifying the image frames
+ define animation sequence:
  Declare a XML file that defines the animation sequence that holds the list of drawables. Create a new file named  frame_animation_list.xml  and paste it to your project resource res/anim or res/drawable folder.
    <?xml version="1.0" encoding="utf-8"?>
    <animation-list xmlns:android="http://schemas.android.com/apk/res/android" android:oneshot="false">
	      <item android:drawable="@drawable/frame1" android:duration="100" />
	      <item android:drawable="@drawable/frame2" android:duration="100" />
	      <item android:drawable="@drawable/frame3" android:duration="100" />
	      <item android:drawable="@drawable/frame4" android:duration="100" />
	      <item android:drawable="@drawable/frame5" android:duration="100" />
	      <item android:drawable="@drawable/frame6" android:duration="100" />
	      <item android:drawable="@drawable/frame7" android:duration="100" />
	      <item android:drawable="@drawable/frame8" android:duration="100" />
	      <item android:drawable="@drawable/frame9" android:duration="100" />
        <item android:drawable="@drawable/frame10" android:duration="100" />
    </animation-list>
+ Declare activity layout: main_activity.xml
+ Note: To Animation move continues, we create AnimationDrawble drawable; and set drawable.setOneShot(false);
2. Reference
      http://stacktips.com/tutorials/android/creating-frame-animations-in-android

  
