# Description: Makefile for the project, only works for Linux and MacOS. Windows only works in WSL.
# To run this file in the terminal, make sure you are in the root directory of the project.
# And then type the following command: make <command>
# run:  make run
# test: make test

run:
	mvn spring-boot:run

test: 
	mvn test
