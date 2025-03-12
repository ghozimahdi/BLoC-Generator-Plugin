# **GM-BLoC Generator 🚀**

**GM-BLoC Generator** is a plugin for **IntelliJ IDEA & Android Studio** that automatically generates **BLoC files** using **Freezed & Injectable** for **Flutter** projects.  
Save time, reduce boilerplate, and focus on feature development! 🎯

---

## ✨ **Features**
✅ **Generates 3 main files (`_bloc.dart`, `_event.dart`, `_state.dart`)**  
✅ **Uses Freezed for event & state management**  
✅ **Injectable support for Dependency Injection**  
✅ **Automatically names files based on user input**  
✅ **Seamlessly integrates with IntelliJ & Android Studio**

---

## ⚡ **Installation**
### **1️⃣ Download & Install from Plugin Marketplace**
1. **Open IntelliJ/Android Studio**
2. **Go to Settings ➝ Plugins ➝ Marketplace**
3. Search for **"GM-BLoC Generator"** and click **Install**
4. Restart your IDE to apply changes

### **2️⃣ Or Install Manually from GitHub**
1. **Download the `.zip` file from [Releases](https://github.com/USERNAME/GM-BLoC-Generator/releases)**
2. **Open IntelliJ/Android Studio**
3. **Go to Settings ➝ Plugins ➝ Install Plugin from Disk...**
4. Select the downloaded `.zip` file and restart your IDE

---

## 🚀 **How to Use**
1. **Select the folder where you want to create the BLoC files**
2. **Run the "GM-BLoC Generator" command via the Tools menu or the available button**
3. **Enter the BLoC name** (e.g., `login`)
4. The plugin will automatically generate the following files in the selected folder:
   ```
   login_bloc.dart
   login_event.dart
   login_state.dart
   ```
5. **Ready to use!** 🎉

---

## 🛠 **Generated Files Example**
### **📄 `login_bloc.dart`**
```dart
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:injectable/injectable.dart';

part 'login_bloc.freezed.dart';
part 'login_event.dart';
part 'login_state.dart';

@injectable
class LoginBloc extends Bloc<LoginEvent, LoginState> {
  LoginBloc() : super(const LoginState.initial()) {
    on<LoginEvent>((event, emit) {
      // TODO: implement event handler
    });
  }
}
```

### **📄 `login_event.dart`**
```dart
part of 'login_bloc.dart';

@freezed
class LoginEvent with _$LoginEvent {
  const factory LoginEvent.started() = _Started;
}
```

### **📄 `login_state.dart`**
```dart
part of 'login_bloc.dart';

@freezed
class LoginState with _$LoginState {
  const factory LoginState.initial() = _Initial;
}
```

---

## 🌟 **Contributing**
💡 **Have ideas for new features or found a bug?**  
Feel free to create an **Issue** or submit a **Pull Request**! All contributions are highly appreciated. 🙌

---

## 📜 **License**
**MIT License** - Free to use and modify! 🎉

