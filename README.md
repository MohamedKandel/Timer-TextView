![Static Badge](https://img.shields.io/badge/Android-green) 
![Static Badge](https://img.shields.io/badge/Kotlin-mauve)
![Static Badge](https://img.shields.io/badge/latest%20release:-1.1.1-red)
![Static Badge](https://img.shields.io/badge/jitPack-gray)
[![HitCount](https://hits.dwyl.com/MohamedKandel/Timer-TextView.svg?style=flat-square)](http://hits.dwyl.com/MohamedKandel/Timer-TextView)

## Timer TextView: Effortlessly Build Your Own Timer in Your Android App

This developer-friendly library simplifies building timer in android application no need to much code to build timer or handle its cases.

Key features:
- Effortless Integration: Add the library to your project with just a few lines in your gradle files.
- hands on all cases: you can handle all status for timer (start - stop - reset)
- get text of timer second by second : you can get which time now in timer to apply any action in specific time you want

# Getting Started:

## Set up Gradle:
 - Add this at the end of your repositories (**settings.gradle**)
    ```
    repositories {
        ....
        maven {
            url = uri("https://jitpack.io")
        }
    }
    ```
 - Add the dependency 
 
     ```
      dependencies {
            implementation "com.github.MohamedKandel:Timer-TextView:latest-release"
        }
    ```
# Simple Usage:
use the timer textview in your xml file as follow:
```
<com.mkandeel.timer.TextViewTimer
        android:id="@+id/txt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:updateInterval="1000" 
        android:textSize="25sp"
        android:fontFamily="sans-serif-medium"/>
```
***updateInterval*** attribute define delay in timer<br>
This library also provides some helper methods to make using of this library is easier:<br>
```startTimer()``` this method start the timer to count<br>
```stopTimer()``` this method pause the timer<br>
```resetTimer()``` this method reset the timer to initial 00:00:00 and stop it till start again.<br>
by using this library also developers can get text of timer now by the following method:<br>
```
setOnTimerTickListener(listener : TickListener)
```
and also you can listen for any changes in timer status by this method:<br>
```
setOnTimerStatusChangedListener(listener: StatusListener)
```
# Compatibility:

This library is compatible with Android versions from API 24 (Android 7) to API 34 (Android 14).

# Contact:

Developed by Mohamed Kandeel. Feel free to reach out via email (mohamed.hossam7799@gmail.com) with suggestions or feature requests.

Thank you for choosing Timer TextView!
