#Removing ./target folder
rm -rf target

#Creating ./target folder
mkdir target

#Compiling source code
javac src/java/edu/school21/printer/*/*.java -d ./target

#Starting source code
java -cp target edu.school21.printer.app.Program . 0 ../it.bmp