# Program Design
### Language
Program is written in Java 8, as it is the language I am most comfortable in and can probably do the best in.  
It *could* be done in Python but I only have an environment setup for Python 3.6, and the RoseLap software is in Python 2.7, also I am not very familiar with creating GUIs in Python, and would rather get this done in a reasonable timeframe than waste time learning Python GUI stuff.
_____
## Proposed designs:
### Universal features
Program will launch a window with a dialogue box to load a previous track or to create a new track  
Selecting the option to create a new track will ask the user to load an image for the track creation process  
The image will be loaded and the user will be asked to specify the scale of the image by marking out the length of one meter (The image should have a scale somewhere in it to make this easier, such as a white object known to be a meter in length that can be traced over to provide the exact length of one meter)  
The user will then select a starting point somewhere on the image  
A "point" will be created at the selected point, this is the start of the track
If the "loop" option for the track is selected the last "section" of track will always be the space between the final point and the first point otherwise the last "section" will be treated as the section between the last two points.
If the "loop" option for the track is selected, the number of laps can be selected, and the program will parse the track into the output file as many times as the number of loops selected. (This allows for multiple laps of the same track)  
The track can be saved in a program specific file type that allows this program to store the image and track data for later use (Image and track data in one file for easy portability).  This is different from unparsing the track from the RoseLap data file  
Program can also parse the loaded track into the the RoseLap data file format.
*Possibility:* The program can parse a track from existing RoseLap data file.
### Proposal 1
The user can then select from several different lengths of line "sizes" to draw the track, these "sizes" can be selected and used at any time (4m, 2m, 1m, 1/2m, 1/4m)  
A line of the selected size will then appear starting at the track starting point and following the direction of the user's cursor  
When the user left clicks a a line segment will be added/drawn along the aforementioned line, and a new line segment & point will be added to the track using that information the process of drawing a line will then be repeated until the user has clicked "done"  
Points may be selected and removed, but this will cause all points following that one to be removed  
The last point may also be moved around by clicking and dragging  
### Proposal 2
A "point" will be created at the selected point, this is the start of the track
The user can then select from several different lengths of line "sizes" to draw the track, these "sizes" can be selected and used at any time (4m, 2m, 1m, 1/2m, 1/4m) **OR** the user can choose to free-hand this section  
A line of the selected size will then appear starting at the track starting point and following the direction of the user's cursor  
When the user left clicks a a line segment will be added/drawn along the aforementioned line, the length of the current line will be displayed, and a new line segment & point will be added to the track using that information the process of drawing a line will then be repeated until the user has clicked "done"  
Points may be selected and removed, doing this will remove the point and the two sections on either side of it, replacing them with one section connecting the previous and next points.  The last point will be simply be removed along with the last section.  
Points may also be moved around by clicking and dragging  
_____ 
### Pros, Cons, and Comparison of the two proposals
Proposal one is much simpler to implement, but is far less flexible with its implementation of tracks.  
Proposal two allows for sections of track that are not a predefined length, possibly allowing much more complex/detailed track designs.  
Proposal two allows track editing to be much less time consuming because removing a point does not invalidate the remaining track.  
Proposal two could be modified to allow for selecting and dragging multiple points/sections of track. (A lot of extra work, possibly "stretch" goal)  
Track storage medium and parsing would be essentially the same for both proposals, as both would simply be a collection of points that reference their previous and next neighbors.  
