
##The Assignment

Using the Java programming language, you are to design, build, test and deploy a color picker Android app.

The color picker is based on hue, saturation and value/lightness (HSV).

##Functional Requirements

The functional requirements for this assignment:

####Initial State of App
Display the color black when your app first launches. The HSV values for black: 0° hue, 0% saturation, and 0% value/lightness.
####Color Swatch <TextView>
Display the color based on the current settings for the hue, saturation, and value (HSV) seek-bars.
####Color Swatch <TextView> :: onLongClick( )
Display the current color's HSV values. Use a Toast message (short) to display the following formatted message: H: <hue>° S: <saturation>% V: <value>%. Where <hue>, <value> and <saturation> are the HSV values. For example, H: 240° S: 100% V: 100%
####Hue <SeekBar>
Change the color swatch's hue in real-time (!) as the user slides the hue seek-bar. As the hue is changing, change the prompt (a <TextView>) Hue to HUE: <hue>°. For example, Hue: 300°. When the user finishes changing the hue value, change the prompt back to: Hue
####Saturation <SeekBar>
Change the color swatch's saturation in real-time (!) as the user slides the saturation seek-bar. As the saturation is changing, change the prompt (a <TextView>) Saturation to SATURATION: <saturation>%. For example, Saturation: 80%. When the user finishes changing the saturation value, change the prompt back to: Saturation
####Value <SeekBar>
Change the color swatch's value in real-time (!) as the user slides the value seek-bar. As the value is changing, change the prompt (a <TextView>) Value / Lightness to VALUE / LIGHTNESS: <value>%. For example, Value: 40%. When the user finishes changing the value, change the prompt back to: Value
####<SeekBar> :: <gradient>
Notice each <SeekBar> object has a <gradient>. The <gradient> for the hue seek-bar is in color (android:startColor="#0F0", android:centerColor="#00F" and android:endColor="#F00"). The saturation seek-bar's b&w <gradient> (android:startColor="#FFF", android:centerColor="#5b5b5b" and android:endColor="#000"). Your //TODO is to figure out the <gradient> for the value/lightness seek-bar. See Helpful Resources below for how to define a <gradient>.
####Color Buttons <Button> :: onClick( )
The app has 15 color buttons (in this order): black, red, lime, blue, yellow, cyan, magenta, silver, gray, maroon, olive, green, purple, teal and navy. When the user clicks one of the color buttons:
set the color swatch to the clicked button's HSV color
set the hue seek-bar
set the saturation seek-bar
set the value seek-bar
Display a Toast (short) message: H: <hue>° S: <saturation>% V: <value>%. For example, H: 359° S: 100% V: 100% 
####About Dialog
Provide an information icon to the app's Action Bar. When clicked, display a dialog (i.e. AlertDialog) that displays your full name (first & last) and username. For example: Gerry Hurdle (hurdleg). Dismiss the dialog when the OK button is clicked.

##Android Project Requirements

See: NEW: How to Create a Blank Activity in Android Studio 1.4

Launch Android Studio, close all projects, and Start a new Android Studio project:

Application name: HSV Color Picker
Company Domain: yourAlgonquinUsername.algonquincollege.com
{Next}
Check: Phone and Tablet
Minimum SDK: API 23: Android 6.0 (Marshmallow)
{Next}
Blank Activity
{Next}
{FINISH: accept default values for MainActivity etc.}

##Domain Range for HSV Values

Here are the domain ranges --- the list of legal values --- for each HSV value:

####Hue
The hue's domain range is: 0 to 359 degrees (inclusive)
####Saturation
The saturation's domain range is: 0 to 100% (inclusive)
####Value / Lightness
The value's domain range is: 0 to 100% (inclusive)

##Visual Requirements

 My app has the following component tree of <View> objects:

RelativeLayout
colorSwatch <TextView>
hue <TextView>
hueSB <SeekBar>
saturation <TextView>
saturationSB <SeekBar>
value <TextView>
valueSB <SeekBar>
horizontalScrollView
buttonGroup1 <LinearLayout>
blackButton <Button>
redButton
limeButton
blueButton
yellowButton
cyanButton
magentaButton
silverButton
grayButton
maroonButton
oliveButton
greenButton
purpleButton
tealButton
navyButton
 Important note: your UI should look very, very similar to mine. Notice I did not say identical.

##Other Requirements

Custom Launch Icon
Design and use a custom icon for your app's launch icon.
