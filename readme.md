What's changed:

All previous ffsers and recipes in database, were removed as there were significant changes made to them.

Notes for front end:
* Ffser is now User.
* You must subscribe to all service methods that return an observable from an http request if you want the request to go through
* All requests now use HTTP. Socket.io is completely gone.
* All URLS (URIs) for http requests are in uri.ts. This allows us to change the endpoints later if need be.

Notes for back end:
* Spring boot was updated to 2.0
* Ffser is now User.
* All requests now use HTTP. Socket.io is completely gone. Tokens still work as expected. 
* Permission was replaced by Authority. I don't totally understand it, but somehow it should allow a user to have multiple authorities (it currently does not).
* All non-account urls are secured by default to require valid token. You can additionally secure methods/classes by authority using the following annotation: @PreAuthorize("hasAuthority('admin')")
* Endpoints were changed to be more logical and tiered
* You can get the current user using the SecurityContextHandler's method "currentUser()"
* Testing should be way easier now, using built in spring testing interfaces for REST.
* Some methods return Optional<T>. This means they may or may not return an actual value. If you don't care, just call .get() on the returned value. 
* Some names on database methods have changed.
-------------------------------------------------------
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