JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	ValidateFloat.java \
	Driver.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
