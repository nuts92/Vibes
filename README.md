# Vibes App

This is the repository for the Music Player App Project required by the Udacity Nanodegree Program.

### App Description

Vibes App is a Music Player App inspired from the Anghami App that allows the user to explore Different Categories of Music.
The user can save the songs he/she likes and view all the saved songs ordered by timestamp in the Library Section. This App doesn't 
actually play Music, it's an app that layout the flow for the structure of a Music Player app.

### App Design

The App has multiple screens and features which are as follows:

### The Splash Screen

When the user opens the TrackIt App, it starts with a Splash Screen which is the first startup screen that appears when 
the TrackIt App is opened. It is a simple constant screen that is displayed for a fixed amount of time basically 3000 seconds which is used to display the TrackIt App Logo in an animated way as shown below.

### The Splash Screen Screenshot

<img src="https://media.giphy.com/media/Xy7yI06MqwXUtL5zcq/giphy.gif" width="300">

### The Vibes Sign Up Process

After the Splash Screen, the user is redirected to the Vibes Sign Up Screen. The App Sign Up Process is built using the 
FirebaseUI Authentication that provides the user with two Sign-In Providers’ Options which are Google and Email. 

### The Vibes Sign Up Screenshot

<img src="https://media.giphy.com/media/hWibqjUDWGRAO8wbMz/giphy.gif" width="300">

### Signing Up using Google

If the user chooses to sign up with Google Option, the authentication process will ask the user to  sign up with his/her Google Account and enter his/her google email and password. Also, there are additional useful features in case the user forgot the password, want to sign up with another Goggle Account or create a new Google Account.

### Google Sign Up Screenshots

<img src="https://i.imgur.com/KuWLAYN.png" width="300"> <img src="https://i.imgur.com/XplZmus.png" width="300"> <img src="https://i.imgur.com/MaCwfi2.png" width="300"> 

### Signing Up using Email

However, if the user chooses to sign up with the Email Option and the user was a new one (hasn’t signed before), the authentication process will ask the user to enter an email, first and last name, and a password. Then the user will be redirected to the main screen where he/she can explore music or navigate to other sections in the App. 

### Email Sign Up Screenshots

<img src="https://i.imgur.com/3nP7WS3.png" width="300"> <img src="https://i.imgur.com/LExuRZY.png" width="300"> 
<img src="https://i.imgur.com/MaCwfi2.png" width="300"> 

Once the user signs up with either Google or Email option, the user data is extracted from the Firebase Auth instance and a user document is created and stored in Firebase Firestore database so that we can display the user information in the User Profile section in the App using this document and also so that when the user wants to update his/her profile, the updated data will be merged with the currently existing user data stored in this document and the new data will be the one displayed. Each user document is named after the unique User Id and stored inside a collection called “Users” as displayed in the screenshot below. So there is a collection called Users and inside this collection there are documents, one for each user and inside each document is another collection called Songs.
 
### FireStore Database Users Collection Screenshot
 
  <img src="https://i.imgur.com/jbzuxhh.png"> 
  
### Explore Music Section
  
Now the user has signed up successfully and logged in to the MainActivity. The MainActivity consists of a Bottom Navigation where the user can navigate between different sections(fragments) of the App includeing Explore Music, User's Library, and User Profile. The first and main screen that appears to the user when he/she signs in is the Explore Music as shown below. The user can scroll through different categories of Music including Popular Category, Trending Category, Morning Category, Evening Category, Relax Category, and Driving Category.

When the user clicks on any of the songs displayed, the user is redirected to the NowPlaying Activity where he/she can start listening to the song chosen and even add it to favorites by clicking on the like button. The user can view a Specific Category's List of Songs by clicking for example on the View All Button that is next to both the Popular and Trending Categories. Also, the user can view other lists of songs by scrolling to the Moods and Activities section and clicking on any of the displayed categories as shown below.

### Explore Music Section Screenshots
  
<img src="https://media.giphy.com/media/gHyrDerxNUqJiXEsb7/giphy.gif" width="300"> <img src="https://media.giphy.com/media/U6G83sGZWogbZQSNCz/giphy.gif" width="300"> <img src="https://media.giphy.com/media/W35fLvtpbVZ0rPJaf1/giphy.gif" width="300"> 

 ### Library Screen
 
In the NowPlaying Activity, if the user clicks on the like button then the current song will be added to the Firestore database inside the collection "Songs" and the song will be displayed in the User's Library Section. However, if the user unlikes a song then it will be removed from the "Songs" collection in the database and as a result will be removed from the User's Library.
 
The user can view all of his/her saved or liked songs in the Library Section. When the user clicks on any of the songs in the Library's List, the user is redirected to the NowPlayong activity where he/she can start listening to this song as shown below.

 ### Library Screen Screenshot

<img src="https://media.giphy.com/media/SV5fisNc9qPHX52dP2/giphy.gif" width="300"> <img src="https://media.giphy.com/media/MbL7bglAe1q6uveBnD/giphy.gif" width="300">

### FireStore Database Songs Collection Screenshot
 
  <img src="https://i.imgur.com/l1NX0rT.png"> 

### User Profile
  
Every user has a profile where the name and the email are displayed along with the profile photo if the user has signed up with the Google option. However, if the user has signed up with the Email option then the displayed photo in the user profile will be the default avatar. Also, every user can have a small self introduction about him/her self and if the user is new meaning signed up for the first time, the self introduction displayed will be the default one as shown below. Every user can choose to update the profile by clicking on the update button and now he/she can choose a profile photo, a display name, and a self introduction that he/she likes. The new updates will be saved in Firestore database and displayed in the user profile as shown below.

### User Profile Screenshots
  
<img src="https://i.imgur.com/WvsUMZD.png" width="300"> <img src="https://i.imgur.com/uNcqrnf.png" width="300"> <img src="https://i.imgur.com/EFZ5n6K.png" width="300">

### Dowload the App
To use this repository, fork/clone it, or download a zip using the green "Clone or download" button at the top of the file list. 

### License

Copyright 2020 Doha Nabil Saad Kash

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
