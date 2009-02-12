#
# $Id$
#

SOURCES    := $(wildcard *.java)
CLASSES    := $(patsubst %.java,%.class,$(SOURCES))
JC      = jikes
JFLAGS  = +E

%.class: %.java
	@rm -f $@
	$(JC) $(JFLAGS) $<

all: $(CLASSES)

clean:
	rm -f core *~ *.class
