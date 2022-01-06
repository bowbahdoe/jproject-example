## To compile
1. Have Java 17 available on your command line
2. Have the clojure command line tools installed
3. java -cp $(clj -A:build -Spath) --enable-preview --source 17 build/Build.java
4. java -jar target/program-0.0.2.jar