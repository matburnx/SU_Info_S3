let next1 ((x1,x2):(int*int)) : int*int =
  (x1+1,x2-1);;

assert ((next1 (0,1)) = (1,0));;
assert ((next1 (1,1)) = (2,0));;
assert ((next1 (1,2)) = (2,1));;

let rec liste_n_next1 (n:int) ((x1,x2):(int*int)) : (int*int) list =
  if n > 0 then (x1,x2)::(liste_n_next1 (n-1) (next1 (x1,x2)))
  else (x1,x2)::[];;

assert ((liste_n_next1 0 (2,8)) = [(2,8)]);;
assert ((liste_n_next1 3 (2,8)) = [(2, 8); (3, 7); (4, 6); (5, 5)]);;

let make_diag (k : int) : (int*int) list=
  (liste_n_next1 (k) (0,k));;

assert ((make_diag 5) = [(0,5);(1,4);(2,3);(3,2);(4,1);(5,0)]);;

let rec nb_pairs_enum_k (k :int) : int=
  if k=0 then 1 else (k+1)+(nb_pairs_enum_k (k-1));;

assert((nb_pairs_enum_k 3) = 10);;

let rec make_all_diag (k : int) : (int*int) list=
  if k = 0 then [(0,0)]
  else (make_all_diag (k-1))@(make_diag k);;

assert((make_all_diag 3) = [(0, 0); (0, 1); (1, 0); (0, 2); (1, 1); (2, 0); (0, 3); (1, 2); (2, 1);
(3, 0)]);;

let next2 (x:int) : int*int = (0,x+1);;

let next ((x1,x2) : (int*int)) : int*int =
  if x2 = 0 then next2 x1 else next1 (x1,x2);;

assert((next (0,3)) = (1,2));;
assert((next (2,0)) = (0,3));;

let rec n_next (n:int) ((x1,x2) : (int*int)) : int*int =
  if n=0 then (x1,x2) else (n_next (n-1) (next (x1,x2)));;

assert ((n_next 7 (0,0)) = (1,2));;
assert ((n_next 6 (1,0)) = (2,1));;

let nat_to_pair_of_nat (n:int) : int*int =
  n_next n (0,0);;

assert( (nat_to_pair_of_nat 9) = (3,0));;

let rec liste_iter_f (f:'a -> 'a) (x:'a) (n:int) : 'a list=
  if n=0 then [x]
  else x::(liste_iter_f f (f x) (n-1));;

let liste_n_next1_iter (n:int) ((x1,x2):(int*int)) : (int*int) list =
  liste_iter_f next1 (x1,x2) n;;

assert ((liste_n_next1_iter 0 (2,8)) = [(2,8)]);;
assert ((liste_n_next1_iter 3 (2,8)) = [(2, 8); (3, 7); (4, 6); (5, 5)]);;

let make_all_diag_iter (k : int) : (int*int) list=
  liste_iter_f next (0,0) (nb_pairs_enum_k (k-1));;

assert((make_all_diag_iter 3) = [(0, 0); (0, 1); (1, 0); (0, 2); (1, 1); (2, 0); (0, 3); (1, 2); (2, 1);(3, 0)]);;
