# Vibes App

This is the repository for the Music Player App Project required by the Udacity Nanodegree Program.

### App Description

Vibes App is a Music Player App inspired from the Anghami App that allows the user to explore Different Categories of Music.
The user can save the Songs he/she likes and view all the saved songs ordered by timestamp in the Library Section. This App doesn't 
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
When the user clicks on any of the songs displayed, the user is directed to the NowPlaying Activity where he/she can listen to the song chosen and even add it to favorites by clicking on the like button. clicks on the Start button, he/she is redirected to a screen where he/she can update the teams' names. Whether the user chooses to update the teams' names or skip this part, he/she will be redirected to the Soccer Counter screen. 

### Explore Music Section Screenshots
  
<img src="https://media.giphy.com/media/eH9f28djsTny4Rvf9U/giphy.gif" width="300"> <img src="https://media.giphy.com/media/JsUuAiN2kw1DLY8GvY/giphy.gif" width="300"> <img src="https://media.giphy.com/media/ZZMg0iDeTt6MJCncVj/giphy.gif" width="300"> 
   
 ### Library Screen
 
Here the user can track the goals and fouls of both the home team and the away team in real time. When the user is done, he/she can choose to save the game result. When the user saves the game result, a popup card shows up with an animation based on the game result and a call to action that prompts the user to start a new game. Also, A toast message is displayed showing that the game is saved. After that, the goal and foul buttons are disabled, the save game button disappears and the reset button is replaced with start a new game button as shown below.

 ### Library Screen Screenshot

<img src="https://media.giphy.com/media/TJfSUxPjeLuwyvpJI6/giphy.gif" width="300"> <img src="https://media.giphy.com/media/dWkmz9xXymxZf8KfAJ/giphy.gif" width="300"> <img src="https://media.giphy.com/media/hScfE2EAIxjinPOV59/giphy.gif" width="300"> <img src="https://media.giphy.com/media/f7NCKuYhHZkWemIAXK/giphy.gif" width="300"> 

The game counter also takes into consideration configuration changes like rotating the device to the landscape mode so that the scores and fouls that the user has entered won't be lost.

 <img src="https://i.imgur.com/g5JP54B.png" width="500"> <img src="https://i.imgur.com/up4j2mU.png" width="300">
   
### User Profile
  
Every user has a profile where the name and the email are displayed along with the profile photo if the user has signed up with the Google option. However, if the user has signed up with the Email option then the displayed photo in the user profile will be the default avatar. Also, every user can have a small self introduction about him/her self and if the user is new meaning signed up for the first time, the self introduction displayed will be the default one as shown below. Every user can choose to update the profile by clicking on the update button and now he/she can choose a profile photo, a display name, and a self introduction that he/she likes. The new updates will be saved in Firestore database and displayed in the user profile as shown below.

### User Profile Screenshots
  
<img src="https://i.imgur.com/b7cea32.png" width="300"> <img src="https://i.imgur.com/OPze6Vr.png" width="300">  <img src="https://i.imgur.com/jzqwxzV.png" width="300"> <img src="https://i.imgur.com/V2aywKN.png" width="300"> <img src="https://i.imgur.com/VGCZoMT.png" width="300">

### Dowload the App
To use this repository, fork/clone it, or download a zip using the green "Clone or download" button at the top of the file list.  
