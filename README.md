

![Screenshot_2022-01-12-12-14-06-419_com example electricmotorautomationapp](https://user-images.githubusercontent.com/68183759/149087280-19807651-d910-4a5e-a7f5-d345d2ee1c3b.jpg)




Watch the live working demo of this Project on [YouTube](https://www.youtube.com/watch?v=uo8SwsEWS_E).

The project uses Raspberry Pi equipped with Distance sensor (HCSR-04) to measure water level of household water reservoir when borewell motor is running and sends notification of live waterlevel to an android app. The notification is done through firebase cloud messaging which is enabled through backend server running on heroku.

Backend connects both Raspberry Pi and Android App 
[Backend Code](https://github.com/yogirajthombre/ElectricMotorAutomation-Node.js-app).

Progressbar on Android App is updated when it recieves notification of water level from the backend.

Unique feature about this app is that it can switch motor/any electrical appliance on and off from anywhere in **World** .

This Feature of App was tested from **Nanded** to **Ambejogai** over the distance of **120 km** and there was very less latency in switching.

Whenever the on or off signal is sent to server from app and python program running inside raspberry pi fetches from the particular api end point continuously and raspberry pi switches the appliance as per response it gets from api .

To replicate the motor bulb running on 230V had to be used it is connected to Raspberry Pi via single channel relay.

Android App was developed using Kotlin,MVVM architecture,Retrofit,Firebase,Firebase Cloud Messaging
