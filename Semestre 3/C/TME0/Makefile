all: hello_world.c hello_world2.c
	make hello_world
	make hello_world2
	make image

clean:
	rm hello_world
	rm hello_world2
	rm image

image: image.c image.h
	gcc -Wall -o image image.c

hello_world: hello_world.c
	gcc -Wall -o hello_world hello_world.c

hello_world2: hello_world2.c
	gcc -Wall -o hello_world2 hello_world2.c
