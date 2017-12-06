JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Card.java \
	Deck.java \
	Game21.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
