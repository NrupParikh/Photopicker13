# Photopicker13
This demo application show the Photo Picker introduced in Android13. Which allow user to select single and/or multiple Images and/or Videos.

# This demo includes below feature and functionality

1. Navigation
2. ViewPager2
3. Tab Layout with Fragments
4. Coil for Image loading
5. Exoplayer to play Video
7. Palette API for getting color from Image

# Demo inlcude total 8 fragments as a Tab

1. Tab1 : Only Image - Pick only 1 Image from Photo Picker
2. Tab2 : Only Video - Pick only 1 Video from Photo Picker
3. Tab3 : Multiple Images - Pick multiple Images from Photo Picker. Max(2) limit set
4. Tab4 : Multiple Videos - Pick multiple Videos from Photo Picker. Max(2) limit set
5. Tab5 : Image or Video - Pick image or  Videos from Photo Picker
6. Tab6 : Images and Videos - Pick image and  Videos from Photo Picker. Max(2) limit set<br />
7. Tab7 : **Coil - Image Transformations.**<br />
  &nbsp;&nbsp;&nbsp;&nbsp; *7.1 : RoundedCornersTransformation* <br />
  &nbsp;&nbsp;&nbsp;&nbsp; *7.2 : CircleCropTransformation* <br />
  &nbsp;&nbsp;&nbsp;&nbsp; *7.3 : BlurTransformation with CircleCropTransformation* <br />
  &nbsp;&nbsp;&nbsp;&nbsp; *7.4 : GrayscaleTransformation with CircleCropTransformation* <br />
  &nbsp;&nbsp;&nbsp;&nbsp; *7.5 : CropTransformation* <br />
  &nbsp;&nbsp;&nbsp;&nbsp; *7.6 : SquareCropTransformation* <br />
  &nbsp;&nbsp;&nbsp;&nbsp; *7.7 : MaskTransformation* <br />
  &nbsp;&nbsp;&nbsp;&nbsp; *7.7 : VideoFrameMillis for getting Frame from Video at particular time duration* <br />
  &nbsp;&nbsp;&nbsp;&nbsp; **7.8 : Palette API to get different colors from Image such as**  <br />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *7.7.1 : vibrantSwatch* : Returns the most vibrant swatch in the palette  <br />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *7.7.2 : darkVibrantSwatch* : Returns a dark and vibrant swatch from the palette  <br />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *7.7.3 : lightVibrantSwatch* : Returns a light and vibrant color from the palette <br />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *7.7.4 : mutedSwatch* : Returns a muted color from the palette <br />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *7.7.5 : darkMutedSwatch* : Returns a muted and dark color from the palette <br />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *7.7.6 : lightMutedSwatch* : Returns a muted and light swatch from the palette  <br />  <br />
8. Tab8 : Exoplayer
