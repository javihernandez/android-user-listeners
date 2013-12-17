GPII Android User Listeners
===========================

Overview
--------

**android-user-listeners** is an _all-in-one_ application for Android, which is
including two user listeners to use within the [GPII](https://github.com/GPII/)
real-time personalization framework.

At this moment this application supports both **NFC** and **QR** user listeners.

### NFC

When writing an NFC tag, **android-user-listeners** will use its own _mime-type_,
so the resulting NFC tags can't be used to log into different implementations
of the GPII until they implement the support of this mime type.

The benefit from using this _mime-type_, is that the login/logout process will
start automatically when reading the NFC tag.

Anyway, for compatibility with other implementations of the GPII, the NFC user
listener also operates with _text-plain_ NFC record types.

To use the NFC user listener just touch your device with your NFC tag.

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

* Add translations:
  * Greek
  * German
* Improve the UI
  * Improve the design and elements in the UI
* New features
  * Improve login/logout behaviour until the GPII is taking care of it
  * Allow the user to choose between _text-plain_ and _mime-type_ when writing
an NFC tag.
  * Provide more feedback to the user:
    * "Unable to connect" (ie: when the GPII is not running) issues
    * Confirming when an NFC tag has (or not) been written

