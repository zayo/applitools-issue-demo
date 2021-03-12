This demo is a reproducible scenario for dependency issues with minified apk.

The details are described in app/build.gradle file.

# Issue result
This demo produces exception 
```java
java.lang.NoClassDefFoundError: Failed resolution of: Lcom/fasterxml/jackson/core/ObjectCodec;
at com.applitools.eyes.android.common.network.ConnectionFactory.create(ConnectionFactory.java:10)
at com.applitools.eyes.android.core.EyesBase.<init>(EyesBase.java:74)
at com.applitools.eyes.android.espresso.Eyes.<init>(RunningSession:65)
at com.playground.atid.test.ExampleApplitoolsTest.<init>(ExampleApplitoolsTest.kt:26)
at java.lang.reflect.Constructor.newInstance0(Native Method)
at java.lang.reflect.Constructor.newInstance(Constructor.java:343)
at org.junit.runners.BlockJUnit4ClassRunner.createTest(BlockJUnit4ClassRunner.java:250)
at org.junit.runners.BlockJUnit4ClassRunner.createTest(BlockJUnit4ClassRunner.java:260)
at org.junit.runners.BlockJUnit4ClassRunner$2.runReflectiveCall(BlockJUnit4ClassRunner.java:309)
at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
at org.junit.runners.BlockJUnit4ClassRunner.methodBlock(BlockJUnit4ClassRunner.java:306)
at org.junit.runners.BlockJUnit4ClassRunner$1.evaluate(BlockJUnit4ClassRunner.java:100)
at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:366)
at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:103)
at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:63)
at org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)
at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)
at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)
at org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)
at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)
at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
at org.junit.runners.ParentRunner.run(ParentRunner.java:413)
at org.junit.runners.Suite.runChild(Suite.java:128)
at org.junit.runners.Suite.runChild(Suite.java:27)
at org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)
at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)
at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)
at org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)
at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)
at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
at org.junit.runners.ParentRunner.run(ParentRunner.java:413)
at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
at androidx.test.internal.runner.TestExecutor.execute(TestExecutor.java:56)
at androidx.test.runner.AndroidJUnitRunner.onStart(AndroidJUnitRunner.java:395)
at android.app.Instrumentation$InstrumentationThread.run(Instrumentation.java:2145)
Caused by: java.lang.ClassNotFoundException: Didn't find class "com.fasterxml.jackson.core.ObjectCodec" on path: DexPathList[[zip file "/system/framework/android.test.runner.jar", zip file "/system/framework/android.test.mock.jar", zip file "/data/app/com.playground.atid.test-wNzdgcJwG--1BBnQbKK9Jg==/base.apk", zip file "/data/app/com.playground.atid-5IXw5gqHIR1I1wNuuVG3sA==/base.apk"],nativeLibraryDirectories=[/data/app/com.playground.atid.test-wNzdgcJwG--1BBnQbKK9Jg==/lib/x86, /data/app/com.playground.atid-5IXw5gqHIR1I1wNuuVG3sA==/lib/x86, /system/lib]]
at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:134)
at java.lang.ClassLoader.loadClass(ClassLoader.java:379)
at java.lang.ClassLoader.loadClass(ClassLoader.java:312)
... 36 more
```

# Ok result
Ok scenario for this use case if to fail on invalid applitools URL. You should see this exception in the logcat.
```java
E/AndroidRuntime: FATAL EXCEPTION: Thread-2
    Process: com.playground.atid, PID: 7779
    com.applitools.eyes.android.common.exceptions.EyesException: Failed to connect to server 
        at com.applitools.eyes.android.common.network.RestClient$1.run(RestClient.java:121)
        at java.lang.Thread.run(Thread.java:764)
     Caused by: java.net.ConnectException: Failed to connect to localhost/127.0.0.1:443
        at com.android.okhttp.internal.io.RealConnection.connectSocket(RealConnection.java:143)
        at com.android.okhttp.internal.io.RealConnection.connect(RealConnection.java:112)
        at com.android.okhttp.internal.http.StreamAllocation.findConnection(StreamAllocation.java:184)
        at com.android.okhttp.internal.http.StreamAllocation.findHealthyConnection(StreamAllocation.java:126)
        at com.android.okhttp.internal.http.StreamAllocation.newStream(StreamAllocation.java:95)
        at com.android.okhttp.internal.http.HttpEngine.connect(HttpEngine.java:281)
        at com.android.okhttp.internal.http.HttpEngine.sendRequest(HttpEngine.java:224)
        at com.android.okhttp.internal.huc.HttpURLConnectionImpl.execute(HttpURLConnectionImpl.java:461)
        at com.android.okhttp.internal.huc.HttpURLConnectionImpl.connect(HttpURLConnectionImpl.java:127)
        at com.android.okhttp.internal.huc.DelegatingHttpsURLConnection.connect(DelegatingHttpsURLConnection.java:89)
        at com.android.okhttp.internal.huc.HttpsURLConnectionImpl.connect(HttpsURLConnectionImpl.java:26)
        at com.applitools.eyes.android.common.network.RestClient.makeRequest(RestClient.java:400)
        at com.applitools.eyes.android.common.network.RestClient$1.run(RestClient.java:106)
        at java.lang.Thread.run(Thread.java:764)
```
