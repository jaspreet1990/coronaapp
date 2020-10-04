# coronaapp

This App shows Country List and Corona Detail Information baseed on Country.

This App is made on Android + Kotlin + MVVM + Repository Pattern + Room DB .

This App is based on Offline First Approach.

Gradle file contains two variants Local and Prod.

LocalDebug Variant has Orange theme while Prod App has other variant has Blue/ Purple theme.

Signing Config is in Gradle file

Retrofit is for making api request.

Extension Function is also used in App. Check GeneralExtension file in Util folder.

Unit test cases in written. Libraries used are Mockito, Robolectric, Junit.

Api Used :

Base URL : https://covid-19-data.p.rapidapi.com

End Points:

/help/countries  : Provides Countries List

report/country/name : Corona Info in Countries, This Api always giving us 0 cases, but if data comes then it will show .

Areas of Improvement:

Test Cases. I need to complete test cases that are pending. 

Test Cases written for UseCase, Api, ViewModel, HomeActivity

Remaing Test Cases for Home Frg , Detail Frg, RecyclerView adater
