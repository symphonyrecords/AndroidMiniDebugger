# AndroidMiniDebugger
A small tool to log your application inside your application with a floating UI component


### Usage:

Start the logging service:

    Intent intent = new Intent(this, DebuggerService.class);
    this.stopService(intent);
    ContextCompat.startForegroundService(this, intent);
    
   ## note:
   don't forget to grant "Draw over other apps" permission. (look into sample project "MainActivity.java")
   
   
Finally use SRLog.java instead of android Log class:
   
    SRLog.d(TAG, "Message");
