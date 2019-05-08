# Fotag_Android

Fotag Mobile is the Android photo album app.

The title bar on the top has a Download button which downloads all the images from the link given. These images appear
in a grid view and each image has a rating bar under it, which can be used to rate the images from 1 to 5. Apart from rating,
the user can even click on individual images to expand them to a full screen. Clicking on the image in the full screen or
pressing the back button dismisses this screen.
Download button has the same behaviour no matter which view it has been clicked on from.

The title bar also has a Clear button which clears everything, i.e., the images and the ratings given to each of them.
Clear button has the same behaviour no matter which view it has been clicked on from.

The title bar also has 5 stars which act as filters. Clicking on a particular star shows all the images which have ratings
equal to or higher than the clicked star. While in the filter view, if the rating of an image is changed to lower than the
filter selected, the image will disappear from the list of images being shown. Filtered images can be expanded as well.
Clicking on a selected filter star clears the selection and shows all the images. Clicking cancel button also clears the
selected filter, along with all the images and their ratings.

The images are being downloaded from the link every time a change is made in the application. So it might take a little time
to download and show the images depending on the internet speed.

To build the app on the command line, please run 'gradle build' command. You might have to change the SDK location in
local.properties files present in the root folder. You can also simply download the APK from the root folder and run the
application. 
