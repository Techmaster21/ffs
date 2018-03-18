This build version solves multiple issues:
1. By popular demand, you can now choose not to build the frontend. In fact, it's the default behavior not to.
2. Finally solves the error page issue
3. Just makes more sense

If you are using netbeans to build, you have to change something for this project to work. Go to your Preferences,
Java, Maven, Experimental, and check the box that says Download and use best maven binary for execution. 

To build frontend on netbeans:
Change default config to front.
On command line (in project root):
./mvnw clean install -Pfront
To not build frontend on command line:
./mvnw clean install

Note that you only have to build the frontend once if you are only testing the server. You can then build without
-Pfront to your heart's desire.

If you want Angular to constantly rebuild for dev purposes, you can still do that.
Just go into the angular directory, and run "npm start". If you want to 
be able to make calls to the backend, you will need to be running the server as well.

Update:
Added a new profile "prod" to maven build to use when building on the server. It will properly
set socketio.

Client-side socket.io version is 1.4.8 because according to an open issue on the netty-socket-io github page
(and confirmed through personal tests), the connect event doesn't fire server-side for newer versions.