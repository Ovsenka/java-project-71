run-dist:
	./build/install/app/bin/app

run-dist-help:
	./build/install/app/bin/app -h

run-dist-version:
	./build/install/app/bin/app -V

run-dist-test:
	./build/install/app/bin/app src/test/resources/test1.json src/test/resources/test2.json

run-dist-test-yml:
	./build/install/app/bin/app src/test/resources/test1.yml src/test/resources/test2.yml

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build