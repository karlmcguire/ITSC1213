JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Card.java \
	Deck.java \
	Driver2.java \
	Invoice.java \
	Driver.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
