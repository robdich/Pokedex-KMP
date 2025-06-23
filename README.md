# Pokedex KMP
A mobile app project built using Kotlin Multiplatform and modern app development technologies and best practices.

# Technologies used
- UI Framework: **Compose Multiplatform**
- Network: **Ktor**
- Data persistence: **SqlDelight**
- Dependency Injection: **Koin**
- Image: **Coil**
- Architecture: **Modern App Architecture, Model-View-Viewmodel (MVVM) and Repository pattern**

# How to build
- Pull from github repository
- Open the project in Android Studio/IntelliJ IDE
- Install KMP and SqlDelight plugins (Might be optional)
- Initiate Gradle sync
- Run using Android emulator
- Additional steps for iOS building:
  - Follow steps to add dynamic linking https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-ktor-sqldelight.html#add-the-dynamic-linking-flag-for-sqldelight.
  - Switch to iosApp configuration, choose an emulator, and run

# API
- The app uses [PokeAPI](https://pokeapi.co/) for its data
