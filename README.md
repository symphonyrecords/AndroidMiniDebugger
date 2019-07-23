# AndroidMiniDebugger
A small tool to log your application inside your application with a floating UI component



![This is how it looks](https://gfycat.com/distantbrightandeancondor)


### Usage:

Start the logging service:

    Intent intent = new Intent(this, DebuggerService.class);
    this.stopService(intent);
    ContextCompat.startForegroundService(this, intent);
    
<b>Note:</b> don't forget to grant "Draw over other apps" permission. (look into sample project <b>"MainActivity.java"</b>)
   
   
Finally use <b>SRLog.java</b> instead of android Log class:
   
    SRLog.d(TAG, "Message");
