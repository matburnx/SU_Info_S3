
let rec nb_un (n : int) : int =
	if nb_un=1 then 1
	else if (nb_un mod 2)=1 then 1 + nb_un (n/2)
		else nb_un (n/2);;

let rec nb_bits (n : int) : int =
	if n/2=0 then 1
	else 1 + nb_bits (n/2);;

let nb_max (n : int) : int =
	(2^n)-1;;

let pgcd (n : int) (m : int) : int =
	let r : int = (n mod m) in
	if r=0 then m
	else (pgcd m r);;

let rec repeat (n : int) (e : 'a) : 'a list =
	if n=0 then []
	else e::(repeat (n-1) e);;

let rec all_in_list (l1 : 'a list) (l2 : 'a list) : bool =
	match l1 with
	| [] -> true
	| h1::t1 -> (List.mem h1 l2) && (all_in_list t1 l2);;

let rec range_inter (a : int) (b : int) : int list =
	if a>b then []
	else a::(range_inter (a+1) b);;

let rec map_cons (e : 'a) (l : 'a list list) : 'a list list =
	match l with
	| [] -> []
	| h1::t1 -> (match h1 with
		| [] -> e
		| h2::t2 -> (e::h1))::(map_cons e t1);;
 
