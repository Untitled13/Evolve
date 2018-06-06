//There is a Diagram at the bottom you may want to look at if confused

Alot of machine learning is the following :
you have a bunch of x values and a bunch of y values that you want to correspond to a function. Using those points the computer tries to create a function that matches those points.



src holds all the classes where the actual java files are (don't worry about the other stuff probably).
Ctrl theoretically is the actual object that runs stuff and makes the whole algorithm, but thats pretty expiremental right now.
This should be a evolutionary algorithm, but right now it just does brute force random changes. For some reason the Initializer for Generation that randomly modulates a already existant Net (The second one). Doesn't really work and I don't know why (Good Luck!!). The way that this works is the following.

This algorithm has a imput of a vector (Row 1) or [A, B, C, D, E, F, G] where Row 1 = [A, B, C, D, E, F, G], Row 2 = [H, I, J, K, L, M], Row 3 = [N, O, P, Q, R] etc.
All Letters except for (A..G) have vectors associated with them (A..G are inputs and therefore are just numbers). (length of (H)) = (length of (Row 1)), (length of (P)) = (length of (Row 2)), (length of (L)) = (length of (Row 1)), (length of (Y)) = (length of (Row 4)) etc. Each element in each vector corresponds to an element in the previous Row. For example H has a vector. That vector is 7 elements long.

Heres how we do the operations and math and stuff:
	H has a vector associated with it. We call all the elements of this vector "weights". when we calculate the value of H, we take the dot product of H.vector and (Row 1). (if we had the vectors a and b where a = [1,2,3] and b = [4,5,6] the dot product of a and b (or a * b) is equal to 1*4 + 2*5 + 3*6 or 34). Remeber Row 1 is just a vector of numbers, A..G do not have vectors associated with them. We are going to say for the purpose of this example [A..G] = [1,2,3,4,5,6,7], and H.vector = [5,3,2,7,6,1,0]
[A..G] * H.vector = 81 (where * is the same as the dot product). H also has a value called bias. The bias is a number that is added or subtracted from the dot product. H.bias = -28. We now say that the Value of H is 81-28 or 53.

	//Assume that (a*b) is the same as "the dot product of a and b"
	
	I.value = (Row 1) * I.vector + I.bias
	J.value = (Row 1) * J.vector + J.bias
	K.value = (Row 1) * K.vector + K.bias
	L.value = (Row 1) * L.vector + L.bias
	M.value = (Row 1) * M.vector + M.bias

	N.value = (values of (H..M or (Row 2)) * N.vector + N.bias
	O.value = (values of Row 2) * O.vector + O.bias

	...

	V.value = (values of Row 3) * V.vector + V.bias

	...

	Y.value = (values of Row 4) * Y.vector + Y.bias

	We usually call the values of the last row (Row 5) the output.



Row	1	2	3	4	5

	A
	
		    H
	B
			       N
		    I
	C			          S
			       O		    W
		    J		      T
	D		       P		    X
		    K		      U
			       Q		    Y
	E			          V
		    L
			       R
	F
		    M

	G


	So all I did to create a machine learning algorithm, was make this framework above, and then I just randomlly modulated each value (the weights and biases) for each neuron, and made a class called Scorer that determines how close the output is to what I want it to be. Then I just found the whole network of neurons that creates the best score according to Scorer.

	This Program Was Made By Cal Colbert-Pollack, SWHS Class of 2020, in April 2018.
