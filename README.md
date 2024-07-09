[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/Naereen/StrapDown.js/graphs/commit-activity)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)

[<img alt="modrinth" height="40" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/available/modrinth_vector.svg">](https://modrinth.com/plugin/easy-eula)

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/G2G4DZF4D)

<img src="https://raw.githubusercontent.com/MrNavaStar/EasyEula/master/common/src/main/resources/assets/easyeula/icon.png" width="300" height="300">

# Easy Eula
A tiny minecraft mod that allows you to agree to the minecraft EULA in console rather than restarting the server!

# For Developers
You can include this mod into your projects build.gradle file for convenience when developing with minecraft servers.
```gradle
repositories {
    maven { url "https://api.modrinth.com/maven" }
}

dependencies {
  modImplementation("maven.modrinth:easy-eula:1.1.0-fabric") // Or -forge
}
```

If extra functionality is required, the Eula can also be accepted in code via:
```java
EasyEula.acceptEula();
```
This is especially useful for test mods that run in automated environments.
