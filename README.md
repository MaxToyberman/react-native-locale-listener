
# react-native-locale-listener
The library allows you to listen to locale changes on your device.
for example reloading the app when the locale changed.
## Getting started

`$ npm install react-native-locale-listener --save`

### Mostly automatic installation

`$ react-native link react-native-locale-listener`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReactNativeLocalePackage;` to the imports at the top of the file
  - Add `new RNReactNativeLocalePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-locale-listener'
  	project(':react-native-locale-listener').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-locale-listener/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-locale-listener')
  	```
## Usage
add to AndroidManifest.xml this :
```Android
android:configChanges="layoutDirection|locale"
```
and to MainActivity.java
```

@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    Intent intent = new Intent("onConfigurationChanged");
    intent.putExtra("newConfig", newConfig);
    this.sendBroadcast(intent);
}
```
you can use it anywhere
```javascript
import RNReactNativeLocale from 'react-native-locale-listener';

changeLayout(language) {
    // Do what you need here
    RNRestart.Restart();
}

componentDidMount () {
  RNReactNativeLocale.addLocaleListener(this.changeLayout)
}

componentWillUnmount() {
  // prevent leaking
  RNReactNativeLocale.removeLocaleListener(this.changeLayout)
}
```
