JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Temperature.java \
	Windchill.java \
	Driver.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
