# QRify 📱

A modern Android QR Code Generator built with **Kotlin** and **Jetpack Compose**.

QRify allows users to generate QR codes from text or URLs, preview them instantly, save them to the device gallery, and share them with other applications.

## ✨ Features

* 🔤 Generate QR codes from text or URLs
* 🖼️ Display generated QR codes instantly
* 💾 Save QR codes as PNG images to the device gallery
* 📤 Share QR codes with other apps
* 🌙 Light and Dark mode support
* 🎨 Modern Material 3 UI
* ⚡ QR generation handled asynchronously
* 🔒 Secure image sharing using Android `FileProvider`

## 🛠️ Tech Stack

* **Kotlin**
* **Jetpack Compose**
* **Material 3**
* **MVVM**
* **StateFlow**
* **ZXing** — QR code generation
* **Android MediaStore** — saving QR images
* **FileProvider** — secure image sharing
* **Coroutines**
* **AndroidX ViewModel**
* **AndroidX SplashScreen**

## 🏗️ Architecture

The application follows the **MVVM (Model–View–ViewModel)** architecture.

```text
UI (Compose)
    │
    ▼
HomeViewModel
    │
    ├── QR Generation
    │      └── ZXing
    │
    ├── Save QR
    │      └── QrStorageManager
    │             └── MediaStore
    │
    └── Share QR
           └── QrShareManager
                  └── FileProvider
```

The UI observes the `HomeUiState` exposed by `HomeViewModel` using `StateFlow`.

## 📂 Project Structure

```text
com.example.qrify
│
├── data
│   ├── QrStorageManager.kt
│   └── QrShareManager.kt
│
├── ui
│   ├── home
│   │   ├── HomeScreen.kt
│   │   ├── HomeViewModel.kt
│   │   └── HomeUiState.kt
│   │
│   └── theme
│
└── MainActivity.kt
```

### Main Components

**HomeScreen**

* Displays the QRify interface.
* Handles user input.
* Displays the generated QR code.
* Provides Save and Share actions.
* Supports Light/Dark mode switching.

**HomeViewModel**

* Manages screen state.
* Generates QR codes using ZXing.
* Handles save and share actions.
* Performs background work using Kotlin Coroutines.

**QrStorageManager**

* Saves generated QR codes as PNG images.
* Uses Android `MediaStore`.
* Stores images under:

```text
Pictures/QRify
```

**QrShareManager**

* Creates a temporary PNG file in the app cache.
* Generates a secure `content://` URI using `FileProvider`.
* Shares the QR code using Android's Sharesheet.

## 🔄 QR Generation Flow

```text
User enters text / URL
        ↓
Generate QR button
        ↓
HomeViewModel
        ↓
ZXing QRCodeWriter
        ↓
BitMatrix
        ↓
Android Bitmap
        ↓
QR displayed on screen
```

## 💾 Save Flow

```text
Generated QR
     ↓
Save QR
     ↓
QrStorageManager
     ↓
MediaStore
     ↓
Pictures/QRify
```

The application uses `MediaStore` for saving images and does not require legacy external storage permissions on modern Android versions.

## 📤 Share Flow

```text
Generated QR
     ↓
Share QR
     ↓
QrShareManager
     ↓
Temporary PNG in cache
     ↓
FileProvider
     ↓
content:// URI
     ↓
Android Sharesheet
```

The app uses `FileProvider` instead of exposing a direct `file://` URI.

## 🎨 UI & Theming

QRify uses **Material 3** with a custom color palette.

The application supports:

* Light theme
* Dark theme
* Manual theme switching
* Custom QRify branding
* Material 3 components
* Android splash screen

## 🚀 Getting Started

### Requirements

* Android Studio
* JDK 17+
* Android SDK
* Android device or emulator

### Clone the Repository

```bash
git clone https://github.com/Ahlamgomaa/Auspify-Android-Task-01-QR-Code-Generator.git
```

### Open the Project

Open the project in Android Studio and allow Gradle to sync.

### Run

Select an Android emulator or connected device and run the `app` configuration.

## 🧪 Testing

The application was tested for the main user flows:

* Entering text
* Entering URLs
* Generating QR codes
* Displaying generated QR codes
* Saving QR codes to the gallery
* Sharing QR codes
* Light/Dark mode switching
* Empty input handling
* Android build verification

## 📱 Screenshots

Screenshots can be added here after capturing the final application UI.

```text
screenshots/
├── home_light.png
├── home_dark.png
├── qr_generated.png
└── share_sheet.png
```

## 👩‍💻 Developer

**Ahlam Gomaa Senosy**

Android / Mobile Developer

* GitHub: [Ahlamgomaa](https://github.com/Ahlamgomaa)
* Repository: [QRify](https://github.com/Ahlamgomaa/Auspify-Android-Task-01-QR-Code-Generator)

## 📌 Internship Task

This project was developed as part of the **Auspify Technologies Android Development Internship**.

### Task 01 — QR Code Generator

The task focuses on:

* Android UI development
* QR code library integration
* Image handling
* Device storage
* Secure image sharing
* Modern Android development practices
