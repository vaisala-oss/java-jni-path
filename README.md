# java-jni-path

Java launchers for working with JNI libraries (or libraries using JNI
libraries). These packages were created because configuring
**java.library.path** is fairly poorly supported by common Java tools.

These debian packages add launchers in `/usr/local/bin` for `java`
and `mvn`, respectively. They add "`/usr/lib/jni`" to the java library path
transparently, so your other tools (build tools and IDEs) can use JNI
libraries without extra setup. This works as long as the actual java
installation is located in the path **\_after\_** `/usr/local/bin`.

## Building and Installation

These packages are versioned in Git, so the upstream and Debian versions are
identical. Each package is built by
```bash
debuild -b -us -uc
```

### Java Installation

Install the packages
```bash
dpkg -i nextexec_<ver>.deb java-jni-wrapper_<ver>.deb
```

### Maven Installation

Install the packages
```bash
dpkg -i nextexec_<ver>.deb mvn-jni-wrapper_<ver>.deb
```

## Usage

Run `java` from the `$PATH`. You should now have "`/usr/lib/jni`" in the
library path automatically, assuming you've installed the actual Java *after*
`/usr/local/bin`. You can use
[assertJniPath.java](java-jni-wrapper/assertJniPath.java) for testing.

Setting up the *Java* **Classpath** is handled well by existing tools.
See instructions for whatever you are using.

## Copyright and License

Copyright 2016 Vaisala Oyj

Licensed under the Apache License, Version 2.0 (the "[License](LICENSE)"); you
may not use this file except in compliance with the License. You may obtain a
copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed
under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
CONDITIONS OF ANY KIND, either express or implied. See the License for the
specific language governing permissions and limitations under the License.
