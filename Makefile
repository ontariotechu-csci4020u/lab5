cp = /volumes/data/lib/antlr-4.8-complete.jar:$(PWD):$(PWD)/target
jdriver = /volumes/data/bin/jdriver.sh

all: g4 java check

g4:
	java -cp $(cp) org.antlr.v4.Tool -no-listener -no-visitor src/*.g4

java:
	mkdir -p ./target
	javac -cp $(cp) -d target -sourcepath src src/*.java

clean:
	rm -f src/Calc*.java src/*.tokens src/*.interp output.edn report.edn

debug:
	java -cp $(cp) org.antlr.v4.runtime.misc.TestRig Calc program $(FILE)

check:
	$(jdriver) \
		:testdrive expected.edn output.edn \
		:report output.edn report.edn
