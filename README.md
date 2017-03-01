
# react-native-locale-listener

## Getting started

`$ npm install react-native-locale-listener --save`

### Mostly automatic installation

`$ react-native link react-native-locale-listener`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-locale-listener` and add `RNReactNativeLocale.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeLocale.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

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

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNReactNativeLocale.sln` in `node_modules/react-native-locale-listener/windows/RNReactNativeLocale.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Com.Reactlibrary.RNReactNativeLocale;` to the usings at the top of the file
  - Add `new RNReactNativeLocalePackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNReactNativeLocale from 'react-native-locale-listener';

// TODO: What to do with the module?
RNReactNativeLocale;
```
  