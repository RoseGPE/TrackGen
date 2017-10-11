# TrackGen
Tool for making tracks to be used by RoseLap V2

## Input:
TBD

## Output:
A list of 'segments', each with the following attributes:
    x: The x position of this segment
    x_m: The x position of the previous segment, -1 if non-existent
    x_p: The x position of the next segment, -1 if non-existent

    y: The y position of this segment
    y_m: The y position of the previous segment, -1 if non-existent
    y_p: The y position of the next segment, -1 if non-existent

    length_m: The length of the previous segment, -1 if non-existent
    length_p: The length of the next segment, -1 if non-existent
    length: The average of length_m and length_p, if one does not exist, the length of the other segment
    length_secant: The length betweern the previous and next segment. If one does not exist, the length of the current segment

    curvature: The curvature of the segment based on the (x, y) position of the previous, current, and next segments

Note: All coordinates should be according to standard Euclidean coordinates for images, meaning (0, 0) is the top-most and left-most coordinates
