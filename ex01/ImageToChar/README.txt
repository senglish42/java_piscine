#Removing ./target folder
rm -rf target

#Creating ./target folder
mkdir target

#Compiling source code
javac src/java/edu/school21/printer/*/*.java -d ./target
cp -R src/resources target/.

#Creating .jar archieve
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

#Getting access to .jar file
chmod 7777 target/images-to-chars-printer.jar

#Archieve assembling and startup
java -jar ./target/images-to-chars-printer.jar . 0
