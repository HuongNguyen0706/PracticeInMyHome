# RecycleView Pratice
Android RecycleView
Task:
   Download the feed data from server, parse the JSON feed response and display the items on list. This example using both RecyclerView and CardView for creating the UI.
We need to follow the following steps:
  1. Create a new Android application in Android Studio IDE and add the support library dependency.
  2. Declare an layout for your activity and add a RecyclerView and ProgressBar widget
  3. Create an activity class to initiate data download, initialize the adapter and display data on RecyclerView
  4. Create RecyclerView row layout. Here we will use the CardView widget.
  5. Create an custom adapter that will be used for RecyclerView
  6. Implementing RecyclerView click event handling
1> Adding support library
  For using RecyclerView in your project you first need to add the recycler view support library to your project. Android Studio users can add the following graddle dependency to project build.graddle file:
      dependencies {
       compile 'com.android.support:recyclerview-v7:+'
       compile 'com.android.support:cardview-v7:21.0.+'
       compile project(':picasso-2.3.4')
      }
2> Adding Internet permission
  <uses-permission android:name="android.permission.INTERNET" />
3> Declaring Activity Layout
4> Activity Using RecyclerView
  RecyclerView is a ViewGroup similar to ListView or GridView. A ViewGroup is an UI widget that is used to render collection of data. In this example, we are trying to download the latest feeds from this site and display it on RecyclerView.  The focus of this tutorial is narrow down to RecyclerView, hence it doesn’t include any explanation for download and parse data from server. For learning how to download data from server, you may read Android Networking Tutorial.

  As the data is downloaded, inside onPostExecute() we are initializing the adapter and setting adapter to RecyclerView instance by just calling setAdapter() method.
5> Creating RecyclerView Adapter
  Android RecyclerView includes special kind of adapter which works pretty much same as traditional Android adapters but with additional functionalities. The additional functionalities includes;

  + It adds two new methods like onCreateViewHolder() and onBindViewHolder() to organize the code. You must override these two methods for inflate the view and to bind data to the view
  + Implements a ViewHolder by default. Conceptually RecyclerView.ViewHolder works same as the ViewHolder design pattern which we have been using with other Adapters
  + Takes care of the overhead of recycling and gives better performance and scrolling
6> RecyclerView Row Layout



TÀI LIỆU THAM KHẢO
  http://javatechig.com/android/android-recyclerview-example
