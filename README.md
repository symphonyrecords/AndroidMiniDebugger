

# AndroidMiniDebugger [![](https://jitpack.io/v/symphonyrecords/AndroidMiniDebugger.svg)](https://jitpack.io/#symphonyrecords/AndroidMiniDebugger)
A small tool to log your application inside your application with a floating UI component



#### Preview
![Preview](https://github.com/symphonyrecords/Data/blob/master/AndroidMiniDebuggerGif.gif)



## Usage:

### Step 1
Add it in your root build.gradle:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
### Step 2
Add dependencies in build.gradle.

    dependencies {
       implementation 'com.github.symphonyrecords:androidminidebugger:1.1.1'
    }


### Step 3
Start the logging service:

    Intent intent = new Intent(this, DebuggerService.class);
    this.stopService(intent);
    ContextCompat.startForegroundService(this, intent);
    
   
### Step 4
Finally use <b>SRLog.java</b> instead of android Log class:
   
    SRLog.d(TAG, "Message");


<b>Note:</b> don't forget to grant <b>"Draw over other apps"</b> permission (Look into <b>Example.java</b>).



