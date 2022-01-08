<img src ="https://github.com/amajaying/KiiT.App/blob/main/ScreenShots/app%201.png">
<p>
<h1>KiiT Explore App</h1>

*"An app to simplify the complicated website navigation and keep track of Attendance"*

```
Use the following credential to login into the app
email = user@user.com
password = user123
```

<hr>

**Problem Statement:**

**Problem 1:**
While exploring colleges/universities after 12th, I, as well as, most of my friends were going across a lot of complicated websites which took a lot of time. I believe every student goes through this phase.

**Problem 2:**
After joining KIIT, I got to know about the SAP portal. But the UI of the portal was really bad and was not to the point because it has a lot of options that are really not needed on a daily basis. It is really hard to keep track of Attendance from that site.

**Problem 3:**
Our university conveys all the information through Gmail. But, some of the students from our class don't get those emails. For a university, it is hard to keep track of all emails of the students.

**Proposed Solutions:**

This app has two features:
**“Login with email and password” and “Skip Login/No Login”**

So with “**Skip Login”,** here comes the **Solution for Problem 1:**<br><br>
<img src ="https://github.com/amajaying/KiiT.App/blob/main/ScreenShots/app%202.png"><br> <br>

After clicking on the “Skip Login” button on the Login Screen, the user is sent to a Home Screen where the user can get all the information needed to know about the university before joining like “Rankings, Placements, Academics, Campus Life, Mission & Vision of University and also other general information”.

The purpose of this feature is to make the complicated university choosing process simpler. The project's scope is to extend it for other institutions in the future in collaboration.
<hr>

Then, with **“Login with email and password”,** we come to the **Solution for Problem 2:**

This app has an **“Attendance”** section where the student can keep track of his/her Monthly attendance also with the percentage shown right there. So, it solves the problem of going to the portal every day, and also it decreases the **number of clicks** a user has to do.

<hr>

With the **“Notifications”** section in the app, we come to the **Solution of Problem 3:**



In the app, we have a Notification section that can be used by the University and Professors to convey the information to the students without having trouble keeping track of emails sent.
This makes information accessible to every student at their fingertip.

<br>
<img src="https://github.com/amajaying/KiiT.App/blob/main/ScreenShots/app%203.png">
<hr>



**Additional Features:**

<br>
<img src="https://github.com/amajaying/KiiT.App/blob/main/ScreenShots/app%204.png">
<br>
1. In this app, the student can also edit their information using **the “Edit Profile”** section. This makes it easier to update the student information without having to send emails to the administration.

```
Example: If a student changes his number, he can easily update it from the app itself which is an easier approach.
```
**2.** There is a note-taking section in the app itself that can be used by students to write To-Dos, Assignments, and important things in the app *(which gets saved in the memory of the device)*

<hr>

**Functionality & Concepts used:**

This App has a very simple and interactive interface which helps the students navigate the app easier and faster. Following are some of the android concepts used in the app to achieve the functionalities:

- **Bottom Navigation:** It has bottom navigation to navigate between screens and gives users a more enhanced UI interface.
- **Constraint Layout & Linear Layout:** Most of the activities in the app uses a flexible constraint layout, which is easy to handle for different screen sizes.
- **LiveData & Room Database:** We are using LiveData to Create, Store, Edit, and Update the notes to local databases using Room.
- **Simple & Easy Views Design:** Use of familiar audience EditText with hints and interactive buttons made it easier for students to Login and Edit their profile. App also uses App Navigation to switch between different screens. It consists of Material Widgets and components like Card Views, Bottom Sheet Dialog, etc. This app also uses App Navigation (Jetpack Library Component) to switch between different screens.
- **Recycler View:** To present the list of Notes, Societies, and Notifications, efficient recyclerview was used.
- **Firebase:** In order to implement the Login and Logout Feature and to fetch the data of users, Firebase Realtime Database was used.

<hr>

**Application Link & Future Scope:**

<br>
This app is currently in the prototype phase and in order to start using this app in real, APIs integration is a must.
You can access the <a href="https://drive.google.com/file/d/1k2sPD8lznFT6UlyoW8LNsb0H-qaxWyJ3/view?usp=sharing">apk file</a> or check our Codebase on <a href="https://github.com/amajaying/Explore-KiiT-App">Github.</a>

We can collaborate with KIIT University and integrate the SAP portal’s API to the app and make effective use of the app.

In the future, we can add the subject-based attendance tracking system which is right now is available on the KiiT Portal site. Also, we can add the class-reminder feature which can be useful to all the students. Also, we can add separate sections for notification from teachers and university administration. We can do modifications to enhance the UI/UX.


```
Version: 1.0.0
Released on: 8th January, 2022
```
