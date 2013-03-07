#$Id: Makefile,v 1.2 2010/08/23 10:46:23 oraz Exp $

CPP 			= $(wildcard *.cpp)
PROGRAMS	= $(CPP:%.cpp=%) 
CFILES 			= $(wildcard *.c)
PROGRAMC	= $(CFILES:%.c=%) 
JFILES 			= $(wildcard *.java)
PROGRAMJ	= $(JFILES:%.java=%.class) 
LIBRARIES	= 

CC			= gcc
CXX			= g++
CFLAGS		+= -Wall -O3
CPPFLAGS		+= -Wall -O2
LDFLAGS		= $(LIBRARIES:%=-l%)
JC          = javac

.PHONY: all clean

all: $(PROGRAMS) $(PROGRAMC) $(PROGRAMJ)

%: %.cpp
	$(CXX) $(CPPFLAGS) $^ -o $@

%: %.c
	$(CC) $(CFLAGS) $^ -o $@

%.class: %.java
	$(JC) $^

clean:
	rm -f *.o *.a $(PROGRAMS) $(PROGRAMC) $(PROGRAMJ)

