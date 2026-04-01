# 📚 EPUB Reader Android

Ứng dụng Android đọc file EPUB được xây dựng bằng Kotlin và FolioReader.

## ✨ Tính năng

- 📂 Chọn file EPUB từ bộ nhớ thiết bị
- 📖 Đọc sách với giao diện đẹp, dễ nhìn
- 🌙 Hỗ trợ chế độ ban đêm (Night Mode)
- 🔊 Đọc to nội dung (Text-to-Speech)
- 🔖 Đánh dấu trang (Bookmark)
- 📝 Tô màu và ghi chú (Highlight & Note)
- 📊 Hiển thị tiến độ đọc

## 📋 Yêu cầu hệ thống

- Android 7.0 (API 24) trở lên
- Android Studio Hedgehog (2023.1.1) trở lên
- JDK 17

## 🚀 Hướng dẫn cài đặt

1. Clone repository:
   ```bash
   git clone https://github.com/viettranassaabloy/epub-reader-android.git
   ```

2. Mở project bằng **Android Studio**

3. Chờ **Gradle Sync** hoàn tất (cần Internet để tải FolioReader từ JitPack)

4. Nhấn **▶ Run** để build và chạy

## 📱 Hướng dẫn sử dụng

1. Mở ứng dụng
2. Nhấn **"📂 Chọn File EPUB"** để chọn file từ bộ nhớ
3. Nhấn **"📖 Đọc Sách"** để bắt đầu đọc
4. Trong khi đọc, có thể:
   - Vuốt trái/phải để lật trang
   - Nhấn vào giữa màn hình để hiện menu
   - Bật/tắt Night Mode
   - Sử dụng TTS để nghe đọc sách

## 📁 Cấu trúc project

```
epub-reader-android/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/epubreader/
│   │   │   └── MainActivity.kt
│   │   ├── res/
│   │   │   ├── layout/activity_main.xml
│   │   │   └── values/
│   │   │       ├── strings.xml
│   │   │       ├── colors.xml
│   │   │       └── themes.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── README.md
```

## 🛠️ Công nghệ sử dụng

| Công nghệ | Phiên bản |
|---|---|
| Kotlin | 1.9.22 |
| Android Gradle Plugin | 8.2.0 |
| FolioReader | r2.6 |
| Material Components | 1.11.0 |
| AndroidX Activity | 1.8.2 |

## 📄 License

MIT License
