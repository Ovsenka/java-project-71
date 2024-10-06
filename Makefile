run-dist:
	app/build/install/app/bin/app

run-dist-help:
	app/build/install/app/bin/app -h

run-dist-version:
	app/build/install/app/bin/app -V

run-dist-test:
	app/build/install/app/bin/app src/test/resources/test1.json src/test/resources/test2.json

run-dist-test-yml:
	app/build/install/app/bin/app src/test/resources/test1.yml src/test/resources/test2.yml

clean:
	app/gradlew clean

build:
	app/gradlew clean build

install:
	app/gradlew clean install

run:
	app/gradlew run

test:
	cp app
	./gradlew test

report:
	cp app
	./gradlew jacocoTestReport

lint:
	cd app
	./gradlew checkstyleMain

check-deps:
	app/gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build