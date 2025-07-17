# 📥 Android PDF File Downloader
This Android app demonstrates how to download a PDF file from a URL using the built-in DownloadManager. The app requests necessary permissions and initiates the file download when the user clicks the Download button. 


# 🚀 Features
<li>Downloads a file using DownloadManager
<li>Saves the file to the Downloads directory
<li>Displays a system notification on download completion
<li>Handles runtime storage permission checks (for Android 6.0+)

# 🛠️ Tech Stack
<li>Kotlin
<li>Android SDK
<li>DownloadManager API
<li>ViewBinding

# 📂 File Download Flow
```
val pdfFileLink = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"
val fileName = pdfFileLink.substringAfterLast("/")
downloadFile(pdfFileLink, fileName)
```

# 🧩 Integration
If you're integrating similar functionality in your project, follow these steps:

1. Add Permission in AndroidManifest.xml:
```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"
    android:maxSdkVersion="28"/>
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
```

2. Use DownloadManager to Download File:
```
val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
val request = DownloadManager.Request(Uri.parse(fileUrl))
request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)
downloadManager.enqueue(request)
```

3. Handle Runtime Permissions (if required)
```
ActivityCompat.requestPermissions(
    this,
    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
    REQUEST_CODE
)
```

# 📷 UI
The UI contains a single button:
🔘 Download PDF – triggers the download process.
