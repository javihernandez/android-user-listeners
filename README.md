GPII Android User Listeners
===========================

Overview
--------

**android-user-listeners** is an _all-in-one_ application for android, which is
including two user listeners to use within the [GPII](https://github.com/GPII/)
real-time personalization framework.

At this moment this application supports both **NFC** and **QR** user listeners.

### NFC

For our NFC user listener we're using our own mime type, so you have to
write the NFC tag from the application before using it.

With this mime type, the login/logout process will start automatically when
reading the NFC tag.

### QR

Our QR user listener depends on a third-party application called **Barcode 
Scanner**, and that means that this application should be installed before
using the QR user listener.

To use the QR user listener you have to open the **android-user-listeners**
application and click on _Let's Read a QR_.

Build and installation
----------------------

You can build this project locally by using **ant**.

Make sure that you have defined your `ANDROID_HOME` environment variable, and
is containing the full path where the Android SDK is located.

To run the build, use `ant debug`.
To install the apk, use `adb install <path-to-apk>`.

As an alternative to ant, you can use any other IDE such as **Eclipse** or 
**IntelliJ**.

TODO
----

* Add i18n support
* Improve the UI
  * Add the ability to create an NFC tag with a given token
  * Improve the design and elements in the UI
* Ideas for new features
  * Improve login/logout behaviour until the GPII is taking care of it
  * Add text-based login facilities

