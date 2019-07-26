# AndroidMiniDebugger
A small tool to log your application inside your application with a floating UI component



#### Preview
![Preview](https://github.com/symphonyrecords/Data/blob/master/AndroidMiniDebuggerGif.gif)



### Usage:

Start the logging service:

    Intent intent = new Intent(this, DebuggerService.class);
    this.stopService(intent);
    ContextCompat.startForegroundService(this, intent);
    
<b>Note:</b> don't forget to grant <b>"Draw over other apps"</b> permission.
   
   
Finally use <b>SRLog.java</b> instead of android Log class:
   
    SRLog.d(TAG, "Message");
