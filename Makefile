setup:
	./gradlew wrapper --gradle-version 6.8.3

clean:
	./gradlew clean

build: clean
	./gradlew build

install: clean
	./gradlew install

run-dist: install
	./build/install/app/bin/app

run:
	./gradlew run

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

check-updates:
	./gradlew dependencyUpdates

build-run: build run