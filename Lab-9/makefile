JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Game.java \
	Die.java \
	Driver.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
