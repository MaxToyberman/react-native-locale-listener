
Pod::Spec.new do |s|
  s.name         = "RNReactNativeLocale"
  s.version      = "1.0.0"
  s.summary      = "RNReactNativeLocale"
  s.description  = <<-DESC
                  RNReactNativeLocale
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNReactNativeLocale.git", :tag => "master" }
  s.source_files  = "RNReactNativeLocale/**/*.{h,m}"
  s.requires_arc = true
  s.homepage = "https://github.com/AlexanderZaytsev/react-native-i18n"

  s.dependency "React"
  #s.dependency "others"

end

  